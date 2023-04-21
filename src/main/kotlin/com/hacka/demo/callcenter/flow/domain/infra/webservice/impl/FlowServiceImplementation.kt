package com.hacka.demo.callcenter.flow.domain.infra.webservice.impl

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import br.com.lince.singe.callcenter.flow.domain.repository.FlowRepository
import br.com.lince.singe.callcenter.packing.domain.usecases.response.FlowFilter
import com.hacka.demo.callcenter.flow.domain.usecases.FlowUseCase
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
class FlowServiceImplementation(private val FlowUseCase: FlowUseCase) : FlowService {
    @GetMapping("/flow")
    override fun listAllFlow(): FlowResponse {
        return FlowUseCase.listAllFlow()
    }
}