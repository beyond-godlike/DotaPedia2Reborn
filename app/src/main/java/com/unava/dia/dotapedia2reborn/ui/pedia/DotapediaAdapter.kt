package com.unava.dia.dotapedia2reborn.ui.pedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.common.PicassoUtils
import com.unava.dia.dotapedia2reborn.common.ProjectConstants
import com.unava.dia.dotapedia2reborn.data.DotaHero
import io.realm.RealmResults
import kotlinx.android.synthetic.main.model_navigator.view.*

class DotapediaAdapter(
    private val heroes: RealmResults<DotaHero>
): RecyclerView.Adapter<DotapediaAdapter.DotapediaViewHolder>() {

    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DotapediaViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.model_navigator, parent, false)

        return DotapediaViewHolder(v)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun onBindViewHolder(holder: DotapediaViewHolder, position: Int) {
        holder.position = position
        PicassoUtils.setImageHero(
            holder.heroImage,
            heroes[position]!!.rname,
            ProjectConstants.IMAGE_HERO_SMALL_WIDTH, ProjectConstants.IMAGE_HERO_SMALL_HEIGHT
            )
        holder.heroName.text = heroes[position]?.name ?: "no data"
    }

    inner class DotapediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var position: Int? = null
        var heroImage: ImageView = itemView.ivHero
        var heroName: TextView = itemView.tvHeroName

        init {
            itemView.setOnClickListener {
                position?.let { it1 -> onItemClick?.invoke(it1) }
            }
        }
    }
}