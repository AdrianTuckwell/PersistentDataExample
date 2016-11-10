package com.codeclan.example.persistentdataexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/**
 * Created by user on 10/11/2016.
 */

public class SavedTextPreferences
{
    // All caps with underscore for CONSTANT
    private static final String PREF_SAVEDTEXT = "savedText";

    // Write Data ------------------------------------------------
    public static void setStoredText(Context context, String text)
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_SAVEDTEXT, text);
        editor.apply();
    }

    // Read Data -------------------------------------------------
    public static String getStoredText(Context context)
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        String text = sharedPreferences.getString(PREF_SAVEDTEXT, null);
        return text;
    }
}
