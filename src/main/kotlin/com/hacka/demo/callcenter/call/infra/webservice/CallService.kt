package com.hacka.demo.callcenter.call.infra.webservice

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponseUpdateSituation

interface CallService {
    fun listAllCall(): AllCallResponse

    fun create(flow: Call): CallResponse

    fun getCallById(numberCall: Int): CallResponse

    fun updateSituation(numberCall: Int, situation: Int): CallResponseUpdateSituation?

    fun listAllCallApprover(): AllCallResponse

}