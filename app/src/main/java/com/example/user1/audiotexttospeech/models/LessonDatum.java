package com.example.user1.audiotexttospeech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LessonDatum {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("conceptName")
    @Expose
    private String conceptName;
    @SerializedName("pronunciation")
    @Expose
    private String pronunciation;
    @SerializedName("targetScript")
    @Expose
    private String targetScript;
    @SerializedName("audio_url")
    @Expose
    private String audioUrl;
    private boolean isSelected;
    private String selText;
    private String tempConceptName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getTargetScript() {
        return targetScript;
    }

    public void setTargetScript(String targetScript) {
        this.targetScript = targetScript;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getSelText() {
        return selText;
    }

    public void setSelText(String selText) {
        this.selText = selText;
    }

    public String getTempConceptName() {
        return tempConceptName;
    }

    public void setTempConceptName(String tempConceptName) {
        this.tempConceptName = tempConceptName;
    }
}
