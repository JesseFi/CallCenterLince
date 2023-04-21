package br.com.lince.singe.callcenter.packing.domain.entities

import br.com.lince.singe.callcenter.warehouse.domain.entities.Warehouse
import java.time.LocalDateTime
import java.util.*

/**
 * - *English*: This class represents the entity for the header of a packing list document
 * - *Português: Esta classe representa o cabeçalho do documento de uma packing list
 * @param uuid UUID
 * - *English*: Represents the unique index identifier of Packing register
 * - *Português*: Representa o índice identificador único do cadastro Packing
 * @param comex Int
 * - *English*: Represents the unique comex code of Packing register
 * - *Português*: Representa o código único de comex do cadastro Packing
 * @param buyer String
 * - *English*: Represents the description of buyer
 * - *Português*: Representa a descrição do comprador
 * @param warehouse Warehouse
 * - *English*: Represents the Warehouse where the Packing will be stored
 * - *Português*: Representa o armazém onde a Packing será armazenada
 * @param receiveDate Date
 * - *English*: Represents the date whom the Packing was received
 * - *Português*: Representa a data na qual a Packing foi recebido
 * @param sendDate Date
 * - *English*: Represents the date whom the Packing was sent
 * - *Português*: Representa a data na qual a Packing foi enviado
 * @param totalGrossWeight Double
 * - *English*: Represents Packing Total Gross Weight
 * - *Português*: Representa o peso total bruto da Packing
 * @param totalNetWeight Double
 * - *English*: Represents Packing Total Net Weight
 * - *Português*: Representa o peso total líquido da Packing
 * @param boxTotalQuantity Int
 * - *English*: Represents the quantity of box of the Packing
 * - *Português*: Representa a quantidade total da packing
 * @param totalCubeMeter Double
 * - *English*: Represents the total cube meter of Packing
 * - *Português*: Representa a metragem cubica total da Packing
 */
class Packing(
    var uuid: UUID?,
    var comex: Int? = 0,
    var buyer: String? = "",
    var warehouse: Warehouse? = null,
    var receiveDate: LocalDateTime? = null,
    var sendDate: LocalDateTime? = null,
    var totalGrossWeight: Double? = 0.0,
    var totalNetWeight: Double? = 0.0,
    var boxTotalQuantity: Int? = 0,
    var totalCubeMeter: Double? = 0.0,
)