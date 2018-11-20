package vision4.com.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vision4.com.Activities.NewAddActivity;
import vision4.com.Adapters.AddsAdapter;
import vision4.com.Modals.AddsModel;
import vision4.com.R;

public class AddsFragment extends Fragment {

    //widgets
    private RecyclerView rView;
    private FloatingActionButton fab;
    //vars
    private AddsAdapter mAdapter;
    private ArrayList<AddsModel> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adds,container,false);
        init(view);
        setRView();
        setData();

        newAdd();
        return view;
    }
    private void init(View v){
        rView = v.findViewById(R.id.adds_rview);
        fab = v.findViewById(R.id.adds_fab);
    }
    private void setRView(){
        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AddsAdapter(list);
        rView.setAdapter(mAdapter);
    }
    private void setData(){
        for(int i = 0;i<5;i++){
            AddsModel adds = new AddsModel();
            adds.setName("Rahul");
            adds.setRating(i);
            adds.setRating_no(246+i);
            adds.setDate("26/11/2018");
            adds.setTime("03:45:20");
            adds.setTitle("Loda Lahsun");
            String s = "";
            for(int j=0;j<50;j++) s+="LOL ";
            adds.setShort_description(s);
            list.add(adds);
            mAdapter.notifyDataSetChanged();

        }
    }
    private void newAdd(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),NewAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
