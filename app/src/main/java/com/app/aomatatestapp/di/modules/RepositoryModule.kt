package com.app.aomatatestapp.di.modules

import android.app.Application
import com.app.aomatatestapp.data.remote.ApiService
import com.app.aomatatestapp.data.repository.Repository
import com.app.aomatatestapp.data.repository.RepositoryImpl
import com.app.aomatatestapp.utils.StringUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * The Dagger Module for providing repository instances.
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideStringUtils(app: Application): StringUtils {
        return StringUtils(app)
    }

    @Singleton
    @Provides
    fun provideImagineRepository(stringUtils: StringUtils, apiService: ApiService): Repository {
        return RepositoryImpl(stringUtils, apiService)
    }
}
