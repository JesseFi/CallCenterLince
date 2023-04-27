package com.hacka.demo.callcenter.call.infra.webservice.impl

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.entities.Reason
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponseUpdateReason
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponseUpdateSituation
import com.hacka.demo.callcenter.call.infra.webservice.CallService
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@CrossOrigin(origins = ["http://10.0.11.76:3000", "http://10.0.11.168:3000"], allowCredentials = "true")
@RequestMapping("/call")
class CallServiceImplementation(private val CallUseCase: CallUseCase) : CallService {

    @PostMapping("/create")
    override fun create(@RequestBody call: Call): CallResponse {
        return CallUseCase.create(call)
    }

    @GetMapping("")
    override fun listAllCall(): AllCallResponse {
        return CallUseCase.listAllCall()
    }

    @GetMapping("/approver")
    override fun listAllCallApprover(): AllCallResponse {
        return CallUseCase.listAllCallApprover()
    }

    @GetMapping("/{numberCall}")
    override fun getCallById(@PathVariable numberCall: Int): CallResponse {
        return CallUseCase.getCallById(numberCall)
    }


    // AAAAAAAAAAAAA
    @PostMapping("update/{numberCall}/{situation}")
    override fun updateSituation(@PathVariable numberCall: Int, @PathVariable situation: Int): CallResponseUpdateSituation? {
        return CallUseCase.updateSituation(numberCall, situation)
    }

    @PostMapping("updateReason/{uuid}/{situation}")
    override fun updateReason(@PathVariable uuid: UUID, @PathVariable situation: Int, @RequestBody reason: Reason): CallResponseUpdateReason? {
        return CallUseCase.updateReason(uuid, situation, reason)
    }


}
