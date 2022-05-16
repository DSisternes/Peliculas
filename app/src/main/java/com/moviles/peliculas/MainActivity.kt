package com.moviles.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("Peliculas").child("1").setValue(Pelicula("IT", "1990", "ppm001", "película", "https://pics.filmaffinity.com/It_Eso_TV-199479174-large.jpg", "EU", "Terror/Suspenso"))
        myRef.child("Peliculas").child("2").setValue(Pelicula("The Batman", "2022", "ppb152", "película", "https://www.amazon.com.mx/Before-Batman-Original-Exciting-Inspired/dp/0593310438", "EU", "Acción/Ciencia Ficción"))
        myRef.child("Peliculas").child("3").setValue(Pelicula("Stranger Things","2022","pps762","serie","https://i.blogs.es/5b1d7d/stranger-cartel/450_1000.jpeg","EU","Terror/Suspenso/Ciencia Ficción"))

        myRef.child("Peliculas").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
    }
}