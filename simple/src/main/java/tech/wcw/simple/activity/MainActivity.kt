package tech.wcw.simple.activity

import android.os.Bundle
import com.orhanobut.logger.Logger
import tech.wcw.basic.LifecycleHandler
import tech.wcw.basic.base.BaseActivity
import tech.wcw.simple.BR
import tech.wcw.simple.R
import tech.wcw.simple.databinding.ActivityMainBinding
import tech.wcw.simple.viewmodel.MainViewModel

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2020/11/24 16:38
 * @Description:
 */
class MainActivity(override var variableId: Int = BR.viewModel) :
    BaseActivity<ActivityMainBinding, MainViewModel>() {
    //this handle will auto remove
    val handler = LifecycleHandler(this)

    override fun getLayoutId(savedInstanceState: Bundle?): Int {
        Logger.i("getLayoutId")
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {
        mViewModel?.baidu()
    }


}
