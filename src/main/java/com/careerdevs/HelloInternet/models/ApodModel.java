package com.careerdevs.HelloInternet.models;

public class ApodModel {


    private String date;
    private String explanation;
    private String url;
    private String title;

    public ApodModel() {

    }

    @Override
    public String toString() {
        return "ApodModel{" +
                "date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }





}
