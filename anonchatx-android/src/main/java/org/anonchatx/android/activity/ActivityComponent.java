package org.anonchatx.android.activity;

import android.app.Activity;

import org.anonchatx.android.AndroidComponent;
import org.anonchatx.android.StartupFailureActivity;
import org.anonchatx.android.account.SetupActivity;
import org.anonchatx.android.account.SetupFragment;
import org.anonchatx.android.account.UnlockActivity;
import org.anonchatx.android.blog.BlogActivity;
import org.anonchatx.android.blog.BlogFragment;
import org.anonchatx.android.blog.BlogPostFragment;
import org.anonchatx.android.blog.FeedFragment;
import org.anonchatx.android.blog.ReblogActivity;
import org.anonchatx.android.blog.ReblogFragment;
import org.anonchatx.android.blog.RssFeedActivity;
import org.anonchatx.android.blog.RssFeedDeleteFeedDialogFragment;
import org.anonchatx.android.blog.RssFeedImportFailedDialogFragment;
import org.anonchatx.android.blog.RssFeedImportFragment;
import org.anonchatx.android.blog.RssFeedManageFragment;
import org.anonchatx.android.blog.WriteBlogPostActivity;
import org.anonchatx.android.contact.ContactListFragment;
import org.anonchatx.android.contact.add.nearby.AddNearbyContactActivity;
import org.anonchatx.android.contact.add.nearby.AddNearbyContactErrorFragment;
import org.anonchatx.android.contact.add.nearby.AddNearbyContactFragment;
import org.anonchatx.android.contact.add.nearby.AddNearbyContactIntroFragment;
import org.anonchatx.android.contact.add.remote.AddContactActivity;
import org.anonchatx.android.contact.add.remote.LinkExchangeFragment;
import org.anonchatx.android.contact.add.remote.NicknameFragment;
import org.anonchatx.android.contact.add.remote.PendingContactListActivity;
import org.anonchatx.android.contact.connect.ConnectViaBluetoothActivity;
import org.anonchatx.android.conversation.AliasDialogFragment;
import org.anonchatx.android.conversation.ConversationActivity;
import org.anonchatx.android.conversation.ConversationSettingsDialog;
import org.anonchatx.android.conversation.ImageActivity;
import org.anonchatx.android.conversation.ImageFragment;
import org.anonchatx.android.forum.CreateForumActivity;
import org.anonchatx.android.forum.ForumActivity;
import org.anonchatx.android.forum.ForumListFragment;
import org.anonchatx.android.fragment.ScreenFilterDialogFragment;
import org.anonchatx.android.hotspot.HotspotActivity;
import org.anonchatx.android.introduction.ContactChooserFragment;
import org.anonchatx.android.introduction.IntroductionActivity;
import org.anonchatx.android.introduction.IntroductionMessageFragment;
import org.anonchatx.android.login.ChangePasswordActivity;
import org.anonchatx.android.login.OpenDatabaseFragment;
import org.anonchatx.android.login.PasswordFragment;
import org.anonchatx.android.login.StartupActivity;
import org.anonchatx.android.mailbox.MailboxActivity;
import org.anonchatx.android.navdrawer.NavDrawerActivity;
import org.anonchatx.android.navdrawer.TransportsActivity;
import org.anonchatx.android.panic.PanicPreferencesActivity;
import org.anonchatx.android.panic.PanicResponderActivity;
import org.anonchatx.android.privategroup.conversation.GroupActivity;
import org.anonchatx.android.privategroup.creation.CreateGroupActivity;
import org.anonchatx.android.privategroup.creation.CreateGroupFragment;
import org.anonchatx.android.privategroup.creation.CreateGroupModule;
import org.anonchatx.android.privategroup.creation.GroupInviteActivity;
import org.anonchatx.android.privategroup.creation.GroupInviteFragment;
import org.anonchatx.android.privategroup.invitation.GroupInvitationActivity;
import org.anonchatx.android.privategroup.invitation.GroupInvitationModule;
import org.anonchatx.android.privategroup.list.GroupListFragment;
import org.anonchatx.android.privategroup.memberlist.GroupMemberListActivity;
import org.anonchatx.android.privategroup.memberlist.GroupMemberModule;
import org.anonchatx.android.privategroup.reveal.GroupRevealModule;
import org.anonchatx.android.privategroup.reveal.RevealContactsActivity;
import org.anonchatx.android.privategroup.reveal.RevealContactsFragment;
import org.anonchatx.android.removabledrive.RemovableDriveActivity;
import org.anonchatx.android.reporting.CrashFragment;
import org.anonchatx.android.reporting.CrashReportActivity;
import org.anonchatx.android.reporting.ReportFormFragment;
import org.anonchatx.android.settings.ConfirmAvatarDialogFragment;
import org.anonchatx.android.settings.SettingsActivity;
import org.anonchatx.android.settings.SettingsFragment;
import org.anonchatx.android.sharing.BlogInvitationActivity;
import org.anonchatx.android.sharing.BlogSharingStatusActivity;
import org.anonchatx.android.sharing.ForumInvitationActivity;
import org.anonchatx.android.sharing.ForumSharingStatusActivity;
import org.anonchatx.android.sharing.ShareBlogActivity;
import org.anonchatx.android.sharing.ShareBlogFragment;
import org.anonchatx.android.sharing.ShareForumActivity;
import org.anonchatx.android.sharing.ShareForumFragment;
import org.anonchatx.android.sharing.SharingModule;
import org.anonchatx.android.splash.SplashScreenActivity;
import org.anonchatx.android.test.TestDataActivity;
import org.anonchatx.android.settings.MoneroSettingsActivity;
import org.anonchatx.android.conversation.RequestXmrActivity;
import org.anonchatx.android.map.MapLocationPickerActivity;
import org.anonchatx.android.map.MapViewActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {
		ActivityModule.class,
		CreateGroupModule.class,
		GroupInvitationModule.class,
		GroupMemberModule.class,
		GroupRevealModule.class,
		SharingModule.SharingLegacyModule.class
}, dependencies = AndroidComponent.class)
public interface ActivityComponent {

