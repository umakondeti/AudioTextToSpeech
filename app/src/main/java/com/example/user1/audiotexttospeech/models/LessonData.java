package com.example.user1.audiotexttospeech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LessonData {

@SerializedName("lesson_data")
@Expose
private List<LessonDatum> lessonData = null;

public List<LessonDatum> getLessonData() {
return lessonData;
}

public void setLessonData(List<LessonDatum> lessonData) {
this.lessonData = lessonData;
}

}