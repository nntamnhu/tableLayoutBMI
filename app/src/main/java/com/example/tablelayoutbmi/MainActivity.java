package com.example.tablelayoutbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtTen, edtChieuCao, edtCanNang, edtBMI, edtChuanDoan;
    Button btnBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTen = findViewById(R.id.edtTen);
        edtChieuCao = findViewById(R.id.edtChieuCao);
        edtCanNang = findViewById(R.id.edtCanNang);
        edtBMI = findViewById(R.id.edtBMI);
        edtChuanDoan = findViewById(R.id.edtChuanDoan);
        btnBMI = findViewById(R.id.btnBMI);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double chieucao = Double.parseDouble(edtChieuCao.getText()+ "");
                double cannang = Double.parseDouble(edtCanNang.getText()+ "");
                DecimalFormat dcf = new DecimalFormat("0.00");
                double BMI = cannang/Math.pow(chieucao, 2) ;

                if((chieucao==0) || (cannang==0))
                {
                    Toast.makeText(MainActivity.this, "Chiều cao, cân nặng phải khác 0", Toast.LENGTH_LONG).show();

                }
                else
                {
                    edtBMI.setText("" + dcf.format(BMI));
                    if (BMI<18){
                        edtChuanDoan.setText("Người gầy");
                    }
                    else if (BMI <=24.9){
                        edtChuanDoan.setText("Người bình thường");
                    }
                    else if (BMI <=29.9) {
                        edtChuanDoan.setText("Người béo phì cấp độ I");
                    }
                    else if (BMI <=34.9) {
                        edtChuanDoan.setText("Người béo phì cấp độ II");
                    }
                    else {
                        edtChuanDoan.setText("Người béo phì cấp độ III");
                    }

                }
            }
        });
    }
}