	Activity activity();

	void inject(SplashScreenActivity activity);

	void inject(StartupActivity activity);

	void inject(SetupActivity activity);

	void inject(NavDrawerActivity activity);

	void inject(MoneroSettingsActivity activity);

	void inject(PanicResponderActivity activity);

	void inject(PanicPreferencesActivity activity);

	void inject(AddNearbyContactActivity activity);

	void inject(ConversationActivity activity);

	void inject(ImageActivity activity);

	void inject(ForumInvitationActivity activity);

	void inject(BlogInvitationActivity activity);

	void inject(CreateGroupActivity activity);

	void inject(GroupActivity activity);

	void inject(GroupInviteActivity activity);

	void inject(GroupInvitationActivity activity);

	void inject(GroupMemberListActivity activity);

	void inject(RevealContactsActivity activity);

	void inject(CreateForumActivity activity);

	void inject(ShareForumActivity activity);

	void inject(ShareBlogActivity activity);

	void inject(ForumSharingStatusActivity activity);

	void inject(BlogSharingStatusActivity activity);

	void inject(ForumActivity activity);

	void inject(BlogActivity activity);

	void inject(WriteBlogPostActivity activity);

	void inject(BlogFragment fragment);

	void inject(BlogPostFragment fragment);

	void inject(ReblogFragment fragment);

	void inject(ReblogActivity activity);

	void inject(SettingsActivity activity);

	void inject(TransportsActivity activity);

	void inject(TestDataActivity activity);

	void inject(ChangePasswordActivity activity);

	void inject(IntroductionActivity activity);

	void inject(RssFeedActivity activity);

	void inject(StartupFailureActivity activity);

	void inject(UnlockActivity activity);

	void inject(AddContactActivity activity);

	void inject(PendingContactListActivity activity);

	void inject(CrashReportActivity crashReportActivity);

	void inject(HotspotActivity hotspotActivity);

	void inject(RemovableDriveActivity activity);

	// Fragments

	void inject(SetupFragment fragment);

	void inject(PasswordFragment imageFragment);

	void inject(OpenDatabaseFragment activity);

	void inject(ContactListFragment fragment);

	void inject(CreateGroupFragment fragment);

	void inject(GroupListFragment fragment);

	void inject(GroupInviteFragment fragment);

	void inject(RevealContactsFragment activity);

	void inject(ForumListFragment fragment);

	void inject(FeedFragment fragment);

	void inject(AddNearbyContactIntroFragment fragment);

	void inject(AddNearbyContactFragment fragment);

	void inject(LinkExchangeFragment fragment);

	void inject(NicknameFragment fragment);

	void inject(ContactChooserFragment fragment);

	void inject(ShareForumFragment fragment);

	void inject(ShareBlogFragment fragment);

	void inject(IntroductionMessageFragment fragment);

	void inject(SettingsFragment fragment);

	void inject(ScreenFilterDialogFragment fragment);

	void inject(AddNearbyContactErrorFragment fragment);

	void inject(AliasDialogFragment aliasDialogFragment);

	void inject(ImageFragment imageFragment);

	void inject(ReportFormFragment reportFormFragment);

	void inject(CrashFragment crashFragment);

	void inject(ConfirmAvatarDialogFragment fragment);

	void inject(ConversationSettingsDialog dialog);

	void inject(RssFeedImportFragment fragment);

	void inject(RssFeedManageFragment fragment);

	void inject(RssFeedImportFailedDialogFragment fragment);

	void inject(RssFeedDeleteFeedDialogFragment fragment);

	void inject(ConnectViaBluetoothActivity connectViaBluetoothActivity);

	void inject(MailboxActivity mailboxActivity);

	void inject(RequestXmrActivity activity);

	void inject(MapLocationPickerActivity activity);

	void inject(MapViewActivity activity);
}
