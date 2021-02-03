package tech.wcw.basic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:10
 * @Description:
 */
class SimpleRecyclerAdapter<D>(@LayoutRes val itemLayoutId: Int, val brId: Int) :
    RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder>() {
    var data: ArrayList<D>? = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimpleRecyclerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, itemLayoutId, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if (data == null) {
            return 0
        }
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.setVariable(brId, data!![position])
    }

    class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ViewDataBinding

        init {
            this.binding = binding
        }
    }


}