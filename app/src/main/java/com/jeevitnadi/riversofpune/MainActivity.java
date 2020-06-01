package com.jeevitnadi.riversofpune;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.jeevitnadi.riversofpune.ui.adoptstretch.RiverAdoptFragment;
import com.jeevitnadi.riversofpune.ui.home.HomeFragment;
import com.jeevitnadi.riversofpune.ui.riverevents.RiverEventsFragment;
import com.jeevitnadi.riversofpune.ui.riverhistory.RiverHistoryFragment;
import com.jeevitnadi.riversofpune.ui.rivermaps.RiverMapsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentTransaction fragmentTransaction;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

        drawer = findViewById(R.id.drawer_layout);
        drawer.setClickable(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open_drawer_content_desc, R.string.close_drawer_content_desc);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /**
         if(savedInstanceState == null){
         fragmentTransaction = getSupportFragmentManager().beginTransaction();
         fragmentTransaction.replace(R.id.main_container, new HomeFragment());
         getSupportActionBar().setTitle("Home");
         fragmentTransaction.commit();
         navigationView.setCheckedItem(R.id.nav_home);
         }
         **/

        if (savedInstanceState == null) {
            Fragment newFragment = new HomeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.main_container, newFragment);
            ft.addToBackStack(null);
            ft.commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
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
            /*
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new ShareFragment());
            getSupportActionBar().setTitle("Share this app :)");
            fragmentTransaction.commit();
            //menuItem.setChecked(true);
             */
            String playstore_link = "https://www.jeevitnadi.org";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Help Pune's Rivers breathe with life again: " + playstore_link);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_send) {
            /*
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new SendFragment());
            getSupportActionBar().setTitle("Contact Us");
            fragmentTransaction.commit();
            //menuItem.setChecked(true);
             */
            String jeevitnadi_email = "jeevitnadi@gmail.com";
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{jeevitnadi_email});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "your message here...");
            startActivity(Intent.createChooser(intent, "Send Email"));

        } else {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
