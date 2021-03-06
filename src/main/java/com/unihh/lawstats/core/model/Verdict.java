package com.unihh.lawstats.core.model;

//import com.sun.javafx.beans.IDProperty;

import com.unihh.lawstats.core.HashService;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents one document with the extracted date from watson
 */
//@SolrDocument(solrCoreName = "verdict")
public class Verdict {

    @Id
    @Field("id")
    @Indexed(type = "long")
    private Long id;
    @Field("docketNumber")
    @Indexed(type = "string")
    private String docketNumber;
    @Field("revisionSuccess")
    @Indexed(type = "long")
    private int revisionSuccess;
    @Field("relevanceScore")
    @Indexed(type = "double")
    private double relevanceScore;
    @Field
    @Indexed(type = "string")
    private String senate;
    @Field
    @Indexed(type = "strings")
    private String[] judgeList;
    @Field(value = "dateVerdict")
    @Indexed(type = "long")
    private Long dateVerdict;
    //Oberlandesgericht
    @Field
    @Indexed(type = "text_general")
    private String foreDecisionRACCourt;
    @Field(value = "foreDecisionRACVerdictDate")
    @Indexed(type = "long")
    private Long foreDecisionRACVerdictDate;
    //Landesgericht
    @Field
    @Indexed(type = "text_general")
    private String foreDecisionRCCourt;
    @Field("foreDecisionRCVerdictDate")
    @Indexed(type = "long")
    private Long foreDecisionRCVerdictDate;
    //Amtsgericht
    @Field
    @Indexed(type = "text_general")
    private String foreDecisionDCCourt;
    @Field("foreDecisionDCVerdictDate")
    @Indexed(type = "long")
    private Long foreDecisionDCVerdictDate;

    @Field
    @Indexed(type = "strings")
    private String[] decisionSentences;

    @Field
    @Indexed(type = "long")
    private int documentNumber;

    public String getDocketNumber() {
        return docketNumber;
    }

    public void setDocketNumber(String docketNumber) {
        id = HashService.longHash(docketNumber);
        this.docketNumber = docketNumber;
    }

    public int getRevisionSuccess() {
        return revisionSuccess;
    }

    public void setRevisionSuccess(int revisionSuccess) {
        this.revisionSuccess = revisionSuccess;
    }

    public double getRelevanceScore() {
        return relevanceScore;
    }

    public void setRelevanceScore(double relevanceScore) {
        this.relevanceScore = relevanceScore;
    }

    public String getSenate() {
        return senate;
    }

    public void setSenate(String senate) {
        if (senate != null) {
            this.senate = senate;
        } else {
            this.senate = "";
        }
    }

    public String[] getJudgeList() {
        return judgeList;
    }

    public void setJudgeList(String[] judgeList) {
        this.judgeList = Arrays.stream(judgeList).filter(Objects::nonNull).toArray(String[]::new);
    }

    public Long getDateVerdict() {
        return dateVerdict;
    }

    public void setDateVerdict(Long dateVerdict) {
        this.dateVerdict = dateVerdict;
    }

    public String getForeDecisionRACCourt() {
        return foreDecisionRACCourt;
    }

    public void setForeDecisionRACCourt(String foreDecisionRACCourt) {
        this.foreDecisionRACCourt = foreDecisionRACCourt;
    }

    public Long getForeDecisionRACVerdictDate() {
        return foreDecisionRACVerdictDate;
    }

    public void setForeDecisionRACVerdictDate(Long foreDecisionRACVerdictDate) {
        this.foreDecisionRACVerdictDate = foreDecisionRACVerdictDate;
    }

    public String getForeDecisionRCCourt() {
        return foreDecisionRCCourt;
    }

    public void setForeDecisionRCCourt(String foreDecisionRCCourt) {
        this.foreDecisionRCCourt = foreDecisionRCCourt;
    }

    public Long getForeDecisionRCVerdictDate() {
        return foreDecisionRCVerdictDate;
    }

    public void setForeDecisionRCVerdictDate(Long foreDecisionRCVerdictDate) {
        this.foreDecisionRCVerdictDate = foreDecisionRCVerdictDate;

    }

    public String getForeDecisionDCCourt() {
        return foreDecisionDCCourt;
    }

    public void setForeDecisionDCCourt(String foreDecisionDCCourt) {
        this.foreDecisionDCCourt = foreDecisionDCCourt;
    }

    public Long getForeDecisionDCVerdictDate() {
        return foreDecisionDCVerdictDate;
    }

    public void setForeDecisionDCVerdictDate(Long foreDecisionDCVerdictDate) {
        this.foreDecisionDCVerdictDate = foreDecisionDCVerdictDate;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Verdict && Objects.equals(this.id, ((Verdict) obj).getId());
    }

    @Override
    public int hashCode() {
        return this.getDocketNumber().hashCode();
    }

    public String[] getDecisionSentences() {
        return decisionSentences;
    }

    public void setDecisionSentences(String[] decisionSentences) {
        this.decisionSentences = decisionSentences;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getId() {
        return id;
    }

}
