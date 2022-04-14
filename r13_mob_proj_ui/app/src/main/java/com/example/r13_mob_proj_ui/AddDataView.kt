package com.example.r13_mob_proj_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class AddDataView : AppCompatActivity() {

    lateinit var db: DocumentReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data_view)

        db = FirebaseFirestore.getInstance().document("Reseptit/Resepti")

        val store = findViewById<View>(R.id.buAdder) as Button

        store.setOnClickListener { view: View? ->
            store()
        }
    }

    private fun store() {
        val reseptiTxt = findViewById<View>(R.id.etName) as EditText
        val recipeName = findViewById<View>(R.id.etName) as EditText
        val toolName = findViewById<View>(R.id.etTools) as EditText
        val ingName = findViewById<View>(R.id.etIng) as EditText

        var resepti = reseptiTxt.text.toString().trim()
        val name = recipeName.text.toString().trim()
        val tool = toolName.text.toString().trim()
        val ingre = ingName.text.toString().trim()

        if (!name.isEmpty() && !tool.isEmpty() && !ingre.isEmpty()) {
            try {
                val items = HashMap<String, Any>()
                items.put("Reseptin nimi", name)
                items.put("Tarvikkeet", tool)
                items.put("Ainesosat", ingre)
                db.collection(resepti).document("Tarvikkeet").set(items)
                    .addOnSuccessListener { void: Void? ->
                        Toast.makeText(
                            this,
                            "Onnistuneesti lisätty tietokantaan",
                            Toast.LENGTH_LONG
                        ).show()
                    }.addOnFailureListener { exception: java.lang.Exception ->
                    Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Täytä kentät", Toast.LENGTH_LONG).show()
        }
    }
}