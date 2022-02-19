package  com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity  extends AppCompatActivity {

    private TextView tvName, tvDescription, tvColor, tvSize, tvPrice, tvGender;
    private ImageView ivPhoto1, ivPhoto2,ivPhoto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        connectComponents();
        Intent i = this.getIntent();
        Product rest = (Product) i.getSerializableExtra("rest");

        tvName.setText(Product.getName());
        tvDescription.setText(Product.getDescription());
        tvColor.setText(Product.getColor());
        tvSize.setText(Product.getSize());
        tvPrice.setText(Product.getPrice());
        picasso.get().load(Product.getPhoto()).into(ivPhoto1);
        Picasso.get().load(Product.getPhoto()).into(ivPhoto2);
        Picasso.get().load(Product.getPhoto()).into(ivPhoto3);

    }

    private void connectComponents() {
        tvName = findViewById(R.id.tvNameProductDetails);
        tvDescription = findViewById(R.id.tvDescriptionProductDetails);
        tvColor = findViewById(R.id.tvColorProductDetails);
        tvPrice = findViewById(R.id.tvPriceProductDetails);
        tvSize = findViewById(R.id.tvSizeProductDetails);
        tvGender = findViewById(R.id.tvGenderProductDetails);
        ivPhoto1 = findViewById(R.id.ivPhoto1ProductDetails);
        ivPhoto2 = findViewById(R.id.ivPhoto2ProductDetails);
        ivPhoto3 = findViewById(R.id.ivPhoto3ProductDetails);
    }
}