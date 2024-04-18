/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationsystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ranug
 */
public class Doctor extends Person {

    private String medicalLicenceNo;
    private String specialization;

    public Doctor(String medicalLicenceNo, String specialization) {
        this.medicalLicenceNo = medicalLicenceNo;
        this.specialization = specialization;
    }

    public Doctor(String medicalLicenceNo, String specialization, String name, String surname, Date dob, String mobileNo) {
        super(name, surname, dob, mobileNo);
        this.medicalLicenceNo = medicalLicenceNo;
        this.specialization = specialization;
    }

    /**
     * @return the medicalLicenceNo
     */
    public String getMedicalLicenceNo() {
        return medicalLicenceNo;
    }

    /**
     * @param medicalLicenceNo the medicalLicenceNo to set
     */
    public void setMedicalLicenceNo(String medicalLicenceNo) {
        this.medicalLicenceNo = medicalLicenceNo;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
}
