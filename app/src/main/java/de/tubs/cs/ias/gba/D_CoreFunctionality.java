package de.tubs.cs.ias.gba;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;

import de.tubs.cs.ias.gba.databinding.CoreFunctionalityBinding;

public class D_CoreFunctionality extends Fragment {

    private MainActivity getMainActivity() {
        return (MainActivity) this.getActivity();
    }

    private CoreFunctionalityBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CoreFunctionalityBinding.inflate(inflater, container, false);

        binding.buttonLogEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.FIRE_EVENT) {
                    binding.coreFunctionalityInfo.setText("firing event...");
                    Context context = getMainActivity().getApplicationContext();
                    Bundle params = new Bundle();
                    params.putString("key","value");
                    AppEventsLogger logger = AppEventsLogger.newLogger(context);
                    logger.logEvent("sanity_check_event_name",params);
                    binding.coreFunctionalityInfo.setText("fired event");
                }
            }
        });

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
