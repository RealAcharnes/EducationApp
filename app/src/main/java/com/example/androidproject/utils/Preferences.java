package com.example.androidproject.utils;

import com.example.androidproject.ProjectApplication;
import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static SharedPreferences getSharedPreferences() {
        return ProjectApplication.getContext().getSharedPreferences(Constants.Preferences.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static String getInputSearch(){
        final SharedPreferences prefs = getSharedPreferences();
        return prefs.getString(Constants.Preferences.PREF_SEARCH_INPUT, null);
    }

    public static void setInputSearch(String inputSearch){
        final SharedPreferences prefs = getSharedPreferences();
        prefs.edit().putString(Constants.Preferences.PREF_SEARCH_INPUT, inputSearch).commit();
    }

}
