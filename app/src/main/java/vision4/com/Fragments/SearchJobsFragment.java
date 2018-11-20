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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import vision4.com.Adapters.HireCraftManAdapter;
import vision4.com.Modals.HireCraftManModal;
import vision4.com.R;

public class SearchJobsFragment extends Fragment {

    //Spinner to select the category
    private Spinner spinner;
    private String[] spinnerStringList = {"pottery","embroidery","silk","basket","origamy"};
    ArrayAdapter<CharSequence> spinnerAdapter;


    //Recycler view

    private RecyclerView recyclerView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private HireCraftManAdapter hireCraftManAdapter;
    private List<HireCraftManModal> hireCraftManList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_jobs,container,false);

        //to set the spinner list items
        setSpinnerList(view);

        //to set Recycler View
        setRecyclerView(view);


        return view;
    }

    public void setSpinnerList(View view)
    {
        spinner = (Spinner) view.findViewById(R.id.hire_spinner_category);
        spinnerAdapter = new ArrayAdapter<CharSequence>(getActivity(), android.R.layout.simple_spinner_item, spinnerStringList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void  setRecyclerView(View view)
    {
        mRecyclerView=(RecyclerView)view.findViewById(R.id.hire_recycler_view);


        //adding some example elements
        HireCraftManModal man = new HireCraftManModal("Ass Singh", "Tatti Khor",null);
        hireCraftManList.add(man);
        man = new HireCraftManModal("Sonu nigam", "Basket Making",null);
        hireCraftManList.add(man);
        man = new HireCraftManModal("Ass King", "Embroidery",null);
        hireCraftManList.add(man);



        hireCraftManAdapter=new HireCraftManAdapter(hireCraftManList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(hireCraftManAdapter);
        hireCraftManAdapter.notifyDataSetChanged();

    }

}
