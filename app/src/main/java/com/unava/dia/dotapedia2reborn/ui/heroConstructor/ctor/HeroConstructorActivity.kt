package com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.data.Invoker
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

            tvAgility.text = (doubleToString(it.currentAgility) + " + " + doubleToString(it.addAg))
            tvStrength.text = (doubleToString(it.currentStrength) + " + " + doubleToString(it.addSt))
            tvIntelligence.text = (doubleToString(it.currentIntelligence) + " + " + doubleToString(it.addInt))

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
        this.viewModel.invoker.observe(this, Observer {
            if(it.skill4 != it.skill5) {
                skill_four.setImageDrawable(
                    Drawable.createFromStream(
                        Utils.openImage(it.skill4, applicationContext),
                        null)
                )
                skill_five.setImageDrawable(
                    Drawable.createFromStream(
                        Utils.openImage(it.skill5, applicationContext),
                        null
                    )
                )
            }
            else {
              // do not update
            }
        })
    }

    private fun doubleToString(number: Double): String {
        return (Integer.toString(number.toInt()))
    }
}
