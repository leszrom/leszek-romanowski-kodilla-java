package com.kodilla.patterns.strategy.broker.predictors;

import com.kodilla.patterns.strategy.broker.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}
