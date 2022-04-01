package com.app.aomatatestapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  /*  @GET("posts")
    suspend fun loadPosts(
        @Query("_start") page: Int = 0,
        @Query("_limit") numOfPosts: Int = AppConstants.Network.POSTS_PER_PAGE,
    ): ApiResponse<List<PostModel>>

    @GET("users")
    suspend fun getUserInfo(
        @Query("id") page: Int = 0,
    ): ApiResponse<List<UserModel>>

    @GET("comments")
    suspend fun getComments(
        @Query("postId") page: Int = 0,
    ): ApiResponse<List<CommentModel>>*/


    companion object {
        const val BASE_API_URL = "https://jsonplaceholder.typicode.com/"
    }
}
