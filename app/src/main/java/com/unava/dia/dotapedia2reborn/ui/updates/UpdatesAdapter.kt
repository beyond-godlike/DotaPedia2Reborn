package com.unava.dia.dotapedia2reborn.ui.updates

import android.text.Html
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.articles.UpdatesEntity
import kotlinx.android.synthetic.main.card_one_update.view.*

class UpdatesAdapter : RecyclerView.Adapter<UpdatesAdapter.UpdatesViewHolder>() {
    private var list: List<UpdatesEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdatesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_one_update, parent, false)

        return UpdatesViewHolder(v)
    }

    override fun onBindViewHolder(holder: UpdatesViewHolder, position: Int) {
        holder.title.text = list[position].title

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            holder.description.text = Html.fromHtml(list[position].description, Html.FROM_HTML_MODE_COMPACT)
        } else {
            holder.description.text = HtmlCompat.fromHtml(list[position].description!!, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
        holder.date.text = list[position].date

        // TODO set listener
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(updates: List<UpdatesEntity>) {
        this.list = updates
        notifyDataSetChanged()
    }

    class UpdatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.tvTitle
        var description: TextView = itemView.tvDescription
        var date: TextView = itemView.tvDate

        // TODO add listener
    }
}