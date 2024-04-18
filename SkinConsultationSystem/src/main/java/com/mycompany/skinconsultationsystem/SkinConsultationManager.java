/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationsystem;

import java.util.ArrayList;

/**
 *
 * @author ranug
 */
public interface SkinConsultationManager {

    void addNewDoctor();

    void deleteDoctor(String medLic);

    ArrayList<Doctor> printDoctorList();

    void saveFile(ArrayList<Doctor> doctorList);

    void loadFile();

    Doctor findDocByMedLic(String medLic);
}
