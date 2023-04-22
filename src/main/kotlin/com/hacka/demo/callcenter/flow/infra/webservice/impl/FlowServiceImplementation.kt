package com.hacka.demo.callcenter.flow.infra.webservice.impl

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.flow.domain.usecases.FlowUseCase
import com.hacka.demo.callcenter.flow.domain.usecases.response.AllFlowResponse
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse
import com.hacka.demo.callcenter.flow.infra.webservice.FlowService
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin("*")
@RequestMapping("/flow")
class FlowServiceImplementation(
    val flowUseCase: FlowUseCase
) : FlowService {

    @PostMapping("/create")
    override fun create(@RequestBody flow: Flow): FlowResponse {
        return flowUseCase.create(flow)
    }
    @GetMapping
    override fun listAllFlow(): AllFlowResponse {
        return flowUseCase.listAllFlow()
    }
}