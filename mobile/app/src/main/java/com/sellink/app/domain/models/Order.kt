package com.sellink.app.domain.models

class Order(val id: Int, val status: String, val listOfGoods: List<Good>) {
    val total: Double
        get() {
            var totalTemp: Double = 0.0
            for (good in listOfGoods) {
                totalTemp += good.price
            }
            return totalTemp
        }
}
