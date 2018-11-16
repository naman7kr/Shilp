package vision4.com.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vision4.com.Modals.CategoryModal;
import vision4.com.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<CategoryModal> categories;
    private Context context;

    public CategoryAdapter(List<CategoryModal> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_element, parent, false);
        context = parent.getContext();
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.setData(holder, position, categories);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}

class CategoryViewHolder extends RecyclerView.ViewHolder {
    View mView;
    private ImageView ivCategoryImage;
    private TextView tvCategoryName;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        ivCategoryImage = itemView.findViewById(R.id.item_category_image);
        tvCategoryName = itemView.findViewById(R.id.item_category_name);
    }


    public void setData(CategoryViewHolder holder, int position, List<CategoryModal> categories) {
        ivCategoryImage.setImageResource(categories.get(position).getImageURL());
        tvCategoryName.setText(categories.get(position).getCategoryName());
    }
}