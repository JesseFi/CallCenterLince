package com.hacka.demo.callcenter.call.domain.usecases.implementation

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.flow.domain.repository.FlowRepository
import org.springframework.stereotype.Service

@Service
class CallUseCaseImplementation (
    val callRepository: CallRepository,
    val flowRepository: FlowRepository
) : CallUseCase {
    override fun listAllCall(): AllCallResponse {
        return try {
            AllCallResponse(call = callRepository.listAllCall())
        } catch (error: Exception) {
            AllCallResponse(message = error)
        }
    }

    override fun create(call: Call): CallResponse {
        return try{
            if (call.uuid == null || call.uuid.toString() == "") {
                val flow: Flow = flowRepository.getFlowById(call.flow!!.uuid!!)
                if (flow.approver_indicator) {
                    call.situation = 66
                } else {
                    call.situation = 99
                }
                CallResponse(call = callRepository.create(call))
            } else {
                CallResponse(call = callRepository.update(call))
            }
        } catch (e: Exception) {
            CallResponse(message = e)
        }
    }

    override fun getCallById(numberCall: Int): CallResponse{
        return try{
            CallResponse(call = callRepository.getCallById(numberCall))
        } catch (e: Exception) {
            CallResponse(message = e)
        }
    }
}