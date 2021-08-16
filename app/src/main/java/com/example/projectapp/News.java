package com.example.projectapp;

public class News {
        private String mTitle, mAuthor, mDesc, mPoster;

        public News(String mTitle, String mAuthor, String mDesc, String mPoster) {

            this.mTitle = mTitle;
            this.mAuthor = mAuthor;
            this.mDesc = mDesc;
            this.mPoster = mPoster;
        }

        public String getmTitle() {
            return mTitle;
        }

        public String getmAuthor() {
            return mAuthor;
        }

        public String getmDesc() {
            return mDesc;
        }

        public String getmPoster() {
            return mPoster;
        }
    }

