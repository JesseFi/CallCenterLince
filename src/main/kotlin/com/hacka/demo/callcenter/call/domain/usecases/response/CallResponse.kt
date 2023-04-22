package com.hacka.demo.callcenter.call.domain.usecases.response

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