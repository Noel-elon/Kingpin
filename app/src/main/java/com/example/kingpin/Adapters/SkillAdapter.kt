package com.example.kingpin.Adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kingpin.R
import com.example.kingpin.models.skillIQ
import com.example.kingpin.utils.inflate
import com.squareup.picasso.Picasso

class SkillAdapter(private val skills: ArrayList<skillIQ>) :
    RecyclerView.Adapter<SkillAdapter.Dataholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillAdapter.Dataholder {
        val inflatedView = parent.inflate(R.layout.rv_item, false)
        return Dataholder(inflatedView)
    }

    override fun getItemCount(): Int {
        return skills.size
    }

    override fun onBindViewHolder(holder: SkillAdapter.Dataholder, position: Int) {
        val skillItem = skills[position]
        holder.bindSkill(skillItem)
    }

    class Dataholder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var skillIQ: skillIQ? = null

        fun bindSkill(skillIQ: skillIQ) {
            this.skillIQ = skillIQ
            Picasso.get().load(skillIQ.badgeUrl).into(view.findViewById<ImageView>(R.id.imageView))
            view.findViewById<TextView>(R.id.textView).text = skillIQ.name
            view.findViewById<TextView>(R.id.textView2).text = skillIQ.score.toString()
            view.findViewById<TextView>(R.id.textView3).text = skillIQ.country
        }

    }
}