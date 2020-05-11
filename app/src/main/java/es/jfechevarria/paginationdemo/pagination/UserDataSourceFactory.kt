package es.jfechevarria.paginationdemo.pagination

import android.service.autofill.UserData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import es.jfechevarria.data.Repository
import es.jfechevarria.domain.User

class UserDataSourceFactory(
    private val repository: Repository,
    val livedata: MutableLiveData<UserDataSourceClass> = MutableLiveData()
): DataSource.Factory<Int, User>() {

    override fun create(): DataSource<Int, User> {
        val dataSourceclass =  UserDataSourceClass(repository)
        livedata.postValue(dataSourceclass)
        return dataSourceclass
    }

}