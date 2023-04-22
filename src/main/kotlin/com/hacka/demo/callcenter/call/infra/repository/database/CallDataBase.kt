package com.hacka.demo.callcenter.call.infra.repository.database

import com.hacka.demo.callcenter.flow.infra.repository.database.FlowDatabase
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import org.w3c.dom.Text
import java.time.LocalDateTime

object CallDatabase : Table("call") {
    var uuid = uuid("id").uniqueIndex()
    var numberCall = integer("number").uniqueIndex()
    var title = varchar("title", 255)
    var flow_id = uuid("flow_id").references(FlowDatabase.uuid).nullable()
    var contact = varchar("contact", 255)
    var priority = integer("priority")
    //var createDate = datetime("createDate").default(LocalDateTime.now())
    var author = varchar("author", 255)
    var originProblemN = integer("problemNumber")
    var originProblemS = varchar("problemDescription", 255)
    var richText = varchar("richText", 5000)

}