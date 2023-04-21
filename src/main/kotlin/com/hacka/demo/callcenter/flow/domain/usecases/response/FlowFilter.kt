package br.com.lince.singe.callcenter.packing.domain.usecases.response

class FlowFilter(
    val name: String,
    val value: String,
) {
    override fun toString(): String {
        return "UserFilters=($name, $value)"
    }
}