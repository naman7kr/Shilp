package vision4.com.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import vision4.com.Modals.ProductInformation;
import vision4.com.R;

public class ProductDetailsActivity extends AppCompatActivity{

    //widgets
    private TextView seller_name,rating_no, item_name, item_desc, item_price, item_qty;
    private RatingBar rating;
    private Button call_seller, email_seller;

    //vars
    private String item_data;
    //constants
    private static final String ITEM_DATA = "item_data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        init();
        getItemData();
        setLayoutDetails();
    }


    private void init() {
        seller_name = findViewById(R.id.pd_seller_name);
        rating = findViewById(R.id.pd_rating);
        rating_no = findViewById(R.id.pd_rating_no);
        item_name = findViewById(R.id.pd_item_name);
        item_desc = findViewById(R.id.pd_item_description);
        item_price = findViewById(R.id.pd_item_price);
        item_qty = findViewById(R.id.pd_item_qty);
    }
    private void getItemData() {
        item_data = getIntent().getStringExtra(ITEM_DATA);
    }
    private void setLayoutDetails() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ProductInformation pinfo = gson.fromJson(item_data, ProductInformation.class);

        seller_name.setText(pinfo.getSeller_name());
        rating.setRating(pinfo.getP_rat());
        rating_no.setText("( "+pinfo.getP_rat_no()+" )");
        item_name.setText(pinfo.getP_name());
        item_desc.setText(pinfo.getP_desc());
        item_price.setText("Rs. "+String.valueOf(pinfo.getP_price()));
        item_qty.setText(String.valueOf(pinfo.getQty()));
    }
}
