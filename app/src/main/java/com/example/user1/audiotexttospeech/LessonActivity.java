package com.example.user1.audiotexttospeech;

import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.user1.audiotexttospeech.adapter.CustomPagerAdapter;
import com.example.user1.audiotexttospeech.models.LessonData;
import com.example.user1.audiotexttospeech.models.ServerUrlModel;
import com.example.user1.audiotexttospeech.retrofit.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LessonActivity extends AppCompatActivity {

    @BindView(R.id.vp_request_items)
    public ViewPager mVPRequestItems;
    public CustomPagerAdapter mLessonItemsDisplayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        ButterKnife.bind(this);
        getData();
        checkVoiceRecognition();

    }

    public void checkVoiceRecognition() {
        // Check if voice recognition is present
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            Toast.makeText(this, "Voice recognizer not present",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void getData() {
        String url = Utilites.isValidJson(Utilites.inputJsonFile);
        Util mUtil = new Util();
        ServerUrlModel serverUrlModel = Util.getServerUrlModel(url);

        Call<LessonData> mGetReqResponse = mUtil.getBaseClassService(this, serverUrlModel.getBaseUrl()).getReqResponse(serverUrlModel.getEndUrl());
        mGetReqResponse.enqueue(new Callback<LessonData>() {
            @Override
            public void onResponse(Call<LessonData> call, Response<LessonData> response) {
                Log.d("request_on", "" + response.body());
                LessonData mLessonData = response.body();
                Log.d("mLessonData", "onResponse: " + mLessonData.getLessonData().get(0).getConceptName());
                mLessonItemsDisplayAdapter = new CustomPagerAdapter(LessonActivity.this, mLessonData.getLessonData());
                mVPRequestItems.setAdapter(mLessonItemsDisplayAdapter);
            }

            @Override
            public void onFailure(Call<LessonData> call, Throwable t) {
                Log.d("request_off", t.getMessage());
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CustomPagerAdapter.VOICE_RECOGNITION_REQUEST_CODE)

            //If Voice recognition is successful then it returns RESULT_OK
            if (resultCode == RESULT_OK) {

                ArrayList<String> textMatchList = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                if (!textMatchList.isEmpty()) {
                        // populate the Matches
                    try {
                        mLessonItemsDisplayAdapter.bindSpeachResultToTextView(textMatchList);
                    }catch (ArrayIndexOutOfBoundsException e)
                    {
                        Log.d("Exception", e.getMessage());
                    }

                }
                //Result code for various error.
            } else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
                showToastMessage("Audio Error");
            } else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
                showToastMessage("Client Error");
            } else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
                showToastMessage("Network Error");
            } else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
                showToastMessage("No Match");
            } else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
                showToastMessage("Server Error");
            }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Helper method to show the toast message
     **/
    void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
