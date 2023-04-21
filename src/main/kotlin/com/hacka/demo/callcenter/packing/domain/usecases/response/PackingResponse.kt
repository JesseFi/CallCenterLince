package br.com.lince.singe.callcenter.packing.domain.usecases.response

import br.com.lince.singe.callcenter.packing.domain.entities.Packing
import br.com.lince.singe.callcenter.packing.domain.entities.PackingList
import br.com.lince.singe.callcenter.packing.domain.exceptions.PackingException

data class PackingResponse(
    val packing: Packing? = null,
    val message: PackingException? = null
)

data class PackingListResponse(
    val packing: PackingList,
    val message: PackingException? = null
)
