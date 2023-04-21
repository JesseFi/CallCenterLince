package br.com.lince.singe.callcenter.packing.infra.repository.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object PackingDatabase : Table("packing") {
    var uuid = uuid("id").uniqueIndex()
    var comex = integer("comex").uniqueIndex()
    var buyer = varchar("buyer", 255)
    var warehouseId = uuid("warehouse_id").nullable()
    var receiveDate = datetime("receive_date").nullable()
    var sendDate = datetime("send_date")
    var totalGrossWeight = double("total_gross_weight")
    var totalNetWeight = double("total_net_weight")
    var boxQuantity = integer("box_quantity")
    var totalCubeMeter = double("total_cube_meter")
}

object BoxDatabase : Table("box") {
    var uuid = uuid("id").uniqueIndex()
    var comex = integer("comex")
    var number = integer("number").autoIncrement()
    var packingId = uuid("packing_id")
    var variantId = uuid("variant_id")
    var article = varchar("article", 60)
    var barCode = varchar("bar_code", 10)
    var grossWeight = double("gross_weight")
    var netWeight = double("net_weight")
    var quantity = double("quantity")
    var batch = varchar("batch", 20)
    var unity = varchar("unity", 2)
    var boxQuantity = integer("box_quantity")
    var initialBox = integer("initial_box")
}
