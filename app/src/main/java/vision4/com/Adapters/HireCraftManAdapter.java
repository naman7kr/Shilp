package vision4.com.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vision4.com.Modals.HireCraftManModal;
import vision4.com.R;

public class HireCraftManAdapter extends RecyclerView.Adapter<MyViewHolder> {

    //list for the recycler view
    List<HireCraftManModal> hireCraftManList;

    public HireCraftManAdapter(List<HireCraftManModal> hireCraftManList) {
        this.hireCraftManList = hireCraftManList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hire_craft_man,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(hireCraftManList.get(position).getName());
        holder.category.setText(hireCraftManList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return hireCraftManList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView name, category;

    public MyViewHolder(View view) {
        super(view);
        name = (TextView) view.findViewById(R.id.hire_craft_man_name);
        category = (TextView) view.findViewById(R.id.hire_craft_man_category);
    }
}
