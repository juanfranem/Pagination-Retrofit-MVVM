package es.jfechevarria.data.cloud

import es.jfechevarria.domain.DefaultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("users")
    suspend fun all(@Query("page") page: Int = 1): DefaultResponse
}