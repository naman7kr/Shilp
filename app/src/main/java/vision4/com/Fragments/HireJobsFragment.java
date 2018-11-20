package vision4.com.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vision4.com.Adapters.HireJobsAdapter;
import vision4.com.Modals.UserInformation;
import vision4.com.R;

public class HireJobsFragment extends Fragment {

    //widgets
    private RecyclerView rView;
    //vars
    private HireJobsAdapter mAdapter;
    private ArrayList<UserInformation> list = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hire_jobs, container, false);
        init(view);

        setRview();

        getData();
        return view;
    }

    private void init(View v){
        rView = v.findViewById(R.id.workers_rview);
        mAdapter = new HireJobsAdapter(list);
    }
    private void setRview(){
        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        rView.setAdapter(mAdapter);
    }
    private void getData(){
        //TODO: get data from backend

        for(int i = 0;i<20;i++){
            UserInformation info = new UserInformation();
            info.setName("rahul");
            info.setEmail("rahul@gmail.com");
            info.setContact_no("943133634"+i);
            info.setHire_rating((float) 4.5);
            info.setHire_rating_no(200+i);
            info.setTags(new String[]{"craftsman", "labour", "farmer"});
            list.add(info);
            mAdapter.notifyDataSetChanged();
        }
    }
}
