package com.example.kingpin.Adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kingpin.R
import com.example.kingpin.models.hours
import com.example.kingpin.models.skillIQ
import com.example.kingpin.utils.inflate
import com.squareup.picasso.Picasso

class HoursAdapter(private val hours: ArrayList<hours>) :
    RecyclerView.Adapter<HoursAdapter.Dataholder>() {
    class Dataholder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var hour: hours? = null

        fun bindHour(hours: hours) {
            this.hour = hours
            Picasso.get().load(hours.badgeUrl).into(view.findViewById<ImageView>(R.id.imageView))
            view.findViewById<TextView>(R.id.textView).text = hours.name
            view.findViewById<TextView>(R.id.textView2).text = hours.hours.toString()
            view.findViewById<TextView>(R.id.textView3).text = hours.country
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursAdapter.Dataholder {
        val inflatedView = parent.inflate(R.layout.rv_item, false)
        return HoursAdapter.Dataholder(inflatedView)
    }

    override fun getItemCount(): Int {
        return hours.size
    }

    override fun onBindViewHolder(holder: HoursAdapter.Dataholder, position: Int) {
        val hourItem = hours[position]
        holder.bindHour(hourItem)
    }
}

