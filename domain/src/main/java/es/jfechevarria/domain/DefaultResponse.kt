package es.jfechevarria.domain

data class DefaultResponse (
    var page: Int = 1,
    var per_page: Int = 0,
    var total: Int = 0,
    var total_pages: Int = 0,
    var data: List<User> = listOf()
)