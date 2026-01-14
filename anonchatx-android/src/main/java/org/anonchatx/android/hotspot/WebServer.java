package org.anonchatx.android.hotspot;

import android.content.Context;

import org.anonchatx.R;
import org.briarproject.nullsafety.NotNullByDefault;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;
import fi.iki.elonen.NanoHTTPD;

import static android.util.Xml.Encoding.UTF_8;
import static fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR;
import static fi.iki.elonen.NanoHTTPD.Response.Status.NOT_FOUND;
import static fi.iki.elonen.NanoHTTPD.Response.Status.OK;
import static java.util.Objects.requireNonNull;
import static java.util.logging.Level.WARNING;
import static java.util.logging.Logger.getLogger;
import static org.anonchatsecure.bramble.util.LogUtils.logException;
import static org.anonchatx.BuildConfig.VERSION_NAME;
import static org.anonchatx.android.hotspot.HotspotViewModel.getApkFileName;

@NotNullByDefault
class WebServer extends NanoHTTPD {

	final static int PORT = 9999;
	private static final Logger LOG = getLogger(WebServer.class.getName());
	private static final String FILE_HTML = "hotspot.html";
	private static final Pattern REGEX_AGENT = Pattern.compile("Android ([0-9]+)");
	private final Context ctx;

	WebServer(Context ctx) {
		super(PORT);
		this.ctx = ctx;
	}

	@Override
	public void start() throws IOException {
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
	}

	@Override
	public Response serve(IHTTPSession session) {
		String uri = session.getUri();

		if (uri.endsWith("favicon.ico")) {
			return newFixedLengthResponse(NOT_FOUND, MIME_PLAINTEXT, NOT_FOUND.getDescription());
		}

		if (uri.endsWith(".apk")) {
			if (uri.contains("mailbox")) {
				return serveMailboxApk();
			} else if (uri.contains("ripple")) {
				return serveRippleApk();
			} else if (uri.contains("monerujo")) {
				return serveMonerujoApk();
			} else if (uri.contains("orbot")) {
				return serveOrbotApk();
			} else if (uri.contains("tor-browser")) {
				return serveTorbrowserApk();
			} else {
				return serveApk();
			}
		}

		Response res;
		try {
			String html = getHtml(session.getHeaders().get("user-agent"));
			res = newFixedLengthResponse(OK, MIME_HTML, html);
		} catch (Exception e) {
			logException(LOG, WARNING, e);
			res = newFixedLengthResponse(INTERNAL_ERROR, MIME_PLAINTEXT,
					ctx.getString(R.string.hotspot_error_web_server_serve));
		}
		return res;
	}


	private String getHtml(@Nullable String userAgent) throws Exception {
		Document doc;
		try (InputStream is = ctx.getAssets().open(FILE_HTML)) {
			doc = Jsoup.parse(is, UTF_8.name(), "");
		}
		String filename = getApkFileName();

		// AnonChat
		doc.select("#download_title").first()
				.text(ctx.getString(R.string.website_download_title_1, VERSION_NAME));
		doc.select("#download_intro").first()
				.text(ctx.getString(R.string.website_download_intro_1));
		doc.select(".button").first().attr("href", filename);
		doc.select("#download_button").first()
				.text(ctx.getString(R.string.website_download_button));

		// Mailbox
		Element mailboxBtn = doc.select("#mailbox_button").first();
		if (mailboxBtn != null) {
			mailboxBtn.attr("href", "anonchat-mailbox.apk");
			mailboxBtn.text(ctx.getString(R.string.website_download_mailbox_button));
		}

		// Ripple
		Element rippleBtn = doc.select("#ripple_button").first();
		if (rippleBtn != null) {
			rippleBtn.attr("href", "ripple.apk");
			rippleBtn.text(ctx.getString(R.string.website_download_ripple_button));
		}

		Element monerujoBtn = doc.select("#monerujo_button").first();
		if (monerujoBtn != null) {
			monerujoBtn.attr("href", "monerujo.apk");
			monerujoBtn.text(ctx.getString(R.string.website_download_monerujo_button));
		}

		Element orbotBtn = doc.select("#orbot_button").first();
		if (orbotBtn != null) {
			orbotBtn.attr("href", "orbot.apk");
			orbotBtn.text(ctx.getString(R.string.website_download_orbot_button));
		}

		Element torbrowserBtn = doc.select("#torbrowser_button").first();
		if (torbrowserBtn != null) {
			torbrowserBtn.attr("href", "tor-browser.apk");
			torbrowserBtn.text(ctx.getString(R.string.website_download_torbrowser_button));
		}


		// Footer
		doc.select("#download_outro").first()
				.text(ctx.getString(R.string.website_download_outro));
		doc.select("#troubleshooting_title").first()
				.text(ctx.getString(R.string.website_troubleshooting_title));
		doc.select("#troubleshooting_1").first()
				.text(ctx.getString(R.string.website_troubleshooting_1));
		doc.select("#troubleshooting_2").first()
				.text(getUnknownSourcesString(userAgent));

		return doc.outerHtml();
	}

