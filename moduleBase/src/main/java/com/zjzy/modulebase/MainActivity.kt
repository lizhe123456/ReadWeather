package com.zjzy.modulebase


import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.zjzy.modulebase.databinding.ActivityMainBinding
import com.zjzy.modulebase.ui.BaseVmActivity


class MainActivity : BaseVmActivity<ActivityMainBinding, MainViewModel>(){



    override fun initVariableId(): Int {
        return BR.main
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initViewObservable() {
        viewModel.liveData.observe(this) {
            binding.setVariable(BR.main, viewModel)
        }
    }

    override fun init() {
        findViewById<Button>(R.id.btn_b1).setOnClickListener {
            viewModel.setData("btn_b1","btn_b1btn_b1btn_b1btn_b1btn_b1btn_b1btn_b1btn_b1","18:00")
        }

        findViewById<Button>(R.id.btn_b2).setOnClickListener {
            viewModel.setData("btn_b2","btn_b2btn_b2btn_b2btn_b2btn_b2btn_b2btn_b2btn_b2","19:00")
        }
    }

    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun setData() {

    }


}