package com.test.test.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.test.adapter.DataAdapter
import com.test.test.databinding.FragmentFirstBinding
import com.test.test.models.DataModel
import com.test.test.viewmodel.DataViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var userViewModel: DataViewModel? = null
    private var adapter: DataAdapter? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) { //prevent to retrieve getData twice
            //prevent to retrieve getData twice
            val recyclerView = binding.rv
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.setHasFixedSize(true)

            userViewModel = ViewModelProviders.of(this)[DataViewModel::class.java]
            adapter = DataAdapter()
            recyclerView.adapter = adapter

            getData()

            binding.retry.setOnClickListener {
                getData()
            }
        }

    }

    private fun getData() {
        val pd = ProgressDialog.show(context, "Retrieving weather data...", "")
        pd.show()

        userViewModel!!.data.observe(viewLifecycleOwner) { response ->
            //Log.d("@@@", "response " + response.size());
            if (response != null) {
                adapter?.setData(response as ArrayList<DataModel?>, context)
                binding.retry.visibility = View.GONE
            } else {
                Toast.makeText(context, "Failed to get weather data!", Toast.LENGTH_SHORT).show()
                binding.retry.visibility = View.VISIBLE
            }
            pd.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}