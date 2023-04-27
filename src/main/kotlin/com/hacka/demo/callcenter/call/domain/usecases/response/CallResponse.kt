package com.hacka.demo.callcenter.call.domain.usecases.response

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.call.domain.entities.Call

data class CallResponse(
    val call: Call? = null,
    val message: Exception? = null
)
data class AllCallResponse(
    val call: List<Call>? = listOf(),
    val message: Exception? = null,
)

data class CallResponseUpdateSituation(
    val call: Call? = null,
    val situation: Int? = null,
    val message: Exception? = null
)

data class CallResponseUpdateReason(
    val call: Call? = null,
    val situation: Int? = null,
    val reason: Call? = null,
    val message: Exception? = null
)

data class FlowResponse(
    val flow: Flow? = null,
    val message: Exception? = null
)