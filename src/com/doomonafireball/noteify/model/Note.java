package com.doomonafireball.noteify.model;

import android.graphics.Bitmap;

/**
 * User: derek Date: 7/15/12 Time: 8:27 AM
 */
public class Note {

    private String mTitle;
    private String mText;
    private Bitmap mIcon;
    private Bitmap mPicture;
    private boolean mSticky;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public void setIcon(Bitmap icon) {
        this.mIcon = icon;
    }

    public Bitmap getPicture() {
        return mPicture;
    }

    public void setPicture(Bitmap picture) {
        this.mPicture = picture;
    }

    public boolean isSticky() {
        return mSticky;
    }

    public void setSticky(boolean sticky) {
        mSticky = sticky;
    }
}
