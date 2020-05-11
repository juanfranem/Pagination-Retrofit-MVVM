package es.jfechevarria.data

import android.content.Context
import es.jfechevarria.data.cloud.ConnectionManager
import es.jfechevarria.data.cloud.Services

class Repository(val context: Context) {

    val services: Services = ConnectionManager(context).getServices()

}