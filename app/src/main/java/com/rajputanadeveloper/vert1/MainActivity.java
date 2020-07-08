package com.rajputanadeveloper.vert1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<VideoItem> videoItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager2 videoViewPager=findViewById(R.id.videoViewPager);
       videoItems= new ArrayList<VideoItem>();



        VideoItem celeb=new VideoItem();
        celeb.videoURL ="https://www.infinityandroid.com/videos/video1.mp4";
        celeb.videoTitle ="Dewalii";
        celeb.videoDescription ="celebrate with everyone";
        videoItems.add(celeb);
//
//
        VideoItem party=new VideoItem();
        party.videoURL ="https://www.infinityandroid.com/videos/video2.mp4";
        party.videoTitle ="party";
        party.videoDescription ="your life your way";
        videoItems.add(party);


        VideoItem exercise=new VideoItem();
        exercise.videoURL ="https://www.infinityandroid.com/videos/video3.mp4";
        exercise.videoTitle ="Exercise";
        exercise.videoDescription ="no pain no gain";
        videoItems.add(exercise);


        VideoItem nature=new VideoItem();
        nature.videoURL ="https://www.infinityandroid.com/videos/video4.mp4";
        nature.videoTitle ="Greenery";
        nature.videoDescription ="Your every walk with nature gives more tham you seek for";
        videoItems.add(nature);

        VideoItem cill2=new VideoItem();
        cill2.videoURL ="https://www.infinityandroid.com/videos/video5.mp4";
        cill2.videoTitle ="Chill";
        cill2.videoDescription ="Always chill alone daily as you will meet yourself";
        videoItems.add(cill2);
//
        VideoItem cill1=new VideoItem();
        cill1.videoURL ="https://www.infinityandroid.com/videos/video6.mp4";
        cill1.videoTitle ="adventure";
        cill1.videoDescription ="Always chill alone daily as you will meet yourself";
        videoItems.add(cill1);







        videoViewPager.setAdapter(new VideosAdapter(videoItems));
    }
}
