package com.readweather.di.scope;

import java.lang.annotation.Retention;
import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@Scope
@Retention(RUNTIME)
public @interface AcyivityScope {
}
