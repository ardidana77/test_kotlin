package com.example.test_kotlin

class ContactModel(id: String?, firstname: String?, lastname: String?, email: String?, phone: String?){

    private var id: String
    private var firstname: String
    private var lastname: String
    private var email: String
    private var phone: String

    init {
        this.id = id!!
        this.firstname = firstname!!
        this.lastname = lastname!!
        this.email = email!!
        this.phone = phone!!
    }

    fun getid(): String?{
        return id
    }

    fun setid(id: String?){
        this.id = id!!
    }

    fun getfirstname(): String?{
        return firstname
    }

    fun setfirstname(firstname: String?){
        this.firstname = firstname!!
    }

    fun getlastname(): String?{
        return lastname
    }

    fun setlastname(lastname: String?){
        this.lastname = lastname!!
    }

    fun getemail(): String?{
        return email
    }

    fun setemail(email: String?){
        this.email = email!!
    }

    fun getphone(): String?{
        return phone
    }

    fun setphone(phone: String?){
        this.phone = phone!!
    }
}