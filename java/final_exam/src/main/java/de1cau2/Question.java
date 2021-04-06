/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1cau2;

/**
 *
 * @author oem
 */
public class Question {
    private String id;
    private String questionName;
    private String[] questionAnswer;
    private String answer;

    public Question(String id, String questionName, String[] questionAnswer, String answer) {
        this.id = id;
        this.questionName = questionName;
        this.questionAnswer = questionAnswer;
        this.answer = answer;
    }
    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String[] getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String[] questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}
