package com.zjzy.modulebase.ui

/**
 * Created by Administrator on 2017/8/18 0018.
 */
interface IBaseView {
    fun showErrorMsg(msg: String?)

    fun stateError()

    fun loading()

    fun unLoading()

}