package com.example.landa.paypalintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    TextView txtId, amount, txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId = findViewById(R.id.txtID);
        amount = findViewById(R.id.txtamount);
        txtStatus = findViewById(R.id.txtStatus);

        Intent intent = getIntent();

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("paymentDetails"));
            showDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("paymentAmount"));

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try{

            txtId.setText(response.getString("id"));
            amount.setText(response.getString("state"));
            txtStatus.setText(response.getString(String.format("$%s",paymentAmount)));
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
