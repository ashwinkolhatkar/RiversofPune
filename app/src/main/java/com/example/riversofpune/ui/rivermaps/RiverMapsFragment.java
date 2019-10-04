package com.example.riversofpune.ui.rivermaps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.riversofpune.R;

public class RiverMapsFragment extends Fragment {

    private RiverMapsViewModel riverMapsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        riverMapsViewModel =
                ViewModelProviders.of(this).get(RiverMapsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rivermaps, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        riverMapsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}