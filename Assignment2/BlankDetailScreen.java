package com.example.cpsc411assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cpsc411assignment2.Model.CourseEnrollment;
import com.example.cpsc411assignment2.Model.Student;
import com.example.cpsc411assignment2.Model.StudentDB;

import java.util.ArrayList;

public class BlankDetailScreen extends AppCompatActivity {

    protected Menu detailMenu;
    protected Student sObj;
    protected final String TAG = "Details Screen";
    protected int counter = 0;
    protected int[] courseID = {R.id.p_c1, R.id.p_c2, R.id.p_c3, R.id.p_c4, R.id.p_c5, R.id.p_c6, R.id.p_c7};
    protected int[] grade = {R.id.p_g1, R.id.p_g2, R.id.p_g3, R.id.p_g4, R.id.p_g5, R.id.p_g6, R.id.p_g7};
    ArrayList<CourseEnrollment> courses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_details_screen);
        courses = new ArrayList<CourseEnrollment>();

        Button button = findViewById(R.id.p_button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //
                        EditText editView = findViewById(R.id.p_first_name_id);
                        String fName = editView.getText().toString();
                        editView.setEnabled(false);
                        editView = findViewById(R.id.p_last_name_id);
                        String lName = editView.getText().toString();
                        editView.setEnabled(false);
                        editView = findViewById(R.id.p_cwid_id);
                       // int id = Integer.getInteger(editView.getText().toString());
                        int id = Integer.parseInt(editView.getText().toString());
                        editView.setEnabled(false);
                        sObj = new Student(fName, lName, id);
                        //sObj = new Student(fName, lName, 1234567);

                        editView = findViewById(courseID[counter]);
                        editView.setVisibility(View.VISIBLE);
                        editView.setEnabled(true);
                        editView = findViewById(grade[counter]);
                        editView.setVisibility(View.VISIBLE);
                        editView.setEnabled(true);
                        if(counter!=0)
                        {
                            editView = findViewById(courseID[counter-1]);
                            editView.setEnabled(false);
                            editView = findViewById(grade[counter-1]);
                            editView.setEnabled(false);
                        }
                        counter++;
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Custom Menu inflation
        getMenuInflater().inflate(R.menu.detail_screen_menu, menu);
        menu.findItem(R.id.action_done).setVisible(true);
        detailMenu = menu;

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_done) {

            EditText editView;
            String c;
            String g;
            // Save info?
            for(int i=0;i<counter;i++){

                editView = findViewById(courseID[i]);
                c = editView.getText().toString();
                editView = findViewById(grade[i]);
                g = editView.getText().toString();
                courses.add(new CourseEnrollment(c,g));
            }
            sObj.setCourses(courses);
            StudentDB.getInstance().addStudent(sObj);

            Intent intent = new Intent(this, SummaryScreen.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
