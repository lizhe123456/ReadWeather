package com.zjzy.modulebase.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.properties.Delegates

abstract class BaseVmActivity<V: ViewDataBinding, VM: BaseViewModel>: BaseActivity(), IBaseView{
    protected var binding: V by Delegates.notNull<V>()
    protected var viewModel: VM by Delegates.notNull<VM>()
    protected var viewModelId  by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelAndBinding()
        initViewObservable()
    }

    private fun initViewModelAndBinding() {
        viewModel = initViewModel()
        binding.setVariable(initVariableId(),viewModel)
        //支持LiveData绑定xml，数据改变，UI自动会更新
        binding.lifecycleOwner = this
        viewModel.let { lifecycle.addObserver(it) }

    }

    //刷新布局
    open fun refreshLayout() {
        binding.setVariable(viewModelId, viewModel)
    }

    abstract fun initVariableId() : Int

    abstract fun initViewModel(): VM

    abstract fun initViewObservable()


    override fun stateError() {

    }

    override fun unLoading() {

    }


    override fun showErrorMsg(msg: String?) {

    }


    override fun loading() {

    }

    override fun setBaseContentView() {
        binding = DataBindingUtil.setContentView<V>(this, setLayout())
    }

}