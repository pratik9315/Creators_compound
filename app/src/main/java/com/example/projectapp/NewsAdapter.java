package com.example.projectapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

        Context context;
        ArrayList<News> arrayList;

        public NewsAdapter(Context context, ArrayList<News> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
            return new NewsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

            News news = arrayList.get(position);
            holder.title.setText(news.getmTitle());
            Glide.with(context).load(news.getmPoster()).into(holder.newsPoster);
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsActivity.class);

                    intent.putExtra("title", news.getmTitle());
                    intent.putExtra("poster", news.getmPoster());

                    context.startActivity(intent);
                }


            });
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class NewsViewHolder extends RecyclerView.ViewHolder {

            ImageView newsPoster;
            TextView title, auth, desc;
            RelativeLayout relativeLayout;

            public NewsViewHolder(@NonNull View itemView) {
                super(itemView);
                newsPoster = itemView.findViewById(R.id.newsPoster);
                title = itemView.findViewById(R.id.newsTitle);
                relativeLayout = itemView.findViewById(R.id.rLayout);
            }
        }
    }


