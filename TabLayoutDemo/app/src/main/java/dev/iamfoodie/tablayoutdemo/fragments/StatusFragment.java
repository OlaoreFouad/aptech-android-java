package dev.iamfoodie.tablayoutdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.iamfoodie.tablayoutdemo.R;
import dev.iamfoodie.tablayoutdemo.listeners.OnFragmentNavigatedListener;

public class StatusFragment extends Fragment implements View.OnClickListener {

    private Button prevButton, nextButton;
    private OnFragmentNavigatedListener mOnFragmentNavigatedListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextButton = view.findViewById(R.id.next_button_from_status);
        prevButton = view.findViewById(R.id.prev_button);

        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mOnFragmentNavigatedListener = (OnFragmentNavigatedListener) context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.prev_button:
                mOnFragmentNavigatedListener.nextFragment("fragmentChats");
                break;
            case R.id.next_button_from_status:
                mOnFragmentNavigatedListener.nextFragment("fragmentCalls");
                break;
        }
    }
}
