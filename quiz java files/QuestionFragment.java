package com.example.quiz;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionFragment extends Fragment {
    private static final String ARG_QUESTION = "question";
    private Question question;
    private RadioGroup radioGroup;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance(Question question) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUESTION, question);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = (Question) getArguments().getSerializable(ARG_QUESTION);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        // Initialize UI elements
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textViewQuestion = view.findViewById(R.id.textViewQuestion);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RadioButton radioButtonOption1 = view.findViewById(R.id.radioButtonOption1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RadioButton radioButtonOption2 = view.findViewById(R.id.radioButtonOption2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RadioButton radioButtonOption3 = view.findViewById(R.id.radioButtonOption3);

        // Set question and options text
        textViewQuestion.setText(question.getQuestion());
        radioButtonOption1.setText(question.getOption1());
        radioButtonOption2.setText(question.getOption2());
        radioButtonOption3.setText(question.getOption3());

        radioGroup = view.findViewById(R.id.radioGroupOptions);

        return view;
    }

    public int getSelectedOption() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.radioButtonOption1:
                return 1;
            case R.id.radioButtonOption2:
                return 2;
            case R.id.radioButtonOption3:
                return 3;
            default:
                return 0;
        }
    }
}
