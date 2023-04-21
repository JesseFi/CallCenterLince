package br.com.lince.singe.callcenter.packing.infra.webservice.impl

import br.com.lince.singe.callcenter.packing.domain.entities.Packing
import br.com.lince.singe.callcenter.packing.domain.usecases.PackingUseCase
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingResponse
import br.com.lince.singe.callcenter.packing.infra.webservice.PackingService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/packing")
class PackingServiceImplementation(private val packingUseCase: PackingUseCase) : PackingService {
    @PostMapping
    override fun create(@RequestBody packing: Packing): PackingResponse {
        return packingUseCase.save(packing)
    }

    @GetMapping("/{packingID}")
    override fun getById(@PathVariable("packingID") packingId: UUID): PackingResponse {
        return packingUseCase.getPacking(packingId)
    }

    @GetMapping("/{packingID}/detailed")
    override fun getByIdDetailed(@PathVariable("packingID") packingId: UUID): PackingResponse {
        return packingUseCase.getPacking(packingId)
    }

    @PutMapping("/{packingID}")
    override fun setWarehouse(@PathVariable("packingID") packingId: UUID, @RequestParam("warehouseId") warehouseId: UUID?): PackingResponse {
        return packingUseCase.setWarehouse(packingId, warehouseId)
    }
}