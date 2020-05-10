package com.deproz.a9jaquiz.Model;

public class Question {
    public String question,A,B,C,D,answer;

    public Question(String question, String answer, String a, String b, String c, String d) {
        this.question = question;
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
        this.answer = answer;
    }

    public Question() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestions(String questions) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void answer(String answer) {
        this.answer = answer;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }
}

