package com.albertoOlle.ejercicioclase.model

import com.albertoOlle.ejercicioclase.data.RepositoryJson


class Repository(val id: Int, val name: String, val description: String, val login: String, val picture: String, val language: String, val license: String, val topics: Array<String>)

fun RepositoryJson.toRepositories():Repository = Repository(this.id,this.name,this.description, this.owner.login, this.owner.avatar_url, this.language ?: "Without language", this.license?.name ?: "Without license", this.topics)

fun List<RepositoryJson>.toRepositories(): List<Repository> =this.map { RepositoryJson -> RepositoryJson.toRepositories() }