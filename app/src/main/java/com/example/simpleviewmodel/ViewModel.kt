package com.example.simpleviewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class ViewModel : ViewModel() {
    private val datalist: LiveData<List<DataModel>>? = null
    private var clickCountA = 0

    fun getInitialCountA(): Int {
        return clickCountA
    }
    fun getCurrentCountA(): Int {
        clickCountA += 1
        return clickCountA
    }


    private var data: MutableLiveData<List<DataModel>>? = null


    fun getFruitList(): LiveData<List<DataModel>>? {
        if (data == null) {
            data = MutableLiveData()
            loadData()
        }
        return data
    }
    fun loadData(){
      var  dat = listOf(DataModel(1, "First data"),DataModel(2, "Second data"),DataModel(3, "Third data"),DataModel(4, "Fourth data"),DataModel(5, "Fifth data"))
         data?.postValue(dat)
    }

}