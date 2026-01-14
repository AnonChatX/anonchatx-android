package org.anonchatx.android.privategroup.reveal;

import org.anonchatx.android.activity.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class GroupRevealModule {

	@ActivityScope
	@Provides
	RevealContactsController provideRevealContactsController(
			RevealContactsControllerImpl revealContactsController) {
		return revealContactsController;
	}
}
