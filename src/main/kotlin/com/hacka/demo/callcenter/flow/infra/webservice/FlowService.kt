package com.hacka.demo.callcenter.flow.infra.webservice

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.flow.domain.usecases.response.AllFlowResponse
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse

interface FlowService {
    fun listAllFlow(): AllFlowResponse

    fun create(flow: Flow): FlowResponse
}