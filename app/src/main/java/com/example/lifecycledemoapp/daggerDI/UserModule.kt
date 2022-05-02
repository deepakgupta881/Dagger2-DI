package com.example.lifecycledemoapp.daggerDI

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class UserModule {

    @Provides
    @Singleton

    fun getFirebaseRepository(): UserRegistrationInterface {
        return FirebaseRepository()
    }

    @Provides
    @Singleton
    @Named("sql")

    fun getSQLRepository(sqlRepository: SQLRepository): UserRegistrationInterface {
        return sqlRepository
    }


}