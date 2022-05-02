package com.example.lifecycledemoapp.daggerDI

import javax.inject.Inject
import javax.inject.Named


class UserRegistrationService @Inject constructor(
    @MessageQualifier
    val emailService: NotificationService,

    @Named("sql")
    val userRepository: UserRegistrationInterface
) {

    fun registerUser(email: String, pass: String) {
        userRepository.saveUser(email, pass)
    }


    fun sendEmail() {
        emailService.send("abc@gmail.com", "def@gamail.com")
    }

}