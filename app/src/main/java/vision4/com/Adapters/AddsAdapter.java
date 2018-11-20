package vision4.com.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import vision4.com.Modals.AddsModel;
import vision4.com.R;

public class AddsAdapter extends RecyclerView.Adapter<AddsAdapter.AddsViewHolder> {
    //vars
    private ArrayList<AddsModel> list;
    public AddsAdapter(ArrayList<AddsModel> list){
        this.list = list;
    }
    @NonNull
    @Override
    public AddsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_adds,parent,false);
        return new AddsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddsViewHolder holder, int position) {
        AddsModel adds = list.get(position);
        holder.advertiser_name.setText(adds.getName());
        holder.date.setText(adds.getDate());
        holder.time.setText(adds.getTime());
        holder.rating_no.setText("( "+adds.getRating_no()+" )");
        holder.title.setText(adds.getTitle());
        holder.short_desc.setText(adds.getShort_description());
        holder.rBar.setRating(adds.getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AddsViewHolder extends RecyclerView.ViewHolder{
        public TextView advertiser_name,date,time,rating_no,title,short_desc;
        public ImageView advertiser_img,img;
        public RatingBar rBar;
        public AddsViewHolder(View itemView) {
            super(itemView);
            init(itemView);
        }
        private void init(View v){
            advertiser_name = v.findViewById(R.id.adds_advertiser_name);
            date = v.findViewById(R.id.adds_date);
            time = v.findViewById(R.id.adds_time);
            title = v.findViewById(R.id.adds_title);
            rating_no = v.findViewById(R.id.adds_advertiser_rating_no);
            short_desc = v.findViewById(R.id.adds_desc);
            advertiser_img = v.findViewById(R.id.adds_advertiser_img);
            img = v.findViewById(R.id.adds_img);
            rBar = v.findViewById(R.id.adds_advertiser_rating);

        }
    }
}
