package br.com.lince.singe.callcenter.packing.domain.usecases.implementation

import br.com.lince.singe.callcenter.packing.domain.entities.Packing
import br.com.lince.singe.callcenter.packing.domain.exceptions.PACKING_DUPLICATED_COMEX
import br.com.lince.singe.callcenter.packing.domain.exceptions.PACKING_INVALID_PARAMETERS
import br.com.lince.singe.callcenter.packing.domain.exceptions.PACKING_INVALID_WAREHOUSE
import br.com.lince.singe.callcenter.packing.domain.exceptions.PACKING_STORAGE_ERROR
import br.com.lince.singe.callcenter.packing.domain.repository.PackingRepository
import br.com.lince.singe.callcenter.packing.domain.usecases.PackingUseCase
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingFilter
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingListResponse
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class PackingUseCaseImplementation(private val packingRepository: PackingRepository) : PackingUseCase {
    override fun save(packing: Packing): PackingResponse {
        return try {
            if (packing.buyer == null || packing.buyer == "") {
                return PackingResponse(message = PACKING_INVALID_PARAMETERS)
            }
            if (packing.comex == null || packing.comex == 0) {
                return PackingResponse(message = PACKING_INVALID_PARAMETERS)
            }
            if (packingRepository.getByCode(packing.comex!!) != null) {
                return PackingResponse(message = PACKING_DUPLICATED_COMEX)
            }
            PackingResponse(packing = packingRepository.create(packing))
        } catch (e: Exception) {
            PackingResponse(message = PACKING_STORAGE_ERROR)
        }
    }

    override fun getPacking(packingId: UUID): PackingResponse {
        return try {
            PackingResponse(packing = packingRepository.getById(packingId))
        } catch (e: Exception) {
            PackingResponse(message = PACKING_STORAGE_ERROR)
        }
    }

    override fun setWarehouse(packingId: UUID, warehouseId: UUID?): PackingResponse {
        return try {
            if(warehouseId == null) {
                PackingResponse(message = PACKING_INVALID_WAREHOUSE)
            }
            PackingResponse(packing = packingRepository.getById(packingId))
        } catch (e: Exception) {
            PackingResponse(message = PACKING_STORAGE_ERROR)
        }
    }

    override fun getByIdDetailed(packingId: UUID): PackingListResponse {
        TODO("Not yet implemented")
    }

    override fun list(packingFilter: PackingFilter): PackingResponse {
        TODO("Not yet implemented")
    }

    override fun listBoxes(packingFilter: PackingFilter): PackingResponse {
        TODO("Not yet implemented")
    }

}