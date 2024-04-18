/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationsystem;

import java.time.LocalDateTime;

/**
 *
 * @author ranug
 */
public class Consultation {
    private Doctor doctor;
    private Patient patient;
    private double cost;
    private String notes;
    private LocalDateTime dateTime;
    private String consultationId;

    public Consultation(Doctor doctor, Patient patient, double cost, String notes, LocalDateTime dateTime, String consultationId) {
        this.doctor = doctor;
        this.patient = patient;
        this.cost = cost;
        this.notes = notes;
        this.dateTime = dateTime;
        this.consultationId = consultationId;
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the dateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the consultationId
     */
    public String getConsultationId() {
        return consultationId;
    }

    /**
     * @param consultationId the consultationId to set
     */
    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
    }

    @Override
    public String toString() {
        return "Consultation{" + "doctor=" + doctor + ", patient=" + patient + ", cost=" + cost + ", notes=" + notes + ", dateTime=" + dateTime + ", consultationId=" + consultationId + '}';
    }
    
    
}
