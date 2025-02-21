package com.diabetes.diabetes.patient;


import jakarta.persistence.*;

    @Entity
    @Table(name = "patient")
    public class Patient {


    @Id
    @Column (nullable = false , updatable = false)
    private Long id;
    private Integer Pregnancies ;
     private Integer Glucose ;
    private Integer BloodPressure ;

    private Integer SkinThickness ;
    private Integer Insulin ;
    private Integer bmi ;
    private Float DiabetesPedigreeFunction  ;
    private Integer Age ;
    private Integer Outcome ;

        public Patient(Long id, Integer Outcome) {
            this.id = id ;
            this.Outcome = Outcome;
        }

       public Patient(Long id, Integer pregnancies, Integer glucose, Integer bloodPressure, Integer skinThickness, Integer insulin, Integer BMI, Float diabetesPedigreeFunction, Integer age, Integer outcome) {
        this.id = id;
        this.Pregnancies = pregnancies;
           this.Glucose = glucose;
           this.BloodPressure = bloodPressure;
           this.SkinThickness = skinThickness;
           this.Insulin = insulin;
        this.bmi = BMI;
           this.DiabetesPedigreeFunction = diabetesPedigreeFunction;
           this.Age = age;
           this.Outcome = outcome;
    }

    public Patient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPregnancies() {
        return Pregnancies;
    }

    public void setPregnancies(Integer pregnancies) {
        Pregnancies = pregnancies;
    }

    public Integer getGlucose() {
        return Glucose;
    }

    public void setGlucose(Integer glucose) {
        Glucose = glucose;
    }

    public Integer getBloodPressure() {
        return BloodPressure;
    }

    public void setBloodPressure(Integer bloodPressure) {
        BloodPressure = bloodPressure;
    }

    public Integer getSkinThickness() {
        return SkinThickness;
    }

    public void setSkinThickness(Integer skinThickness) {
        SkinThickness = skinThickness;
    }

    public Integer getInsulin() {
        return Insulin;
    }

    public void setInsulin(Integer insulin) {
        Insulin = insulin;
    }

    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }

    public Float getDiabetesPedigreeFunction() {
        return DiabetesPedigreeFunction;
    }

    public void setDiabetesPedigreeFunction(Float diabetesPedigreeFunction) {
        DiabetesPedigreeFunction = diabetesPedigreeFunction;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getOutcome() {
        return Outcome;
    }

    public void setOutcome(Integer outcome) {
        Outcome = outcome;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", Pregnancies=" + Pregnancies +
                ", Glucose=" + Glucose +
                ", BloodPressure=" + BloodPressure +
                ", SkinThickness=" + SkinThickness +
                ", Insulin=" + Insulin +
                ", Bmi=" + bmi +
                ", DiabetesPedigreeFunction=" + DiabetesPedigreeFunction +
                ", Age=" + Age +
                ", Outcome=" + Outcome +
                '}';
    }
}
