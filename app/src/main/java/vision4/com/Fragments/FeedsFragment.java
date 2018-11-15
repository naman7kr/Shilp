package vision4.com.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import vision4.com.Adapters.TopCategoryAdapter;
import vision4.com.Adapters.TopRecruiterAdapter;
import vision4.com.Adapters.TopWorkerAdapter;
import vision4.com.Modals.TopRecruiter;
import vision4.com.Modals.TopWorker;
import vision4.com.Modals.Topcategories;
import vision4.com.R;

/*
* Created by sanay
* on 16/11/2018
*/

public class FeedsFragment extends Fragment {

    //Declaration of all lists
    List<Topcategories> topcategories;
    List<TopWorker> topWorkers;
    List<TopRecruiter> topRecruiters;

    //Declaration of all recycler view
    RecyclerView rvTopCategoriesRecycler,rvTopWorker,rvTopRecruiter;

    //Declaration of all adapters
    TopCategoryAdapter adTopCategoriesAdapter;
    TopWorkerAdapter adTopWorkerAdapter;
    TopRecruiterAdapter adTopRecruiterAdapter;

    //Declaration of all LinearLayoutManager
    LinearLayoutManager categorylinearLayoutManager,workerLinearLayoutManager,recruiterLinearLayoutManager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeds,container,false);

        //Initialise all the widgets
        init(view);

        //Set the adapter for each of the three recycler Views
        //Currently for testing purpose they use sample lists
        //later on they will have to be modified to store data from the json output
        setTopCategoryAdapter(rvTopCategoriesRecycler,categorylinearLayoutManager,adTopCategoriesAdapter);
        setTopWorkerAdpater(rvTopWorker,workerLinearLayoutManager,adTopWorkerAdapter);
        setTopRecruiterAdapter(rvTopRecruiter,recruiterLinearLayoutManager,adTopRecruiterAdapter);


        return view;
    }

    //Method to set the adapter for the top recruiters
    private void setTopRecruiterAdapter(RecyclerView rvTopRecruiters, LinearLayoutManager recruiterLinearLayoutManager, TopRecruiterAdapter adTopRecruiterAdapter) {
        recruiterLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);

        rvTopRecruiters.setLayoutManager(recruiterLinearLayoutManager);
        rvTopRecruiters.setAdapter(adTopRecruiterAdapter);
        adTopRecruiterAdapter.notifyDataSetChanged();

    }
    //Method to set the adapter for the top Workers
    private void setTopWorkerAdpater(RecyclerView rvTopWorker, LinearLayoutManager workerLinearLayoutManager, TopWorkerAdapter adTopWorkerAdapter) {
        workerLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);

        rvTopWorker.setLayoutManager(workerLinearLayoutManager);
        rvTopWorker.setAdapter(adTopWorkerAdapter);
        adTopWorkerAdapter.notifyDataSetChanged();

    }

    //Method to set the adapter for the top Categories
    private void setTopCategoryAdapter(RecyclerView rvTopCategorieRecycler, LinearLayoutManager linearLayoutManager, TopCategoryAdapter adTopCategoriesAdapter) {
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);

        rvTopCategorieRecycler.setLayoutManager(linearLayoutManager);
        rvTopCategorieRecycler.setAdapter(adTopCategoriesAdapter);
        adTopCategoriesAdapter.notifyDataSetChanged();

    }

    //Method to initialise all the widgets
    private void init(View view) {

        //Initialise the Top category section Widgets
        rvTopCategoriesRecycler = view.findViewById(R.id.feeds_topcategories_recycler);
        topcategories = new ArrayList<>();
        //currently this is a dummy list
        for(int i =0;i<10;i++)
        {
            Topcategories topcategory = new Topcategories(R.drawable.ic_launcher_foreground,"type"+i);
            topcategories.add(topcategory);
        }
        adTopCategoriesAdapter = new TopCategoryAdapter(topcategories);

        //Initialise the Top category section Widgets
        rvTopWorker = view.findViewById(R.id.feeds_topworkers_recycler);
        topWorkers = new ArrayList<>();
        //Dummy list
        for(int i =0;i<5;i++)
        {
            TopWorker topWorker = new TopWorker("Sanay","sanny.sanay","7903197762");
            topWorkers.add(topWorker);
        }
        adTopWorkerAdapter = new TopWorkerAdapter(topWorkers);

        //Initialise the Top category section Widgets
        rvTopRecruiter = view.findViewById(R.id.feeds_toprecruiters_recycler);
        topRecruiters = new ArrayList<>();
        //Dummy List
        for(int i =0;i<4;i++)
        {
            TopRecruiter topRecruiter = new TopRecruiter("Somnats","sanny.somu","7903197762");
            topRecruiters.add(topRecruiter);
        }
        adTopRecruiterAdapter = new TopRecruiterAdapter(topRecruiters);

    }



}
