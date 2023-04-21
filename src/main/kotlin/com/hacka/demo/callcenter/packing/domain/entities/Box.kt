package br.com.lince.singe.callcenter.packing.domain.entities

import br.com.lince.singe.callcenter.product.domain.entities.Product
import java.util.*

/**
 * - *English*: This class represents the entity for the boxes of the Packing
 * - *Português: Esta classe representa as caixas da Packing
 * @param uuid UUID
 * - *English*: Represents the unique index identifier of Packing List register
 * - *Português*: Representa o índice identificador único do cadastro Packing
 * @param comex Int
 * - *English*: Represents the unique comex code of Packing register
 * - *Português*: Representa o código único de comex do cadastro Packing
 * @param packing Packing
 * - *English*: Represents the packing header of this box
 * - *Português*: Representa o cabeçalho packing desta caixa
 * @param boxNumber Int
 * - *English*: Represents the unique code of box of the packing
 * - *Português*: Representa o código unico da caixa da packing
 * @param product Product
 * - *English*: Represents the product of the box
 * - *Português*: Representa o produto da caixa
 * @param article String
 * - *English*: Represents the description of the product into the box
 * - *Português*: Representa a descrição do produto dentro da caixa
 * @param grossWeight Double
 * - *English*: Represents box unitary Gross Weight
 * - *Português*: Representa o peso total bruto da Packing
 * @param netWeight Double
 * - *English*: Represents box unitary Net Weight
 * - *Português*: Representa o peso total líquido da Packing
 * @param unity String
 * - *English*: Represents way of measurement the product
 * - *Português*: Representa a forma de medição do produto
 * @param quantity Int
 * - *English*: Represents quantity of products the box has
 * - *Português*: Representa a quantidade de produtos que a caixa possui
 * @param batch String
 * - *English*: Represents the batch code of the box
 * - *Português*: Representa o código do lote da caixa
 */
class Box (
    var uuid: UUID?,
    var comex: Int? = 0,
    var packing: Packing? = null,
    var boxNumber: Int? = 0,
    var product: Product? = null,
    var article: String? = "",
    var grossWeight: Double? = 0.0,
    var netWeight: Double? = 0.0,
    var unity: String? = "",
    var quantity: Double? = 0.0,
    var batch: String? = ""
)