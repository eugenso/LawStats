package com.unihh.lawstats.NaturalLanguageProcessing.MainMethods;

import com.unihh.lawstats.NaturalLanguageProcessing.ABSClassifier.TrainingDataManager;

public class TrainingDataMain {

    public static void main(String[] args) {
        TrainingDataManager trainingDataManager = new TrainingDataManager();
        trainingDataManager.createTrainingsDataBaseFiles();


    }
}