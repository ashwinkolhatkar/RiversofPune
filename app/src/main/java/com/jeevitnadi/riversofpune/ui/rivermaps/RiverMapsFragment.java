package com.jeevitnadi.riversofpune.ui.rivermaps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.jeevitnadi.riversofpune.R;

public class RiverMapsFragment extends Fragment {

    private RiverMapsViewModel riverMapsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        riverMapsViewModel =
                ViewModelProviders.of(this).get(RiverMapsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rivermaps, container, false);
        /*final TextView textView = root.findViewById(R.id.text_gallery);
        riverMapsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        WebView webView = root.findViewById(R.id.rivermap_webview);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.loadUrl("file:///android_asset/rivermaps_html/rivermaps_html.html");
        return root;
    }
}