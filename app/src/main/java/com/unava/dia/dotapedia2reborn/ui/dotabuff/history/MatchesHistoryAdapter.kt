package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.history.HistoryMatch
import com.unava.dia.dotapedia2reborn.utils.PicassoUtils
import kotlinx.android.synthetic.main.card_matches_history.view.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MatchesHistoryAdapter(history: ArrayList<HistoryMatch>, heroesMap: HashMap<Int, String>) :
    RecyclerView.Adapter<MatchesHistoryAdapter.Companion.MatchesHistoryViewHolder>() {

    private var list: ArrayList<HistoryMatch> = ArrayList()
    private var icons: Map<Int, String> = HashMap()

    init {
        this.list = history
        this.icons = heroesMap
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesHistoryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_matches_history, parent, false)

        return MatchesHistoryViewHolder(v)
    }

    override fun onBindViewHolder(holder: MatchesHistoryViewHolder, position: Int) {
        val heroName: String? = this.icons[list[position].heroId]
        if (heroName != null) PicassoUtils.setHeroIconSmall(holder.heroIcon, heroName)

        // TODO show localized name
        //holder.nickname.text = (list[position].accountId.toString())

        when {
            list[position].skill == 1 -> holder.skillbracket.text = "Normal Skill"
            list[position].skill == 2 -> holder.skillbracket.text = "High Skill"
            list[position].skill == 3 -> holder.skillbracket.text = "Very High Skill"
            else -> holder.skillbracket.text = "Unknown Skill"
        }
        holder.winLost.text = (" win: " + list[position].radiantWin.toString())

        val dur = getTime(list[position].duration!!)
        holder.duration.text = dur

        holder.startTime.text = (list[position].startTime.toString())
        holder.type.text = (list[position].gameMode.toString())
        holder.matchType.text = (list[position].lobbyType.toString())
        holder.kda.text = (
                list[position].kills.toString() + " / " +
                list[position].deaths.toString()  + " / " +
                list[position].assists.toString() + " "
                )
    }

    private fun getTime(totalSecs: Long) : String {
        val hours = totalSecs / 3600
        val minutes = (totalSecs % 3600) / 60
        val seconds = totalSecs % 60

        return String.format(Locale.ENGLISH, "%02d:%02d:%02d", hours, minutes, seconds)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    companion object {
        class MatchesHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var heroIcon: ImageView = itemView.ivHeroIcon
            var heroName: TextView = itemView.tvNickname
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