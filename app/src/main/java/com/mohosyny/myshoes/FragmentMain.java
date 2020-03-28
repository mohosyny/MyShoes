package com.mohosyny.myshoes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


public class FragmentMain extends Fragment implements View.OnClickListener {
    private View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) root = inflater.inflate(R.layout.fragment_main, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView btnSignIn = root.findViewById(R.id.signin);
        TextView btnSignUp = root.findViewById(R.id.signup);

        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signin)
            Navigation.findNavController(v).navigate(R.id.action_fragmentMain_to_fragmentSignIn);
        else Navigation.findNavController(v).navigate(R.id.action_fragmentMain_to_fragmentSignUp);

    }
}
