package joaozao.sourcedev.com.retrospective;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import joaozao.sourcedev.com.retrospective.di.component.AppComponent;
import joaozao.sourcedev.com.retrospective.di.component.DaggerAppComponent;

public class RetrospectiveApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
