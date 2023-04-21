package com.hacka.demo.callcenter.flow.infra.webservice

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse

interface CallService {

    fun create(call: Call): CallResponse

}