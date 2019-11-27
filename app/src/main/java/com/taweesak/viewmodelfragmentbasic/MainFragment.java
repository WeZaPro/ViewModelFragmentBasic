package com.taweesak.viewmodelfragmentbasic;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    TextView textView;
    EditText editText1, editText2;
    Button button;
    AndroidViewModel androidViewModel;
    private ModelNumber modelNumber;
    int numA, numB, selectId;

    int choice ;
    RadioGroup radioGroup;
    RadioButton radioButton;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        androidViewModel = ViewModelProviders.of(this).get(AndroidViewModel.class);

        findView(view);

        androidViewModel.getData().observe(getActivity(), new Observer<ModelNumber>() {
            @Override
            public void onChanged(ModelNumber modelNumber) {
                if (choice == 0) {
                    textView.setText("Number plus is " + modelNumber.getPlusNumber());
                } else {
                    textView.setText("Number plus is " + modelNumber.getMinusNumber());
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectChoice();

                try {
                    numA = Integer.valueOf(editText1.getText().toString());
                    numB = Integer.valueOf(editText2.getText().toString());

                    modelNumber = new ModelNumber(numA, numB);
                    androidViewModel.setNumber(modelNumber);

                } catch (NumberFormatException e) {
                    textView.setText("Insert number only!.......");
                }
            }
        });

        return view;
    }

    private void findView(View view) {
        textView = view.findViewById(R.id.textView);
        editText1 = view.findViewById(R.id.editText1);
        editText2 = view.findViewById(R.id.editText2);
        button = view.findViewById(R.id.button);
        radioGroup = (RadioGroup) view.findViewById(R.id.raidoButton);
    }

    private void selectChoice() {
        selectId = radioGroup.getCheckedRadioButtonId();
        radioButton = getActivity().findViewById(selectId);

        switch (radioButton.getId()) {
            case R.id.zeroText:
                choice = 0;
                break;
            case R.id.oneText:
                choice = 1;
                break;
        }
    }
}
