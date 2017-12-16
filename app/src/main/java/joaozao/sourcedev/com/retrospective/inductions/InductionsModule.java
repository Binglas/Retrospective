package joaozao.sourcedev.com.retrospective.inductions;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import joaozao.sourcedev.com.retrospective.di.qualifier.DefaultOkHttpClient;
import joaozao.sourcedev.com.retrospective.di.qualifier.GitlabRetrofit;
import joaozao.sourcedev.com.retrospective.di.qualifier.InductionsRequest;
import joaozao.sourcedev.com.retrospective.di.scope.ActivityScope;
import joaozao.sourcedev.com.retrospective.di.scope.FragmentScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link InductionsPresenter}.
 */
@Module
public abstract class InductionsModule {

    private static final String BASE_URL_GITLAB = "https://api.gitlab.com/";

    @FragmentScope
    @ContributesAndroidInjector
    abstract InductionsFragment inductionsFragment();

    @ActivityScope
    @Binds
    abstract InductionsContract.Presenter inductionPresenter(InductionsPresenter presenter);

    @Provides
    @ActivityScope
    @InductionsRequest
    static Request providesInductionsRequest() {
        return new Request.Builder().url("https://drive.google.com/uc?" +
                "authuser=0&id=1sMSltMnb1z_QhbZmr_conPAS_xzusAXN&export=download").build();
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
