package com.upc.gamarramayoristasapp.perfil

data class OptionPerfil(
    val titulo: String,
    val subtitulo: String,
    val tipo: PerfilOptionType
)

enum class PerfilOptionType {
    MIS_PEDIDOS,
    DIRECCIONES_ENVIO,
    METODOS_PAGO,
    CODIGOS_PROMOCIONALES,
    MIS_RESEÑAS,
    AJUSTES
}