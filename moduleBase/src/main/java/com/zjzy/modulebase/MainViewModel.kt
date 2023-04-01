package com.zjzy.modulebase

import android.util.Log
import androidx.lifecycle.*
import com.zjzy.modulebase.ui.BaseViewModel

class MainViewModel: BaseViewModel(){

    val liveData: MutableLiveData<MainBean> by lazy{ MutableLiveData<MainBean>() }

    val li: String by lazy{"11"}


    fun getData() : MainBean? {
        return liveData.value
    }

    fun setData(tile: String, desc: String, time: String){
        val mainBean = MainBean(tile, desc, time)
        liveData.value = mainBean
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d("sada","onCreate")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d("sada","onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d("sada","onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d("sada","onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d("sada","onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d("sada","onDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.d("sada","onAny")
    }

}