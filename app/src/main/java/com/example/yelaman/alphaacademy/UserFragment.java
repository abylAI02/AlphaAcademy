package com.example.yelaman.alphaacademy;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private static final String TAG = UserFragment.class.getSimpleName();
    private CardView accountInformation;
    private ImageView avatar;
    private TextView fullName;
    private TextView emailField;

    private UserSingleton userSingleton = UserSingleton.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("My Account");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref =
                database.getReference("users/" + user.getUid());

        accountInformation = view.findViewById(R.id.cardAccount);

        emailField = view.findViewById(R.id.textViewEmail);
        fullName = view.findViewById(R.id.textViewFullName);

        emailField.setText(user.getEmail());

        Log.d(TAG, ref.toString());

        //get name from database
        if (userSingleton.getUser() == null) {
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Log.d(TAG, "" + dataSnapshot.toString());

                    User user = dataSnapshot.getValue(User.class);

                    userSingleton.setUser(user);
                    fullName.setText(user.getFullName());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.e(TAG, "" + databaseError.toString());
                }
            });
        } else {
            fullName.setText(userSingleton.getUser().getFullName());
        }

        accountInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new SettingsFragment();

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }


}
