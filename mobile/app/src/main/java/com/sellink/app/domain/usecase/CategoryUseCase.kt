package com.sellink.app.domain.usecase
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.sellink.app.data.Database
import com.sellink.app.domain.models.Good
import kotlinx.coroutines.tasks.await
import java.io.Serializable

class CategoryUseCase {
    private val db: FirebaseFirestore = Database.db

    suspend fun addCategory(category: String) {
        val ref = db.collection("store")
            .document("chris_restaurant")
            .collection("categories")
            .document(category)

        ref.get().addOnSuccessListener { document ->
            if (document != null && document.exists()){
                println("ERROR ADDING DOCUMENT EXIST")
            }
            else {
                println("ADD SUCCESSFULL")
                val data = mapOf("name" to category)
                ref.set(data)
            }
        }.await()
    }

    suspend fun getCategories(): List<String> {
        return try {
            val ref = db.collection("store")
                .document("chris_restaurant")
                .collection("categories")

            val snapshot = ref.get().await()

            Log.d("RefStatus", "${snapshot}")
            snapshot.documents.mapNotNull { document ->
                document.getString("name")
            }
        } catch (e: Exception) {
            Log.e("FirestoreError", "Error fetching categories: ${e.message}")
            emptyList()
        }
    }
}
