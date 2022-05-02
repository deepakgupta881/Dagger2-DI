package com.example.lifecycledemoapp.design


// we don't need builder patter in kotlin now bcz we have data classes and its constructor properties default and named parameters

class UserBuilder constructor(val name: String, val age: Int, val section: String) {


    class Builder {
        private var name: String = "Deepak"
        var age: Int = 12
        private var section: String = "B"


        fun name(name: String) = apply { this.name = name }
        fun age(age: Int) = apply { this.age = age }
        fun section(section: String) = apply { this.section = section }


        fun build(): UserBuilder = UserBuilder(name, age, section)

    }
}