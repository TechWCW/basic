package tech.wcw.basic.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 17:42
 * @Description:
 */
abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : Fragment(){
    var rootView: View? = null
    lateinit var mBinding: DB
    abstract var variableId: Int
    var mViewModel: VM? = null

    @LayoutRes
    abstract fun getLayoutId(savedInstanceState: Bundle?): Int
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate<DB>(inflater, getLayoutId(savedInstanceState), container, false)
        rootView = mBinding.root
        mBinding.lifecycleOwner = this
        initView()
        mViewModel = initViewModel()
        mViewModel?.injectLifecycle(this)
        initViewModel()
        mBinding.setVariable(variableId, mViewModel)
        initData()

        return rootView
    }

    open fun initViewModel(): VM? {
        if (mViewModel == null) {
            val type = javaClass.genericSuperclass
            mViewModel = if (type is ParameterizedType) {
                 ViewModelProvider(this).get(type.actualTypeArguments[1] as Class<VM>)
            } else {
                ViewModelProvider(this).get(BaseViewModel::class.java as Class<VM>)
            }
        }
        return mViewModel
    }


    abstract fun initView()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        mBinding.unbind()
    }
}