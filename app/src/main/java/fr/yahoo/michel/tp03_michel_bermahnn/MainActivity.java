package fr.yahoo.michel.tp03_michel_bermahnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonGmail;
    private Button buttonAppel;
    private Button buttonGoogle;
    private Button buttonTp01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * Methods that allow to retrieve the instance of views in the layout
     */
    private void initViews() {
        buttonGmail = findViewById(R.id.gmail);
        buttonAppel = findViewById(R.id.appel);
        buttonGoogle = findViewById(R.id.google);
        buttonTp01 = findViewById(R.id.tp01);

        // Intercept click on the GOOGLE button
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

        // Intercept click on the APPEL button
        buttonAppel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+509 36 75 31 02"));
                startActivity(intent);
                   }
        });

        // Intercept click on the GMAIL button
        buttonGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "mbermahnn@yahoo.fr");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });

        // Intercept click on the TP01 button
        buttonTp01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("gestion.mbds.CALC");
                startActivity(intent);
            }
        });


    }
}
