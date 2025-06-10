package com.sellink.app.domain.usecase

import com.google.firebase.firestore.FirebaseFirestore
import com.sellink.app.data.Database
import com.sellink.app.domain.models.Good
import kotlinx.coroutines.tasks.await
import java.io.Serializable

class GoodUseCase {
    private val db: FirebaseFirestore = Database.db

    suspend fun addGood(good: Good) {
        val good: HashMap<String, Any> = hashMapOf(
            "name" to good.name,
            "price" to good.price,
            "currency" to good.currency,
            "category" to good.category)
        db.collection("good").add(good).await()
    }
}