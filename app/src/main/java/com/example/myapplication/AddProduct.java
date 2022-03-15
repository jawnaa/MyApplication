package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.UUID;

public class AddProduct extends AppCompatActivity {

    private static final String TAG = "AddProductActivity";
    private EditText etName,etDesc, etColor, etSize, etPrice;
    private Spinner spCat;
    private ImageView ivPhoto;
    private FirebaseServices fbs;
    private Uri filePath;
    private RadioGroup radioGroup;
    private RadioButton rd1, rd2;
    private Button btnDisplay;
    StorageReference storageReference;
    private boolean Gender;
    private String refAfterSuccessfullUpload = null;
    private String downloadableURL = "";


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_Product);

        getSupportActionBar().hide();
        connectComponents();

    }


    private void connectComponents() {
        etName = findViewById(R.id.etNameAddProduct);
        etDesc = findViewById(R.id.etDescriptionAddProduct);
        etColor = findViewById(R.id.etColorAddProduct);
        etSize = findViewById(R.id.etSizeAddProduct);
        etPrice = findViewById(R.id.etPriceAddProduct);
        spCat = findViewById(R.id.etSpinnerProduct);
        ivPhoto = findViewById(R.id.ivPhotoAddProduct);
        fbs = FirebaseServices.getInstance();
        spCat.setAdapter(new ArrayAdapter<AccessoriesCat>(this, android.R.layout.simple_list_item_1, AccessoriesCat.values()));
        spCat.setAdapter(new ArrayAdapter<ShoesCat>(this, android.R.layout.simple_list_item_1, ShoesCat.values()));
        spCat.setAdapter(new ArrayAdapter<BagsCat>(this, android.R.layout.simple_list_item_1, BagsCat.values()));
        spCat.setAdapter(new ArrayAdapter<ClothesCat>(this, android.R.layout.simple_list_item_1, ClothesCat.values()));
        spCat.setAdapter(new ArrayAdapter<DecorCat>(this, android.R.layout.simple_list_item_1, DecorCat.values()));
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        storageReference = fbs.getStorage().getReference();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdMaleAddProduct:
                        Gender = false;
                        break;
                    case R.id.rdFemaleAddProduct:
                        Gender = true;
                        break;
                }
            }
        });

        //btnDisplay.setOnClickListener(new OnClickListener());
    }

    public void add(View view) {
        // check if any field is empty
        String name,description, Color, Size, Price, photo, category;
        boolean gender;
        name = etName.getText().toString();
        description = etDesc.getText().toString();
        Color = etColor.getText().toString();
        Size = etSize.getText().toString();
        Price = etPrice.getText().toString();
        category = spCat.getSelectedItem().toString();
        if (ivPhoto.getDrawable() == null)
            photo = "no_image";
        else photo = downloadableURL;

        int selectedId = radioGroup.getCheckedRadioButtonId();

        Toast.makeText(AddProduct.this, rd1.getText(), Toast.LENGTH_SHORT).show();
        if (!rd1.isChecked() && !rd2.isChecked()) {
            Toast.makeText(this, R.string.err_fields_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        if (name.trim().isEmpty() || description.trim().isEmpty() ||Color.trim().isEmpty() || Size.trim().isEmpty() ||
                Price.trim().isEmpty() || category.trim().isEmpty() || photo.trim().isEmpty()) {
            Toast.makeText(this, R.string.err_fields_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        Product product = new Product(name,description , Color,AccessoriesCat.valueOf(category), ShoesCat.valueOf(category),
                BagsCat.valueOf(category), ClothesCat.valueOf(category), DecorCat.valueOf(category), photo, Size, Price,Gender);

        fbs.getFirestore().collection("Product")
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
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 40);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 40) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {

                    filePath = data.getData();
                    ivPhoto.setBackground(null);
                    Picasso.get().load(filePath).into(ivPhoto);
                    uploadImage();

                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }


        private void uploadImage()
        {
            if (filePath != null) {

                // Code for showing progressDialog while uploading
                ProgressDialog progressDialog
                        = new ProgressDialog(this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                // Defining the child of storageReference
                String fileNameStr = filePath.toString().substring(filePath.toString().lastIndexOf("/") + 1);
                StorageReference ref
                        = storageReference
                        .child(
                                "images/"
                                        + fileNameStr);

                // adding listeners on upload
                // or failure of image
                downloadableURL = ref.getDownloadUrl().toString();
                ref.putFile(filePath)
                        .addOnSuccessListener(
                                new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                    @Override
                                    public void onSuccess(
                                            UploadTask.TaskSnapshot taskSnapshot) {

                                        // Image uploaded successfully
                                        // Dismiss dialog
                                        progressDialog.dismiss();
                                        Toast
                                                .makeText(AddProduct.this,
                                                        "Image Uploaded!!",
                                                        Toast.LENGTH_SHORT)
                                                .show();
                                        refAfterSuccessfullUpload = ref.toString();
                                    }
                                })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

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
                                            UploadTask.TaskSnapshot taskSnapshot) {
                                        double progress
                                                = (100.0
                                                * taskSnapshot.getBytesTransferred()
                                                / taskSnapshot.getTotalByteCount());
                                        progressDialog.setMessage(
                                                "Uploaded "
                                                        + (int) progress + "%");
                                    }
                                });
            }
        }
    }








