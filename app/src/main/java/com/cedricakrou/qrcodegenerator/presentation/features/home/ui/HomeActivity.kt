package com.cedricakrou.qrcodegenerator.presentation.features.home.ui

import android.view.View
import android.widget.Toast
import com.cedricakrou.qrcodegenerator.presentation.common.BaseActivity
import com.cedricakrou.qrcodegenerator.R
import com.cedricakrou.qrcodegenerator.presentation.Utils
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<
        HomeIntent,
        HomeAction,
        HomeState,
        HomeViewModel>( HomeViewModel::class.java )
{

    override fun getLayoutResId(): Int = R.layout.activity_home

    override fun initUI() {

    }

    override fun initDATA() {

    }

    override fun initEVENT() {

        btn_submit.setOnClickListener {

//            Utils.hideAndShowView( ll_body, loading_bar )

            ll_body.visibility = View.GONE
            loading_bar.visibility = View.VISIBLE

            Toast.makeText( this, "Génération des qr codes", Toast.LENGTH_SHORT ).show()


            dispatchIntent(
                HomeIntent.Submit(
                    activity = this,
                    inf = if ( edt_inf.text.isEmpty() ) 0L else edt_inf.text.toString().toLong(),
                    sup = if ( edt_sup.text.isEmpty() ) 0L else edt_sup.text.toString().toLong()
                )
            )

        }

    }

    override fun render(state: HomeState) {

        when( state ) {
            is HomeState.LOADING -> {
                Utils.hideAndShowView( ll_body, loading_bar )
                Toast.makeText( this, "Génération des qr codes", Toast.LENGTH_SHORT ).show()

            }
            is HomeState.FINISH -> {
                Utils.hideAndShowView( loading_bar, ll_body)
                Toast.makeText( this, "Génération des qr code terminée", Toast.LENGTH_SHORT ).show()
            }

        }

    }

}