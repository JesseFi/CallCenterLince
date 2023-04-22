package br.com.lince.singe.callcenter.flow.domain.exceptions

import com.hacka.demo.callcenter.call.domain.exceptions.CallException

val FLOW_NOT_NULL = FlowException("FLOW_STORAGE_ERROR", "UUID FLOW CAN'T BE NULL");
class FlowException (
    code: String,
    description: String
) : Exception("packing-module")