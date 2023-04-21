package br.com.lince.singe.callcenter.packing.infra.webservice

import br.com.lince.singe.callcenter.packing.domain.entities.Packing
import br.com.lince.singe.callcenter.packing.domain.usecases.response.PackingResponse
import java.util.*


/**
 * - *English*: This interface defines all functions that packing use cases will use
 * - *Português*: Esta inferface define todas as funções que serão utilizadas pelos casos de uso da packing
 */
interface PackingService {

    /**
     * - *English*: This function is used to verify all use cases on creation of packing
     * - *Português*: Esta função é usada para verificação de todos os casos de uso na criação da packing
     * @param packing Packing
     * - *English*: This parameter will receive all data necessary to create a packing header
     * - *Português*: Este parâmetro receberá todos os dados necessários para a criação do cabeçalho da packing
     */
    fun create(packing: Packing): PackingResponse

    /**
     * - *English*: This function will return a packing header that ID is the same as informed on parameters if it exists, else will return a error message
     * - *Português*: Esta função retornará um cabeçalho de packing cujo ID é o mesmo informado nos parâmetros caso exista, caso contrário retornará uma mensagem de erro
     * @param packingId UUID
     * - *English*: This parameter will receive the ID that will be search for
     * - *Português*: Este parametro receberá o ID que será procurado
     *
     */
    fun getById(packingId: UUID): PackingResponse

    /**
     * - *English*: This function will set the warehouse for the packing
     * - *Português*: Esta função atrelará o warehouse cuja packing pertence
     * @param packingId UUID
     * - *English*: This parameter will receive the packing ID that will be changed
     * - *Português*: Este parametro receberá o ID da packing que será alterada
     * @param warehouseId UUID
     * - *English*: This parameter will receive the warehouse ID that will be setted on packing
     * - *Português*: Este parametro receberá o ID da warehouse que será atrelada à packing
     *
     */
    fun setWarehouse(packingId: UUID, warehouseId: UUID?): PackingResponse
    fun getByIdDetailed(packingId: UUID): PackingResponse
}