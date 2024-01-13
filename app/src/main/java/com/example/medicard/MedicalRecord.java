package com.example.medicard;

public class MedicalRecord {

    private String conditions;
    private String allergies;
    private String medications;
    private String physician;
    private String insurance;
    private String knownConditions;
    private String currentSymptoms;
    private String emergencyContactForm;
    private String emergencyContactRelationship;
    private String preferredHospital;
    private String dietaryRestrictions;
    private String recentTests;
    private String fullname;
    private int emergencycontact;
    private String address;
    private String gender;
    private String bloodgroup;

    // Default constructor
    public MedicalRecord() {
        // Default constructor
    }

    // Constructor with all fields
    public MedicalRecord(String conditions, String allergies, String medications, String physician, String insurance,
                         String knownConditions, String currentSymptoms, String emergencyContactForm,
                         String emergencyContactRelationship, String preferredHospital,
                         String dietaryRestrictions, String recentTests,
                         String fullname, int emergencycontact, String address, String gender, String bloodgroup) {
        this.conditions = conditions;
        this.allergies = allergies;
        this.medications = medications;
        this.physician = physician;
        this.insurance = insurance;
        this.knownConditions = knownConditions;
        this.currentSymptoms = currentSymptoms;
        this.emergencyContactForm = emergencyContactForm;
        this.emergencyContactRelationship = emergencyContactRelationship;
        this.preferredHospital = preferredHospital;
        this.dietaryRestrictions = dietaryRestrictions;
        this.recentTests = recentTests;
        this.fullname = fullname;
        this.emergencycontact = emergencycontact;
        this.address = address;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
    }

    // Getters and setters for all fields...

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getPhysician() {
        return physician;
    }

    public void setPhysician(String physician) {
        this.physician = physician;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getKnownConditions() {
        return knownConditions;
    }

    public void setKnownConditions(String knownConditions) {
        this.knownConditions = knownConditions;
    }

    public String getCurrentSymptoms() {
        return currentSymptoms;
    }

    public void setCurrentSymptoms(String currentSymptoms) {
        this.currentSymptoms = currentSymptoms;
    }

    public String getEmergencyContactForm() {
        return emergencyContactForm;
    }

    public void setEmergencyContactForm(String emergencyContactForm) {
        this.emergencyContactForm = emergencyContactForm;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    public String getPreferredHospital() {
        return preferredHospital;
    }

    public void setPreferredHospital(String preferredHospital) {
        this.preferredHospital = preferredHospital;
    }

    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public String getRecentTests() {
        return recentTests;
    }

    public void setRecentTests(String recentTests) {
        this.recentTests = recentTests;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getEmergencyContact() {
        return emergencycontact;
    }

    public void setEmergencycontact(int emergencycontact) {
        this.emergencycontact = emergencycontact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}
// ge