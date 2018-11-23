package com.example.yelaman.alphaacademy;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import static android.provider.CalendarContract.CalendarCache.URI;


public class NewsFragment extends Fragment {

    private PlayerView playerView;
    private SimpleExoPlayer player;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("News");

        playerView = view.findViewById(R.id.playerView);

    }

    @Override
    public void onStart() {
        super.onStart();

        player = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector());

        playerView.setPlayer(player);

        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(getContext(),
                Util.getUserAgent(getContext(),"AlphaAcademy"));

        ExtractorMediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(URI);

        player.prepare(mediaSource);
        player.setPlayWhenReady(true);
    }



    @Override
    public void onStop() {
        super.onStop();

        playerView.setPlayer(null);
        player.release();
        player = null;
    }

}
