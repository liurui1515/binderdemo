package com.example.binderserver;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaInfo implements Parcelable {
    String name;
    String url;
    String artist;

    public MediaInfo(String name, String url, String artist) {
        this.name = name;
        this.url = url;
        this.artist = artist;
    }

    protected MediaInfo(Parcel in) {
        name = in.readString();
        url = in.readString();
        artist = in.readString();
    }

    public static final Creator<MediaInfo> CREATOR = new Creator<MediaInfo>() {
        @Override
        public MediaInfo createFromParcel(Parcel in) {
            return new MediaInfo(in);
        }

        @Override
        public MediaInfo[] newArray(int size) {
            return new MediaInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(artist);
    }
}
