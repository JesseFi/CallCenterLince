package com.hacka.demo.callcenter.call.domain.repository

import com.hacka.demo.callcenter.call.domain.entities.Call
import java.util.*

interface CallRepository {
        fun create (call: Call): Call?
        fun listCalls (page: Int, size: Int, sorby: Int, orderBy: Int, callFilter: CallFilter): Call?
        fun getCallById (uuid: UUID): Call?
        fun getCallByCode(code: Int): Call?
}