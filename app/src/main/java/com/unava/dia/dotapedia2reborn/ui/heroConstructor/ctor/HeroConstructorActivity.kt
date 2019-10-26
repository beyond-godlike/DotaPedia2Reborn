package com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.common.PicassoUtils
import com.unava.dia.dotapedia2reborn.common.ProjectConstants
import com.unava.dia.dotapedia2reborn.common.loadImage
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
        this.viewModel.loadHero(this.intent?.extras!!.getInt("HERO_ID"))
        this.viewModel.updateLvl()

        btPlus.setOnClickListener { this.viewModel.addLvl() }
        btMinus.setOnClickListener { this.viewModel.minusLvl() }
        btMaximum.setOnClickListener { this.viewModel.maxLvl() }
        btMinimum.setOnClickListener { this.viewModel.resetLvl() }
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
            tvLvl.text = (it.currentLvl + 1).toString()
            tvHp.text =
                (doubleToString(it.currentHp) + " (" + doubleToString(it.currentEHP) + "), (" + doubleToString(it.currentEHPm) + ") ")
            tvMp.text = doubleToString(it.currentMp)
            tvAttack.text = (doubleToString(it.currentDmg1) + " + " + doubleToString(it.currentDmg2))
            tvArmor.text = doubleToString(it.currentArmor)
            tvSpeed.text = it.currentSpeed.toString()
            tvAgility.text = (doubleToString(it.currentAgility) + " + " + doubleToString(it.agi_gain))
            tvStrength.text = (doubleToString(it.currentStrength) + " + " + doubleToString(it.str_gain))
            tvIntelligence.text = (doubleToString(it.currentIntelligence) + " + " + doubleToString(it.int_gain))
            skill_one.loadImage(it.skill1, applicationContext)
            skill_two.loadImage(it.skill2, applicationContext)
            skill_three.loadImage(it.skill3, applicationContext)
            skill_six.loadImage(it.skill6, applicationContext)
            if (it.skill4.isNotEmpty()) {
                skill_four.loadImage(it.skill4, applicationContext)
            }
            if (it.skill5.isNotEmpty()) {
                skill_five.visibility = View.VISIBLE
                skill_five.loadImage(it.skill5, applicationContext)
            }
        })
        this.viewModel.skillDescription.observe(this, Observer {
            tvSkillDescription.text = it.toString()
        })
        this.viewModel.invoker.observe(this, Observer {
            if(it.skill4 != it.skill5) {
                skill_four.loadImage(it.skill4, applicationContext)
                skill_five.loadImage(it.skill5, applicationContext)
            }
            else {
              // TODO not implemented yet
            }
        })
    }

    private fun doubleToString(number: Double): String {
        return (number.toInt().toString())
    }
}
