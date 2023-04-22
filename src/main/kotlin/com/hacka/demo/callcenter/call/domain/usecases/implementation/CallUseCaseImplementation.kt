package com.hacka.demo.callcenter.call.domain.usecases.implementation

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.exceptions.NUMBERCALL_NOT_ZEROS
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.CallUseCase
import com.hacka.demo.callcenter.call.domain.usecases.response.AllCallResponse
import com.hacka.demo.callcenter.call.domain.usecases.response.CallResponse
import com.hacka.demo.callcenter.call.infra.repository.database.CallDatabase
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.util.*

@Service
class CallUseCaseImplementation (val callRepository: CallRepository) : CallUseCase {
    override fun listAllCall(): AllCallResponse {
        return try {
            AllCallResponse(call = callRepository.listAllCall())
        } catch (error: Exception) {
            AllCallResponse(message = error)
        }
    }

    override fun create(call: Call): CallResponse {
        return try{
            if (call.numberCall == 0) {
                CallResponse(message = NUMBERCALL_NOT_ZEROS)
            }
            if (call.uuid == null) {
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