package org.anonchatx.android.privategroup.invitation;

import org.anonchatx.android.sharing.InvitationController;
import org.anonchatsecure.anonchat.api.privategroup.invitation.GroupInvitationItem;
import org.briarproject.nullsafety.NotNullByDefault;

@NotNullByDefault
interface GroupInvitationController
		extends InvitationController<GroupInvitationItem> {
}
