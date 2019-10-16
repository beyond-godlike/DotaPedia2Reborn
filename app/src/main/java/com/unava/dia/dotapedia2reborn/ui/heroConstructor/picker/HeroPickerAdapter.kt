package com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.DotaHero
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor.HeroConstructorActivity
import com.unava.dia.dotapedia2reborn.ui.common.PicassoUtils
import com.unava.dia.dotapedia2reborn.ui.common.ProjectConstants
import com.unava.dia.dotapedia2reborn.ui.common.RecyclerViewClickListener
import io.realm.RealmResults


class HeroPickerAdapter(
    private var heroesList: RealmResults<DotaHero>,
    internal var activity: Activity
) : RecyclerView.Adapter<HeroPickerAdapter.HeroPickerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroPickerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.icon_model, parent, false)

        return HeroPickerViewHolder(v)
    }

    override fun onBindViewHolder(holder: HeroPickerViewHolder, position: Int) {
        PicassoUtils.setImageHero(
            holder.heroImage, heroesList[position]!!.rname,
            ProjectConstants.IMAGE_HERO_SMALL_WIDTH, ProjectConstants.IMAGE_HERO_SMALL_HEIGHT
        )

        holder.setItemClickListener(object : RecyclerViewClickListener {
            override fun onItemClick(position: Int) {
                val buttonIndex = holder.adapterPosition

                val intent = Intent(activity, HeroConstructorActivity::class.java)
                intent.putExtra("HERO_ID", buttonIndex)
                activity.startActivity(intent)

            }
        })
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    inner class HeroPickerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var itemClickListener: RecyclerViewClickListener
        var heroImage: ImageView = itemView.findViewById(R.id.cardImageView) as ImageView

        init {
            itemView.setOnClickListener(this)
        }

        fun setItemClickListener(itemClickListener: RecyclerViewClickListener) {
            this.itemClickListener = itemClickListener
        }

        override fun onClick(view: View) {
            this.itemClickListener.onItemClick(this.layoutPosition)
        }
    }
}