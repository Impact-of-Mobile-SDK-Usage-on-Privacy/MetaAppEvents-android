package de.tubs.cs.ias.gba;

import android.media.FaceDetector;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;

import de.tubs.cs.ias.gba.databinding.InitializeBinding;

public class C_Initialize extends Fragment {

    private InitializeBinding binding;

    private MainActivity getMainActivity() {
        return (MainActivity) this.getActivity();
    }

    private void initializeFacebookSDK() {
        if (MainActivity.INITIALIZE_SDK) {
            FacebookSdk.setAutoInitEnabled(true);
            FacebookSdk.fullyInitialize();
            AppEventsLogger.activateApp(this.getActivity().getApplication());
            binding.textviewInitialize.setText("initialized! [DONE]");
            Log.i("user access token", FacebookSdk.getApplicationId());
            Log.i("client token", FacebookSdk.getClientToken());
            Log.i("app signature", FacebookSdk.getApplicationSignature(this.getActivity()));

        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = InitializeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(C_Initialize.this)
                        .navigate(R.id.action_Initialize_to_InquireConsent);
            }
        });

        binding.buttonInitialize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeFacebookSDK();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
