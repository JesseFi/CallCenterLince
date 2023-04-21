package br.com.lince.singe.callcenter.packing.domain.usecases.response

import br.com.lince.singe.callcenter.packing.domain.entities.Box
import br.com.lince.singe.callcenter.packing.domain.exceptions.PackingException

data class BoxResponse(
    val box: Box? = null,
    val message: PackingException? = null
)

data class allBoxesResponse(
    val boxes: List<Box> = listOf(),
    val message: PackingException? = null
)