package com.hacka.demo.callcenter.flow.domain.usecases

import br.com.lince.singe.callcenter.packing.domain.usecases.response.FlowFilter
import com.hacka.demo.callcenter.flow.domain.usecases.response.FlowResponse

interface FlowUseCase {

    fun listAllFlow(): FlowResponse

}