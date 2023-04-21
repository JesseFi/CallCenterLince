package br.com.lince.singe.callcenter.flow.domain.repository

import br.com.lince.singe.callcenter.flow.domain.entities.Flow
import br.com.lince.singe.callcenter.packing.domain.usecases.response.FlowFilter

interface FlowRepository {
    fun listAllFlow(): Flow?

}