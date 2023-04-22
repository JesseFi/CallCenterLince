package com.hacka.demo.callcenter.call.domain.entities

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import java.time.LocalDateTime
import java.util.*

class Call(
    var uuid: UUID?,
    var numberCall: Int? = 0,
    var title: String? = "",
    var flow: Flow? = null,
    var contact: String? = "",
    var priority: Int? = 0,
    var createDate: LocalDateTime? = null,
    var author: String? = "",
    var originProblemN: Int? = 0,
    var originProblemS: String? = "",
    var richText: String? = "",
    var situation: Int? = 0
)