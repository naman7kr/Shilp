package vision4.com.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vision4.com.Adapters.CategoryAdapter;
import vision4.com.Modals.CategoryModal;
import vision4.com.R;

public class CategoriesFragment extends Fragment {

    private RecyclerView rvCategoryRecycler;
    private CategoryAdapter adCategoryAdapter;
    private List<CategoryModal> categories;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories,container,false);

        init(view);
        int numberOfColumns = 2;
        rvCategoryRecycler.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        rvCategoryRecycler.setAdapter(adCategoryAdapter);
        return view;

    }

    private void init(View view) {
        rvCategoryRecycler = view.findViewById(R.id.category_recycler);
        categories = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            CategoryModal categoryModal = new CategoryModal(R.color.colorAccent,"category"+i);
            categories.add(categoryModal);
        }

        adCategoryAdapter = new CategoryAdapter(categories);

    }
}
