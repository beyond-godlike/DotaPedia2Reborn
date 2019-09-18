package com.unava.dia.dotapedia2reborn.ui.dotabuff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.ui.dotabuff.checker.MmrCheckerActivity
import com.unava.dia.dotapedia2reborn.ui.dotabuff.history.MatchesHistoryActivity
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchActivity
import kotlinx.android.synthetic.main.activity_dotabuff.*

class DotabuffActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dotabuff)

        btFindHistory.setOnClickListener {
            val intent = Intent(this, MatchesHistoryActivity::class.java)
            intent.putExtra("PLAYER_ID", etFindHistory.text.toString())
            startActivity(intent)
        }

        btFindMatch.setOnClickListener {
            // передаем номер матча
            val intent = Intent(this, MatchActivity::class.java)
            intent.putExtra("MATCH_NUMBER", etFindMatch.text.toString())
            startActivity(intent)
        }

        btFindPlayer.setOnClickListener {
            // передаем в активити номер акка
            val intent = Intent(this, MmrCheckerActivity::class.java)
            intent.putExtra("PLAYER_ID", etFindPlayer.text.toString())
            startActivity(intent)
        }
    }
}
