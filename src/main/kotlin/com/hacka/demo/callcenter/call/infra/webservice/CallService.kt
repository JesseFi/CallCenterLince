package com.hacka.demo.callcenter.call.infra.webservice

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.entities.Reason
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponseUpdateReason
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponseUpdateSituation
import java.util.UUID

interface CallService {
    fun listAllCall(): AllCallResponse

    fun create(flow: Call): CallResponse

    fun getCallById(numberCall: Int): CallResponse

    fun updateSituation(numberCall: Int, situation: Int): CallResponseUpdateSituation?

    fun updateReason(uuid: UUID, situation: Int, reason: Reason): CallResponseUpdateReason?

    fun listAllCallApprover(): AllCallResponse

}