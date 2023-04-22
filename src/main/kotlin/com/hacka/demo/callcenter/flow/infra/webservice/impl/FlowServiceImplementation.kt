package com.hacka.demo.callcenter.flow.infra.webservice.impl

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.flow.domain.usecases.FlowUseCase
import com.hacka.demo.callcenter.flow.domain.usecases.response.AllFlowResponse
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse
import com.hacka.demo.callcenter.flow.infra.webservice.FlowService
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin(origins = ["http://10.0.11.76:3000", "http://10.0.11.168:3000"], allowCredentials = "true")
@RequestMapping("/flow")
class FlowServiceImplementation(private val FlowUseCase: FlowUseCase) : FlowService {

    @PostMapping("/create")
    override fun create(@RequestBody flow: Flow): FlowResponse {
        return FlowUseCase.create(flow)
    }
    @GetMapping("")
    override fun listAllFlow(): AllFlowResponse {
        return FlowUseCase.listAllFlow()
    }
}