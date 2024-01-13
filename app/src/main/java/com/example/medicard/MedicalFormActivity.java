 package com.example.medicard;

 import android.content.Intent;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.Toast;

 import androidx.appcompat.app.AppCompatActivity;

 public class MedicalFormActivity extends AppCompatActivity {

     private DBhelper databaseHelper;

     private EditText editTextConditions;
     private EditText editTextAllergies;
     private EditText editTextMedications;
     private EditText editTextPhysician;
     private EditText editTextInsurance;
     private EditText editTextKnownConditions;
     private EditText editTextCurrentSymptoms;
     private EditText editTextEmergencyContact;
     private EditText editTextEmergencyContactRelationship;
     private EditText editTextPreferredHospital;
     private EditText editTextDietaryRestrictions;
     private EditText editTextRecentTests;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_medical_form);

         // Initialize your EditText fields
         editTextConditions = findViewById(R.id.editTextConditionsform);
         editTextAllergies = findViewById(R.id.editTextAllergies);
         editTextMedications = findViewById(R.id.editTextMedicationsform);
         editTextPhysician = findViewById(R.id.editTextPhysician);
         editTextInsurance = findViewById(R.id.editTextInsurance);
         editTextKnownConditions = findViewById(R.id.editTextKnownConditions);
         editTextCurrentSymptoms = findViewById(R.id.CurrentSymptoms);
         editTextEmergencyContact = findViewById(R.id.editTextEmergencyContactform);
         editTextEmergencyContactRelationship = findViewById(R.id.EmergencyContactRelationship);
         editTextPreferredHospital = findViewById(R.id.PreferredHospital);
         editTextDietaryRestrictions = findViewById(R.id.DietaryRestrictions);
         editTextRecentTests = findViewById(R.id.RecentTests);

         // Initialize the database helper
         databaseHelper = new DBhelper(this);

         Button submitButton = findViewById(R.id.submitButton);
         submitButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 submitForm();
                Intent intent = new Intent(MedicalFormActivity.this,MedicalCardActivity.class);
                startActivity(intent);
             }
         });
     }

     private void submitForm() {
         // Retrieve values from EditText fields
         String conditions = editTextConditions.getText().toString();
         String allergies = editTextAllergies.getText().toString();
         String medications = editTextMedications.getText().toString();
         String physician = editTextPhysician.getText().toString();
         String insurance = editTextInsurance.getText().toString();
         String knownConditions = editTextKnownConditions.getText().toString();
         String currentSymptoms = editTextCurrentSymptoms.getText().toString();
         String emergencyContact = editTextEmergencyContact.getText().toString();
         String emergencyContactRelationship = editTextEmergencyContactRelationship.getText().toString();
         String preferredHospital = editTextPreferredHospital.getText().toString();
         String dietaryRestrictions = editTextDietaryRestrictions.getText().toString();
         String recentTests = editTextRecentTests.getText().toString();

         // Insert the data into the database
         long newRowId = databaseHelper.insertMedicalRecord(
                 conditions, allergies, medications, physician, insurance,
                 knownConditions, currentSymptoms, emergencyContact,
                 emergencyContactRelationship, preferredHospital,
                 dietaryRestrictions, recentTests);

         if (newRowId != -1) {
             // Data inserted successfully
             Toast.makeText(this, "Form Submitted!", Toast.LENGTH_SHORT).show();
         } else {
             // Error occurred during insertion
             Toast.makeText(this, "Failed to submit form. Please try again.", Toast.LENGTH_SHORT).show();
         }
     }

     @Override
     protected void onDestroy() {
         // Close the database helper when the activity is destroyed
         databaseHelper.close();
         super.onDestroy();
     }
 }
