package es.jfechevarria.paginationdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import es.jfechevarria.data.Repository
import es.jfechevarria.domain.User
import es.jfechevarria.paginationdemo.pagination.UserDataSourceClass
import es.jfechevarria.paginationdemo.pagination.UserDataSourceFactory

class MainViewmodel(app: Application): AndroidViewModel(app) {
    private val repository = Repository(app)
    var data: LiveData<PagedList<User>>? = null
    private val dataFactory = UserDataSourceFactory(repository)
    init {

        val config = PagedList.Config.Builder()
            .setPageSize(6)
            .setEnablePlaceholders(true)
            .build()
        data = LivePagedListBuilder(dataFactory, config).build()

    }
}