	private String getUnknownSourcesString(@Nullable String userAgent) {
		boolean is8OrHigher = false;
		if (userAgent != null) {
			Matcher matcher = REGEX_AGENT.matcher(userAgent);
			if (matcher.find()) {
				int androidMajorVersion = Integer.parseInt(requireNonNull(matcher.group(1)));
				is8OrHigher = androidMajorVersion >= 8;
			}
		}
		return is8OrHigher ?
				ctx.getString(R.string.website_troubleshooting_2_new) :
				ctx.getString(R.string.website_troubleshooting_2_old);
	}

	private Response serveApk() {
		String mime = "application/vnd.android.package-archive";
		File file = new File(ctx.getPackageCodePath());
		long fileLen = file.length();

		try {
			FileInputStream fis = new FileInputStream(file);
			Response res = newFixedLengthResponse(OK, mime, fis, fileLen);
			res.addHeader("Content-Length", "" + fileLen);
			return res;
		} catch (FileNotFoundException e) {
			logException(LOG, WARNING, e);
			return newFixedLengthResponse(NOT_FOUND, MIME_PLAINTEXT,
					ctx.getString(R.string.hotspot_error_web_server_serve));
		}
	}

	private Response serveMailboxApk() {
		String mime = "application/vnd.android.package-archive";
		try {
			InputStream is = ctx.getAssets().open("anonchat-mailbox.apk");
			int size = is.available();
			Response res = newFixedLengthResponse(OK, mime, is, size);
			res.addHeader("Content-Length", String.valueOf(size));
			return res;
		} catch (IOException e) {
			logException(LOG, WARNING, e);
			return newFixedLengthResponse(NOT_FOUND, MIME_PLAINTEXT,
					ctx.getString(R.string.hotspot_error_web_server_serve));
		}
	}

	private Response serveRippleApk() {
		String mime = "application/vnd.android.package-archive";
		try {
			InputStream is = ctx.getAssets().open("ripple.apk");
			int size = is.available();
			Response res = newFixedLengthResponse(OK, mime, is, size);
			res.addHeader("Content-Length", String.valueOf(size));
			return res;
		} catch (IOException e) {
			logException(LOG, WARNING, e);
			return newFixedLengthResponse(NOT_FOUND, MIME_PLAINTEXT,
					ctx.getString(R.string.hotspot_error_web_server_serve));
		}
	}

	private Response serveMonerujoApk() {
		String mime = "application/vnd.android.package-archive";
		try {
			InputStream is = ctx.getAssets().open("monerujo.apk");
			int size = is.available();
			Response res = newFixedLengthResponse(OK, mime, is, size);
			res.addHeader("Content-Length", String.valueOf(size));
			return res;
		} catch (IOException e) {
			logException(LOG, WARNING, e);
			return newFixedLengthResponse(NOT_FOUND, MIME_PLAINTEXT,
					ctx.getString(R.string.hotspot_error_web_server_serve));
		}
	}

	private Response serveOrbotApk() {
		String mime = "application/vnd.android.package-archive";
		try {
			InputStream is = ctx.getAssets().open("orbot.apk");
			int size = is.available();
			Response res = newFixedLengthResponse(OK, mime, is, size);
			res.addHeader("Content-Length", String.valueOf(size));
			return res;
		} catch (IOException e) {
			logException(LOG, WARNING, e);
			return newFixedLengthResponse(NOT_FOUND, MIME_PLAINTEXT,
					ctx.getString(R.string.hotspot_error_web_server_serve));
		}
	}

	private Response serveTorbrowserApk() {
		String mime = "application/vnd.android.package-archive";
		try {
			InputStream is = ctx.getAssets().open("tor-browser.apk");
			int size = is.available();
			Response res = newFixedLengthResponse(OK, mime, is, size);
			res.addHeader("Content-Length", String.valueOf(size));
			return res;
		} catch (IOException e) {
			logException(LOG, WARNING, e);
			return newFixedLengthResponse(NOT_FOUND, MIME_PLAINTEXT,
					ctx.getString(R.string.hotspot_error_web_server_serve));
		}
	}
}