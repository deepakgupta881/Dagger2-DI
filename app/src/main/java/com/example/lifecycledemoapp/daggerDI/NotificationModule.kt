package com.example.lifecycledemoapp.daggerDI

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class NotificationModule {

    @Provides
    @Named("email")
    fun getEmailNotification(): NotificationService {
        return EmailService()
    }

    @Provides
    @MessageQualifier
    fun getSMSNotification(retry:Int): NotificationService {
        return SMSService(retry)
    }
}