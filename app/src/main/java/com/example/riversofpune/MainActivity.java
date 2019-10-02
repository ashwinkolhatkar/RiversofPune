package com.example.riversofpune;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.riversofpune.adapters.ArticleAdapter;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements ArticleAdapter.OnArticleListener {

    private AppBarConfiguration mAppBarConfiguration;
    RecyclerView recyclerView;
    ArticleAdapter adapter;
    private ArrayList<Article> listContentArray= new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_rivermaps, R.id.nav_riverevents,
                R.id.nav_history, R.id.nav_adoptstretch,R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        //As explained in the tutorial, LineatLayoutManager tells the RecyclerView that the view
        //must be arranged in linear fashion
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ArticleAdapter(listContentArray,this);
        //Method call for populating the view
        populateRecyclerViewValues();

    }

    private void populateRecyclerViewValues() {
        /** This is where we pass the data to the adpater using POJO class.
         *  RecyclerView has been used for easy database integration.
         *  You can use a JSON object request to gather the required values and populate in the
         *  RecyclerView.
         * */
        for(int iter=1;iter<=50;iter++) {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onArticleClick(int position) {
        listContentArray.get(position);
        Intent intent = new Intent(this, ArticleActivity.class);
        startActivity(intent);
    }
}
