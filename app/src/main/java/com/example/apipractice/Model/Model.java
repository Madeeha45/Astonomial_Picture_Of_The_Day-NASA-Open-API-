package com.example.apipractice.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Model {

    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("explanation")
    @Expose
    private String explanation;
    @SerializedName("hdurl")
    @Expose
    private String hdurl;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("service_version")
    @Expose
    private String serviceVersion;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;

    public Model(String copyright, String date, String explanation, String hdurl, String mediaType, String serviceVersion, String title, String url) {
        this.copyright=copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }


    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

