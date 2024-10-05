package com.upc.gamarramayoristasapp.producto

import com.upc.gamarramayoristasapp.carrito.ListCarrito

class CategoriaProvider {
    companion object{
        val CategoriaList = listOf<ListCategoria>(
            ListCategoria(
                "Nuevo",
                "https://images.unsplash.com/photo-1483985988355-763728e1935b?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            ListCategoria(
                "Ropa",
                "https://plus.unsplash.com/premium_photo-1661284847284-6438c7c16fa9?q=80&w=3542&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            ListCategoria(
                "Zapatos y Sapatillas",
                "https://plus.unsplash.com/premium_photo-1671718111684-9142a70a5fe0?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            ListCategoria(
                "Accesorios",
                "https://plus.unsplash.com/premium_photo-1661645417454-fabe3698fe4a?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),

        )
    }
}