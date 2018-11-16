package vision4.com.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vision4.com.Adapters.BuyProductsAdapter;
import vision4.com.Modals.ProductInformation;
import vision4.com.R;

public class BuyProductsFragment extends Fragment {

    //widgets
    private RecyclerView rView;
    private BuyProductsAdapter adapter;

    //vars
    private ArrayList<ProductInformation> list;


    //constants
    private static final String TAG = "BuyProductsFragment";
    private static final int NO_OF_COLUMNS = 2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_products,container,false);
        init(view);
        setRecView();

        //TODO: getData and update adapter
        getData();

        return view;
    }


    private void init(View view){
        list = new ArrayList<>();
        rView = view.findViewById(R.id.bp_rview);

    }
    private void setRecView() {
        rView.setLayoutManager(new GridLayoutManager(getContext(),NO_OF_COLUMNS));
        adapter = new BuyProductsAdapter(getContext(),list);
        rView.setAdapter(adapter);
    }

    public void getData() {
        int rat_no = 100;
        for(int i = 0;i<10;i++){
            ProductInformation pinfo = new ProductInformation();
            pinfo.setP_name("silk");
            pinfo.setP_price(200);
            pinfo.setP_rat((float) 4.5);
            pinfo.setP_rat_no(rat_no++);
            pinfo.setSeller_name("Naman");
            pinfo.setSeller_email("naman7kr@gmail.com");
            pinfo.setQty(4);
            String desc = "";
            for(int j = 0;j<20;j++){
                desc+="LOL";
            }
            pinfo.setP_desc(desc);
            list.add(pinfo);
        }
        adapter.notifyDataSetChanged();
        return;
    }
}
