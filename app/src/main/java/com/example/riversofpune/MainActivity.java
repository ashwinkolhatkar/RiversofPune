package com.example.riversofpune;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.riversofpune.ui.adoptstretch.RiverAdoptFragment;
import com.example.riversofpune.ui.home.HomeFragment;
import com.example.riversofpune.ui.riverevents.RiverEventsFragment;
import com.example.riversofpune.ui.riverhistory.RiverHistoryFragment;
import com.example.riversofpune.ui.rivermaps.RiverMapsFragment;
import com.example.riversofpune.ui.send.SendFragment;
import com.example.riversofpune.ui.share.ShareFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentTransaction fragmentTransaction;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);

        /**
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
         **/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open_drawer_content_desc, R.string.close_drawer_content_desc);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /**
         if(savedInstanceState == null){
         fragmentTransaction = getSupportFragmentManager().beginTransaction();
         fragmentTransaction.replace(R.id.main_container, new HomeFragment());
         getSupportActionBar().setTitle("Home");
         fragmentTransaction.commit();
         navigationView.setCheckedItem(R.id.nav_home);
         }
         **/


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



    /*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

    }
     */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_home) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new HomeFragment());
            getSupportActionBar().setTitle("Home");
            fragmentTransaction.commit();
            menuItem.setChecked(true);

        } else if (id == R.id.nav_rivermaps) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new RiverMapsFragment());
            getSupportActionBar().setTitle("RiverMaps");
            fragmentTransaction.commit();
            menuItem.setChecked(true);

        } else if (id == R.id.nav_riverevents) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new RiverEventsFragment());
            getSupportActionBar().setTitle("Events by the River");
            fragmentTransaction.commit();
            menuItem.setChecked(true);

        } else if (id == R.id.nav_history) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new RiverHistoryFragment());
            getSupportActionBar().setTitle("History of the River");
            fragmentTransaction.commit();
            menuItem.setChecked(true);

        } else if (id == R.id.nav_adoptstretch) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new RiverAdoptFragment());
            getSupportActionBar().setTitle("Adopt a Stretch of River Mula Mutha");
            fragmentTransaction.commit();
            menuItem.setChecked(true);

        } else if (id == R.id.nav_share) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new ShareFragment());
            getSupportActionBar().setTitle("Share this app :)");
            fragmentTransaction.commit();
            menuItem.setChecked(true);

        } else if (id == R.id.nav_send) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new SendFragment());
            getSupportActionBar().setTitle("Contact Us");
            fragmentTransaction.commit();
            menuItem.setChecked(true);

        } else {

        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
