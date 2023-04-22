package com.hacka.demo.callcenter.call.domain.exceptions

val PACKING_STORAGE_ERROR = CallException("CALL_STORAGE_ERROR", "Um erro ocorreu ao tentar salvar o chamado")
val NUMBERCALL_NOT_ZEROS = CallException("CALL_STORAGE_ERROR", "NumeberCall can't be zeros!");
val FLOW_NOT_EXIST = CallException("FLOW_NOT_EXIST", "Flow doesn't exists!");
class CallException (
    code: String,
    description: String
) : Exception("Call-module")