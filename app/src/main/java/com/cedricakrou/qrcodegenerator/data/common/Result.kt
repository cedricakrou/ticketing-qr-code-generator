package com.cedricakrou.artisanat.data.common

import com.cedricakrou.qrcodegenerator.data.common.CallErrors

/**
 * Created by Rim Gazzah on 8/28/20.
 **/
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: CallErrors) : Result<Nothing>()
    object Loading : Result<Nothing>()
}