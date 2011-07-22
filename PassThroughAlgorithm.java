// 
//  PassThroughAlgorithm.java
//  PassThroughRecipes
//  
//  Created by Philip Kuryloski on 2011-07-11.
//  Copyright 2011 University of California, Berkeley. All rights reserved.
// 

package edu.berkeley.waverecipe.passthrough;

import edu.berkeley.androidwave.waverecipe.waverecipealgorithm.*;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class PassThroughAlgorithm implements WaveRecipeAlgorithm {
    
    private static final String TAG = PassThroughAlgorithm.class.getSimpleName();
    
    WaveRecipeAlgorithmListener theListener;
    
    public void setAuthorizedMaxOutputRate(double maxOutputRate) {
        // empty method as input and output rates are by definition equal in
        // a pass through recipe
    }
    
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