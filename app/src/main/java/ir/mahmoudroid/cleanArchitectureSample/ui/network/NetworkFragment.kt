package ir.mahmoudroid.cleanArchitectureSample.ui.network

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.mahmoudroid.cleanArchitectureSample.R
import ir.mahmoudroid.cleanArchitectureSample.framework.adapter.StudentAdapter
import kotlinx.android.synthetic.main.fragment_network.*
import org.koin.android.ext.android.inject

class NetworkFragment : Fragment() {

    private val viewModel: NetworkViewModel by inject()
    private val studentAdapter = StudentAdapter(){
        viewModel.onItemClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_network, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setToolbar()
        prepareRecyclerview()
        observs()

        dataBtn.setOnClickListener {
            viewModel.getData()
        }

    }

    private fun prepareRecyclerview() {
        with(recyclerview){
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
            adapter = studentAdapter
        }
    }

    private fun observs() {
        viewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            studentAdapter.submitList(it)
            studentAdapter.notifyDataSetChanged()
        })
    }


}