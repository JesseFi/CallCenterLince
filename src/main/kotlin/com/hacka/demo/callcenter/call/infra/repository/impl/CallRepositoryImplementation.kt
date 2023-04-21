package com.hacka.demo.callcenter.call.infra.repository.impl

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.infra.repository.database.CallDatabase
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
@Repository
class CallRepositoryImplementation : CallRepository {
    override fun create(call: Call): Call? {
        TODO("Not yet implemented")
    }

    override fun listAllCall(): List<Call>? {
        val flow: MutableList<Call> = mutableListOf()
        return transaction {
            CallDatabase.selectAll().map {
                Call(
                    uuid = it[CallDatabase.uuid],
                    numberCall = it[CallDatabase.numberCall],
                    title = it[CallDatabase.title],
                    flow = it[CallDatabase.flow],
                    contact = it[CallDatabase.contact],
                    priority = it[CallDatabase.priority],
                    author = it[CallDatabase.author],
                    originProblemN = it[CallDatabase.originProblemN],
                    originProblemS = it[CallDatabase.originProblemS],
                )
            }
        }
    }


}