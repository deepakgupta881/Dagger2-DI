package com.example.lifecycledemoapp.daggerDI

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(RetentionPolicy.RUNTIME)
annotation class MessageQualifier()