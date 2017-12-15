package joaozao.sourcedev.com.retrospective.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {

    // Default empty interface

}