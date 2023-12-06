package com.taz.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Convertor extends AppCompatActivity {
    private EditText giris,giris2,giris3;
    private TextView sonuc,sonuc2,sonuc3;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);
         giris = findViewById(R.id.input1);
         sonuc = findViewById(R.id.result1);
        Spinner spinner =findViewById(R.id.spinner1);
        List<String> kategori = new ArrayList<>();
        kategori.add("Seçiminizi Yapınız");
        kategori.add("ikilik");
        kategori.add("sekizlik");
        kategori.add("onaltılık");

        ArrayAdapter<String> liste = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,kategori);
        liste.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(liste);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String secilenKategori = kategori.get(position);
                String girisDegeri = giris.getText().toString();
                convertAndDisplayResult(girisDegeri,secilenKategori);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        giris2 = findViewById(R.id.input2);
        sonuc2 = findViewById(R.id.result2);
        Spinner spinner2 =findViewById(R.id.spinner2);
        List<String> kategori2 = new ArrayList<>();
        kategori2.add("Seçiminizi Yapınız");
        kategori2.add("kilo byte");
        kategori2.add("byte");
        kategori2.add("kibi byte");
        kategori2.add("bit");
        ArrayAdapter<String> liste2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,kategori2);
        liste.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(liste2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String secilenKategori2 = kategori2.get(position);
                String girisDegeri2 = giris2.getText().toString();
                convertAndDisplayResult2(girisDegeri2,secilenKategori2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        giris3 = findViewById(R.id.input3);
        sonuc3 = findViewById(R.id.result3);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton tiklananButon = findViewById(checkedId);
                String type = tiklananButon.getText().toString();
                String girisDegeri3 = giris3.getText().toString();
                convertAndDisplayResult3(girisDegeri3,type);

            }
        });




    }

    private  void  convertAndDisplayResult(String girisDegeri,String secilenKategori){
        if(girisDegeri.isEmpty()){
            Toast.makeText(getApplicationContext(),"Değer Oluşturulamaz",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            int Numara = Integer.parseInt(girisDegeri);
            String result ="";
            switch (secilenKategori){
                case "ikilik":
                    result = Integer.toBinaryString(Numara);
                    break;
                case "sekizlik":
                    result = Integer.toOctalString(Numara);
                    break;
                case "onaltılık":
                    result = Integer.toHexString(Numara);
                    break;
            }
            sonuc.setText(result);


        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Hatalı sayı girdiniz",Toast.LENGTH_SHORT).show();
        }
    }
    private void convertAndDisplayResult2(String girisDegeri2,String secilenKategori2){
        if (girisDegeri2.isEmpty()){
            Toast.makeText(getApplicationContext(),"Değer Oluşturulamaz",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            int Numara2 = Integer.parseInt(girisDegeri2);
            String result2="";
            switch (secilenKategori2){
                case "kilo byte":
                double kilobyte= Numara2 * 1000;
                result2=String.valueOf(kilobyte);
                break;
                case "byte":
                    double bytee=Numara2 * 1024*1024;
                    result2=String.valueOf(bytee);
                    break;
                case "kibi byte":
                    double kibibyte = Numara2 * 1024* 1024*8;
                    result2=String.valueOf(kibibyte);
                    break;
                case "bit":
                    double bit= Numara2 * 1024;
                    result2=String.valueOf(bit);
                    break;
            }
            sonuc2.setText(result2);

        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Hatalı sayı girdiniz",Toast.LENGTH_SHORT).show();
        }
    }
    private void convertAndDisplayResult3(String girisDegeri3,String type3){
        if (girisDegeri3.isEmpty()){
            Toast.makeText(getApplicationContext(),"yanlış değer girdiniz",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double tempature = Integer.parseInt(girisDegeri3);
            String result3 ="";
            if (type3.equals("Fahrenayt")){
                double fahrenayt = (tempature*9/5)+32;
                result3 =String.valueOf(fahrenayt);
            } else if (type3.equals("Kelvin")) {
                double kelvin = tempature+273.15;
                result3=String.valueOf(kelvin);


            }
            sonuc3.setText(result3);


        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"doğru sayı giriniz",Toast.LENGTH_SHORT).show();
        }

    }

}