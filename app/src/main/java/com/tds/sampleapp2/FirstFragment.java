package com.tds.sampleapp2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.tds.sampleapp2.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonFirst.setOnClickListener(view1 -> {
            String text = "errado";
            String answer = binding.et.getText() != null ? binding.et.getText().toString() : "";
            if (!answer.equalsIgnoreCase("marega")){
                binding.et.setWrong(true);
            }
            else{
                text =  "acertou";
                binding.et.setWrong(false);
            }
            Toast t =  Toast.makeText(binding.getRoot().getContext(), text, Toast.LENGTH_LONG);
            t.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 100);
            t.show();
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}