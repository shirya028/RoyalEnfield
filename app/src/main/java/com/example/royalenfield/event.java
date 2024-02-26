package com.example.royalenfield;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.time.Duration;
import java.util.ArrayList;

public class event extends AppCompatActivity {
    EditText amount, note, name, upivirtualid ,phone;
    Button send;
    String TAG ="main";
    WebView wb;
    final int UPI_PAYMENT = 0;
    String total_amount_toPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        wb = findViewById(R.id.web);
        wb.setWebViewClient(new WebViewClient());
        wb.getSettings().setSupportZoom(true);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("https://docs.google.com/presentation/d/11BZbf1B3Gt9xOLdg-A1NJ3ihdaNPM-s_2cyfX_LV9Vo/edit?usp=sharing");
        Toast.makeText(this, "Please wait for few seconds....", Toast.LENGTH_SHORT).show();


        send = (Button) findViewById(R.id.send);
        amount = (EditText) findViewById(R.id.amount_et);
        note = (EditText) findViewById(R.id.note);
        name = (EditText) findViewById(R.id.ename);
        phone = (EditText) findViewById(R.id.ephone);

        upivirtualid = (EditText) findViewById(R.id.upi_id);

        String am="";
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("uname",MODE_PRIVATE);
            am=sharedPreferences.getString("amount","");

            amount.setText(am);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(View view) {
        if(phone.getText().toString().trim().length()!=10)
        {
            Toast.makeText(this, "Enter valid mobile number!!", Toast.LENGTH_SHORT).show();
        }
        if (amount.getText().toString().equals("0")|| amount.getText().toString().equals("")) {
            Toast.makeText(this, "Event is Not Yet Ready. \n PLease try after some hours!!", Toast.LENGTH_SHORT).show();
        } else {

            EditText amount;
            String TAG = "main";
            final int UPI_PAYMENT = 0;
            amount = (EditText) findViewById(R.id.amount_et);
            String totalAmount = amount.getText().toString();
            total_amount_toPay = totalAmount;
            if (name.length()>5 )
            {
                if (phone.length()==10)
                {
                    payUsingUpi(totalAmount);
                }
                else
                    Toast.makeText(this, "Enter Valid Phone number", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Enter Full Name", Toast.LENGTH_SHORT).show();


        }
    }
        void payUsingUpi (String amount){
            Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
            String merchantUPILink = "upi://pay?pa=9545459549@axl&pn=Mohammadsaad%20Mulla&mc=0000&mode=02&purpose=00";
            upiPayIntent.setData(Uri.parse(merchantUPILink + "&am=" + 1));


            Intent chooser = Intent.createChooser(upiPayIntent, "Pay With: ");
            if (null != chooser.resolveActivity(getPackageManager())) {
                startActivityForResult(chooser, UPI_PAYMENT);
            } else {
                Toast.makeText(this, "Payment Application Not Found!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            Log.e("main ", "response " + resultCode);

            switch (requestCode) {

                case UPI_PAYMENT:
                    if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                        if (data != null) {
                            String trxt = data.getStringExtra("response");
                            Log.e("UPI", "onActivityResult: " + trxt);
                            ArrayList<String> dataList = new ArrayList<>();
                            dataList.add(trxt);

                            upiPaymentDataOperation(dataList);

                        } else {
                            Log.e("UPI", "onActivityResult: " + "Return data is null");
                            ArrayList<String> dataList = new ArrayList<>();
                            dataList.add("nothing");
                            upiPaymentDataOperation(dataList);
                        }
                    } else {
                        //when user simply back without payment
                        Log.e("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                    break;
            }
        }
        private void upiPaymentDataOperation (ArrayList < String > data) {
            if (isConnectionAvailable(this)) {
                String str = data.get(0);
                Log.e("UPIPAY", "upiPaymentDataOperation: " + str);
                String paymentCancel = "";
                if (str == null) str = "discard";
                String status = "";
                String approvalRefNo = "";
                String response[] = str.split("&");
                for (int i = 0; i < response.length; i++) {
                    String equalStr[] = response[i].split("=");
                    if (equalStr.length >= 2) {
                        if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                            status = equalStr[1].toLowerCase();
                        } else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                            approvalRefNo = equalStr[1];
                        }
                    } else {
                        paymentCancel = "Payment cancelled by user.";
                    }
                }
                if (status.equals("success")) {
                    //Code to handle successful transaction here.
                    Toast.makeText(this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                    Log.e("UPI", "payment successfull: " + approvalRefNo);

                    save();


                } else if ("Payment cancelled by user.".equals(paymentCancel)) {
                    Toast.makeText(this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
                    Log.e("UPI", "Cancelled by user: " + approvalRefNo);
                } else {
                    Toast.makeText(this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
                    Log.e("UPI", "failed payment: " + approvalRefNo);
                }
            } else {
                Log.e("UPI", "Internet issue: ");
                Toast.makeText(this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
            }
        }
        public static boolean isConnectionAvailable (Context context){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                @SuppressLint("MissingPermission") NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
                if (netInfo != null && netInfo.isConnected()
                        && netInfo.isConnectedOrConnecting()
                        && netInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        }



    public void save()
    {
        EditText e1,e2;
        e1=findViewById(R.id.ename);
        e2=findViewById(R.id.ephone);
        String name="";
        event_registeration_details ev = new event_registeration_details(this);
        ev.insertDetails(e1.getText().toString(),e2.getText().toString());

        }
    }




