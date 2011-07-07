// 
//  LocationPassThroughAlgorithm.java
//  PassThroughRecipes
//  
//  Created by Philip Kuryloski on 2011-07-06.
//  Copyright 2011 University of California, Berkeley. All rights reserved.
// 

package edu.berkeley.waverecipe.passthrough;

import edu.berkeley.androidwave.waverecipe.waverecipealgorithm.*;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class LocationPassThroughAlgorithm implements WaveRecipeAlgorithm {
    
    private static final String TAG = LocationPassThroughAlgorithm.class.getSimpleName();
    
    WaveRecipeAlgorithmListener theListener;
    
    public boolean setWaveRecipeAlgorithmListener(Object listener) {
        try {
            theListener = new WaveRecipeAlgorithmListenerShadow(listener);
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Exception in setWaveRecipeAlgorithmListener", e);
        }
        return false;
    }
    
    public void ingestSensorData(long time, Map<String, Double> values) {
        theListener.handleRecipeData(time, values);
    }
}