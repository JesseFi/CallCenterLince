package com.hacka.demo.callcenter.call.domain.entities

import java.time.LocalDateTime
import java.util.*

class Call(
    var uuid: UUID?,
    var numberCall: Int? = 0,
    var title: String? = "",
    var flow: UUID? = null,
    var contact: String? = "",
    var priority: Int? = 0,
    //var createDate: LocalDateTime? = null,
    var author: String? = "",
    var originProblemN: Int? = 0,
    var originProblemS: String? = ""
)