package com.hacka.demo.callcenter.call.domain.usecases


import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponseUpdateSituation

interface CallUseCase {

    fun create(call: Call): CallResponse
    //fun save (call: Call) : CallResponse
    fun listAllCall(): AllCallResponse

    fun listAllCallApprover(): AllCallResponse
    fun getCallById(numberCall: Int): CallResponse

    fun updateSituation(numberCall: Int, situation: Int): CallResponseUpdateSituation
}