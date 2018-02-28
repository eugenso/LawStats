package com.unihh.lawstats.core.mapping;


import com.unihh.lawstats.core.model.Verdict;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;

public class Mapper {


    /*
    //to do: main und zugehörige statics entfernen! -> Ticket in Trello
    public static void main(String[] args) throws JSONException, IOException, ParseException {

        File testfile = new File("src/main/resources/testData/JsonMappingTestData.json");
        if (testfile.exists()) {
            InputStream is = new FileInputStream(testfile);
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            
            JSONObject json = new JSONObject(jsonTxt);
            JSONArray jsonArray = json.getJSONArray("entities");

            // Listen für die einzelnen Entities
            List<String> docketnumberL = new ArrayList<>();
            // TODO List Revision Success

            List<String> senateL = new ArrayList<>();
            Set<String> judgeL = new HashSet<>();
            List<String> dateverdictL = new ArrayList<>();
            List<String> foreDecRACcL = new ArrayList<>();
            List<String> foreDecRACdvL = new ArrayList<>();
            List<String> foreDecRCcL = new ArrayList<>();
            List<String> foreDecRCdvL = new ArrayList<>();
            List<String> foreDecDCcL = new ArrayList<>();
            List<String> foreDecDCdvL = new ArrayList<>();

            // Iterieren durch das JSON Array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectEntity = jsonArray.getJSONObject(i);
                String type = jsonObjectEntity.getString("type");

                //Abfrage des Inhalts | Einsortieren in die zugehörige Liste
                switch (type) {
                    case "DocketNumber":
                        docketnumberL.add(jsonObjectEntity.getString("text"));
                        break;
                    //TODO Revision Success Case
                    case "Senate":
                        senateL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "Judges":
                        //judgeL.toArray(new String[judgeL.size()]);
                        judgeL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "DateVerdict":
                        dateverdictL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "ForeDecisionRACCourt":
                        foreDecRACcL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "ForeDecisionRACDateVerdict":
                        foreDecRACdvL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "ForeDecisionRCCourt":
                        foreDecRCcL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "ForeDecisionRCDateVerdict":
                        foreDecRCdvL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "ForeDecisionDCCourt":
                        foreDecDCcL.add(jsonObjectEntity.getString("text"));
                        break;
                    case "ForeDecisionDCDateVerdict":
                        foreDecDCdvL.add(jsonObjectEntity.getString("text"));
                        break;
                }
            }
            // Creating a new Verdict Object
            // Using Date for Date-Elements
            Verdict verdict = new Verdict();

            //Docket Number
            verdict.setDocketNumber(mostCommon(docketnumberL));

            // TODO revisionSuccess

            //Senate
            verdict.setSenate(mostCommon(senateL));

            //Judges
            String[] judgeList = judgeL.toArray(new String[judgeL.size()]);
            verdict.setJudgeList(judgeList);

            //Date Verdict
            verdict.setDateVerdict(filterNewestDate(dateverdictL));

            //Oberlandesgericht - RAC
            verdict.setForeDecisionRACCourt(mostCommon(foreDecRACcL));
            verdict.setForeDecisionRACVerdictDate((filterNewestDate(foreDecRACdvL)));

            //Landesgericht - RC
            verdict.setForeDecisionRCCourt(mostCommon(foreDecRCcL));
            verdict.setForeDecisionRCVerdictDate(filterNewestDate(foreDecRCdvL));

            //Amtsgericht - DC
            verdict.setForeDecisionDCCourt(mostCommon(foreDecDCcL));
            verdict.setForeDecisionDCVerdictDate(filterNewestDate((foreDecDCdvL)));

            //sout nur für debugger benötigt
            //System.out.println("");
        }
    }

    */

