package com.unihh.lawstats.bootstrap;

import com.unihh.lawstats.bootstrap.Converter.Formatting.Formatter;
import com.unihh.lawstats.bootstrap.Converter.PDFToTextConverter;
import com.unihh.lawstats.bootstrap.NaturalLanguageProcessing.Watson.NLU.LawEntityExtractor;
import com.unihh.lawstats.core.mapping.Mapper;
import com.unihh.lawstats.core.mapping.NoDocketnumberFoundException;
import com.unihh.lawstats.core.model.Verdict;
import lombok.extern.slf4j.Slf4j;


import java.io.File;
import java.text.ParseException;

public class AnalyzingCoordinator {

    /**
     * this method analyse the given files and creates a verdict of it
     *
     * @return the verdict of the given file
     * @throws NoDocketnumberFoundException when no DocketNumber was found
     */
    public Verdict analyzeDocument(File fileToAnalyze) throws NoDocketnumberFoundException {
        PDFToTextConverter pdfToTextConverter = new PDFToTextConverter();
        LawEntityExtractor lawEntityExtractor = new LawEntityExtractor();
        Mapper verdictMapper = new Mapper();
        String documentText = null;
        String jsonNLUResponse = null;


        String path = fileToAnalyze.getPath();
        String pathTxt = path.replace(".pdf", ".txt");


        pdfToTextConverter.convertPDFToText(path);
        documentText = Formatter.formatText(pathTxt);
        jsonNLUResponse = lawEntityExtractor.extractEntities("10:864de4a5-5bab-495e-8080-2f1185d1b38d", documentText); //TODO model id von config holen

        // Throw the NoDocketnumberFoundException
        Verdict verdict = verdictMapper.mapJSONStringToVerdicObject(jsonNLUResponse);

        //TODO set the documentNumber

        //TODO hier kommt es drauf an ob Watson oder TU Darm. Classifier benutzt wird
        verdict.setRevisionSuccess(1);

        String jsonClassifierResponse = "";

        return verdict;
    }

}
