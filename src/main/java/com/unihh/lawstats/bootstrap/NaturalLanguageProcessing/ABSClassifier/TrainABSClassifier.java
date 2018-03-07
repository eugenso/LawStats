package com.unihh.lawstats.bootstrap.NaturalLanguageProcessing.ABSClassifier;

import uhh_lt.ABSA.ABSentiment.featureExtractor.precomputation.ComputeIdfTermsCategory;

public class TrainABSClassifier {

    public static void main(String[] args) {
        String[] arg = new String[1];
        arg[0] = "src/main/resources/config/ABSConfiguration.txt";

        // inducing features from training set and background corpus
        //uhh_lt.ABSA.ABSentiment.PreComputeFeatures.main(arg);

       // ComputeIdfTermsCategory.computeIdfScores("src/main/resources/config/ABSConfiguration.txt", "src/main/resources/data/trainingsData.tsv", "src/main/resources/data/features/relevance_idf_terms.tsv", false, "relevance");


        // training model
        uhh_lt.ABSA.ABSentiment.TrainAllClassifiers.main(arg);

    }

}
