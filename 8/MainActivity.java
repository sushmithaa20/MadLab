package com.example.phonedialer;

import static android.net.Uri.parse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnZero,btnStar,btnHash,btnDel,btnSave,btnCall;
    EditText editPhone;
    String phoneNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix= findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnStar = findViewById(R.id.btnStar);
        btnHash = findViewById(R.id.btnHash);
        btnDel = findViewById(R.id.btnDel);
        btnCall = findViewById(R.id.btnCall);
        btnSave = findViewById(R.id.btnSave);
        editPhone = findViewById(R.id.editPhone);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnStar.setOnClickListener(this);
        btnHash.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        phoneNum = editPhone.getText().toString().trim();
        try{
            if(view.equals(btnOne)){
                phoneNum+="1";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnTwo)){
                phoneNum+="2";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnThree)){
                phoneNum+="3";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnFour)){
                phoneNum+="4";
                editPhone.setText(phoneNum);
            }
            else  if(view.equals(btnFive)){
                phoneNum+="5";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnSix)){
                phoneNum+="6";
                editPhone.setText(phoneNum);
            }else if(view.equals(btnSeven)){
                phoneNum+="7";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnEight)){
                phoneNum+="8";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnNine)){
                phoneNum+="9";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnZero)){
                phoneNum+="0";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnStar)){
                phoneNum+="*";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnHash)){
                phoneNum+="#";
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnDel)){
                if(!phoneNum.isEmpty() && phoneNum.length()>0) {
                    phoneNum = phoneNum.substring(0, phoneNum.length() - 1);

                }else{
                    phoneNum = "";
                }
                editPhone.setText(phoneNum);
            }
            else if(view.equals(btnCall)){
                phoneNum = phoneNum.trim();
                if(phoneNum.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter the Number To Call!!!",Toast.LENGTH_LONG).show();
                }
                else {
                    if (phoneNum.contains("#")) {
                        phoneNum = phoneNum.replace("#", "%23");
                    }
                    Uri uri = parse("tel:" + phoneNum);
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    try {
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }
            else if(view.equals(btnSave)){
                phoneNum = phoneNum.trim();
                if(phoneNum.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter the Number To Save!!!",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE,phoneNum);
                    try {
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
