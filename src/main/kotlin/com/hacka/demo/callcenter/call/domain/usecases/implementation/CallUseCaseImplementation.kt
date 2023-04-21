package com.hacka.demo.callcenter.call.domain.usecases.implementation

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.call.infra.repository.database.CallDatabase
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.util.*

@Service
class CallUseCaseImplementation (val callRepository: CallRepository) : CallUseCase {
    override fun listAllCall(): AllCallResponse {
        return try {
            AllCallResponse(call = callRepository.listAllCall())
        } catch (error: Exception) {
            AllCallResponse(message = error)
        }
    }
    override fun create(call: Call): Call? {
        val idGenerated = UUID.randomUUID()
        call.uuid = idGenerated
        return transaction {
            CallDatabase.insert {
                it[uuid] = call.uuid!!
                it[numberCall] = call.numberCall!!
                it[title] = call.title!!
                it[flow_id] = call.flow!!.uuid!!
                it[contact] = call.contact!!
                it[priority] = call.priority!!
                it[author] = call.author!!
                it[originProblemN] = call.originProblemN!!
                it[originProblemS] = call.originProblemS!!
            }.resultedValues!!
            call
        }
    }
}