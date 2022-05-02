package com.example.lifecycledemoapp.mvp

interface LoginContractor {

    interface View{
        fun success()
        fun error( errorMsg:String)
    }

    interface Presenter{
        fun login(email:String,password:String)
    }
}