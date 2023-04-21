package com.hacka.demo.callcenter.call.infra.repository.impl

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.response.CallFilter
import com.hacka.demo.callcenter.call.infra.repository.database.CallDatabase
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.util.*

@Service
class CallRepositoryImplementation : CallRepository {
    override fun create(call: Call): Call? {
        var idGenerated = UUID.randomUUID()
        call.uuid = idGenerated
        return transaction {
            CallDatabase.insert {
                it[uuid] = call.uuid!!
                it[numberCall] = call.numberCall!!
                it[title] = call.title!!
                //it[flow] = flow.uuid!!
                it[contact] = call.contact!!
                it[priority] = call.priority!!
                //it[createDate] = call.createDate!!
                it[author] = call.author!!
                it[originProblemN] = call.originProblemN!!
                it[originProblemS] = call.originProblemS!!
            }.resultedValues!!
            call
        }
    }

    override fun listCalls(page: Int, size: Int, sorby: Int, orderBy: Int, callFilter: CallFilter): Call? {
        TODO("Not yet implemented")
    }

    override fun getCallById(uuid: UUID): Call? {
        TODO("Not yet implemented")
    }

    override fun getCallByCode(code: Int): Call? {
        TODO("Not yet implemented")
    }

}