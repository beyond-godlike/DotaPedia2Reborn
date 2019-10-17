package com.unava.dia.dotapedia2reborn.ui.dotabuff.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.history.*
import com.unava.dia.dotapedia2reborn.ui.common.PicassoUtils
import kotlinx.android.synthetic.main.card_matches_history.view.*
import java.util.*

class MatchesHistoryAdapter(
    private val heroes: ArrayList<HeroInfo>,
    private val matches: ArrayList<HistoryMatch>
) :
    RecyclerView.Adapter<MatchesHistoryAdapter.MatchesHistoryViewHolder>() {

    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesHistoryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_matches_history, parent, false)

        return MatchesHistoryViewHolder(v)
    }

    override fun onBindViewHolder(holder: MatchesHistoryViewHolder, position: Int) {
        val hero = heroes.find { it.heroId == matches[position].heroId }

        holder.matchId = matches[position].matchId.toString()
        PicassoUtils.setHeroIconSmall(holder.heroIcon, hero?.name!!)
        holder.heroName.text = hero.localizedName
        if (matches[position].skill != null) {
            holder.skillbracket.text = SkillBrackets.brackets[matches[position].skill!!]
        } else {
            holder.skillbracket.text = SkillBrackets.brackets[0]
        }
        if (matches[position].radiantWin == true) {
            holder.winLost.text = "Won Match"
        } else {
            holder.winLost.text = "Lost Match"
        }
        holder.duration.text = getTime(matches[position].duration!!)
        holder.startTime.text = getDays(matches[position].startTime!!)
        holder.type.text = GameModes.modes[matches[position].gameMode!!]
        holder.matchType.text = LobbyTypes.types[matches[position].lobbyType!!]
        holder.kda.text = (
                matches[position].kills.toString() + " / " +
                        matches[position].deaths.toString() + " / " +
                        matches[position].assists.toString() + " "
                )
    }

    private fun getTime(totalSecs: Long): String {
        val hours = totalSecs / 3600
        val minutes = (totalSecs % 3600) / 60
        val seconds = totalSecs % 60

        return String.format(Locale.ENGLISH, "%02d:%02d:%02d", hours, minutes, seconds)
    }

    private fun getDays(startTime: Long): String {
        val todaySecs = System.currentTimeMillis() / 1000

        val secs = todaySecs - startTime
        val days = secs / (24 * 3600)
        val hours = secs / 3600
        val minutes = (secs % 3600) / 60

        return when {
            (days > 0) -> days.toString().plus(" days ago")
            else ->  String.format(Locale.ENGLISH, "%02d:%02d", hours, minutes).plus(" ago")
        }
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    inner class MatchesHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var matchId: String? = null
        var heroIcon: ImageView = itemView.ivHeroIcon
        var heroName: TextView = itemView.tvNickname
        var skillbracket: TextView = itemView.tvSkillbracket
        var winLost: TextView = itemView.tvWinLost
        var startTime: TextView = itemView.tvStartTime
        var type: TextView = itemView.tvType
        var matchType: TextView = itemView.tvMatchType
        var duration: TextView = itemView.tvDuration
        var kda: TextView = itemView.tvKDA

        init {
            itemView.setOnClickListener {
                if (matchId != null)
                    onItemClick?.invoke(matchId!!)
            }
        }

    }
}