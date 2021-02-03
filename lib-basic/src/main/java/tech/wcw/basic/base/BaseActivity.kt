package tech.wcw.basic.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 17:42
 * @Description:
 * DB representative * dataBinding
 * VM representative * ViewModel
 */
abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel>(
) :
    AppCompatActivity() {
    abstract var variableId: Int
    lateinit var mBinding: DB
    var mViewModel: VM? = null;


    @LayoutRes
    abstract fun getLayoutId(savedInstanceState: Bundle?): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<DB>(this, getLayoutId(savedInstanceState))
        mBinding.lifecycleOwner = this
        initView()
        mViewModel = initViewModel()
        mViewModel?.injectLifecycle(this)
        mBinding.setVariable(variableId, mViewModel)
        initData()
    }


    abstract fun initView()

    abstract fun initData()

    open fun initViewModel(): VM? {
        if (mViewModel == null) {
            val type = javaClass.genericSuperclass
            mViewModel = if (type is ParameterizedType) {
                ViewModelProvider(
                    this
                ).get(type.actualTypeArguments[1] as Class<VM>)
            } else {
                ViewModelProvider(
                    this
                ).get(BaseViewModel::class.java as Class<VM>)
            }
        }
        return mViewModel
    }

//    /**
//     * 对lifecycleScope使用再次封装
//     */
//    fun whenCreated(block: suspend CoroutineScope.() -> Unit): Job =
//        lifecycleScope.launchWhenCreated(block)
//
//    fun whenStarted(block: suspend CoroutineScope.() -> Unit): Job =
//        lifecycleScope.launchWhenStarted(block)
//
//    fun whenResumed(block: suspend CoroutineScope.() -> Unit): Job =
//        lifecycleScope.launchWhenResumed(block)

    override fun onDestroy() {
        super.onDestroy()
        mBinding.unbind()
    }


}