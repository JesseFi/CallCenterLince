package com.hacka.demo.callcenter.call.domain.exceptions

import br.com.lince.singe.callcenter.packing.domain.exceptions.PackingException

val PACKING_STORAGE_ERROR = PackingException("CALL_STORAGE_ERROR", "Um erro ocorreu ao tentar salvar o chamado")
class CallException (
    code: String,
    description: String
) : GenericError("packing-module", code, description)