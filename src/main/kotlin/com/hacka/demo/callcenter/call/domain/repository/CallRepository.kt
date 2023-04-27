package com.hacka.demo.callcenter.call.domain.repository

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.entities.Reason
import java.util.*

interface CallRepository {

        fun create (call: Call): Call?
        fun listAllCall (): List<Call>?
        fun listAllCallApprover (): List<Call>?
        fun getCallById (numberCall: Int): Call?

        fun getCallByUuid (uuid: UUID): Call?
        fun update(call: Call): Call?


        fun updateSituation(call: Call, situation: Int): Call?

        fun getFlowById(uuid: UUID): Flow

        fun updateReason(call: Call, situation: Int, reason: Reason): Call?


}