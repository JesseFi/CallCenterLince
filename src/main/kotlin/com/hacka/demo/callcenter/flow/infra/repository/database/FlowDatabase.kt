package br.com.lince.singe.callcenter.flow.infra.repository.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object FlowDatabase : Table("flow") {

    var uuid = uuid("id").uniqueIndex()
    var number = integer("number").uniqueIndex()
    var description = varchar("description", 255)
    var approver_indicator = bool("approver_indicator")
    var infra_indicator = bool("infra_indicator")

}