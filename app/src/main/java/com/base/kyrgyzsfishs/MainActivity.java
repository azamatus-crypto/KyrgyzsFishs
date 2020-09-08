package com.base.kyrgyzsfishs;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

import Settings.SettingsActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private String[]array;
    private ArrayAdapter <String> arrayAdapter;
     private Toolbar toolbar;
     private  DrawerLayout drawer;
     private int categories_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview1 = findViewById(R.id.listview_1);
        array=getResources().getStringArray(R.array.Isikulfisharray);
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));

        listview1.setAdapter(arrayAdapter);

         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.issyk_kul_fish_p);
       drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle togle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(togle);
        togle.syncState();
         listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 Intent intent=new Intent(MainActivity.this,TextContentActivity.class);
                 intent.putExtra("category",categories_index);
                 intent.putExtra("position",position);
                 startActivity(intent);
             }
         });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        toolbar.setTitle(R.string.app_name);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings){
            Intent intent=new Intent(MainActivity.this, SettingsActivity.class);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_issikul){
            toolbar.setTitle(R.string.issyk_kul_fish_p);
            array=getResources().getStringArray(R.array.Isikulfisharray);
        arrayAdapter.clear();
        arrayAdapter.addAll(array);
        arrayAdapter.notifyDataSetChanged();
        categories_index=0;
        }
        else if(id==R.id.nav_sonkol){
            toolbar.setTitle(R.string.sonkol_e_fish_p);
            array=getResources().getStringArray(R.array.Sonkolfisharray);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
            categories_index=1;
        }
        else if(id==R.id.nav_sarichelek){
            toolbar.setTitle(R.string.fish_p);
            array=getResources().getStringArray(R.array.sarichelekfisharray);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
            categories_index=2;
        }
        else if(id==R.id.nav_istorii){
            toolbar.setTitle(R.string.tips_for_fishermen_c_p);
            array=getResources().getStringArray(R.array.istorii);
            arrayAdapter.clear();
            arrayAdapter.addAll(array);
            arrayAdapter.notifyDataSetChanged();
            categories_index=3;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}