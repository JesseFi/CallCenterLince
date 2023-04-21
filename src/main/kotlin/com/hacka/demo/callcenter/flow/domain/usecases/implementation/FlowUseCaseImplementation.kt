package br.com.lince.singe.callcenter.flow.domain.usecases.implementation

import br.com.lince.singe.callcenter.flow.domain.repository.FlowRepository
import br.com.lince.singe.callcenter.packing.domain.usecases.response.FlowFilter
import com.hacka.demo.callcenter.flow.domain.usecases.FlowUseCase
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse
import org.springframework.stereotype.Service

@Service
class FlowUseCaseImplementation (private val flowRepository: FlowRepository) : FlowUseCase {
    override fun listAllFlow(flowFilter: FlowFilter): FlowResponse {
        TODO("Not yet implemented")
    }


}