package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllProductActivity extends AppCompatActivity {
    private RecyclerView rvAllProduct;
    AdapterProduct adapter;
    FirebaseServices fbs;
    ArrayList<Product> products;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        fbs = FirebaseServices.getInstance();
        products = new ArrayList<Product>();
        readData();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAllProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       adapter = new AdapterProduct(this, products);
        recyclerView.setAdapter(adapter);
    }



      private  void readData()
      {
        fbs.getFire().collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                products.add(document.toObject(Product.class));
                            }
                        } else {
                            Log.e("AllRestActivity: readData()", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}