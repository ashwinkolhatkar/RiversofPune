package com.jeevitnadi.riversofpune.ui.riverevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.jeevitnadi.riversofpune.R;

public class RiverEventsFragment extends Fragment {

    private RiverEventsViewModel riverEventsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        riverEventsViewModel =
                ViewModelProviders.of(this).get(RiverEventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_riverevents, container, false);
        WebView webView = root.findViewById(R.id.riverevents_webview);
        webView.loadUrl("https://www.jeevitnadi.org/muthai-river-walk/");
        return root;
    }
}