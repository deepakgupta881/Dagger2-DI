package com.example.lifecycledemoapp.daggerDI

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserModule::class, NotificationModule::class])
interface UserComponent {
//    fun getUserRegistrationService(): UserRegistrationService
//    fun getEmailService(): EmailService

    fun inject(daggerActivity: DaggerActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance retry:Int) :UserComponent
    }

}