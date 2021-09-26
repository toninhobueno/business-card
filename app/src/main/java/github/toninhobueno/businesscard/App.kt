package github.toninhobueno.businesscard

import android.app.Application
import github.toninhobueno.businesscard.data.AppDataBase
import github.toninhobueno.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy {AppDataBase.getDatabase(this) }
    val repository by lazy {BusinessCardRepository(database.businessDao())}

}