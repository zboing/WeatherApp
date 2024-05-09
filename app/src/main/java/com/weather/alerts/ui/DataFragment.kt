package com.weather.alerts.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weather.alerts.R
import com.weather.alerts.adapter.DataAdapter
import com.weather.alerts.databinding.FragmentDataBinding
import com.weather.alerts.interfaces.UiState
import com.weather.alerts.viewmodel.DataViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DataFragment : Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentDataBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private lateinit var viewModel: DataViewModel
    private lateinit var adapter: DataAdapter
    private lateinit var rv: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()

        getData()

        binding.retry.setOnClickListener {
            getData()
        }
    }

    private fun setupUI(){
        rv = binding.rv
        rv.layoutManager = LinearLayoutManager(context)
        rv.setHasFixedSize(true)
        adapter = DataAdapter(arrayListOf())
        rv.adapter = adapter
        setupObserverViewModel(adapter)
    }

    private fun getData(){
        if (isNetworkAvailable(context)) {
            viewModel.getData()
        } else {
            binding.retry.visibility = View.VISIBLE
            Toast.makeText(context, getString(R.string.internet_missing), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupObserverViewModel(adapter : DataAdapter) {
        viewModel = ViewModelProvider(this)[DataViewModel::class.java]
        viewModel.getUiState().observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Success -> {
                    binding.pb.visibility = View.GONE
                    binding.retry.visibility = View.GONE
                    adapter.addData(it.data)
                    adapter.notifyDataSetChanged()
                }
                is UiState.Loading -> {
                    binding.pb.visibility = View.VISIBLE
                }
                is UiState.Error -> {
                    binding.pb.visibility = View.GONE
                    binding.retry.visibility = View.VISIBLE
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    return true
                }
            }
        } else {
            try {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    return true
                }
            } catch (e: Exception) {
                //Log.d(TAG, "isNetworkAvailable()" , e.getMessage());
            }
        }
        //Log.i(TAG,"Network is available : FALSE ");
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TAG = "@@@"
    }
}