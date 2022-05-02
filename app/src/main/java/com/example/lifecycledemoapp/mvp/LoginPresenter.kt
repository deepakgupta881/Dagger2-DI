package com.example.lifecycledemoapp.mvp

class LoginPresenter(val view: LoginContractor.View) : LoginContractor.Presenter {


    override fun login(email: String, password: String) {
        if (email=="admin@gmail.com"&& password=="123"){
            view.success()
        }else{
            view.error("invalid user credentials")
        }
    }
}