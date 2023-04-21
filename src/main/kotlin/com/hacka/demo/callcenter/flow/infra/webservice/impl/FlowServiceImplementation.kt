package com.hacka.demo.callcenter.flow.domain.infra.webservice.impl

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.flow.domain.usecases.FlowUseCase
import com.hacka.demo.callcenter.flow.domain.usecases.response.AllFlowResponse
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse
import com.hacka.demo.callcenter.flow.infra.webservice.FlowService
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class FlowServiceImplementation(private val FlowUseCase: FlowUseCase) : FlowService {

    @PostMapping("/flow/create")
    override fun create(@RequestBody flow: Flow): FlowResponse {
        return FlowUseCase.create(flow)
    }
    @GetMapping("/flow")
    override fun listAllFlow(): AllFlowResponse {
        return FlowUseCase.listAllFlow()
    }
}