package com.weather.alerts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.weather.alerts.databinding.AdapterItemBinding
import com.weather.alerts.models.Features
import java.util.Date
import java.util.concurrent.TimeUnit

class DataAdapter(
    private val dataModels: ArrayList<Features>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    private var ctx: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemBinding = AdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ctx = parent.context
        return DataViewHolder(itemBinding)
    }

    class DataViewHolder(val item: AdapterItemBinding) : RecyclerView.ViewHolder(item.root)

    override fun onBindViewHolder(holder: DataViewHolder, pos: Int) {
        val row: Features = dataModels[pos]
        holder.item.event.text = row.properties?.event
        holder.item.sender.text = row.properties?.senderName
        holder.item.duration.text = timeBetween(row.properties?.effective, row.properties?.ends)

        //get unique square images
        Glide.with(ctx!!).load("https://picsum.photos/id/$pos/200/200")
            .transition(DrawableTransitionOptions.withCrossFade()).into(holder.item.image)
    }

    private fun timeBetween(date1: Date?, date2: Date?): String {
        var time = ""
        if (date1 != null && date2 != null) {
            try {
                val diff = date2.time - date1.time
                val days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
                val minutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS)
                time = if (days == 0L) "$minutes min" else "$days days"
            } catch (e: Exception) {
                time = "ex"
                e.printStackTrace()
            }
        } else {
            time = "?"
        }
        return time
    }

    override fun getItemCount(): Int = dataModels.size

    fun addData(list: List<Features>) {
        dataModels.addAll(list)
    }

    companion object {
        private const val TAG = "@@@"
    }
}