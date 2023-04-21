package com.hacka.demo.callcenter.call.domain.usecases.implementation

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import org.springframework.stereotype.Service

@Service
class CallUseCaseImplementation (private val callRepository: CallRepository) : CallUseCase {
    override fun save(call: Call): CallResponse {
        return try{
            CallResponse(call = callRepository.create(call))
        } catch (e: Exception) {
            CallResponse(message = e)
        }
    }
}