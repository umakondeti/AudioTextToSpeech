package com.example.user1.audiotexttospeech.retrofit;

import com.example.user1.audiotexttospeech.models.LessonData;
import com.example.user1.audiotexttospeech.models.Request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by user1 on 11-Apr-18.
 */

public interface MemberDetailsApi {

    @Headers("Content-Type: application/json")
    @GET("{api}")
    Call<LessonData> getReqResponse(@Path(value = "api", encoded = true) String mPath);
}
