package com.hacka.demo.callcenter.call.infra.repository.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.util.*

object CallDatabase : Table("call") {
    var uuid = uuid("id").uniqueIndex()
    var numberCall = integer("number").uniqueIndex()
    var title = varchar("title", 255)
    var flow = uuid("flow_id").nullable()
    var contact = varchar("title", 255)
    var priority = integer("priority")
    var createDate = localDate("date_creation").nullable()
    var author = varchar("author", 255)
    var originProblemN = integer("problemNumber")
    var originProblemS = varchar("problemDescription", 255)
}