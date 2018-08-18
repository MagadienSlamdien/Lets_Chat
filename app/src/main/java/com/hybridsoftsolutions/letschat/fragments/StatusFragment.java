package com.hybridsoftsolutions.letschat.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hybridsoftsolutions.letschat.R;

/**
 * Created by Magadien on 2018/08/16.
 */

public class StatusFragment extends Fragment implements FloatingActionButton.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_status, null);
        FloatingActionButton fab = v.findViewById(R.id.fab_status);
        fab.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "Status fab click", Toast.LENGTH_SHORT).show();
    }
}
