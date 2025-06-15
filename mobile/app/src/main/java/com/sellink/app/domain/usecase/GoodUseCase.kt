package com.sellink.app.domain.usecase

import com.google.firebase.firestore.FirebaseFirestore
import com.sellink.app.data.Database
import com.sellink.app.domain.models.Good
import kotlinx.coroutines.tasks.await
import java.io.Serializable

class GoodUseCase {
    private val db: FirebaseFirestore = Database.db

    suspend fun addGood(good: Good) {
        val ref = db.collection("store")
            .document("chris_restaurant")
            .collection("categories")
            .document(good.category)
            .collection("good")
            .document(good.name)

        ref.get().addOnSuccessListener { document ->
            if (document != null && document.exists()){
                println("ERROR ADDING DOCUMENT EXIST")
            }
            else {
                ref.set(
                    mapOf(
                        "price" to good.price,
                        "currency" to good.currency
                    )
                )
                println("ADD SUCCESSFULL")
            }
        }.await()
    }

    suspend fun getGoods() : List<Good>{
        val goodsList = mutableListOf<Good>()

        val ref = db.collection("store")
            .document("chris_restaurant")
            .collection("categories")

        val categorySnapshot = ref.get().await()

        for (categoryDocument in categorySnapshot.documents) {
            val goodsRef = ref.document(categoryDocument.id).collection("good")

            val goodsSnapshot = goodsRef.get().await()
            for (goodsDocument in goodsSnapshot.documents) {
                val name = goodsDocument.getString("name") ?: ""
                val price = goodsDocument.getDouble("price") ?: 0.0
                val category = goodsDocument.getString("category") ?: ""
                val currency = goodsDocument.getString("currency") ?: ""

                println(name);

                val good = Good(name, price, category, currency)
                goodsList.add(good)
            }
        }
        return goodsList
    }
}