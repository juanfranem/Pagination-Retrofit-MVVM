package es.jfechevarria.paginationdemo.pagination

import androidx.paging.PageKeyedDataSource
import es.jfechevarria.data.Repository
import es.jfechevarria.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class UserDataSourceClass(
    private val repository: Repository
): PageKeyedDataSource<Int, User>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, User>
    ) {
        GlobalScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.services.all()
                }
                callback.onResult(
                    response.data, if (response.page == 1)
                    null
                else
                    response.page, response.page + 1)
            } catch (e: Exception) {}

        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        GlobalScope.launch {
            try {
            val response =  withContext(Dispatchers.IO) {
                repository.services.all(params.key)
            }

            callback.onResult(response.data, params.key + 1)
            } catch (e: Exception) {}

        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        GlobalScope.launch {
            try {
            val response =  withContext(Dispatchers.IO) {
                repository.services.all(params.key)
            }

            callback.onResult(response.data, params.key - 1)
            } catch (e: Exception) {}
        }
    }

}