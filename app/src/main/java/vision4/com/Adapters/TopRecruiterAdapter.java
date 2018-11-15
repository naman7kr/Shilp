package vision4.com.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vision4.com.Modals.TopRecruiter;
import vision4.com.R;

public class TopRecruiterAdapter extends RecyclerView.Adapter<TopRecruiterViewHolder> {


    private List<TopRecruiter> topRecruiters;
    private Context context;

    public TopRecruiterAdapter(List<TopRecruiter> topRecruiters) {
        this.topRecruiters = topRecruiters;
    }

    @NonNull
    @Override
    public TopRecruiterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_recruiter_element,parent,false);
        context = parent.getContext();
        return new TopRecruiterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRecruiterViewHolder holder, int position) {
        holder.setData(holder,position,topRecruiters);
    }


    @Override
    public int getItemCount() {
        return topRecruiters.size();
    }
}

class TopRecruiterViewHolder extends RecyclerView.ViewHolder{

    View mView;

    private TextView tvName,tvEmail,tvPhone;

    public TopRecruiterViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        tvName = mView.findViewById(R.id.single_recruiter_name);
        tvEmail = mView.findViewById(R.id.single_recruiter_email);
        tvPhone = mView.findViewById(R.id.single_recruiter_phone);
    }

    public void setData(TopRecruiterViewHolder holder, int position, List<TopRecruiter> topRecruiters) {

        tvName.setText(topRecruiters.get(position).getName());
        tvEmail.setText(topRecruiters.get(position).getEmail());
        tvPhone.setText(topRecruiters.get(position).getPhone());
    }
}