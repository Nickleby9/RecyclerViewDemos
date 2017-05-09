package hilay.edu.recyclerviewdemos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android2017 on 5/9/2017.
 */

public class SongItem implements Parcelable {
    private String title, artist, lyrics, duration;
    private int thumbResId;

    public SongItem(String title, String artist, int thumbResId, String lyrics, String duration) {
        this.title = title;
        this.artist = artist;
        this.lyrics = lyrics;
        this.duration = duration;
        this.thumbResId = thumbResId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getDuration() {
        return duration;
    }

    public int getThumbResId() {
        return thumbResId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.artist);
        dest.writeString(this.lyrics);
        dest.writeString(this.duration);
        dest.writeInt(this.thumbResId);
    }

    protected SongItem(Parcel in) {
        this.title = in.readString();
        this.artist = in.readString();
        this.lyrics = in.readString();
        this.duration = in.readString();
        this.thumbResId = in.readInt();
    }

    public static final Parcelable.Creator<SongItem> CREATOR = new Parcelable.Creator<SongItem>() {
        @Override
        public SongItem createFromParcel(Parcel source) {
            return new SongItem(source);
        }

        @Override
        public SongItem[] newArray(int size) {
            return new SongItem[size];
        }
    };
}
