package br.com.lince.singe.callcenter.flow.domain.entities

import java.util.*

class Flow (
    var uuid: UUID?,
    var number: Int? = 0,
    var description: String? = "",
    var approver_indicator: Boolean = false,
    var infra_indicator: Boolean = false,
)