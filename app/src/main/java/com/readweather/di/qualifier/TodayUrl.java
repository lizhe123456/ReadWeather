package com.readweather.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Administrator on 2018/2/5.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TodayUrl {
}
