package ir.mahmoudroid.cleanArchitectureSample.framework.other

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class GeneralDiffCallback<T> : DiffUtil.ItemCallback<T>() {


    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
}