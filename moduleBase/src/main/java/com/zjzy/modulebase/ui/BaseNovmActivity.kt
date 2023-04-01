package com.zjzy.modulebase.ui

import android.view.LayoutInflater
import android.view.View

abstract class BaseNoVmActivity: BaseActivity() {

    protected var mView: View? = null

    override fun init() {

    }

    override fun stateError() {

    }

    override fun unLoading() {

    }


    override fun showErrorMsg(msg: String?) {

    }


    override fun loading() {

    }

    override fun setBaseContentView() {
        mActivity = this;
        mView = LayoutInflater.from(this).inflate(setLayout(),null);
    }

}