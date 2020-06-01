package com.jeevitnadi.riversofpune.ui.home;

import android.content.Context;
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

import com.google.gson.Gson;
import com.jeevitnadi.riversofpune.Article;
import com.jeevitnadi.riversofpune.ArticleActivity;
import com.jeevitnadi.riversofpune.R;
import com.jeevitnadi.riversofpune.adapters.ArticleAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements ArticleAdapter.OnArticleListener {
    private static final String TAG = "HomeFragment";

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    ArticleAdapter adapter;
    private ArrayList<Article> listContentArray = new ArrayList<>();
    private ArrayList<String> articleFileList;

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

        articleFileList = new ArrayList<>();
        //articleFileList.add("a1_old"); // Impact on birds
        articleFileList.add("a2_old");  // Toxin-free lifestyle

        articleFileList.add("a1");  // Impact on birds
        articleFileList.add("a2");  // Impact on fauna
        articleFileList.add("a3");  // Pune developed in the cradle of the mutha (RnR)
        articleFileList.add("a4");  // Present State of the River
        articleFileList.add("a5");  // Rights and Responsibilities
        articleFileList.add("a6");  // Rivers from Pune carry most polluted water
        articleFileList.add("a7");  // Steps to ensure River cleanliness

        articleFileList.add("m1");  // Rivers from Pune carry most polluted water
        articleFileList.add("m2");  // Age and History of the River [COMPLETE]
        articleFileList.add("m3");  // The Present state of the River
        articleFileList.add("m4");  // Red Lines and Blue lines FAQ
        articleFileList.add("m5");  // Pune will see clean mula-mutha soon - Javadekar
        articleFileList.add("m6");  // Pune River development project
        articleFileList.add("m7");  // 7 ways to keep lakes and rivers pollution free.

        //Method call for populating the view
        populateRecyclerViewValues();
    }

    private void populateRecyclerViewValues() {
        /** This is where we pass the data to the adapter using POJO class.
         *  RecyclerView has been used for easy database integration.
         *  You can use a JSON object request to gather the required values and populate in the
         *  RecyclerView.
         * */
        for (int iter = 0; iter < articleFileList.size(); iter++) {
            /**
            //Creating POJO class object
            Article pojoObject = new Article();
            //Values are binded using set method of the POJO class
            pojoObject.setArticleContentSummary("We need to save the river. ");
            pojoObject.setArticleContent("https://www.sitpune.edu.in/#");
            pojoObject.setArticleDate(new Date(12101998L));
            pojoObject.setArticleTitle("Mula Mutha River in peril!!");
             Gson gson = new Gson();
             Log.d(TAG, "populateRecyclerViewValues: "+gson.toJson(pojoObject));
             **/

            Gson gson = new Gson();
            String articleId = articleFileList.get(iter);
            Article articlePojo = gson.fromJson(loadJSONFromAsset(getContext(), articleId), Article.class);
            listContentArray.add(articlePojo);
        }
        adapter.setListContent(listContentArray);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onArticleClick(int position) {
        Article article = listContentArray.get(position);
        Intent intent = new Intent(getContext(), ArticleActivity.class);
        intent.putExtra("title", article.getArticleTitle());
        intent.putExtra("content_link", article.getArticleContent());
        startActivity(intent);
    }

    public String loadJSONFromAsset(Context context, String articleId) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(articleId + "/" + articleId + ".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}