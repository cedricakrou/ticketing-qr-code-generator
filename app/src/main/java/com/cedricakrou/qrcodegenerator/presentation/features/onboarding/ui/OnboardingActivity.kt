package com.cedricakrou.qrcodegenerator.presentation.features.onboarding.ui

import android.content.Intent
import com.cedricakrou.qrcodegenerator.presentation.common.BaseActivity
import com.cedricakrou.qrcodegenerator.R
import com.cedricakrou.qrcodegenerator.presentation.features.home.ui.HomeActivity
import com.cedricakrou.qrcodegenerator.presentation.features.home.ui.HomeViewModel
import com.cedricakrou.qrcodegenerator.presentation.features.onboarding.OnBoardingViewModel
import com.cedricakrou.qrcodegenerator.presentation.features.onboarding.OnboardingAction
import com.cedricakrou.qrcodegenerator.presentation.features.onboarding.OnboardingIntent
import com.cedricakrou.qrcodegenerator.presentation.features.onboarding.OnboardingState
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_onboarding.*
import java.util.ArrayList

class OnboardingActivity : BaseActivity<
        OnboardingIntent,
        OnboardingAction,
        OnboardingState,
        OnBoardingViewModel>( OnBoardingViewModel::class.java ) {


    // fill list screen
    private val mList: MutableList<ScreenItem> = ArrayList<ScreenItem>()

    private val mAdapter = IntroViewPagerAdapter(this, mList)



    override fun getLayoutResId(): Int = R.layout.activity_onboarding

    override fun initUI() {

        mList.add(
            ScreenItem(
                "Bienvenue à Qr Code Generator'",
                "Générer au les Qr Code à poser sur vos tickets.",
                R.drawable.onboarding_img1
            )
        )

        mList.add(
            ScreenItem(
                "EVENEMENT",
                "Entrez la capacité minimale et la capacité maximale de votre événement puis nous générons vos tickets",
                R.drawable.onboarding_img2
            )
        )

        mList.add(
            ScreenItem(
                "AVENTURE",
                "Embarquez avec nous dans cette aventure merveilleuse.",
                R.drawable.onboarding_img3
            )
        )


        screen_viewpager.adapter = mAdapter
        mAdapter.notifyDataSetChanged()

        tab_indicator.setupWithViewPager( screen_viewpager )

        // tablayout add change listener
        tab_indicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {


            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

    override fun initDATA() {



    }

    override fun initEVENT() {

         btn_start.setOnClickListener {

             dispatchIntent(OnboardingIntent.FirstConnection)

        }
    }

    override fun render(state: OnboardingState) {

        when( state ) {
            is OnboardingState.FirstConnection -> {

                val intent = Intent( this, HomeActivity::class.java )

                startActivity( intent )

                finish()
            }
        }

    }





}