package com.example.medicard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MedicalCardDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USER_PROFILES = "user_profiles";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_EMERGENCY_CONTACT = "emergency_contact";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_BLOOD_GROUP = "blood_group";
    private static final String COLUMN_USER_PROFILE = "user_profile"; // Added column for user profile picture

    private static final String TABLE_MEDICAL_RECORDS = "medical_records";
    private static final String COLUMN_CONDITIONS = "conditions";
    private static final String COLUMN_ALLERGIES = "allergies";
    private static final String COLUMN_MEDICATIONS = "medications";
    private static final String COLUMN_PHYSICIAN = "physician";
    private static final String COLUMN_INSURANCE = "insurance";
    private static final String COLUMN_KNOWN_CONDITIONS = "known_conditions";
    private static final String COLUMN_CURRENT_SYMPTOMS = "current_symptoms";
    private static final String COLUMN_EMERGENCY_CONTACT_FORM = "emergency_contact_form";
    private static final String COLUMN_EMERGENCY_CONTACT_RELATIONSHIP = "emergency_contact_relationship";
    private static final String COLUMN_PREFERRED_HOSPITAL = "preferred_hospital";
    private static final String COLUMN_DIETARY_RESTRICTIONS = "dietary_restrictions";
    private static final String COLUMN_RECENT_TESTS = "recent_tests";

    private static final String CREATE_TABLE_USER_PROFILES =
            "CREATE TABLE " + TABLE_USER_PROFILES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_AGE + " INTEGER, " +
                    COLUMN_DOB + " TEXT, " +
                    COLUMN_EMERGENCY_CONTACT + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_BLOOD_GROUP + " TEXT, " +
                    COLUMN_USER_PROFILE + " BLOB);"; // Added user profile picture column

    private static final String CREATE_TABLE_MEDICAL_RECORDS =
            "CREATE TABLE " + TABLE_MEDICAL_RECORDS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CONDITIONS + " TEXT, " +
                    COLUMN_ALLERGIES + " TEXT, " +
                    COLUMN_MEDICATIONS + " TEXT, " +
                    COLUMN_PHYSICIAN + " TEXT, " +
                    COLUMN_INSURANCE + " TEXT, " +
                    COLUMN_KNOWN_CONDITIONS + " TEXT, " +
                    COLUMN_CURRENT_SYMPTOMS + " TEXT, " +
                    COLUMN_EMERGENCY_CONTACT_FORM + " TEXT, " +
                    COLUMN_EMERGENCY_CONTACT_RELATIONSHIP + " TEXT, " +
                    COLUMN_PREFERRED_HOSPITAL + " TEXT, " +
                    COLUMN_DIETARY_RESTRICTIONS + " TEXT, " +
                    COLUMN_RECENT_TESTS + " TEXT);";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER_PROFILES);
        db.execSQL(CREATE_TABLE_MEDICAL_RECORDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Add any necessary upgrade logic here
    }

    public long insertUserProfile(String name, int age, String dob, String emergencyContact, String address, String gender, String bloodGroup, byte[] userProfile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_DOB, dob);
        values.put(COLUMN_EMERGENCY_CONTACT, emergencyContact);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_BLOOD_GROUP, bloodGroup);
        values.put(COLUMN_USER_PROFILE, userProfile); // Insert user profile picture here

        return db.insert(TABLE_USER_PROFILES, null, values);
    }

    public long insertMedicalRecord(String conditions, String allergies, String medications, String physician, String insurance,
                                    String knownConditions, String currentSymptoms, String emergencyContactForm,
                                    String emergencyContactRelationship, String preferredHospital,
                                    String dietaryRestrictions, String recentTests) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONDITIONS, conditions);
        values.put(COLUMN_ALLERGIES, allergies);
        values.put(COLUMN_MEDICATIONS, medications);
        values.put(COLUMN_PHYSICIAN, physician);
        values.put(COLUMN_INSURANCE, insurance);
        values.put(COLUMN_KNOWN_CONDITIONS, knownConditions);
        values.put(COLUMN_CURRENT_SYMPTOMS, currentSymptoms);
        values.put(COLUMN_EMERGENCY_CONTACT_FORM, emergencyContactForm);
        values.put(COLUMN_EMERGENCY_CONTACT_RELATIONSHIP, emergencyContactRelationship);
        values.put(COLUMN_PREFERRED_HOSPITAL, preferredHospital);
        values.put(COLUMN_DIETARY_RESTRICTIONS, dietaryRestrictions);
        values.put(COLUMN_RECENT_TESTS, recentTests);

        return db.insert(TABLE_MEDICAL_RECORDS, null, values);
    }

    public MedicalRecord getMedicalRecord() {
        MedicalRecord medicalRecord = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {
                COLUMN_CONDITIONS,
                COLUMN_ALLERGIES,
                COLUMN_MEDICATIONS,
                COLUMN_PHYSICIAN,
                COLUMN_INSURANCE,
                COLUMN_KNOWN_CONDITIONS,
                COLUMN_CURRENT_SYMPTOMS,
                COLUMN_EMERGENCY_CONTACT_FORM,
                COLUMN_EMERGENCY_CONTACT_RELATIONSHIP,
                COLUMN_PREFERRED_HOSPITAL,
                COLUMN_DIETARY_RESTRICTIONS,
                COLUMN_RECENT_TESTS
        };

        Cursor cursor = db.query(
                TABLE_MEDICAL_RECORDS,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            medicalRecord = new MedicalRecord();
            medicalRecord.setConditions(cursor.getString(cursor.getColumnIndex(COLUMN_CONDITIONS)));
            medicalRecord.setAllergies(cursor.getString(cursor.getColumnIndex(COLUMN_ALLERGIES)));
            medicalRecord.setMedications(cursor.getString(cursor.getColumnIndex(COLUMN_MEDICATIONS)));
            medicalRecord.setPhysician(cursor.getString(cursor.getColumnIndex(COLUMN_PHYSICIAN)));
            medicalRecord.setInsurance(cursor.getString(cursor.getColumnIndex(COLUMN_INSURANCE)));
            medicalRecord.setKnownConditions(cursor.getString(cursor.getColumnIndex(COLUMN_KNOWN_CONDITIONS)));
            medicalRecord.setCurrentSymptoms(cursor.getString(cursor.getColumnIndex(COLUMN_CURRENT_SYMPTOMS)));
            medicalRecord.setEmergencyContactForm(cursor.getString(cursor.getColumnIndex(COLUMN_EMERGENCY_CONTACT_FORM)));
            medicalRecord.setEmergencyContactRelationship(cursor.getString(cursor.getColumnIndex(COLUMN_EMERGENCY_CONTACT_RELATIONSHIP)));
            medicalRecord.setPreferredHospital(cursor.getString(cursor.getColumnIndex(COLUMN_PREFERRED_HOSPITAL)));
            medicalRecord.setDietaryRestrictions(cursor.getString(cursor.getColumnIndex(COLUMN_DIETARY_RESTRICTIONS)));
            medicalRecord.setRecentTests(cursor.getString(cursor.getColumnIndex(COLUMN_RECENT_TESTS)));
            cursor.close();
        }

        return medicalRecord;
    }

}
