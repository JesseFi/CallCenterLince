package com.hacka.demo.callcenter.call.domain.repository

import com.hacka.demo.callcenter.call.domain.entities.Call

interface CallRepository {

        fun create (call: Call): Call?
        fun listAllCall (): List<Call>?
        fun getCallById (callNumber: Int): Call?

}