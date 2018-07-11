package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    RadioButton rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        

    }


    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        float fltGPA = Float.parseFloat(etGPA.getText().toString());

        //Step1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step1c: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //step1d: Add the key-value pair
        //        The value should be from the Vaiable defined in step1a
        prefEdit.putString("name", strName);
        prefEdit.putFloat("GPA", fltGPA);

        //Step 1e: Call commit() method to save the changes into SharedPreferences
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step2b: Retrieve the saved data from the SharedPreferences
        String displayName = prefs.getString("name", null);
        float displayGPA = prefs.getFloat("gpa", 0);

        //Step1c: Update the UI element with the value
        etName.setText(displayName);
        etGPA.setText(Float.toString(displayGPA));



    }
}