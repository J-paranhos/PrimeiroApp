package com.jparanhos.primeiraapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.jparanhos.primeiraapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int Count = getArguments().getInt("count");
        binding.textviewRandom.setText( Integer.toString(Count));
        binding.textviewHeader.setText(binding.textviewHeader.getText() +
                Integer.toString(functions.setRound(Count)));



        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NavHostFragment.findNavController(SecondFragment.this).
                        navigate(R.id.action_SecondFragment_to_FirstFragment);



            }
        });


    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}