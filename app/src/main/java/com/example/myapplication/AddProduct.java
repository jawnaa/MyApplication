package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class AddProduct extends AppCompatActivity {

    private static final String TAG = "AddProductActivity";
    private EditText etName, etColor, etSize, etPrice;
    private Spinner spCat;
    private ImageView ivPhoto;
    private FirebaseServices fbs;
    private Uri filePath;
    private RadioButton rd1,rd2;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_Product);
        connectComponents();
    }

    private void connectComponents() {
        etName = findViewById(R.id.etNameAddProduct);
        etColor= findViewById(R.id.etColorAddProduct);
        etSize = findViewById(R.id.etSizeAddProduct);
        etPrice = findViewById(R.id.etPriceAddProduct);
        spCat = findViewById(R.id.etSpinnerProduct);
        ivPhoto = findViewById(R.id.ivPhotoAddProduct);
        fbs = FirebaseServices.getInstance();
        spCat.setAdapter(new ArrayAdapter<Accessories>(this, android.R.layout.simple_list_item_1, Accessories.values()));
        spCat.setAdapter(new ArrayAdapter<Shoes>(this, android.R.layout.simple_list_item_1, Shoes.values()));
        spCat.setAdapter(new ArrayAdapter<Bags>(this, android.R.layout.simple_list_item_1, Bags.values()));
        spCat.setAdapter(new ArrayAdapter<Clothes>(this, android.R.layout.simple_list_item_1, Clothes.values()));
        spCat.setAdapter(new ArrayAdapter<Decor>(this, android.R.layout.simple_list_item_1,Decor.values()));
    }

    public void add(View view) {
        // check if any field is empty
        String name, Color, Size,Price, photo,category;
        name = etName.getText().toString();
       Color = etColor.getText().toString();
        Size = etSize.getText().toString();
        Price = etPrice.getText().toString();
        category = spCat.getSelectedItem().toString();
        if (ivPhoto.getDrawable() == null)
            photo = "no_image";
        else photo = ivPhoto.getDrawable().toString();

        if (name.trim().isEmpty() ||Color.trim().isEmpty() || Size.trim().isEmpty() ||
               Price.trim().isEmpty() || category.trim().isEmpty() || photo.trim().isEmpty())
        {
            Toast.makeText(this, R.string.err_fields_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        Product product = new Product (name, Color,Size,Accessories.valueOf(category), photo, Price);

        fbs.getFirestore().collection("restaurants")
                .add(product)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });
                }

        public void selectPhoto(View view) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"),40);
        }

        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 40) {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        try {
                            filePath = data.getData();
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                            ivPhoto.setBackground(null);
                            ivPhoto.setImageBitmap(bitmap);
                            uploadImage();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (resultCode == Activity.RESULT_CANCELED)  {
                    Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                }
            }
        }
    



    private void uploadImage()
    {
        if (filePath != null) {

            // Code for showing progressDialog while uploading
            final ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageReference
                    .child(
                            "images/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(AddProduct.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(AddProduct.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int)progress + "%");
                                }
                            });
        }
    }

    public void setMale(View view) {
        rd1.checked = true;
        rd2.checked = false;
    }
}




