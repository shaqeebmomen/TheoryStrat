package com.theorystrat;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.theorystrat.ViewModels.TournyViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private BottomNavigationView navView;
    private TournyViewModel tournyViewModel;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();


        //Set up NavController and BottomNavigationView
        navView = findViewById(R.id.nav_view);
//         Passing each menu ID as a set of Ids because each
//         menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.matchCardSelectorNav, R.id.matchCardMakerNav, R.id.matches, R.id.teamNav)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_welcome_host);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                if (navController.getCurrentDestination().getId() == R.id.teamDisplayFragment) {
                    navController.popBackStack(R.id.teamDisplayFragment, true);
                }
                break;

            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
