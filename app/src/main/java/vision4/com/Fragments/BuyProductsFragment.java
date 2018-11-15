package vision4.com.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vision4.com.Adapter.BuyProductsAdapter;
import vision4.com.Modals.ProductInformation;
import vision4.com.R;

public class BuyProductsFragment extends Fragment {

    //widgets
    private RecyclerView rView;
    private BuyProductsAdapter adapter;

    //vars
    private ArrayList<ProductInformation> list;
    private static final String TAG = "BuyProductsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_products,container,false);
        init(view);
        setRecView();
        rView.setLayoutManager(new LinearLayoutManager(getContext()));

        //TODO: getData and update adapter
        getData();

        return view;
    }


    private void init(View view){
        list = new ArrayList<>();
        rView = view.findViewById(R.id.bp_rview);

    }
    private void setRecView() {
        adapter = new BuyProductsAdapter(getContext(),list);
        rView.setAdapter(adapter);
    }

    public void getData() {
        ProductInformation pinfo = new ProductInformation();
        pinfo.setP_name("silk");
        pinfo.setP_price("200");
        pinfo.setP_rat((float) 4.5);
        pinfo.setP_rat_no(500);
        list.add(pinfo);
        adapter.notifyDataSetChanged();
        return;
    }
}
