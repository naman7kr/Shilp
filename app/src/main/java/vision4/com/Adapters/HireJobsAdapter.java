package vision4.com.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import vision4.com.Modals.UserInformation;
import vision4.com.R;

public class HireJobsAdapter extends RecyclerView.Adapter<HireJobsAdapter.WorkersViewHolder> {
    //vars
    private ArrayList<UserInformation> list;
    public HireJobsAdapter(ArrayList<UserInformation> list){
        this.list = list;
    }
    @NonNull
    @Override
    public HireJobsAdapter.WorkersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_hire_jobs,parent,false);
        return new WorkersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkersViewHolder holder, int position) {
        UserInformation uInfo = list.get(position);
        holder.name.setText(uInfo.getName());
        holder.email.setText(uInfo.getEmail());
        String tags = "";
        for(int i =0;i<uInfo.getTags().length;i++){
            if(i!=0){
                tags+=", ";
            }
            tags+=uInfo.getTags()[i];
        }
        holder.tags.setText(tags);
        holder.rBar.setRating(uInfo.getHire_rating());
        holder.rating_no.setText(String.valueOf(uInfo.getHire_rating_no()));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WorkersViewHolder extends RecyclerView.ViewHolder{
        public TextView name,email,tags,rating_no;
        public RatingBar rBar;
        public WorkersViewHolder(View itemView) {
            super(itemView);
            init(itemView);
        }
        private void init(View v){
            name = v.findViewById(R.id.workers_name);
            email = v.findViewById(R.id.workers_email);
            tags = v.findViewById(R.id.workers_tags);
            rating_no = v.findViewById(R.id.workers_rating_no);
            rBar = v.findViewById(R.id.workers_rating);
        }
    }
}
