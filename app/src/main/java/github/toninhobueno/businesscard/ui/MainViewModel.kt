package github.toninhobueno.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import github.toninhobueno.businesscard.data.BusinessCard
import github.toninhobueno.businesscard.data.BusinessCardRepository
import java.lang.IllegalArgumentException

class MainViewModel (private val BusinessCardRepository : BusinessCardRepository) : ViewModel() {


    fun insert (BusinessCard:BusinessCard){
        BusinessCardRepository.insert(BusinessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>>{
        return BusinessCardRepository.getAll()
    }
}


class MainViewModelFactory (private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
            throw IllegalArgumentException("Unknown ViewModel class")

    }
}