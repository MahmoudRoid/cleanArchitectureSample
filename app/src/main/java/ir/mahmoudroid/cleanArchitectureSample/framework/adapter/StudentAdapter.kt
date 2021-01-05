package ir.mahmoudroid.cleanArchitectureSample.framework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import ir.mahmoudroid.core.domain.Student
import ir.mahmoudroid.cleanArchitectureSample.R
import ir.mahmoudroid.cleanArchitectureSample.framework.other.GeneralDiffCallback
import kotlinx.android.synthetic.main.row_list.view.*

class StudentAdapter(
    private val onItemClick: (student: Student) -> Unit
)
    : ListAdapter<Student, StudentAdapter.ViewHolder>(GeneralDiffCallback<Student>()){



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(item: Student?) {
            item?.let {
                itemView.row_email.text = item.email
                itemView.first_name.text = item.first_name
                itemView.last_name.text = item.last_name
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindTo(getItem(position))

        holder.itemView.setOnClickListener {
            onItemClick.invoke(getItem(position))
        }
    }


}