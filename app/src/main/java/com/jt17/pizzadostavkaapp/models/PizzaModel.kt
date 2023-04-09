package com.jt17.pizzadostavkaapp.models

//data class Welcome(
//    val vegetarian: List<PizzaModel>
//)

data class PizzaModel(
    val name: String,
    val price: Int,
    val info: String,
    val img: Int
): java.io.Serializable
