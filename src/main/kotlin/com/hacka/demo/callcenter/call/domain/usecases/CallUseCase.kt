package com.hacka.demo.callcenter.call.domain.usecases


import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse

interface CallUseCase {
    fun listAllCall(): AllCallResponse

    fun create(call: Call): CallResponse

}