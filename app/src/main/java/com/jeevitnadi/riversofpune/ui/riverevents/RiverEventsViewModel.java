package com.jeevitnadi.riversofpune.ui.riverevents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RiverEventsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RiverEventsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}