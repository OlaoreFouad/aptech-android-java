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

public class CallsFragment extends Fragment {

//    private Button prevButton;
//    private OnFragmentNavigatedListener mOnFragmentNavigatedListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calls, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
/*//        prevButton = view.findViewById(R.id.prev_button_from_calls);
//
//        prevButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mOnFragmentNavigatedListener.nextFragment("fragmentStatus");
//            }
//        });*/

    }

    /*@Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mOnFragmentNavigatedListener = (OnFragmentNavigatedListener) context;
    }*/
}
