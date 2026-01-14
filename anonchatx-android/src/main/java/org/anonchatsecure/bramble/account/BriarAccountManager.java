package org.anonchatsecure.bramble.account;

import android.app.Application;
import android.content.SharedPreferences;

import org.anonchatsecure.bramble.api.crypto.CryptoComponent;
import org.anonchatsecure.bramble.api.db.DatabaseConfig;
import org.anonchatsecure.bramble.api.identity.IdentityManager;
import org.anonchatx.R;
import org.anonchatx.android.Localizer;
import org.anonchatx.android.util.UiUtils;

import javax.inject.Inject;

class BriarAccountManager extends AndroidAccountManager {

	@Inject
	BriarAccountManager(DatabaseConfig databaseConfig, CryptoComponent crypto,
			IdentityManager identityManager, SharedPreferences prefs,
			Application app) {
		super(databaseConfig, crypto, identityManager, prefs, app);
	}

	@Override
	public void deleteAccount() {
		synchronized (stateChangeLock) {
			super.deleteAccount();
			Localizer.reinitialize();
			UiUtils.setTheme(appContext,
					appContext.getString(R.string.pref_theme_dark_value));
		}
	}
}