    /**
     * Überführt einen String, welcher mit JSON Daten gefüllt ist in ein Verdict Objekt
     *
     * @param jsonText - String, welcher die von Watson ermittelten Entities etc. enthält
     * @return ein Verdict Object, mit den parameterisierten Daten der Entities
     * @throws ParseException - ja, kann passieren
     */
    public Verdict mapJSONStringToVerdicObject(String jsonText) throws ParseException {
        JSONObject json = new JSONObject(jsonText);
        JSONArray jsonArray = json.getJSONArray("entities");

        // Listen für die einzelnen Entities
        List<String> docketnumberL = new ArrayList<>();
        // TODO List Revision Success

        List<String> senateL = new ArrayList<>();
        Set<String> judgeL = new HashSet<>();
        List<String> dateverdictL = new ArrayList<>();
        List<String> foreDecRACcL = new ArrayList<>();
        List<String> foreDecRACdvL = new ArrayList<>();
        List<String> foreDecRCcL = new ArrayList<>();
        List<String> foreDecRCdvL = new ArrayList<>();
        List<String> foreDecDCcL = new ArrayList<>();
        List<String> foreDecDCdvL = new ArrayList<>();

        // Iterieren durch das JSON Array
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObjectEntity = jsonArray.getJSONObject(i);
            String type = jsonObjectEntity.getString("type");

            //Abfrage des Inhalts | Einsortieren in die zugehörige Liste
            switch (type) {
                case "DocketNumber":
                    docketnumberL.add(jsonObjectEntity.getString("text"));
                    break;
                //TODO Revision Success Case
                case "Senate":
                    senateL.add(jsonObjectEntity.getString("text"));
                    break;
                case "Judges":
                    //judgeL.toArray(new String[judgeL.size()]);
                    judgeL.add(jsonObjectEntity.getString("text"));
                    break;
                case "DateVerdict":
                    dateverdictL.add(jsonObjectEntity.getString("text"));
                    break;
                case "ForeDecisionRACCourt":
                    foreDecRACcL.add(jsonObjectEntity.getString("text"));
                    break;
                case "ForeDecisionRACDateVerdict":
                    foreDecRACdvL.add(jsonObjectEntity.getString("text"));
                    break;
                case "ForeDecisionRCCourt":
                    foreDecRCcL.add(jsonObjectEntity.getString("text"));
                    break;
                case "ForeDecisionRCDateVerdict":
                    foreDecRCdvL.add(jsonObjectEntity.getString("text"));
                    break;
                case "ForeDecisionDCCourt":
                    foreDecDCcL.add(jsonObjectEntity.getString("text"));
                    break;
                case "ForeDecisionDCDateVerdict":
                    foreDecDCdvL.add(jsonObjectEntity.getString("text"));
                    break;
            }
        }
        // Creating a new Verdict Object
        // Using Date for Date-Elements
        Verdict verdict = new Verdict();

        //Docket Number
        verdict.setDocketNumber(mostCommon(docketnumberL));

        // TODO revisionSuccess

        //Senate
        verdict.setSenate(mostCommon(senateL));

        //Judges
        String[] judgeList = judgeL.toArray(new String[judgeL.size()]);
        verdict.setJudgeList(judgeList);

        //Date Verdict
        verdict.setDateVerdict(filterNewestDate(dateverdictL));

        //Oberlandesgericht - RAC
        verdict.setForeDecisionRACCourt(mostCommon(foreDecRACcL));
        verdict.setForeDecisionRACVerdictDate((filterNewestDate(foreDecRACdvL)));

        //Landesgericht - RC
        verdict.setForeDecisionRCCourt(mostCommon(foreDecRCcL));
        verdict.setForeDecisionRCVerdictDate(filterNewestDate(foreDecRCdvL));

        //Amtsgericht - DC
        verdict.setForeDecisionDCCourt(mostCommon(foreDecDCcL));
        verdict.setForeDecisionDCVerdictDate(filterNewestDate((foreDecDCdvL)));

        //sout nur für debugger benötigt
        //System.out.println("");
        return verdict;
    }


    /**
     * Hilfsmethode, sucht das Element einer Stringliste, welches am häufigsten vorkommt.
     * Bei gleicher Kardinalität: Das letzte Element (entspricht random auswahl)
     *
     * @param typelist - Liste von Strings
     * @return - das häugiste Element
     */
    private String mostCommon(List<String> typelist) {
        if (!typelist.isEmpty()) {
            Map<String, Integer> map = new HashMap<>();
            for (String string : typelist) {
                string = normalizeString(string);
                Integer val = map.get(string);
                map.put(string, val == null ? 0 : val + 1);
            }
            Map.Entry<String, Integer> max = null;

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (max == null || e.getValue() > max.getValue()) {
                    max = e;
                }
            }
            return max.getKey();
        } else {
            return null;
        }

    }

    /**
     * Trimmt und setzt einen String auf lower case
     *
     * @param string
     * @return
     */
    private String normalizeString(String string) {
        string = string.trim();
        return string.toLowerCase();
    }


    /**
     * Filtert aus einer Stringliste das am kuerzesten zurückliegende/ jüngste Datum
     *
     * @param stringL Stringliste
     * @return
     * @throws ParseException
     */
    private Long filterNewestDate(List<String> stringL) throws ParseException {
        VerdictDateFormatter verdictDateFormatter = new VerdictDateFormatter();
        // Empfängt eine Liste und gibt dabei das neueste Datum zurück.
        List<Long> dateVerdicts;
        dateVerdicts = verdictDateFormatter.formateStringDateToLongList(stringL);
        return Collections.max(dateVerdicts);


    }

}