package com.example.user1.audiotexttospeech.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.speech.RecognizerIntent;
import android.support.v4.view.PagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user1.audiotexttospeech.R;
import com.example.user1.audiotexttospeech.models.LessonDatum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {

    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;
    private static final String TAG = "CustomPagerAdapter";
    private static int currentPosition;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<LessonDatum> mRequestListData;
    private MediaPlayer mMediaPlayer;
    private TextView mTVspeechTextResult;

    public CustomPagerAdapter(Context context, List<LessonDatum> requestList) {
        mContext = context;
        mRequestListData = requestList;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mRequestListData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        mMediaPlayer = new MediaPlayer();
        View itemView = mLayoutInflater.inflate(R.layout.view_pager_item, container, false);
        final ImageView mIVPlayPauseMusic = (ImageView) itemView.findViewById(R.id.iv_play_pause_audio);
        ImageView mIVTextToSpeech = (ImageView) itemView.findViewById(R.id.iv_text_to_speech);
        mTVspeechTextResult = (TextView) itemView.findViewById(R.id.tv_speech_result);
        activeInActiveImage(mIVPlayPauseMusic, "false");

        if (mRequestListData.get(position).isSelected()) {
            String speechContent = mRequestListData.get(position).getTempConceptName();
            String selectedText = mRequestListData.get(position).getSelText();
            int unblockTextIndexStart = speechContent.indexOf(selectedText);
            int unblockTextIndexEnd = speechContent.indexOf(selectedText) + (selectedText).length();
            SpannableString content = new SpannableString(speechContent);
            content.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.colorAccent)), unblockTextIndexStart, unblockTextIndexEnd, 0);
            content.setSpan(new StyleSpan(Typeface.BOLD), unblockTextIndexStart, unblockTextIndexEnd, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            mTVspeechTextResult.setText(content, TextView.BufferType.SPANNABLE);
        } else
            mTVspeechTextResult.setText(mRequestListData.get(position).getConceptName());
        mIVPlayPauseMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRequestListData.get(position).getAudioUrl() != null) {
                    if (mIVPlayPauseMusic.getTag(mIVPlayPauseMusic.getId()).equals("true")) {
                        activeInActiveImage(mIVPlayPauseMusic, "false");
                    } else
                        activeInActiveImage(mIVPlayPauseMusic, "true");


                    try {

                        mMediaPlayer.setDataSource(mRequestListData.get(position).getAudioUrl());
                        mMediaPlayer.prepare();


                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    mMediaPlayer.start();
                }
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // activeInActiveImage(mIVPlayPauseMusic, "false");
                mIVPlayPauseMusic.setImageResource(R.drawable.ic_play_music);
                mIVPlayPauseMusic.setTag(mIVPlayPauseMusic.getId(),"false");
                notifyDataSetChanged();
            }
        });
        mIVTextToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition = position;

                speak(view, mTVspeechTextResult);

            }
        });

        container.addView(itemView);

        return itemView;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }

    public void speak(View view, TextView mTVspeechTextResult) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        // Specify the calling package to identify your application
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass()
                .getPackage().getName());

        // Display an hint to the user about what he should say.
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, mTVspeechTextResult.getText()
                .toString());

        // Given an hint to the recognizer about what the user is going to say
        //There are two form of language model available
        //1.LANGUAGE_MODEL_WEB_SEARCH : For short phrases
        //2.LANGUAGE_MODEL_FREE_FORM  : If not sure about the words or phrases and its domain.
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        // If number of Matches is not selected then return show toast message

        // Specify how many results you want to receive. The results will be
        // sorted where the first result is the one with higher confidence.
        //Start the Voice recognizer activity for the result.
        ((Activity) mContext).startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);

    }

    public void bindSpeachResultToTextView(ArrayList<String> speechResultListText) {
        for (int i = 0; i < speechResultListText.size(); i++) {
            String speechResultText = speechResultListText.get(i);
            String primaryText = mRequestListData.get(currentPosition).getConceptName().toLowerCase();
            if (speechResultText.toLowerCase().contains(primaryText)) {
                mRequestListData.get(currentPosition).setTempConceptName(speechResultText);
                mRequestListData.get(currentPosition).setSelected(true);
                mRequestListData.get(currentPosition).setSelText(primaryText);
                break;
            }
        }
        notifyDataSetChanged();

    }

    private void activeInActiveImage(ImageView mIV, String aFalse) {
        mIV.setTag(mIV.getId(), aFalse);
        if (aFalse.equals("true")) {
            mIV.setImageResource(R.drawable.ic_pause_music);
        } else {
            mIV.setImageResource(R.drawable.ic_play_music);
        }

    }
}
