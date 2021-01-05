package ir.mahmoudroid.cleanArchitectureSample.ui.db

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ir.mahmoudroid.cleanArchitectureSample.R
import kotlinx.android.synthetic.main.fragment_database.*
import org.koin.android.ext.android.inject

class DatabaseFragment : Fragment() {

    private val viewModel: DatabaseViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_database, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initial()
        observes()
    }

    private fun initial() {
        viewModel.setToolbar()
        addUserBtn.setOnClickListener { viewModel.addUser() }
        allUsersBtn.setOnClickListener { viewModel.getAllUsers() }
        deleteBtn.setOnClickListener { viewModel.deleteFirstUser() }
    }

    private fun observes() {

        viewModel.getAllUsersWithLiveData().observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                textView.text =
                        """
                     | xxx
                    | ALL numbers = ${it.size}
                    | id = ${it[it.size - 1].id}
                    | name = ${it[it.size - 1].name}
                    | age = ${it[it.size - 1].age}
                    | isStaff = ${it[it.size - 1].isStaff}
                """.trimMargin()
            }
            else
                textView.text = "No Data  ( Async )"
        })

        viewModel.textLiveData.observe(viewLifecycleOwner, Observer { result ->
            textView.apply {
                text = result
            }

        })



    }

}