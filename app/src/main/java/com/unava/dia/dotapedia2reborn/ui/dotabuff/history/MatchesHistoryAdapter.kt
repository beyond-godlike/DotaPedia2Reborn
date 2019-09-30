package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import com.unava.dia.dotapedia2reborn.data.history.Result
import kotlinx.android.synthetic.main.card_matches_history.view.*

class MatchesHistoryAdapter(history: Result, heroesMap: HashMap<Int, String>) :
    RecyclerView.Adapter<MatchesHistoryAdapter.Companion.MatchesHistoryViewHolder>() {

    private var list: ArrayList<HistoryMatch> = ArrayList()
    private var icons: Map<Int, String> = HashMap()

    init {
        this.list = history.matches!!
        this.icons = heroesMap
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesHistoryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_matches_history, parent, false)

        return MatchesHistoryViewHolder(v)
    }

    override fun onBindViewHolder(holder: MatchesHistoryViewHolder, position: Int) {
        //val heroName: String? = this.icons[list[position].heroId]
        //if (heroName != null) PicassoUtils.setHeroIconSmall(holder.heroIcon, heroName)

        //holder.nickname.text = (list[position].accountId.toString())

        holder.startTime.text = (list[position].startTime.toString())
        holder.type.text = (list[position].lobbyType.toString())
        //holder.matchType.text = (list[position].lobbyType.toString())
        //holder.duration.text = (list[position].startTime.toString())
    }

    override fun getItemCount(): Int {
        return list.size
    }

    companion object {
        class MatchesHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var heroIcon: ImageView = itemView.ivHeroIcon
            var nickname: TextView = itemView.tvNickname
            var skillbracket: TextView = itemView.tvSkillbracket
            var winLost: TextView = itemView.tvWinLost
            var startTime: TextView = itemView.tvStartTime
            var type: TextView = itemView.tvType
            var matchType: TextView = itemView.tvMatchType
            var duration: TextView = itemView.tvDuration
            var kda: TextView = itemView.tvKDA
        }
    }
}