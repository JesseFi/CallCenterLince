package com.hacka.demo.callcenter.call.infra.repository.impl

import com.hacka.demo.callcenter.call.domain.entities.Call
import com.hacka.demo.callcenter.call.domain.repository.CallRepository
import com.hacka.demo.callcenter.call.domain.usecases.response.CallFilter
import org.springframework.stereotype.Service
import java.util.*

@Service
class CallRepositoryImplementation : CallRepository {
    override fun create(call: Call): Call? {
        TODO("Not yet implemented")
    }

    override fun listCalls(page: Int, size: Int, sorby: Int, orderBy: Int, callFilter: CallFilter): Call? {
        TODO("Not yet implemented")
    }

    override fun getCallById(uuid: UUID): Call? {
        TODO("Not yet implemented")
    }

    override fun getCallByCode(code: Int): Call? {
        TODO("Not yet implemented")
    }

}