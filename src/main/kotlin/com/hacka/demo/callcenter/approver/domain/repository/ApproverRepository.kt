package com.hacka.demo.callcenter.approver.domain.repository

import com.hacka.demo.callcenter.approver.domain.entities.Approver
import java.util.UUID

interface ApproverRepository {

        fun create(approver: Approver): Approver?
        fun getApproverById(uuid: UUID): Approver?
}