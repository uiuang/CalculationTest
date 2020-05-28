package com.uiuang.calculationtest.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uiuang.calculationtest.R;
import com.uiuang.calculationtest.databinding.FragmentWinBinding;
import com.uiuang.calculationtest.viewmodel.MyViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class WinFragment extends Fragment {

    private MyViewModel myViewModel;
    private FragmentWinBinding binding;

    public WinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SavedStateViewModelFactory savedStateViewModelFactory = new SavedStateViewModelFactory(getActivity().getApplication(), requireActivity());
        myViewModel = new ViewModelProvider(requireActivity(), savedStateViewModelFactory).get(MyViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_win, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_winFragment_to_titleFragment);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}
