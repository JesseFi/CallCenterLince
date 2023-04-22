package com.hacka.demo.callcenter.flow.infra.repository.impl

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.infra.repository.database.CallDatabase
import com.hacka.demo.callcenter.flow.domain.repository.FlowRepository
import com.hacka.demo.callcenter.flow.infra.repository.database.FlowDatabase
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class FlowRepositoryImplementation : FlowRepository {
    override fun listAllFlow(): List<Flow>? {
         val flow: MutableList<Flow> = mutableListOf()
         return transaction {
            FlowDatabase.selectAll().map {
                Flow(
                    uuid = it[FlowDatabase.uuid],
                    number = it[FlowDatabase.number],
                    description = it[FlowDatabase.description],
                    approver_indicator = it[FlowDatabase.approver_indicator],
                    infra_indicator = it[FlowDatabase.infra_indicator],
                )
            }
        }
    }

    override fun create(flow: Flow): Flow? {
        var idGenerated = UUID.randomUUID()
        flow.uuid = idGenerated
        return transaction {
            FlowDatabase.insert {
                it[uuid] = flow.uuid!!
                it[number] = flow.number!!
                it[description] = flow.description!!
                it[approver_indicator] = flow.approver_indicator!!
                it[infra_indicator] = flow.infra_indicator!!
            }.resultedValues!!
            flow
        }
    }

    override fun getFlowById(uuid: UUID): Flow {
        return transaction {
            addLogger(StdOutSqlLogger)
            FlowDatabase.select{ FlowDatabase.uuid eq uuid }.map {
                Flow(
                    uuid = it[FlowDatabase.uuid],
                    number = it[FlowDatabase.number],
                    description = it[FlowDatabase.description],
                    approver_indicator = it[FlowDatabase.approver_indicator],
                    infra_indicator = it[FlowDatabase.infra_indicator],
                )
            }.firstOrNull()!!
        }
    }

}