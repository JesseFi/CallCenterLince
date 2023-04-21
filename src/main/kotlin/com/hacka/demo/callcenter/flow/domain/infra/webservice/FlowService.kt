package com.hacka.demo.callcenter.flow.domain.infra.webservice.impl

import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse

interface FlowService {
    fun listAllFlow(): FlowResponse
}