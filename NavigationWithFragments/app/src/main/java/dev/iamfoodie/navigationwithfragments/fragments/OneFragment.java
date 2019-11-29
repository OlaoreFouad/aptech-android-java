package dev.iamfoodie.navigationwithfragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.iamfoodie.navigationwithfragments.MainActivity;
import dev.iamfoodie.navigationwithfragments.R;
import dev.iamfoodie.navigationwithfragments.listeners.OnDataSentListener;

public class OneFragment extends Fragment {

    private EditText sendEditText;
    private Button sendButton;

    OnDataSentListener mOnDataSentListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        sendEditText = view.findViewById(R.id.enter_text);
        sendButton = view.findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sendEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Empty fields!", Toast.LENGTH_SHORT).show();
                    return;
                }


                String text = sendEditText.getText().toString();
                mOnDataSentListener.send(text, "fragmentOne");

            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mOnDataSentListener = (OnDataSentListener) getActivity();
    }
}
