package com.example.simplejsonparse;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simplejsonparse.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;

    String JSON_STRING = "{\"employee\":{\"name\":\"John Rai\",\"salary\":900000,\"address\":Lalitpur}}";

    String name, salary, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        try {
            JSONObject object = new JSONObject(JSON_STRING);
            JSONObject employee = object.getJSONObject("employee");

            name = employee.getString("name");
            salary = employee.getString("salary");
            address = employee.getString("address");

            bind.txtName.setText("Name: "+name);
            bind.txtSalary.setText("Salary: "+salary);
            bind.txtAddress.setText("Address: "+address);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}