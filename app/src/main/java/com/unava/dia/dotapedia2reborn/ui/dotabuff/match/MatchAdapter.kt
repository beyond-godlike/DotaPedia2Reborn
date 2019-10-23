package com.unava.dia.dotapedia2reborn.ui.dotabuff.match

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.match.Result
import com.unava.dia.dotapedia2reborn.common.PicassoUtils
import kotlinx.android.synthetic.main.card_one_match.view.*

class MatchAdapter(
    private val list: ArrayList<Result>,
    private val icons: HashMap<Int, String>
) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_one_match, parent, false)

        return MatchViewHolder(v)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val heroName: String? = this.icons[list[position].heroId]
        if (heroName != null) PicassoUtils.setHeroIconSmall(holder.heroIcon, heroName)
        holder.nickname.text = list[position].accountId?.toInt().toString()

        holder.kills.text = (list[position].kills.toString())
        holder.deaths.text = (list[position].deaths.toString())
        holder.assists.text = (list[position].assists.toString())

        holder.netwotrh.text = (list[position].goldSpent.toString())
        holder.lhdn.text = (list[position].lastHits.toString() + " / " +
                list[position].denies.toString())
        holder.gpmxpm.text = (list[position].gpm.toString() + " / " +
                list[position].xpm.toString())

        holder.dmg.text = (list[position].heroDamage.toString())
        holder.heal.text = (list[position].heroHealing.toString())
        holder.bld.text = (list[position].towerDamage.toString())

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var heroIcon: ImageView = itemView.ivHeroIcon
        var nickname: TextView = itemView.tvNickname

        var kills: TextView = itemView.tvKills
        var deaths: TextView = itemView.tvDeaths
        var assists: TextView = itemView.tvAssists

        var netwotrh: TextView = itemView.tvNetworth
        var lhdn: TextView = itemView.tvLhdn
        var gpmxpm: TextView = itemView.tvGpmxpm

        var dmg: TextView = itemView.tvDmg
        var heal: TextView = itemView.tvHeal
        var bld: TextView = itemView.tvBldDmg

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(nickname.text.toString())
            }
        }
    }
}