package vision4.com.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vision4.com.Modals.Topcategories;
import vision4.com.R;

public class TopCategoryAdapter extends RecyclerView.Adapter<TopCategoryViewHolder>{

    List<Topcategories> topcategories;
    Context context;

    public TopCategoryAdapter(List<Topcategories> topcategories) {
        this.topcategories = topcategories;
    }

    @NonNull
    @Override
    public TopCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_category_element,parent,false);
        context = parent.getContext();
        return new TopCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopCategoryViewHolder holder, int position) {
        holder.setData(holder,position,topcategories);
    }


    @Override
    public int getItemCount() {
        return topcategories.size();
    }
}

class TopCategoryViewHolder extends RecyclerView.ViewHolder{

    private View mView;
    private TextView tvCategoryName;
    private ImageView ivCategoryImage;


    public TopCategoryViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        tvCategoryName = mView.findViewById(R.id.single_category_name);
        ivCategoryImage = mView.findViewById(R.id.single_category_image);
    }


    public void setData(TopCategoryViewHolder holder, int position, List<Topcategories> topcategories) {

        ivCategoryImage.setImageResource(topcategories.get(position).getImageRes());
        tvCategoryName.setText(topcategories.get(position).getName());
    }
}
