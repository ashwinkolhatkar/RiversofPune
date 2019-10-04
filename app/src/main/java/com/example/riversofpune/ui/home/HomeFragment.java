package com.example.riversofpune.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.riversofpune.Article;
import com.example.riversofpune.ArticleActivity;
import com.example.riversofpune.R;
import com.example.riversofpune.adapters.ArticleAdapter;

import java.util.ArrayList;
import java.util.Date;

public class HomeFragment extends Fragment implements ArticleAdapter.OnArticleListener {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    ArticleAdapter adapter;
    private ArrayList<Article> listContentArray = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        adapter = new ArticleAdapter(listContentArray, this);
        //Method call for populating the view
        populateRecyclerViewValues();
    }

    private void populateRecyclerViewValues() {
        /** This is where we pass the data to the adapter using POJO class.
         *  RecyclerView has been used for easy database integration.
         *  You can use a JSON object request to gather the required values and populate in the
         *  RecyclerView.
         * */
        for (int iter = 1; iter <= 50; iter++) {
            //Creating POJO class object
            Article pojoObject = new Article();
            //Values are binded using set method of the POJO class
            pojoObject.setArticleContentSummary("We need to save the river. ");
            pojoObject.setArticleContent("https://www.sitpune.edu.in/#");
            pojoObject.setArticleDate(new Date(12101998L));
            pojoObject.setArticleTitle("Mula Mutha River in peril!!");
            listContentArray.add(pojoObject);
        }
        adapter.setListContent(listContentArray);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onArticleClick(int position) {
        listContentArray.get(position);
        Intent intent = new Intent(getContext(), ArticleActivity.class);
        startActivity(intent);
    }
}