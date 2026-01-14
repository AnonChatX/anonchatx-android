package org.anonchatx.android.privategroup.reveal;

import android.view.View;
import android.widget.ImageView;

import org.anonchatx.R;
import org.anonchatx.android.contact.OnContactClickListener;
import org.anonchatx.android.contactselection.BaseSelectableContactHolder;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.Nullable;

import androidx.annotation.UiThread;

import static org.anonchatx.android.privategroup.VisibilityHelper.getVisibilityIcon;
import static org.anonchatx.android.privategroup.VisibilityHelper.getVisibilityString;
import static org.anonchatx.android.util.UiUtils.GREY_OUT;
import static org.anonchatx.android.util.UiUtils.getContactDisplayName;

@UiThread
@NotNullByDefault
class RevealableContactViewHolder
		extends BaseSelectableContactHolder<RevealableContactItem> {

	private final ImageView icon;

	RevealableContactViewHolder(View v) {
		super(v);

		icon = v.findViewById(R.id.visibilityView);
	}

	@Override
	protected void bind(RevealableContactItem item, @Nullable
			OnContactClickListener<RevealableContactItem> listener) {
		super.bind(item, listener);

		icon.setImageResource(getVisibilityIcon(item.getVisibility()));
		info.setText(
				getVisibilityString(info.getContext(), item.getVisibility(),
						getContactDisplayName(item.getContact())));
	}

	@Override
	protected void grayOutItem(boolean gray) {
		super.grayOutItem(gray);
		float alpha = gray ? GREY_OUT : 1f;
		icon.setAlpha(alpha);
	}

}
