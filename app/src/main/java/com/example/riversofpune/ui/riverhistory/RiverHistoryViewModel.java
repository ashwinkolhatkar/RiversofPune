package com.example.riversofpune.ui.riverhistory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RiverHistoryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RiverHistoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}