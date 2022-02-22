package  com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailsActivity  extends AppCompatActivity {

    private TextView tvName, tvDescription, tvColor, tvSize, tvPrice, tvGender;
    private ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        connectComponents();
        Intent i = this.getIntent();
        Product product = (Product) i.getSerializableExtra("product");

        tvName.setText(product.getName());
        tvDescription.setText(product.getDescription());
        tvColor.setText(product.getColor());
        tvSize.setText(product.getSize());
        tvPrice.setText(product.getPrice());
        tvGender.setText(product.getGender());
        Picasso.get().load(product.getPhoto()).into(ivPhoto);

    }

    private void connectComponents() {
        tvName = findViewById(R.id.tvNameProductDetails);
        tvDescription = findViewById(R.id.tvDescriptionProductDetails);
        tvColor = findViewById(R.id.tvColorProductDetails);
        tvPrice = findViewById(R.id.tvPriceProductDetails);
        tvSize = findViewById(R.id.tvSizeProductDetails);
        tvGender = findViewById(R.id.tvGenderProductDetails);
        ivPhoto = findViewById(R.id.ivPhotoProductDetails);

    }
}