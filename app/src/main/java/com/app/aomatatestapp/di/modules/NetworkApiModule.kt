package com.app.aomatatestapp.di.modules

import com.app.aomatatestapp.data.remote.ApiResponseCallAdapterFactory
import com.app.aomatatestapp.data.remote.ApiService
import com.app.aomatatestapp.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * The Dagger Module to provide the instances of [OkHttpClient], [Retrofit], and [ApiService] classes.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkApiModule {

    @Singleton
    @Provides
    fun provideOKHttpClient(): OkHttpClient {
        val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .readTimeout(AppConstants.Network.TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(AppConstants.Network.TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
