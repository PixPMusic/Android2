package com.iponyradio.iponyradio;

import android.annotation.TargetApi;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class IRC extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_irc, container, false);
        return rootView;
    }

    public static IRC newInstance() {
        IRC n = new IRC();
        return n;
    }

}
