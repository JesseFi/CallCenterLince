package br.com.lince.singe.callcenter.packing.domain.exceptions

import br.com.lince.singe.core.shared.error.GenericError

val PACKING_STORAGE_ERROR = PackingException("PACKING_STORAGE_ERROR", "An error has ocurred on packing storage")
val PACKING_DUPLICATED_COMEX = PackingException("PACKING_DUPLICATED_COMEX", "The packing's comex already exists")
val PACKING_INVALID_PARAMETERS = PackingException("PACKING_INVALID_PARAMETERS", "The packing's parameters aren't okay")
val PACKING_INVALID_WAREHOUSE = PackingException("PACKING_INVALID_WAREHOUSE", "The warehouse that you sent, is a invalid warehouse")

class PackingException(
    code: String,
    description: String
) : GenericError("packing-module", code, description)