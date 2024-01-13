package com.example.medicard;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class MedicalCardActivity extends AppCompatActivity {

    private ImageView qrImageView;
    private TextView fullNameTextView;
    private TextView emergencyContactTextView;
    private TextView addressTextView;
    private TextView genderTextView;
    private TextView bloodGroupTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_card);

        // Initialize your views
        qrImageView = findViewById(R.id.QR);
        fullNameTextView = findViewById(R.id.FullName);
        emergencyContactTextView = findViewById(R.id.EmergencyContact);
        addressTextView = findViewById(R.id.Adddress);
        genderTextView = findViewById(R.id.Gender);
        bloodGroupTextView = findViewById(R.id.BloodGroup);

        // Read medical record from the database
        DBhelper dbHelper = new DBhelper(this);
        MedicalRecord medicalRecord = dbHelper.getMedicalRecord();

        // Set information to TextViews
        if (medicalRecord != null) {
            fullNameTextView.setText("Full Name: " + medicalRecord.getFullName());
            emergencyContactTextView.setText("Emergency Contact: " + medicalRecord.getEmergencyContact());
            addressTextView.setText("Address: " + medicalRecord.getAddress());
            genderTextView.setText("Gender: " + medicalRecord.getGender());
            bloodGroupTextView.setText("Blood Group: " + medicalRecord.getBloodGroup());
        }

        // Generate QR code and set it to ImageView
        if (medicalRecord != null) {
            String qrData = "Medical Record: " + medicalRecord.getConditions();  // Customize this based on your needs
            Bitmap qrCodeBitmap = generateQRCode(qrData);
            qrImageView.setImageBitmap(qrCodeBitmap);
        }
    }

    // Function to generate QR code from data
    private Bitmap generateQRCode(String data) {
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 300, 300);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }

            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
