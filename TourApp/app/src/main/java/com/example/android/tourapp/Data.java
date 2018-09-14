package com.example.android.tourapp;

//This is the Data model being displayed by the RecyclerView.

public class Data {
    private String mName;
    private String mDescription;


    /***
     * Image resource ID for the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /***
     * Constant value that represents no image was provided for this place
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    //Creates a new Data object.
    public Data(String name, String description, int imageResourceId) {
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }



    public String getmDescription() {
        return mDescription;
    }



    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
