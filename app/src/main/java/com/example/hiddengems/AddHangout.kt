package com.example.hiddengems

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.IOException
import java.util.UUID

class AddHangout : AppCompatActivity() {
    lateinit var addimgview:ImageView
    lateinit var addtxtview:TextView
    lateinit var edtaddname:EditText
    lateinit var edtaddcontacts:EditText
    lateinit var edtaddlocation:EditText
    lateinit var edtadddescription:EditText
    lateinit var btnchooseimage:Button
    lateinit var btnuploaddata:Button

    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null

    lateinit var progress: ProgressDialog

    private val PICK_IMAGE_REQUEST = 71
    private var fileUri: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hangout)

        addimgview = findViewById(R.id.add_imageview)
        addtxtview= findViewById(R.id.Add_textview)
        edtaddname = findViewById(R.id.edtlocationname)
        edtaddcontacts = findViewById(R.id.edtlocationcontact)
        edtaddlocation = findViewById(R.id.edtlocation)
        edtadddescription = findViewById(R.id.edtlocationdescription)
        btnchooseimage = findViewById(R.id.btnlocationimage)
        btnuploaddata = findViewById(R.id.btnlocationupload)

        firebaseStore = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")


        btnchooseimage.setOnClickListener {
            launchGallery()

        }




        btnuploaddata.setOnClickListener {

            uploadImage()


        }






    }


    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            fileUri = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, fileUri)
                addimgview.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImage(){
        var name = edtaddname.text.toString().trim()
        var contacts = edtaddcontacts.text.toString().trim()
        var location = edtaddlocation.text.toString().trim()
        var description = edtadddescription.text.toString().trim()
        var id = System.currentTimeMillis().toString()

        if (name.isEmpty()){
            edtaddname.setError("Please fill this input")
            edtaddname.requestFocus()
        }else if (contacts.isEmpty()){
            edtaddcontacts.setError("Please fill this input")
            edtaddcontacts.requestFocus()
        }else if (location.isEmpty()){
            edtaddlocation.setError("Please fill this input")
            edtaddlocation.requestFocus()
        }else if (description.isEmpty()){
            edtadddescription.setError("Please fill this input")
            edtadddescription.requestFocus()
        }else{
            if(fileUri != null){

                val ref = storageReference?.child("Names/" + UUID.randomUUID().toString())
                progress.show()
                val uploadTask = ref?.putFile(fileUri!!)!!.addOnCompleteListener{
                    progress.dismiss()
                    if (it.isSuccessful){
                        ref.downloadUrl.addOnSuccessListener {

                            var user_data = Hangout(name,contacts,location,description,it.toString(),id)


                            var ref = FirebaseDatabase.getInstance().getReference().child("Names/$id")
                            ref.setValue(user_data)
                            Toast.makeText(this, "Hangout submitted successfully", Toast.LENGTH_SHORT).show()

                            var gotoview = Intent(this,View_Activity::class.java)
                            startActivity(gotoview)
                        }
                    }else{
                        Toast.makeText(this, "Hangout submission failed", Toast.LENGTH_SHORT).show()
                    }
                }


            }else{
                Toast.makeText(this, "Please Upload an Image", Toast.LENGTH_SHORT).show()
            }
        }

    }



}