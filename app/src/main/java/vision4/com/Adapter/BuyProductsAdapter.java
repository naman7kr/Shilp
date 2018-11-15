package vision4.com.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vision4.com.Modals.ProductInformation;
import vision4.com.R;

public class BuyProductsAdapter extends RecyclerView.Adapter<BuyProductsAdapter.ViewHolder> {
    //vars
    private ArrayList<ProductInformation> list;
    private Context context;
    private LayoutInflater inflater;

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

        ProductInformation info = list.get(position);
        holder.name.setText(info.getP_name());
        holder.price.setText(info.getP_price());
        holder.rating.setText(String.valueOf(info.getP_rat())+" (");
        holder.rating_no.setText(String.valueOf(info.getP_rat_no()+ " )"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //widgets
        public TextView name,price,rating,rating_no;


        public ViewHolder(View itemView) {
            super(itemView);
            init(itemView);
        }
        private void init(View view){
            name = view.findViewById(R.id.bp_item_name);
            price = view.findViewById(R.id.bp_item_price);
            rating = view.findViewById(R.id.bp_item_rating);
            rating_no = view.findViewById(R.id.bp_item_rating_no);
        }
    }
}
