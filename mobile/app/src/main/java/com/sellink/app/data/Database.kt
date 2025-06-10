package com.sellink.app.data

import com.google.firebase.firestore.FirebaseFirestore

object Database {
    val db: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
}