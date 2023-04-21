package com.hacka.demo.callcenter.flow.infra.repository.database

import org.jetbrains.exposed.sql.Table

object FlowDatabase : Table("flow") {
    var uuid = uuid("uuid").uniqueIndex()
    var number = integer("number").uniqueIndex()
    var description = varchar("description", 255)
    var approver_indicator = bool("approver_indicator")
    var infra_indicator = bool("infra_indicator")
}