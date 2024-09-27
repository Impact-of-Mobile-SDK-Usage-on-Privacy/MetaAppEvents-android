package de.tubs.cs.ias.gba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.facebook.FacebookSdk;

import de.tubs.cs.ias.gba.databinding.InquireConsentBinding;

public class B_InquireConsent extends Fragment {

    private InquireConsentBinding binding;

    private MainActivity getMainActivity() {
        return (MainActivity) this.getActivity();
    }



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = InquireConsentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(B_InquireConsent.this)
                        .navigate(R.id.action_InquireConsent_to_CoreFunctionality);
            }
        });

        binding.buttonConsentNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FacebookSdk.setAutoLogAppEventsEnabled(false);
                FacebookSdk.setAdvertiserIDCollectionEnabled(false);
                binding.textviewInquireConsentPrior.setText("Disabled adid collection and autologging");
            }
        });

        binding.buttonConsentYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FacebookSdk.setAutoLogAppEventsEnabled(true);
                FacebookSdk.setAdvertiserIDCollectionEnabled(true);
                binding.textviewInquireConsentPrior.setText("enable adid collection and autologging");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
