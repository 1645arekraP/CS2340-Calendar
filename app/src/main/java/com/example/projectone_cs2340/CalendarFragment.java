package com.example.projectone_cs2340;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CalendarFragment extends Fragment {

    // Delete this class later

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Base_Theme_ProjectOne_CS2340);
        LayoutInflater layoutInflater = inflater.cloneInContext(contextThemeWrapper);
        return layoutInflater.inflate(R.layout.calendar_fragment, container, false);
        /* View originalView = inflater.inflate(R.layout.calendar_fragment, container, false);
        return originalView; */
    }
}
