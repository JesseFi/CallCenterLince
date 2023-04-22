package com.hacka.demo.callcenter.call.infra.repository.impl

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.infra.repository.database.CallDatabase
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CallRepositoryImplementation : CallRepository {
    override fun create(call: Call): Call? {
        val idGenerated = UUID.randomUUID()
        call.uuid = idGenerated
        return transaction {
            CallDatabase.insert {
                it[uuid] = call.uuid!!
                it[numberCall] = call.numberCall!!
                it[title] = call.title!!
                //it[flow_id] = call.flow!!.uuid!!
                it[contact] = call.contact!!
                it[priority] = call.priority!!
                it[author] = call.author!!
                it[originProblemN] = call.originProblemN!!
                it[originProblemS] = call.originProblemS!!
                it[richText] = call.richText!!
            }.resultedValues!!
            call
        }
    }

    override fun listAllCall(): List<Call>? {
        val flow: MutableList<Call> = mutableListOf()
        return transaction {
            CallDatabase.selectAll().map {
                Call(
                    uuid = it[CallDatabase.uuid],
                    numberCall = it[CallDatabase.numberCall],
                    title = it[CallDatabase.title],
                    //flow = it[CallDatabase.flow],
                    contact = it[CallDatabase.contact],
                    priority = it[CallDatabase.priority],
                    author = it[CallDatabase.author],
                    originProblemN = it[CallDatabase.originProblemN],
                    originProblemS = it[CallDatabase.originProblemS],
                )
            }
        }
    }

    override fun getCallById(numberCall: Int): Call?{
        return transaction {
            CallDatabase.select{CallDatabase.numberCall eq numberCall}.map {
                Call(
                    uuid = it[CallDatabase.uuid],
                    numberCall = it[CallDatabase.numberCall],
                    title = it[CallDatabase.title],
                    //flow = it[CallDatabase.flow],
                    contact = it[CallDatabase.contact],
                    priority = it[CallDatabase.priority],
                    author = it[CallDatabase.author],
                    originProblemN = it[CallDatabase.originProblemN],
                    originProblemS = it[CallDatabase.originProblemS],
                    richText = it[CallDatabase.richText]
                )
            }.firstOrNull()!!
        }
    }


}