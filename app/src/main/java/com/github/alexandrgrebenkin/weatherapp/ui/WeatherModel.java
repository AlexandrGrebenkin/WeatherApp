package com.github.alexandrgrebenkin.weatherapp.ui;

import android.content.Context;
import android.location.Address;

import com.github.alexandrgrebenkin.weatherapp.data.entity.WeatherInfo;
import com.github.alexandrgrebenkin.weatherapp.data.manager.WeatherDataManager;

public class WeatherModel {
    private final Context context;

    public WeatherModel(Context context) {
        this.context = context;
    }

    public void loadWeather(Address address, LoadWeatherCallback callback) {
        WeatherDataManager weatherDataManager = new WeatherDataManager();
        weatherDataManager.loadWeatherInfo(address, weatherInfo -> {
            callback.onLoad(weatherInfo);
        });
    }

    interface LoadWeatherCallback {
        void onLoad(WeatherInfo weatherInfo);
    }
}
