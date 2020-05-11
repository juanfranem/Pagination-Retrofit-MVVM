package es.jfechevarria.domain

data class User(
    var id: Int = 0,
    var email: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var avatar: String = ""
)