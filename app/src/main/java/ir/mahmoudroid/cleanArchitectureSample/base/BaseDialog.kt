package ir.mahmoudroid.cleanArchitectureSample.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import ir.mahmoudroid.cleanArchitectureSample.R

abstract class BaseDialog(
        context: Context,
        private val matchHeight: Boolean? = false,
        private val cancelable: Boolean? = null,
        private val isMatchParentHeight:Boolean = false
) :
    Dialog(context, R.style.BaseDialogTheme) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getDialogLayout())
        val width = context.resources.displayMetrics.widthPixels
        if(isMatchParentHeight){
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        }else{
            window?.setLayout(
                (width / 1.0).toInt(),
                if (matchHeight == true) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        cancelable?.let {
            setCancelable(cancelable)
        } ?: run{
            setCancelable(true)
        }
        setUpDialogView()
    }

    abstract fun getDialogLayout(): Int
    abstract fun setUpDialogView()

}