package com.example.gws;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_rating =findViewById(R.id.btn_rating);
        Button btn_general =findViewById(R.id.btn_general);
        Button btn_food_beverage=findViewById(R.id.btn_food_beverage);
        Button btn_feedback=findViewById(R.id.btn_feedback);
        btn_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity_rating();
            }
        });
        btn_general.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity_general();
            }
        });
        btn_food_beverage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity_food_beverage();
            }
        });
        btn_feedback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity_feedback();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);



        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,
                    new FaqFragment()).commit();
            navigationView.setCheckedItem(R.id.sub_faq);
        }

    }
    private void activity_rating() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void activity_general() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void activity_food_beverage() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void activity_feedback() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.sub_faq:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,new FaqFragment()).commit();
               break;

            case R.id.sub_policy:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,new PolicyFragment()).commit();
                break;

        }
       drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed(){

        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
         }

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

    private class FaqFragment extends Fragment {
    }

    private class PolicyFragment extends Fragment {
    }
}