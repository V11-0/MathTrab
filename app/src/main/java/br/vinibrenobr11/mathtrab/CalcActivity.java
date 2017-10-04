package br.vinibrenobr11.mathtrab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // If exists some ActionBar, the arrow is show to go back
        if (!(getSupportActionBar() == null)) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Get the EditTexts from layout file
        final EditText edt_fav = (EditText) findViewById(R.id.edt_second_one);
        final EditText edt_tot = (EditText) findViewById(R.id.edt_second_two);

        // Get one button
        Button button = (Button) findViewById(R.id.btn_calc2);

        // And get the TextView where the result will be show
        final TextView result = (TextView) findViewById(R.id.result_text);

        // When the button is clicked...
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // See if EditTexts are empty
                if (!(TextUtils.isEmpty(edt_fav.getText())
                        || TextUtils.isEmpty(edt_tot.getText()))) {

                    // Get values from them
                    /*
                    One is a float Because, being a int, the result will not give
                    decimal, being not correct
                     */
                    int na = Integer.parseInt(edt_fav.getText().toString());
                    float n = Float.parseFloat(edt_tot.getText().toString());

                    float res = na / n * 100;

                    // Print the result in TextView
                    result.setText(getString(R.string.res, res));
                } else {
                    // If one of the text fields is empty, a Toast will notify
                    Toast.makeText(getApplicationContext(), getString(R.string.empty),
                            Toast.LENGTH_SHORT).show();
                }

                // Get and define an action for this button
                // And it is to clean the EditTexts and the result TextView
                Button lim = (Button) findViewById(R.id.btn_calc_c);

                lim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edt_fav.setText("");
                        edt_tot.setText("");
                        result.setText("");
                    }
                });
            }
        });
    }
}
