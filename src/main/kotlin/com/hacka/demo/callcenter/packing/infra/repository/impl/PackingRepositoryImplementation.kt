package br.com.lince.singe.callcenter.packing.infra.repository.impl

import br.com.lince.singe.callcenter.packing.domain.entities.Box
import br.com.lince.singe.callcenter.packing.domain.entities.Packing
import br.com.lince.singe.callcenter.packing.domain.entities.PackingList
import br.com.lince.singe.callcenter.packing.domain.repository.PackingRepository
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingFilter
import br.com.lince.singe.callcenter.packing.infra.repository.database.BoxDatabase
import br.com.lince.singe.callcenter.packing.infra.repository.database.PackingDatabase
import br.com.lince.singe.callcenter.product.domain.entities.Product
import br.com.lince.singe.callcenter.product.infraestructure.repository.database.ProductDatabase
import br.com.lince.singe.callcenter.product.infraestructure.repository.database.VariantDatabase
import br.com.lince.singe.callcenter.stock.infraestructure.repository.database.StockTransferBoxesDatabase
import br.com.lince.singe.callcenter.warehouse.domain.entities.Warehouse
import br.com.lince.singe.callcenter.warehouse.domain.repository.WarehouseRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class PackingRepositoryImplementation(
    private val warehouseRepository: WarehouseRepository,
) : PackingRepository {
    override fun create(packing: Packing): Packing? {
        var idGenerated = UUID.randomUUID()
        packing.uuid = idGenerated
        packing.sendDate = packing.sendDate ?: LocalDateTime.now()
        return transaction {
            PackingDatabase.insert {
                it[uuid] = packing.uuid!!
                it[comex] = packing.comex!!
                it[buyer] = packing.buyer!!
                it[warehouseId] = null
                it[receiveDate] = null
                it[sendDate] = packing.sendDate!!
                it[totalGrossWeight] = 0.0
                it[totalNetWeight] = 0.0
                it[boxQuantity] = 0
                it[totalCubeMeter] = 0.0
            }.resultedValues!!
            packing
        }
    }

    override fun addItem(box: Box): Box {
        var idGenerated = UUID.randomUUID()
        box.uuid = idGenerated
        return transaction {
            BoxDatabase.insert {
                it[uuid] = box.uuid!!
                it[comex] = box.comex!!
                it[number] = box.boxNumber!!
                it[packingId] = box.packing!!.uuid!!
                it[article] = box.article!!
                it[grossWeight] = box.grossWeight!!
                it[netWeight] = box.netWeight!!
                it[quantity] = box.quantity!!
                it[batch] = box.batch!!
                it[unity] = box.unity!!
            }.resultedValues!!
            box
        }
    }

    override fun getByCode(code: Int): Packing? {
        return transaction {
            PackingDatabase.select { PackingDatabase.comex eq code }.map {
                Packing(
                    uuid = it[PackingDatabase.uuid],
                    comex = it[PackingDatabase.comex],
                    buyer = it[PackingDatabase.buyer],
                    warehouse = warehouseRepository.getById(it[PackingDatabase.warehouseId]!!),
                    receiveDate = it[PackingDatabase.receiveDate],
                    sendDate = it[PackingDatabase.sendDate],
                    totalGrossWeight = it[PackingDatabase.totalGrossWeight],
                    totalNetWeight = it[PackingDatabase.totalNetWeight],
                    boxTotalQuantity = it[PackingDatabase.boxQuantity],
                    totalCubeMeter = it[PackingDatabase.totalCubeMeter],
                )
            }.firstOrNull()
        }
    }

    override fun getById(uuid: UUID): Packing? {
        return transaction {
            PackingDatabase.select { PackingDatabase.uuid eq uuid }.map {
                var warehouse: Warehouse? = null
                if (it[PackingDatabase.warehouseId] != null) {
                    warehouse = warehouseRepository.getById(it[PackingDatabase.warehouseId]!!)
                }
                Packing(
                    uuid = it[PackingDatabase.uuid],
                    comex = it[PackingDatabase.comex],
                    buyer = it[PackingDatabase.buyer],
                    warehouse = warehouse,
                    receiveDate = it[PackingDatabase.receiveDate],
                    sendDate = it[PackingDatabase.sendDate],
                    totalGrossWeight = it[PackingDatabase.totalGrossWeight],
                    totalNetWeight = it[PackingDatabase.totalNetWeight],
                    boxTotalQuantity = it[PackingDatabase.boxQuantity],
                    totalCubeMeter = it[PackingDatabase.totalCubeMeter],
                )
            }.firstOrNull()
        }
    }

    override fun getByIdDetailed(uuid: UUID): PackingList? {
        var packing: Packing? = null
        var boxes: List<Box>? = null
        PackingDatabase.select { PackingDatabase.uuid eq uuid }.map {
            var warehouse: Warehouse? = null
            if (it[PackingDatabase.warehouseId] != null) {
                warehouse = warehouseRepository.getById(it[PackingDatabase.warehouseId]!!)
            }
            packing = Packing(
                uuid = it[PackingDatabase.uuid],
                comex = it[PackingDatabase.comex],
                buyer = it[PackingDatabase.buyer],
                warehouse = warehouse,
                receiveDate = it[PackingDatabase.receiveDate],
                sendDate = it[PackingDatabase.sendDate],
                totalGrossWeight = it[PackingDatabase.totalGrossWeight],
                totalNetWeight = it[PackingDatabase.totalNetWeight],
                boxTotalQuantity = it[PackingDatabase.boxQuantity],
                totalCubeMeter = it[PackingDatabase.totalCubeMeter],
            )
            boxes = getBoxesByPackingId(uuid)


        }
        return PackingList(packing = packing, boxes = boxes)
    }

    override fun getBoxesByPackingId(packingId: UUID): List<Box>? {
        return transaction {
            BoxDatabase.select { BoxDatabase.packingId eq packingId }.map {
                Box(
                    uuid = it[BoxDatabase.uuid],
                    comex = it[BoxDatabase.comex],
                    packing = getById(it[BoxDatabase.packingId]),
                    boxNumber = it[BoxDatabase.number],
                    product = null,
                    article = it[BoxDatabase.article],
                    grossWeight = it[BoxDatabase.grossWeight],
                    netWeight = it[BoxDatabase.netWeight],
                    unity = it[BoxDatabase.unity],
                    quantity = it[BoxDatabase.quantity],
                    batch = it[BoxDatabase.batch]
                )
            }
        }
    }

    override fun getBoxByNumber(number: Int): Box? {
        return transaction {
            BoxDatabase.select { BoxDatabase.number eq number }.map {
                Box(
                    uuid = it[BoxDatabase.uuid],
                    comex = it[BoxDatabase.comex],
                    packing = getById(it[BoxDatabase.packingId]),
                    boxNumber = it[BoxDatabase.number],
                    product = null,
                    article = it[BoxDatabase.article],
                    grossWeight = it[BoxDatabase.grossWeight],
                    netWeight = it[BoxDatabase.netWeight],
                    unity = it[BoxDatabase.unity],
                    quantity = it[BoxDatabase.quantity],
                    batch = it[BoxDatabase.batch]
                )
            }.firstOrNull()
        }
    }

    override fun getBoxById(uuid: UUID): Box? {
        return transaction {
            BoxDatabase.select { BoxDatabase.uuid eq uuid }.map {
                Box(
                    uuid = it[BoxDatabase.uuid],
                    comex = it[BoxDatabase.comex],
                    packing = getById(it[BoxDatabase.packingId]),
                    boxNumber = it[BoxDatabase.number],
                    product = null,
                    article = it[BoxDatabase.article],
                    grossWeight = it[BoxDatabase.grossWeight],
                    netWeight = it[BoxDatabase.netWeight],
                    unity = it[BoxDatabase.unity],
                    quantity = it[BoxDatabase.quantity],
                    batch = it[BoxDatabase.batch]
                )
            }.firstOrNull()
        }
    }

    override fun update(packing: Packing): Packing? {
        return transaction {
            PackingDatabase.update({ PackingDatabase.uuid eq packing.uuid!! }) {
                it[buyer] = packing.buyer!!
                it[warehouseId] = packing.warehouse!!.uuid!!
                it[receiveDate] = packing.receiveDate
                it[totalGrossWeight] = packing.totalGrossWeight!!
                it[totalNetWeight] = packing.totalNetWeight!!
                it[boxQuantity] = packing.boxTotalQuantity!!
                it[totalCubeMeter] = packing.totalCubeMeter!!
            }
            packing
        }
    }

    override fun updateBox(box: Box): Box? {
        TODO("Not yet implemented")
    }

    override fun setWarehouse(packingId: UUID, warehouseId: UUID): Packing? {
        val packing = getById(packingId)
        var warehouse = warehouseRepository.getById(warehouseId)
        packing!!.warehouse = warehouse
        return update(packing)
    }

    override fun list(page: Int, size: Int, sortBy: Int, orderBy: Int, packingFilter: PackingFilter): Packing? {
        TODO("Not yet implemented")
    }

    override fun listBoxes(page: Int, size: Int, sortBy: Int, orderBy: Int, packingFilter: PackingFilter): Packing? {
        TODO("Not yet implemented")
    }

    override fun getPackingByStockTransfer(transferUUID: UUID): List<Packing> {
        val packings: MutableList<Packing> = mutableListOf()
        transaction {
            PackingDatabase
                .join(BoxDatabase, JoinType.INNER, PackingDatabase.uuid, BoxDatabase.packingId)
                .join(StockTransferBoxesDatabase, JoinType.INNER, BoxDatabase.uuid, StockTransferBoxesDatabase.boxUUID)
                .slice(
                    PackingDatabase.uuid,
                    PackingDatabase.comex,
                )
                .select {
                    StockTransferBoxesDatabase.transferUUID eq transferUUID
                }
                .groupBy(
                    PackingDatabase.uuid,
                    PackingDatabase.comex
                )
                .map {
                    packings.add(
                        Packing(
                            uuid = it[PackingDatabase.uuid],
                            comex = it[PackingDatabase.comex],
                        )
                    )
                }
        }

        return packings.toList()
    }

    override fun getBoxByPackingUUIDStockTransfer(uuid: UUID?): List<Box> {
        val boxes: MutableList<Box> = mutableListOf()

        transaction {
            BoxDatabase
                .join(PackingDatabase, JoinType.INNER, BoxDatabase.packingId, PackingDatabase.uuid)
                .join(VariantDatabase, JoinType.INNER, BoxDatabase.variantId, VariantDatabase.uuid)
                .join(ProductDatabase, JoinType.INNER, VariantDatabase.productUUID, ProductDatabase.uuid)
                .slice(
                    BoxDatabase.uuid,
                    BoxDatabase.number,
                    ProductDatabase.description,
                )
                .selectAll()
                .map {
                    boxes.add(
                        Box(
                            uuid = it[BoxDatabase.uuid],
                            boxNumber = it[BoxDatabase.number],
                            product = Product(
                                description = it[ProductDatabase.description],
                            ),
                        )
                    )
                }
        }

        return boxes.toList()
    }

}