package com.hacka.demo.callcenter.call.domain.repository

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.call.domain.entities.Call
import java.util.*

interface CallRepository {

        fun create (call: Call): Call?
        fun listAllCall (): List<Call>?
        fun listAllCallApprover (): List<Call>?
        fun getCallById (numberCall: Int): Call?
        fun update(call: Call): Call?


        fun updateSituation(call: Call, situation: Int): Call?

        fun getFlowById(uuid: UUID): Flow


}