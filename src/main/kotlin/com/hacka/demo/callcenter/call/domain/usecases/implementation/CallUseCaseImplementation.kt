package com.hacka.demo.callcenter.call.domain.usecases.implementation

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponseUpdateSituation
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

    override fun listAllCallApprover(): AllCallResponse {
        return try {
            AllCallResponse(call = callRepository.listAllCallApprover())
        } catch (error: Exception) {
            AllCallResponse(message = error)
        }
    }

    override fun create(call: Call): CallResponse {
        return try{
            if (call.uuid == null || call.uuid.toString() == "") {
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

    override fun updateSituation(numberCall: Int, situation: Int): CallResponseUpdateSituation {
        return try{

            var call: Call? = null
            call = callRepository.getCallById(numberCall)
            call!!.situation = numberCall
            CallResponseUpdateSituation(callRepository.updateSituation(call, situation))
        } catch(e: Exception){
            CallResponseUpdateSituation(message = e)
        }

    }
}