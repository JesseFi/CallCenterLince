package com.hacka.demo.callcenter.call.domain.usecases


import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse

interface CallUseCase {
    fun save (call: Call) : CallResponse
}