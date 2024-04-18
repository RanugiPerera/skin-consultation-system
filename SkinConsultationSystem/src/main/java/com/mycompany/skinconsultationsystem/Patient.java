/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationsystem;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ranug
 */
public class Patient extends Person implements Serializable{
    private int patientId;

    public Patient(int patientId) {
        this.patientId = patientId;
    }

    public Patient(int patientId, String name, String surname, Date dob, String mobileNo) {
        super(name, surname, dob, mobileNo);
        this.patientId = patientId;
    }

    /**
     * @return the patientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

  
}
