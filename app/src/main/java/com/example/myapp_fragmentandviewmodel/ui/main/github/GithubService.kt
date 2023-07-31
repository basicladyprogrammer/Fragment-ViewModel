package com.example.myapp_fragmentandviewmodel.ui.main.github

import retrofit2.Response
import retrofit2.http.GET

data class GithubUser (var login:String, var avatar_url:String)

interface GithubService {
    @GET("users")
    suspend fun users():Response<List<GithubUser>>
}