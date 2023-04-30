package com.example.kalkulator_rumus;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_Menu4 extends Fragment implements View.OnClickListener {

    public EditText suhu, satuanawal, satuanakhir;
    public Button btnsubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_menu4,container,false);
        suhu = (EditText) view.findViewById(R.id.suhu);
        satuanawal = (EditText) view.findViewById(R.id.satuanawal);
        satuanakhir = (EditText) view.findViewById(R.id.satuanakhir);
        btnsubmit = (Button) view.findViewById(R.id.btn_submit);
        suhu.setOnClickListener(this);
        satuanawal.setOnClickListener(this);
        satuanakhir.setOnClickListener(this);
        btnsubmit.setOnClickListener(this);
        return view;
    }

    public void onClick(View view){
        TextView Hitung = getView().findViewById(R.id.suhukonversi);

        if (view.getId() == R.id.btn_submit) {
            String Suhu = suhu.getText().toString().trim();
            String Satuanawal = satuanawal.getText().toString().trim();
            String Satuanakhir = satuanakhir.getText().toString().trim();
            boolean isEmptyFields = false;
            boolean invalidInput = false;
            if (TextUtils.isEmpty(Suhu)) {
                isEmptyFields = true;
                suhu.setError("Field ini tidak boleh kosong");
            }
            if (Integer.valueOf(Satuanawal) < 1 || Integer.valueOf(Satuanawal)> 2) {
                invalidInput = true;
                satuanawal.setError("Input tidak valid, input harus 1 atau 2");
            }
            if (Integer.valueOf(Satuanakhir) < 1 || Integer.valueOf(Satuanakhir)> 2) {
                invalidInput = true;
                satuanakhir.setError("Input tidak valid, input harus 1 atau 2");
            }
            if (!isEmptyFields && !invalidInput) {
                int SAw = Integer.valueOf(Satuanawal);
                double S = Double.valueOf(Suhu);
                int SAk = Integer.valueOf(Satuanakhir);
                double konversi = 0.0000;

                //Memilih percepatan gravitasi (soalnya soal fisika sering pakai 9,8 m/(s^2) dan 10 m/(s^2))
                if(SAw == 1) {
                    if (SAk == 1) {
                        konversi = S;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 2) {
                        konversi = ((S / 5) * 9) + 32;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 3) {
                        konversi =  ((S / 5) * 4);
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 4) {
                        konversi = (S + 273) ;
                        Hitung.setText(String.valueOf(konversi));
                    }
                } else if(SAw == 2) {
                    if (SAk == 1) {
                        konversi = ((S - 32) / 9) * 5;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 2) {
                        konversi = S;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 3) {
                        konversi = ((S - 32) / 9) * 4;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 4) {
                        konversi = (((S - 32) / 9) * 5) + 273;
                        Hitung.setText(String.valueOf(konversi));
                    }
                }else if(SAw == 3) {
                    if (SAk == 1) {
                        konversi = (S / 4) * 5;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 2) {
                        konversi = ((S / 4) * 9) + 32;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 3) {
                        konversi = ((S / 4) * 5) + 273;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 4) {
                        konversi = (S - 273);
                        Hitung.setText(String.valueOf(konversi));
                    }
                }else if(SAw == 4) {
                    if (SAk == 1) {
                        konversi = (S - 273);
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 2) {
                        konversi = ((S - 273) / 5) * 9 + 32;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 3) {
                        konversi = ((S - 273) /5) * 4;
                        Hitung.setText(String.valueOf(konversi));
                    } else if (SAk == 4) {
                        konversi = S;
                        Hitung.setText(String.valueOf(konversi));
                    }
                }
            }
        }
    }
}
