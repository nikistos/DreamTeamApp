package com.example.dreamteamapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.text.FieldPosition

class JobRecyclerViewAdapter : RecyclerView.Adapter<JobRecyclerViewAdapter.ViewHolder>() {

    var data = listOf<JobItem>()
        set(value) {
            field = if (value.count() > 0) value
            else listOf(JobItem("Нет опыта", "Но работа над этим идёт!", "", "", R.drawable.outline_work_off_24))
            notifyDataSetChanged()
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val company = itemView.findViewById<TextView>(R.id.companyNameText)
        val position = itemView.findViewById<TextView>(R.id.positionText)
        val period = itemView.findViewById<TextView>(R.id.jobPeriodText)
        val picture = itemView.findViewById<CircleImageView>(R.id.jobPic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_job_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = data.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.company.text = data[position].companyName
        holder.position.text = data[position].position
        holder.period.text = data[position].getPeriodString()
        holder.picture.setImageDrawable(holder.itemView.context.resources.getDrawable(data[position].logoId))
    }
}