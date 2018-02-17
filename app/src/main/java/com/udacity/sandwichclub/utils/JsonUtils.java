package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)
    {


        Sandwich sandwich = new Sandwich();

        try {
            JSONObject initial = new JSONObject(json);

            JSONObject name = initial.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
            JSONArray ingredientsArray = initial.getJSONArray("ingredients");

            String placeOfOrigin = initial.getString("placeOfOrigin");
            String description = initial.getString("description");
            String image = initial.getString("image");


            sandwich.setMainName(mainName);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setPlaceOfOrigin(placeOfOrigin);

ArrayList<String> ingredientsList = new ArrayList<>();
           for (int i=0;i<ingredientsArray.length();i++)
           {
               String ingredient = ingredientsArray.getString(i);
               ingredientsList.add(ingredient);
           }

            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for (int i=0;i<alsoKnownAsArray.length();i++)
            {
                String alsoKnownAs = alsoKnownAsArray.getString(i);
                alsoKnownAsList.add(alsoKnownAs);

            }
            sandwich.setIngredients(ingredientsList);
            sandwich.setAlsoKnownAs(alsoKnownAsList);
        }

        catch (JSONException ex)
        {
            Log.v("Error in parsing","",ex);
        }




        return sandwich;
    }
}
