package vision4.com.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vision4.com.Modals.TopWorker;
import vision4.com.R;

public class TopWorkerAdapter extends RecyclerView.Adapter<TopWorkerViewHolder>{

    List<TopWorker> topWorkers;
    Context context;

    public TopWorkerAdapter(List<TopWorker> topWorkers) {
        this.topWorkers = topWorkers;
    }

    @NonNull
    @Override
    public TopWorkerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_worker_element,parent,false);
        context = parent.getContext();
        return new TopWorkerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopWorkerViewHolder holder, int position) {

            holder.setdata(holder,position,topWorkers);
    }

    @Override
    public int getItemCount() {
        return topWorkers.size();
    }

}


class TopWorkerViewHolder extends RecyclerView.ViewHolder{

    View mView;
    private TextView tvName,tvEmail,tvPhone;
    public TopWorkerViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        tvName = mView.findViewById(R.id.single_worker_name);
        tvEmail = mView.findViewById(R.id.single_worker_email);
        tvPhone = mView.findViewById(R.id.single_worker_phone);

    }

    public void setdata(TopWorkerViewHolder holder, int position, List<TopWorker> topWorkers) {
        tvName.setText(topWorkers.get(position).getName());
        tvEmail.setText(topWorkers.get(position).getEmail());
        tvPhone.setText(topWorkers.get(position).getPhone());
    }
}