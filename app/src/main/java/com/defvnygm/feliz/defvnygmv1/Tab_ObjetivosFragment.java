package com.defvnygm.feliz.defvnygmv1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java8.util.Optional;
import java8.util.function.Consumer;


public class Tab_ObjetivosFragment extends Fragment {
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_objetivos, container, false);
    }*/

    @NonNull
    private Optional<WebView> webView = Optional.empty();
    @Override @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.defvny_inicio, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView = Optional.ofNullable((WebView) view.findViewById(R.id.webView));
    }
    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView.ifPresent(new Consumer<WebView>() {
            @Override public void accept(WebView webView) {
                webView.loadUrl("file:///android_asset/objetivos.html");
            }
        });
    }
}
