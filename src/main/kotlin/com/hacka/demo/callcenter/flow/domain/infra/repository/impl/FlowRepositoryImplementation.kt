package com.hacka.demo.callcenter.flow.domain.infra.repository.impl

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import br.com.lince.singe.callcenter.flow.domain.repository.FlowRepository
import br.com.lince.singe.callcenter.flow.infra.repository.database.FlowDatabase
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class FlowRepositoryImplementation() : FlowRepository {
    override fun listAllFlow(): Flow? {
        return transaction {
            FlowDatabase.selectAll().map {
                Flow(
                    uuid = it[FlowDatabase.uuid],
                    number = it[FlowDatabase.number],
                    description = it[FlowDatabase.description],
                    approver_indicator = it[FlowDatabase.approver_indicator],
                    infra_indicator = it[FlowDatabase.infra_indicator],
                )
            }.firstOrNull()
        }
    }
}