package com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.utils.PicassoUtils
import com.unava.dia.dotapedia2reborn.utils.ProjectConstants
import com.unava.dia.dotapedia2reborn.utils.Utils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_hero_ctor.*
import javax.inject.Inject

class HeroConstructorActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: HeroConstructorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_ctor)
        AndroidInjection.inject(this)
        this.bindViewModel()
        init()
    }

    private fun init() {
        val id = this.intent.flags
        this.viewModel.loadHero(id)
        this.viewModel.updateLvl()

        btPlus.setOnClickListener {
            this.viewModel.addLvl()
        }
        btMinus.setOnClickListener {
            this.viewModel.minusLvl()
        }
        btMaximum.setOnClickListener {
            this.viewModel.maxLvl()
        }
        btMinimum.setOnClickListener {
            this.viewModel.resetLvl()
        }

        skill_one.setOnClickListener { this.viewModel.updateSkillDescription(1) }
        skill_two.setOnClickListener { this.viewModel.updateSkillDescription(2) }
        skill_three.setOnClickListener { this.viewModel.updateSkillDescription(3) }
        skill_four.setOnClickListener { this.viewModel.updateSkillDescription(4) }
        skill_five.setOnClickListener { this.viewModel.updateSkillDescription(5) }
        skill_six.setOnClickListener { this.viewModel.updateSkillDescription(6) }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProvider(this, viewModelFactory).get(HeroConstructorViewModel::class.java)
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.hero.observe(this, Observer {
            PicassoUtils.setImageHero(
                ivHero,
                it.rname,
                ProjectConstants.IMAGE_HERO_CONSTRUCTOR_WIDTH,
                ProjectConstants.IMAGE_HERO_CONSTRUCTOR_HEIGHT
            )
            tvLvl.text = (it.currentLvl+1).toString()
            tvHp.text = (formatter(it.currentHp) + " (" + formatter(it.currentEHP) + "), (" + formatter(it.currentEHPm) + ") ")
            tvMp.text = formatter(it.currentMp)

            tvAttack.text = (formatter(it.currentDmg1) + " + " + formatter(it.currentDmg2))
            tvArmor.text = formatter(it.currentArmor)
            tvSpeed.text = it.currentSpeed.toString()

            tvAgility.text = (formatter(it.currentAgility) + " + " + formatter(it.addAg))
            tvStrength.text = (formatter(it.currentStrength) + " + " + formatter(it.addSt))
            tvIntelligence.text = (formatter(it.currentIntelligence) + " + " + formatter(it.addInt))

            skill_one.setImageDrawable(Drawable.createFromStream(Utils.openImage(it.skill1, applicationContext), null))
            skill_two.setImageDrawable(Drawable.createFromStream(Utils.openImage(it.skill2, applicationContext), null))
            skill_three.setImageDrawable(
                Drawable.createFromStream(
                    Utils.openImage(it.skill3, applicationContext),
                    null
                )
            )
            skill_six.setImageDrawable(Drawable.createFromStream(Utils.openImage(it.skill6, applicationContext), null))
            if (it.skill4.isNotEmpty()) {
                skill_four.visibility = View.VISIBLE
                skill_four.setImageDrawable(
                    Drawable.createFromStream(
                        Utils.openImage(it.skill4, applicationContext),
                        null
                    )
                )
            }
            if (it.skill5.isNotEmpty()) {
                skill_five.visibility = View.VISIBLE
                skill_five.setImageDrawable(
                    Drawable.createFromStream(
                        Utils.openImage(it.skill5, applicationContext),
                        null
                    )
                )
            }
        })
        this.viewModel.skillDescription.observe(this, Observer {
            tvSkillDescription.text = it.toString()
        })
    }

    private fun formatter(number: Double) : String {
        return (Integer.toString(number.toInt()))
    }

    fun formatterD(number: Double) : String {
        return number.toString()
    }
}
