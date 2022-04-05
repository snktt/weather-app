package com.example.weather;

import org.json.JSONException;
import org.json.JSONObject;

class weatherData {
    private String mTemperature,mIcon,mCity,mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject){
        try{
            weatherData weatherD=new weatherData();
            weatherD.mCity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.mIcon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);
            return weatherD;

        }
       catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static String updateWeatherIcon(int condition){
        if(condition>=0 && condition<=300){
            return "s1";
        }
        else if(condition>=301 && condition<=500){
            return "s2";
        }
        else if(condition>=501 && condition<=600){
            return "s3";
        }
        else if(condition>=601 && condition<=700){
            return "s4";
        }
        else if(condition>=701 && condition<=771){
            return "s5";
        }
        else if(condition>=772 && condition<=779){
            return "s6";
        }
        else if(condition==800){
            return "s7";
        }
        else if(condition>=801 && condition<=804){
            return "s1";
        }
        else if(condition>=900 && condition<=902){
            return "s9";
        }
        if(condition==903){
            return "s1";
        }
        if(condition==904){
            return "s2";
        }
        else if(condition>=905 && condition<=1000){
            return "s3";
        }
        return "dunno";
    }

    public String getmTemperature() {
        return mTemperature + "°C" ;
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
