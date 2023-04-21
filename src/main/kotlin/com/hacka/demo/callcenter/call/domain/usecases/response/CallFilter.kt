package com.hacka.demo.callcenter.call.domain.usecases.response

class CallFilter(
    val name: String,
    val value: String,
) {
    override fun toString(): String {
        return "UserFilters=($name, $value)"
    }
}