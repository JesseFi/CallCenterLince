package br.com.lince.singe.callcenter.packing.domain.repository

import br.com.lince.singe.callcenter.packing.domain.entities.Box
import br.com.lince.singe.callcenter.packing.domain.entities.Packing
import br.com.lince.singe.callcenter.packing.domain.entities.PackingList
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingFilter
import java.util.*

interface PackingRepository {
    fun create (packing: Packing): Packing?
    fun addItem (box: Box): Box?
    fun getByCode(code: Int): Packing?
    fun getById(uuid: UUID): Packing?
    fun getByIdDetailed(uuid: UUID): PackingList?
    fun getBoxesByPackingId(packingId: UUID): List<Box>?
    fun getBoxByNumber(number: Int): Box?
    fun getBoxById(uuid: UUID): Box?
    fun update(packing: Packing): Packing?
    fun updateBox(box: Box): Box?
    fun setWarehouse(packingId: UUID, warehouseId: UUID): Packing?
    fun list(page: Int, size: Int, sortBy: Int, orderBy: Int, packingFilter: PackingFilter): Packing?
    fun listBoxes(page: Int, size: Int, sortBy: Int, orderBy: Int, packingFilter: PackingFilter): Packing?
    fun getPackingByStockTransfer(transferUUID: UUID): List<Packing>
    fun getBoxByPackingUUIDStockTransfer(uuid: UUID?): List<Box>
}