package com.cedricakrou.qrcodegenerator.presentation.features.home.ui

import com.cedricakrou.qrcodegenerator.presentation.common.BaseViewModel
import com.cedricakrou.qrcodegenerator.presentation.features.async.LikpechAsyncTask
import javax.inject.Inject


class HomeViewModel @Inject constructor(
) : BaseViewModel<
        HomeIntent,
        HomeAction,
        HomeState>()
{
    override fun intentToAction(intent: HomeIntent): HomeAction {

        return when( intent ) {
            is HomeIntent.INIT -> HomeAction.INIT
            is HomeIntent.Submit -> HomeAction.Submit(
                activity= intent.activity,
                inf = intent.inf,
                sup = intent.sup
            )
        }

    }

    override fun handleAction(action: HomeAction) {

        launchOnUi {

            when( action ) {

                is HomeAction.INIT -> {
                }

                is HomeAction.Submit -> {

                    val asyncTask = LikpechAsyncTask(
                        action.activity,
                        mState,
                        action.inf,
                        action.sup
                    )

                    asyncTask.execute()

                }

            }

        }

    }
}