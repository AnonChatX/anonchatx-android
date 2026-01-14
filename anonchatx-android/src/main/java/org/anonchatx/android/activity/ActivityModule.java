package org.anonchatx.android.activity;

import android.app.Activity;

import org.anonchatx.android.controller.AnonChatController;
import org.anonchatx.android.controller.AnonChatControllerImpl;
import org.anonchatx.android.controller.DbController;
import org.anonchatx.android.controller.DbControllerImpl;

import dagger.Module;
import dagger.Provides;

import static org.anonchatx.android.AnonChatService.AnonchatServiceConnection;

@Module
public class ActivityModule {

	private final BaseActivity activity;

	public ActivityModule(BaseActivity activity) {
		this.activity = activity;
	}

	@ActivityScope
	@Provides
	BaseActivity provideBaseActivity() {
		return activity;
	}

	@ActivityScope
	@Provides
	Activity provideActivity() {
		return activity;
	}

	@ActivityScope
	@Provides
	protected AnonChatController provideAnonChatController(
			AnonChatControllerImpl briarController) {
		activity.addLifecycleController(briarController);
		return briarController;
	}

	@ActivityScope
	@Provides
	DbController provideDBController(DbControllerImpl dbController) {
		return dbController;
	}

	@ActivityScope
	@Provides
	AnonchatServiceConnection provideBriarServiceConnection() {
		return new AnonchatServiceConnection();
	}
}
