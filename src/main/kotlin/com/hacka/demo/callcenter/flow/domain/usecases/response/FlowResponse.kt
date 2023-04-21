package com.hacka.demo.callcenter.flow.domain.usecases.response

import br.com.lince.singe.callcenter.flow.domain.entities.Flow

data class FlowResponse(
    val flow: Flow? = null,
    val message: Exception? = null
)

data class AllFlowResponse(
    val flow: List<Flow>? = listOf(),
    val message: Exception? = null
)