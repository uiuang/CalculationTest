package com.uiuang.calculationtest.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uiuang.calculationtest.App;
import com.uiuang.calculationtest.R;
import com.uiuang.calculationtest.databinding.FragmentTitleBinding;
import com.uiuang.calculationtest.viewmodel.MyViewModel;


public class TitleFragment extends Fragment {


    private FragmentTitleBinding binding;
    private MyViewModel myViewModel;

    public TitleFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SavedStateViewModelFactory savedStateViewModelFactory = new SavedStateViewModelFactory(getActivity().getApplication(),requireActivity());
        myViewModel = new ViewModelProvider(requireActivity(), savedStateViewModelFactory).get(MyViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_titleFragment_to_questionFragment);
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_title, container, false);
    }
}
