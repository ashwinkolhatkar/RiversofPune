package com.jeevitnadi.riversofpune.ui.rivermaps;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RiverMapsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RiverMapsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Maps of Mula-mutha river");
    }

    public LiveData<String> getText() {
        return mText;
    }
}