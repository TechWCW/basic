package tech.wcw.basic.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:13
 * @Description:
 */
class ListViewInScrollView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    ListView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val expandSpec = MeasureSpec.makeMeasureSpec(
            Int.MAX_VALUE shr 2,
            MeasureSpec.AT_MOST
        )
        super.onMeasure(widthMeasureSpec, expandSpec)
    }

}