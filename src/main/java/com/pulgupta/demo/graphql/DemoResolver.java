package com.pulgupta.demo.graphql;

import javax.inject.Qualifier;
import javax.inject.Singleton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Singleton
public @interface DemoResolver {
}
