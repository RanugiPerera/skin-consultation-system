/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ranug
 */
public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    
    private static final Logger LOG = Logger.getLogger(WestminsterSkinConsultationManager.class.getName());
    
    private ArrayList<Doctor> doctorList;
    private ArrayList<Patient> patientsList;
    private final int MAX_DOCTOR_NO = 10;
    Scanner sc = new Scanner(System.in);
    ;
    boolean applicationRunStatus = true;
    
    public WestminsterSkinConsultationManager() {
        this.doctorList = new ArrayList<>();
        loadFile();
        while (applicationRunStatus) {
            selection();
        }
    }
    
    public void displayMenu() {
        System.out.println("+------------------------------------------+");
        System.out.println("|               Welcome to                 |");
        System.out.println("|   Westminster Skin Consultation Center   |");
        System.out.println("+------------------------------------------+");
        System.out.println("ADD : Add a new doctor");
        System.out.println("DELETE : Delete a doctor");
        System.out.println("PRINT : Print list of doctors");
        System.out.println("SAVE : Save Doctors");
        System.out.println("LOAD : Load doctors");
        System.out.println("GUI : Display GUI");
        System.out.println("EXIT : Exit from System");
        System.out.println("Please make a selection");
    }
    
    private void selection() {
        displayMenu();
        String option = sc.nextLine().toUpperCase();
        switch (option) {
            case "ADD":
                addNewDoctor();
                break;
            case "DELETE":
                System.out.println("Enter medical licence");
                String medLicence = sc.nextLine();
                deleteDoctor(medLicence);
                break;
            case "PRINT":
                printDoctorList();
                break;
            case "SAVE":
                saveFile(doctorList);
                break;
            case "LOAD":
                loadFile();
                break;
            case "GUI":
                displayGUI();
                break;
            case "EXIT":
                applicationRunStatus = false;
                System.out.println("Exiting from System...");
                break;
            default:
                System.out.println("Invalid option. Please select a valid option from the menu.");
                break;
        }
    }
    
    @Override
    public void addNewDoctor() {
        System.out.println("Adding a new doctor to the list");
        if (doctorList.size() < MAX_DOCTOR_NO) {
            
            System.out.println("Doctor's medical licence numberr: ");
            String medicalLicenceNo = sc.nextLine();
            System.out.println("Doctor's specialization");
            String specialization = sc.nextLine();
            System.out.println("Doctor's first name: ");
            String firstName = sc.nextLine();
            System.out.println("Doctor's last name: ");
            String lastName = sc.nextLine();
     
            Date dob = null;
          
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Date of Birth (yyyy-MM-dd ): ");
                   dob=new SimpleDateFormat("yyyy-MM-DD").parse(sc.nextLine()); // Parse input to LocalDateTime
                    validInput = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter the date in the correct format (yyyy-MM-dd).");
                } catch (ParseException ex) {
                    Logger.getLogger(WestminsterSkinConsultationManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Doctor's mobile number: ");
            String mobileNo = sc.nextLine();
            Doctor doctor = new Doctor(medicalLicenceNo, specialization, firstName, lastName, dob, mobileNo);
            doctorList.add(doctor);
            System.out.println(doctor.getName());
            System.out.println(doctor.getSurname());
            System.out.println(doctor.getMedicalLicenceNo());            
            System.out.println(doctor.getMobileNo());
            System.out.println(doctor.getDob());
            System.out.println("Doctor added Successfully");
        } else {
            System.out.println("Center has reached maximum doctor limit");
        }
    }
    
    @Override
    public void deleteDoctor(String medLic) {
        int removeIndex = -1;
        for (int i = 0; i < doctorList.size(); i++) {
            doctorList.get(i);
            findDocByMedLic(medLic);
            removeIndex = i;
            if (removeIndex != -1) {
                doctorList.remove(removeIndex);
                System.out.println("Doctor removed sucessfully");
                System.out.println("Available doctors: " + doctorList.size());
            } else {
                System.out.println("Doctor with " + medLic + " doesn't exist");
            }
        }
    }
    
    @Override
    public ArrayList<Doctor> printDoctorList() {
        // Add debug statement to check if the method is being called
        System.out.println("Printing doctor list:");

//        Collections.sort(doctorList, Comparator.comparing(Doctor::getSurname));
        if (doctorList.isEmpty()) {
            System.out.println("Doctor list is empty.");
        } else {
            for (Doctor doctor : doctorList) {
                System.out.println("Doctor's surname: " + doctor.getSurname());
                System.out.println("Doctor's first name: " + doctor.getName());
                System.out.println("Doctor's medical licence No: " + doctor.getMedicalLicenceNo());
                System.out.println("Doctor's mobile number: " + doctor.getMobileNo());
                System.out.println("Specialization: " + doctor.getSpecialization());
            }
        }
        return doctorList;
    }
    
    @Override
    public void saveFile(ArrayList <Doctor> doctorList) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Doctor List.txt"))) {
            outputStream.writeObject(doctorList);
            System.out.println("Doctor's data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving doctor's data: " + e.getMessage());
        }
    }
    
    @Override
    public void loadFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Doctor List.txt"))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                this.doctorList = (ArrayList) obj;
                for (Doctor doctor : doctorList) {
                    System.out.println(doctor.getName());                    
                }
                System.out.println("Doctors loaded from file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading doctors from file: " + e.getMessage());
        }
    }
    
    private void displayGUI() {
        GUI gui = new GUI(doctorList, this);
        gui.setVisible(true);
    }
    
    @Override
    public Doctor findDocByMedLic(String medLic) {
        for (Doctor doctor : doctorList) {
            if (medLic.equals(doctor.getMedicalLicenceNo())) {
                return doctor;
            } else {
                LOG.log(Level.WARNING, "{0} is invalid.", medLic);
            }
            
        }
        return (null);
        
    }
}
