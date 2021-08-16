package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class YoutubeActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tv;
    WebView webView;
    ImageView nordVpn, prime, skillshare, devfolio, devfest, sawo, policies, toxic, mon, more, grow;
    ImageView person1, person2, person3, person4, person5;
    ImageView clickInsta, clickFb, clickYoutube, clickTwitter;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private ArrayList<News> arrayList;

    SliderView sliderView;
    int[] images = {
            R.drawable.bbb,
            R.drawable.ajey,
            R.drawable.as,
            R.drawable.tech

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.dLayout);
        navigationView = (NavigationView) findViewById(R.id.nav);
        webView = findViewById(R.id.webview);
        sliderView = findViewById(R.id.relLout);
        nordVpn = findViewById(R.id.nordVpn);
        skillshare = findViewById(R.id.skillshare);
        devfolio = findViewById(R.id.devfolio);
        prime = findViewById(R.id.prime);
        sawo = findViewById(R.id.sawo);
        devfest = findViewById(R.id.devfest);
        tv = findViewById(R.id.textView5);
        policies = findViewById(R.id.policies);
        toxic = findViewById(R.id.toxic);
        mon = findViewById(R.id.monetization);
        more = findViewById(R.id.More);
        grow = findViewById(R.id.grow);
        clickInsta = findViewById(R.id.clickInsta);
        clickFb = findViewById(R.id.clickFb);
        clickTwitter = findViewById(R.id.clickTwitter);
        clickYoutube = findViewById(R.id.clickYoutube);
        person1 = findViewById(R.id.person1);
        person2 = findViewById(R.id.person2);
        person3 = findViewById(R.id.person3);
        person4 = findViewById(R.id.person4);
        person5 = findViewById(R.id.person5);
        personProfile();

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://indianexpress.com/section/lifestyle/";
                openWebPage(url);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        arrayList = new ArrayList<>();
        requestQueue = MySingleton.getInstance(this).getRequestQueue();
        fetchData();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(YoutubeActivity.this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.startAutoCycle();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        startActivity(new Intent(YoutubeActivity.this, YoutubeActivity.class));
                        break;

                    case R.id.dashboard:
                        startActivity(new Intent(YoutubeActivity.this, CallbackActivity.class));
                        break;


                    case R.id.Share:
                        shareText();
                        break;

                    case R.id.about_us:
                        startActivity(new Intent(YoutubeActivity.this, AboutUs.class));
                        break;

                    case R.id.seo:
                        String url = "https://backlinko.com/how-to-rank-youtube-videos";
                        openWebPage(url);
                }
                return true;
            }
        });

        clickInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.instagram.com";
                openWebPage(url);
            }
        });

        clickFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com";
                openWebPage(url);
            }
        });

        clickYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com";
                openWebPage(url);
            }
        });
        clickTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.twitter.com";
                openWebPage(url);
            }
        });

        nordVpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.nordvpn.com";
                openWebPage(url);
            }
        });

        policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://creatoracademy.youtube.com/page/lesson/copyright-guidelines";
                openWebPage(url);
            }
        });

        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://support.google.com/youtube/answer/1311392?hl=en";
                openWebPage(url);
            }
        });

        toxic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/howyoutubeworks/policies/community-guidelines/";
                openWebPage(url);
            }
        });

        grow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://backlinko.com/how-to-rank-youtube-videos";
                openWebPage(url);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/intl/ALL_in/howyoutubeworks/progress-impact/impact/";
                openWebPage(url);
            }
        });


        skillshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.skillshare.com";
                openWebPage(url);
            }
        });


        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.in/";
                openWebPage(url);
            }
        });


        devfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://devfolio.co/";
                openWebPage(url);
            }
        });


        sawo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.sawolabs.com";
                openWebPage(url);
            }
        });


        devfest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://fest.devsoc.club/";
                openWebPage(url);
            }
        });


    }

    public void shareText() {
        String type = "text/plain";
        String title = "Share Our App!";
        String text = "https://fest.devsoc.club/";

        ShareCompat.IntentBuilder
                .from(YoutubeActivity.this)
                .setType(type)
                .setChooserTitle(title)
                .setText(text)
                .startChooser();
    }

    private void fetchData() {
        //String url = "https://newsapi.org/v2/everything?q=tesla&from=2021-07-16&sortBy=publishedAt&apiKey=4907359357e14e059ac942fab5a2c04b1";
        String url = "https://gnews.io/api/v4/search?q=memes&token=df7187b9b1866f39fd5a49cdaeb3b1f6&lang=en";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject articles = jsonArray.getJSONObject(i);
                        String title = articles.getString("title");
                        String author = articles.getString("content");
                        String desc = articles.getString("description");
                        String poster = articles.getString("image");

                        News news = new News(title, author, desc, poster);
                        arrayList.add(news);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                NewsAdapter adapter = new NewsAdapter(YoutubeActivity.this, arrayList);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(YoutubeActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }


    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void personProfile(){
        person1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sample = "prajyotpatil12@gmail.com";
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:"+sample+ "your_email"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });

        person2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sample = "adriansilva25@gmail.com";
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:"+sample+ "your_email"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });

        person3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sample = "aarti_thakur23@gmail.com";
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:"+sample+ "your_email"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });

        person4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sample = "nathan_holland245@gmail.com";
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:"+sample+ "your_email"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Need Video Editor For My Youtube Videos");
                    intent.putExtra(Intent.EXTRA_TEXT, "Hey!");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });

        person5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sample = "sam_kutner3@gmail.com";
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:"+sample+ "your_email"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });
    }
}

