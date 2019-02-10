package com.tabvn.dailylovequotes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

public class GridFragment extends Fragment {

    public Filter filter;
    private QuoteViewModel quoteViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);
        GridView gridview = (GridView) v.findViewById(R.id.gridView);

        RecyclerView recyclerView = v.findViewById(R.id.gridView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setHasFixedSize(true);
        final QuoteAdapter adapter = new QuoteAdapter();
        recyclerView.setAdapter(adapter);


        quoteViewModel = ViewModelProviders.of(this).get(QuoteViewModel.class);

        quoteViewModel.insert(new Quote(1, "Title 1", "Description", "https://66.media.tumblr.com/6026a2f4d2f68a45cf06f809a0f7c3f0/tumblr_p490styH6n1w6a9vro1_640.jpg", "http://tabvn.com", "new", "blue", 0));
        quoteViewModel.insert(new Quote(2, "Title 2", "Description", "https://66.media.tumblr.com/ef544db45c933455c6ffe172c9f1b344/tumblr_p75qgtCx8L1vgtkbeo1_1280.jpg", "http://tabvn.com", "new", "blue", 0));
        quoteViewModel.insert(new Quote(3, "Title 1", "Description", "https://i.pinimg.com/564x/d9/4e/ed/d94eedfce86807d8f3424f85e2330023.jpg", "http://tabvn.com", "new", "blue", 0));
        quoteViewModel.insert(new Quote(4, "Title 2", "Description", "https://i.pinimg.com/564x/e2/74/cd/e274cd5f5b23eb358da9fc92f0b43771.jpg", "http://tabvn.com", "new", "blue", 0));
        quoteViewModel.insert(new Quote(5, "Title 1", "Description", "https://i.pinimg.com/564x/d8/5e/7e/d85e7ee4bf76250523ac6f2505667452.jpg", "http://tabvn.com", "new", "blue", 0));
        quoteViewModel.insert(new Quote(6, "Title 2", "Description", "https://i.pinimg.com/564x/1a/95/31/1a953102a8af216cd6bcdb9106f871c9.jpg?b=t", "http://tabvn.com", "new", "blue", 0));

        if (filter != null) {
            quoteViewModel.quotesByCategory(filter.getValue()).observe(this, new Observer<List<Quote>>() {
                @Override
                public void onChanged(@Nullable List<Quote> quotes) {
                    Toast.makeText(getActivity(), "updated" + quotes.size(), Toast.LENGTH_SHORT).show();
                    adapter.setQuotes(quotes);
                }
            });
        }


        return v;

    }
}
