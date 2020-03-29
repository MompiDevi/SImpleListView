package com.example.recyclerviewwcreation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.recyclerviewwcreation.Adapter.RecyclerViewAdapter;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
