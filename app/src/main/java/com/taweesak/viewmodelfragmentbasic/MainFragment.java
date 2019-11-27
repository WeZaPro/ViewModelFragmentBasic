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
import android.widget.Switch;
import android.widget.TextView;

public class MainFragment extends Fragment {

    TextView textView;
    EditText editText1, editText2;
    Button button;
    AndroidViewModel androidViewModel;
    private ModelNumber modelNumber;
    int  selectId,choice ;
    double numA, numB;

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
                /*if (choice == 0) {
                    textView.setText("Number plus is " + modelNumber.getPlusNumber());
                } else {
                    textView.setText("Number minus is " + modelNumber.getMinusNumber());
                }*/
                checkChoice(modelNumber);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectChoice();

                try {
                    numA = Double.parseDouble(editText1.getText().toString());
                    numB = Double.parseDouble(editText2.getText().toString());

                    modelNumber = new ModelNumber(numA, numB,choice);
                    androidViewModel.setNumber(modelNumber);

                } catch (NumberFormatException e) {
                    textView.setText("Insert number only!.......");
                }
            }
        });
        return view;
    }

    private void checkChoice(ModelNumber modelNumber) {
        switch (modelNumber.choice){
            case 0:
                textView.setText("Number minus is : " + String.format("%1.2f", modelNumber.getPlusNumber()));
                break;
            case 1:
                textView.setText("Number minus is : " + String.format("%1.2f", modelNumber.getMinusNumber()));
                break;
            case 2:
                textView.setText("Number multiply is : " + String.format("%1.2f", modelNumber.getMultiplyNumber()));
                break;
            case 3:
                textView.setText("Number divide is : " + String.format("%1.2f", modelNumber.getDivideNumber()));
                break;
        }
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
            case R.id.plus:
                choice = 0;
                break;
            case R.id.minus:
                choice = 1;
                break;
            case R.id.multiply:
                choice = 2;
                break;
            case R.id.divide:
                choice = 3;
                break;
        }
    }
}
