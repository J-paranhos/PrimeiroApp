package com.jparanhos.primeiraapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;


import com.jparanhos.primeiraapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });


        binding.countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countString = binding.textviewFirst.getText().toString();
                binding.textviewFirst.setText(functions.countMe(countString));
            }
        });

        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = Integer.parseInt(binding.textviewFirst.getText().toString());


                FirstFragment fragment = new FirstFragment();
                Bundle args = new Bundle();
                args.putInt("count",currentCount);
                NavHostFragment.findNavController(FirstFragment.this).
                        navigate(R.id.action_FirstFragment_to_SecondFragment,args);



            }
        });





    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}