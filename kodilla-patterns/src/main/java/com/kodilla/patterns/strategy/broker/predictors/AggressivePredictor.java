package com.kodilla.patterns.strategy.broker.predictors;

import com.kodilla.patterns.strategy.broker.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] buy stock of XYZ";
    }
}
