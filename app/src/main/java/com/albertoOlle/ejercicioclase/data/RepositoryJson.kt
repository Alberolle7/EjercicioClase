package com.albertoOlle.ejercicioclase.data

data class RepositoryJson(
    var id: Int,
    var name: String,
    var owner: Owner,
    var description: String,
    var language: String?,
    var license: License?,
    var topics: Array<String>
)

data class Owner(
    var login: String,
    var avatar_url: String

)

data class License(
    var name: String,
)
