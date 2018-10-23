package com.kodilla.patterns.strategy.broker.predictors;

import com.kodilla.patterns.strategy.broker.BuyPredictor;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced predictor] Buy shared units of Fund XYZ";
    }
}
