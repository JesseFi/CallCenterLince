package com.hacka.demo.callcenter.call.domain.usecases.implementation

import br.com.lince.singe.callcenter.packing.domain.usecases.response.CallFilter
import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import org.springframework.stereotype.Service

@Service
class CallUseCaseImplementation (private val callRepository: CallRepository) : CallUseCase {
    override fun listAllCall(): AllCallResponse {
        TODO("Not yet implemented")
    }
    override fun create(call: Call): CallResponse {
        TODO("Not yet implemented")
    }
}