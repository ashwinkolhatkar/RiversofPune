package com.example.riversofpune.ui.riverevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.riversofpune.R;

public class RiverEventsFragment extends Fragment {

    private RiverEventsViewModel riverEventsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        riverEventsViewModel =
                ViewModelProviders.of(this).get(RiverEventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_riverevents, container, false);
        return root;
    }
}