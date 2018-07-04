package com.example.soumyajitdas.reactdemo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ListModel {

    ArrayList<Model> result;

    public ArrayList<Model> getModelArrayList() {
        return result;
    }

    public static class Model implements Parcelable
    {
        /*"name": "Muskaan Foundation",
                "emailId": "muskaanfoundation@gmail.com",
                "type": "Orphanage",
                "bannerImage": "https://xyz.xyz",
                "numberOfResidents": "100",
                "distance": "2979.1",
                "isVerified": false*/
        String name;
        String emailId;
        String type;
        String bannerImage;
        String numberOfResidents;
        String distance;
        Boolean isVerified;

        public Model(Parcel in) {

            name=in.readString();
            emailId=in.readString();
            type=in.readString();
            bannerImage=in.readString();
            numberOfResidents=in.readString();
            distance=in.readString();
            if(in.readString().equals("true"))
            {
                isVerified=true;
            }
            else
            {
                isVerified=false;
            }

        }


        public String getName() {
            return name;
        }

        public String getEmailId() {
            return emailId;
        }

        public String getType() {
            return type;
        }

        public String getBannerImage() {
            return bannerImage;
        }

        public String getNumberOfResidents() {
            return numberOfResidents;
        }

        public String getDistance() {
            return distance;
        }

        public Boolean getVerified() {
            return isVerified;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setBannerImage(String bannerImage) {
            this.bannerImage = bannerImage;
        }

        public void setNumberOfResidents(String numberOfResidents) {
            this.numberOfResidents = numberOfResidents;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public void setVerified(Boolean verified) {
            isVerified = verified;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Parcelable.Creator<Model> CREATOR
                = new Parcelable.Creator<Model>() {
            public Model createFromParcel(Parcel in) {
                return new Model(in);
            }

            public Model[] newArray(int size) {
                return new Model[size];
            }
        };

        @Override
        public void writeToParcel(Parcel dest, int flags) {

            dest.writeString(name);
            dest.writeString(emailId);
            dest.writeString(type);
            dest.writeString(bannerImage);
            dest.writeString(numberOfResidents);
            dest.writeString(distance);
            dest.writeString(String.valueOf(isVerified));

        }
    }
}
