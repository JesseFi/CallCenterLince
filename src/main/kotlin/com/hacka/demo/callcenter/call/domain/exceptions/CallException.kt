package com.hacka.demo.callcenter.call.domain.exceptions

val PACKING_STORAGE_ERROR = CallException("CALL_STORAGE_ERROR", "Um erro ocorreu ao tentar salvar o chamado")
class CallException (
    code: String,
    description: String
) : Exception("Call-module")