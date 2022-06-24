package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllProductActivity extends AppCompatActivity {
    private RecyclerView rvAllProduct;
    AdapterProduct adapter;
    FirebaseServices fbs;
    ArrayList<Product> products;
    MyCallback myCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        fbs = FirebaseServices.getInstance();
        products = new ArrayList<Product>();
        readData();
        myCallback = new MyCallback() {
            @Override
            public void onCallback(List<Product> restsList) {
                RecyclerView recyclerView = findViewById(R.id.rvAllProducts);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterProduct(getApplicationContext(), products);
                recyclerView.setAdapter(adapter);
            }
        };
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("  ProductApp");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //case R.id.miSearch:
            // User chose the "Settings" item, show the app settings UI...
            //return true;

            case R.id.miProfile:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            case R.id.miSettings:

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    private  void readData()
      {
          try {

              fbs.getFire().collection("products")
                      .get()
                      .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                          @Override
                          public void onComplete(@NonNull Task<QuerySnapshot> task) {
                              if (task.isSuccessful()) {
                                  for (QueryDocumentSnapshot document : task.getResult()) {
                                      products.add(document.toObject(Product.class));
                                  }

                                  myCallback.onCallback(products);
                              } else {
                                  Log.e("AllRestActivity: readData()", "Error getting documents.", task.getException());
                              }
                          }
                      });

              // TODO: Added sorting
              Collections.sort(products, new ProductComparator());
          }
          catch (Exception e)
          {
              Toast.makeText(getApplicationContext(), "error reading!" + e.getMessage(), Toast.LENGTH_SHORT).show();
          }
      }

    public void gotoAddProduct(View view) {
        Intent i = new Intent(this, AddProduct.class);
        startActivity(i);
    }
}
