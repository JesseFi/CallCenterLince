package com.hacka.demo.callcenter.call.domain.usecases.response

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.exceptions.CallException

data class CallResponse(
    val call: Call? = null,
    val message: CallException? = null
)

data class CallListResponse(
    //val packing: CallList,
    val message: CallException? = null
)