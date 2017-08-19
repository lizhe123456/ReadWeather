package com.readweather.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface WeatherUrl {
}
