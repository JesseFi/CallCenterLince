package com.hacka.demo.callcenter.call.domain.exceptions

val PACKING_STORAGE_ERROR = CallException("CALL_STORAGE_ERROR", "Um erro ocorreu ao tentar salvar o chamado")
val NUMBERCALL_NOT_ZEROS = CallException("CALL_STORAGE_ERROR", "NumeberCall can't be zeros!");
class CallException (
    code: String,
    description: String
) : Exception("Call-module")