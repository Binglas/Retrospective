package joaozao.sourcedev.com.retrospective.di.module;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import joaozao.sourcedev.com.retrospective.di.qualifier.DefaultOkHttpClient;
import joaozao.sourcedev.com.retrospective.di.qualifier.GitlabRetrofit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    private static final int DEFAULT_CACHE_SIZE = 10 * 1024 * 1024; // 10 Mib
    private static final int DEFAULT_TIMEOUT = 30; // Seconds

    private static final String BASE_URL_GITLAB = "https://api.gitlab.com/";

    private NetworkModule() {
        // Disallow instantiation with empty private constructor
    }

    @Provides
    @Singleton
    static Cache provideOkHttpCache(Application application) {
        return new Cache(application.getCacheDir(), DEFAULT_CACHE_SIZE);
    }

    @Provides
    @Singleton
    @DefaultOkHttpClient
    static OkHttpClient provideDefaultOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @GitlabRetrofit
    static Retrofit provideGitlabRetrofit(@DefaultOkHttpClient OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL_GITLAB)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

}
