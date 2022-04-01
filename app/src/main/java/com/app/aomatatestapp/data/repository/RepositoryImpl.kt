package com.app.aomatatestapp.data.repository

import com.app.aomatatestapp.data.remote.ApiService
import com.app.aomatatestapp.utils.StringUtils
import javax.inject.Inject

/**
 * This is an implementation of [Repository] to handle communication with [ApiService] server.
 */
class RepositoryImpl @Inject constructor(
    private val stringUtils: StringUtils,
    private val apiService: ApiService
) : Repository {

   /* @WorkerThread
    override suspend fun loadPosts(
        start: Int,
        limit: Int
    ): Flow<DataState<List<PostModel>>> {
        return flow {
            apiService.loadPosts(start, limit).apply {
                this.onSuccessSuspend {
                    data?.let {
                        emit(DataState.success(it))
                    }
                }
                // handle the case when the API request gets an error response.
                // e.g. internal server error.
            }.onErrorSuspend {
                emit(DataState.error<List<PostModel>>(message()))

                // handle the case when the API request gets an exception response.
                // e.g. network connection error.
            }.onExceptionSuspend {
                if (this.exception is IOException) {
                    emit(DataState.error<List<PostModel>>(stringUtils.noNetworkErrorMessage()))
                } else {
                    emit(DataState.error<List<PostModel>>(stringUtils.somethingWentWrong()))
                }
            }
        }

    }*/

}
