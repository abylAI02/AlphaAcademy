package com.example.yelaman.alphaacademy;

public class Video {
    private String title;
    private String URL;
    private String thumbnail;

    public Video(String URL) {

        this.URL = URL;
        this.title = "video";
      /*  this.thumbnail = ;
        this.title = ;*/
    }

    public String getTitle() {
        return title;
    }


    public String getURL() {
        return URL;
    }



    public String getThumbnail() {
        return thumbnail;
    }

}
