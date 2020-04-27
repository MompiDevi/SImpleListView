package com.example.recyclerviewwcreation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.recyclerviewwcreation.Adapter.RecyclerViewAdapter;
import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    ActionBarDrawerToggle tg;
    DrawerLayout dl;
    NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_drawer_layout);

        CarouselView carousel = (CarouselView) findViewById(R.id.carousel);
        carousel.setPageCount(3);
        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                switch (position){
                    case 0:
                        imageView.setImageResource(R.drawable.image1);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.image2);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.image3);
                }
            }
        });

        list = (RecyclerView)findViewById(R.id.list);
        String[] data = {"Test 1","Test 2", "Test 3", "Test 4"};
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this, data);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        dl = (DrawerLayout)findViewById(R.id.drawerlayout);
        tg = new ActionBarDrawerToggle(this, dl, R.string.drawer_open, R.string.drawer_close);

        dl.addDrawerListener(tg);
        tg.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nav);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.account:
                        Toast.makeText(MainActivity.this,"Tapped on Account", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.orders:
                        Toast.makeText(MainActivity.this,"Tapped on Orders", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.shoppingcart:
                        Toast.makeText(MainActivity.this,"Tapped on Shopping Cart", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        tg.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}
