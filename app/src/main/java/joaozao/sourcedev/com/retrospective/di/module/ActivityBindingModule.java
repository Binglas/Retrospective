package joaozao.sourcedev.com.retrospective.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import joaozao.sourcedev.com.retrospective.data.source.InductionsRepositoryModule;
import joaozao.sourcedev.com.retrospective.di.scope.ActivityScope;
import joaozao.sourcedev.com.retrospective.inductions.InductionsActivity;
import joaozao.sourcedev.com.retrospective.inductions.InductionsModule;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {InductionsModule.class, InductionsRepositoryModule.class})
    abstract InductionsActivity tasksActivity();

}
