package ir.mahmoudroid.cleanArchitectureSample.ui.dialog

import android.content.Context
import ir.mahmoudroid.cleanArchitectureSample.R
import ir.mahmoudroid.cleanArchitectureSample.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_description.*

class DialogDescription(
    mContext: Context,
    private val description: String,
    private val callback: (() -> Unit)? = null
) : BaseDialog(mContext) {

    override fun getDialogLayout() = R.layout.dialog_description

    override fun setUpDialogView() {
        txtDescription.text = description

        btnDismiss.setOnClickListener {
            callback?.let { call -> call() }
            dismiss()
        }
    }

}