package com.hacka.demo.callcenter.flow.domain.infra.webservice.impl

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.flow.infra.webservice.CallService
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin(origins = ["http://10.0.11.76:3000"], allowCredentials = "true")
class CallServiceImplementation(private val CallUseCase: CallUseCase) : CallService {

    @PostMapping("/call/create")
    override fun create(@RequestBody call: Call): CallResponse {
        return CallUseCase.create(call)
    }
    /*@GetMapping("/call")
    override fun listaAllCall(): AllCallResponse {
        return FlowUseCase.listAllFlow()
    }*/
}