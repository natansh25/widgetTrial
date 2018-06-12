package com.udacity.horatio.widgetexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    String time;
    String text, image;
    boolean isComplete;


    public Model() {

    }

    public Model(String time, String text, String image, boolean isComplete) {
        this.time = time;
        this.text = text;
        this.image = image;
        this.isComplete = isComplete;
    }


    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.time);
        dest.writeString(this.text);
        dest.writeString(this.image);
        dest.writeByte(this.isComplete ? (byte) 1 : (byte) 0);
    }

    protected Model(Parcel in) {
        this.time = in.readString();
        this.text = in.readString();
        this.image = in.readString();
        this.isComplete = in.readByte() != 0;
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}
