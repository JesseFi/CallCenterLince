package br.com.lince.singe.callcenter.packing.domain.usecases

import br.com.lince.singe.callcenter.packing.domain.entities.Packing
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingFilter
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingListResponse
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingResponse
import java.util.*

interface PackingUseCase {
    fun save (packing: Packing) : PackingResponse
    fun getPacking (packingId: UUID) : PackingResponse
    fun setWarehouse (packingId: UUID, warehouseId: UUID?) : PackingResponse
    fun getByIdDetailed(packingId: UUID): PackingListResponse
    fun list (packingFilter: PackingFilter) : PackingResponse
    fun listBoxes (packingFilter: PackingFilter) : PackingResponse
}