package joaozao.sourcedev.com.retrospective.data.source;

import dagger.Module;
import dagger.Provides;
import joaozao.sourcedev.com.retrospective.data.source.remote.InductionsRemoteDataSource;
import joaozao.sourcedev.com.retrospective.di.qualifier.DefaultOkHttpClient;
import joaozao.sourcedev.com.retrospective.di.qualifier.InductionsRequest;
import joaozao.sourcedev.com.retrospective.di.scope.ActivityScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * This is used by Dagger to inject the required arguments into the {@link InductionsRepository}.
 */
@Module
public class InductionsRepositoryModule {

    @ActivityScope
    @Provides
    @Remote
    InductionsDataSource provideInductionsRemoteDataSource(
            @DefaultOkHttpClient OkHttpClient okHttpClient, @InductionsRequest Request request) {
        return new InductionsRemoteDataSource(okHttpClient, request);
    }

}
