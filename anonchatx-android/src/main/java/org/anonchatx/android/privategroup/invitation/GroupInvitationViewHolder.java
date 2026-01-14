package org.anonchatx.android.privategroup.invitation;

import android.view.View;

import org.anonchatx.R;
import org.anonchatx.android.sharing.InvitationAdapter.InvitationClickListener;
import org.anonchatx.android.sharing.InvitationViewHolder;
import org.anonchatsecure.anonchat.api.privategroup.invitation.GroupInvitationItem;

import javax.annotation.Nullable;

import static org.anonchatx.android.util.UiUtils.getContactDisplayName;

class GroupInvitationViewHolder
		extends InvitationViewHolder<GroupInvitationItem> {

	GroupInvitationViewHolder(View v) {
		super(v);
	}

	@Override
	public void onBind(@Nullable GroupInvitationItem item,
			InvitationClickListener<GroupInvitationItem> listener) {
		super.onBind(item, listener);
		if (item == null) return;

		sharedBy.setText(
				sharedBy.getContext().getString(R.string.groups_created_by,
						getContactDisplayName(item.getCreator())));
	}

}