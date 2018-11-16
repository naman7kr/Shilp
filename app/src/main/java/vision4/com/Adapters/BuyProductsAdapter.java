package vision4.com.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import vision4.com.Activities.ProductDetailsActivity;
import vision4.com.Modals.ProductInformation;
import vision4.com.R;

public class BuyProductsAdapter extends RecyclerView.Adapter<BuyProductsAdapter.ViewHolder> implements View.OnClickListener {
    //vars
    private ArrayList<ProductInformation> list;
    private Context context;
    private LayoutInflater inflater;

    //constants
    private static final String ITEM_DATA = "item_data";

    public BuyProductsAdapter(Context context, ArrayList<ProductInformation> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_buy_products,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set vals to the item

        final ProductInformation info = list.get(position);
        holder.name.setText(info.getP_name());
        holder.price.setText("Rs. "+String.valueOf(info.getP_price()));
        holder.rating.setRating(info.getP_rat());
        holder.rating_no.setText(String.valueOf("( "+info.getP_rat_no()+ " )"));
        holder.cView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);

                //pass item data to ProductDetailsActivity
                Gson gson = new Gson();
                String item_data = gson.toJson(info);
                intent.putExtra(ITEM_DATA,item_data);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //widgets
        public TextView name,price,rating_no;
        public RatingBar rating;
        private CardView cView;

        public ViewHolder(View itemView) {
            super(itemView);
            init(itemView);
        }
        private void init(View view){
            name = view.findViewById(R.id.bp_item_name);
            price = view.findViewById(R.id.bp_item_price);
            rating = view.findViewById(R.id.bp_item_rating);
            rating_no = view.findViewById(R.id.bp_item_rating_no);
            cView = view.findViewById(R.id.bp_item_cview);
        }
    }
}
