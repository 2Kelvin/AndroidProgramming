package com.r19.firebaseapplication

//creating a table in the firebase database
class user {
    var name:String = ""
    var email:String = ""
    var IDNo:String = ""
    var id:String = ""

    constructor(name:String, email:String, IDNo:String, id:String) {
        this.name = name
        this.email = email
        this.IDNo = IDNo
        this.id = id
    }
    constructor(){}
}