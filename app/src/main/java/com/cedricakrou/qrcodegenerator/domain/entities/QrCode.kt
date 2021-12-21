package com.cedricakrou.qrcodegenerator.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties( ignoreUnknown = true )
class QrCode( val ticketNumber : String = "", val createdDate : String = "", val scanDate : String = "" ) :
    Serializable