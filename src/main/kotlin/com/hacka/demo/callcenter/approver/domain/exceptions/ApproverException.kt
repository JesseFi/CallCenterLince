package com.hacka.demo.callcenter.approver.domain.exceptions

import com.hacka.demo.callcenter.call.domain.exceptions.CallException

val PACKING_STORAGE_ERROR = CallException("APPROVER_STORAGE_ERROR", "ERRO AO CADASTRAS APROVADOR")
class ApproverException(
    code: String,
    description: String
) : Exception("Approver-module")