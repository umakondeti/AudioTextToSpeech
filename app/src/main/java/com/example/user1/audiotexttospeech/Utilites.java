package com.example.user1.audiotexttospeech;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

/**
 * Created by user1 on 25-Apr-18.
 */

public class Utilites {

    private static final byte JSON_OBJECT = 1;
    private static final byte JSON_ARRAY = 2;
    private static final byte JSON_INVALID = 3;
  static   String inputJsonFile="{\n" +
            "\t\"id\": \"eb5f5da4-25ba-2b47-c71a-d4e2b3272cc4\",\n" +
            "\t\"name\": \"assignment_android\",\n" +
            "\t\"description\": \"\",\n" +
            "\t\"order\": [\n" +
            "\t\t\"69ef8b9e-6d9f-efe4-7d33-e1fd75d46f5f\"\n" +
            "\t],\n" +
            "\t\"folders\": [],\n" +
            "\t\"folders_order\": [],\n" +
            "\t\"timestamp\": 1504521492956,\n" +
            "\t\"owner\": 0,\n" +
            "\t\"public\": false,\n" +
            "\t\"requests\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": \"69ef8b9e-6d9f-efe4-7d33-e1fd75d46f5f\",\n" +
            "\t\t\t\"headers\": \"\",\n" +
            "\t\t\t\"headerData\": [],\n" +
            "\t\t\t\"url\": \"http://www.akshaycrt2k.com/getLessonData.php\",\n" +
            "\t\t\t\"queryParams\": [],\n" +
            "\t\t\t\"pathVariables\": {},\n" +
            "\t\t\t\"pathVariableData\": [],\n" +
            "\t\t\t\"preRequestScript\": null,\n" +
            "\t\t\t\"method\": \"GET\",\n" +
            "\t\t\t\"collectionId\": \"eb5f5da4-25ba-2b47-c71a-d4e2b3272cc4\",\n" +
            "\t\t\t\"data\": null,\n" +
            "\t\t\t\"dataMode\": \"params\",\n" +
            "\t\t\t\"name\": \"Get Lesson Data\",\n" +
            "\t\t\t\"description\": \"\",\n" +
            "\t\t\t\"descriptionFormat\": \"html\",\n" +
            "\t\t\t\"time\": 1504524010366,\n" +
            "\t\t\t\"version\": 2,\n" +
            "\t\t\t\"responses\": [],\n" +
            "\t\t\t\"tests\": null,\n" +
            "\t\t\t\"currentHelper\": \"normal\",\n" +
            "\t\t\t\"helperAttributes\": {}\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";

    public static byte getJSONType(String jsonString) {
        byte mJsonStatus = JSON_INVALID;
        try {
            new JSONObject(jsonString);
            mJsonStatus = JSON_OBJECT;
        } catch (JSONException ex) {
            try {
                new JSONArray(jsonString);
                mJsonStatus = JSON_ARRAY;
            } catch (JSONException ignored) {
            }
        }
        return mJsonStatus;
    }
    //validate the json signIn session object
    public static String isValidJson(String sessionData) {
        boolean validJson = false;
         JSONObject validJsonObject = null;
         String url= null;
        if (getJSONType(sessionData) == JSON_OBJECT) {
            try {
                validJsonObject = new JSONObject(sessionData);
                if(validJsonObject.has("requests")) {
                    JSONArray mJsonArray= validJsonObject.getJSONArray("requests");
                    for(int i=0;i<mJsonArray.length();i++)
                    {
                        JSONObject mJsonObject = mJsonArray.getJSONObject(i);
                       if(mJsonObject.has("url")) {
                            url = mJsonObject.getString("url");
                           if(!isStringNullOrEmpty(url))
                               validJson = true;

                       }



                    }
                }
            } catch (Exception ignored) {
            }
        }
        return url;
    }

    //validate the json signIn session object
    public static boolean getUrlFonJosn(String sessionData) {
        boolean validJson = false;
        JSONObject validJsonObject = null;
        if (getJSONType(sessionData) == JSON_OBJECT) {
            try {
                validJsonObject = new JSONObject(sessionData);
                if(validJsonObject.has("requests")) {
                    JSONArray mJsonArray= validJsonObject.getJSONArray("requests");
                    for(int i=0;i<mJsonArray.length();i++)
                    {
                        JSONObject mJsonObject = mJsonArray.getJSONObject(i);
                        if(mJsonObject.has("url")) {
                            String url = mJsonObject.getString("url");
                            if(!isStringNullOrEmpty(url))
                                validJson = true;

                        }



                    }
                }
            } catch (Exception ignored) {
            }
        }
        return validJson;
    }
    public static boolean isStringNullOrEmpty(String value) {
        return value == null || Objects.equals(value.toLowerCase().trim(), "") || value.trim().length() == 0;
    }

}
