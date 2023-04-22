package com.hacka.demo.callcenter.flow.domain.repository

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import java.util.UUID

interface FlowRepository {
    fun listAllFlow(): List<Flow>?
    fun create(flow: Flow): Flow?

    fun getFlowById(uuid: UUID): Flow

}