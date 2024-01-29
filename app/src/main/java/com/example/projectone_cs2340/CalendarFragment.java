package com.example.projectone_cs2340;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
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

    Button button1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View originalView = inflater.inflate(R.layout.calendar_fragment, container, false);
        return originalView;
    }

    public void onViewCreated(@NonNull View originalView, Bundle savedInstanceState) {
        super.onViewCreated(originalView, savedInstanceState);

        Toast test = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
        test.show();

        button1 = originalView.findViewById(R.id.todoButton);
        /* button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast test = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                test.show();
                showDialog();
            }
        }); */

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_pop_up, null);
                //View view = View.inflate(getActivity(), R.layout.fragment_pop_up, null);
                Spinner spinner = (Spinner) view.findViewById(R.id.eventSpinner);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                        R.array.eventOptions,
                        android.R.layout.simple_spinner_item
                );
                spinner.setAdapter(adapter);
                EditText eventName = (EditText) view.findViewById(R.id.name);
                EditText eventDate = (EditText) view.findViewById(R.id.time);
                EditText courseName = (EditText) view.findViewById(R.id.course);
                EditText location = (EditText) view.findViewById(R.id.location);
                EditText professorName = (EditText) view.findViewById(R.id.professor);
                EditText isCompleted = (EditText) view.findViewById(R.id.completed);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Enter event details here:")
                        .setView(view)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String eName = eventName.getText().toString();
                                String eDate = eventDate.getText().toString();
                                String cName = courseName.getText().toString();
                                String loc = location.getText().toString();
                                String prof = professorName.getText().toString();
                                String complete = isCompleted.getText().toString();

                                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                                myToast.show();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();


            }
        });
    }

    private void showDialog()
    {
        Dialog dialog = new Dialog(this.getContext());
        dialog.setContentView(R.layout.fragment_pop_up);
        dialog.show();
    }
}
