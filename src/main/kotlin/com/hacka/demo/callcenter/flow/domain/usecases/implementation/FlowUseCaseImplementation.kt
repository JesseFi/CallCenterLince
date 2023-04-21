package com.hacka.demo.callcenter.flow.domain.usecases.implementation

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.flow.domain.repository.FlowRepository
import com.hacka.demo.callcenter.flow.domain.usecases.FlowUseCase
import com.hacka.demo.callcenter.flow.domain.usecases.response.AllFlowResponse
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse
import org.springframework.stereotype.Service

@Service
class FlowUseCaseImplementation (private val flowRepository: FlowRepository) : FlowUseCase {
    override fun listAllFlow(): AllFlowResponse {
        return try {
            AllFlowResponse(flow = flowRepository.listAllFlow())
        } catch (error: Exception) {
            AllFlowResponse(message = error)
        }
    }
    override fun create(flow: Flow): FlowResponse {
        TODO("Not yet implemented")
    }
}

