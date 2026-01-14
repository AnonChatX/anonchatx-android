package org.anonchatx.android.conversation;

import org.anonchatx.android.activity.ActivityScope;
import org.anonchatx.android.conversation.glide.BriarDataFetcherFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ConversationModule {

	@ActivityScope
	@Provides
	BriarDataFetcherFactory provideBriarDataFetcherFactory(
			BriarDataFetcherFactory dataFetcherFactory) {
		return dataFetcherFactory;
	}

}
