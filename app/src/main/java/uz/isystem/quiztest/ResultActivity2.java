package uz.isystem.quiztest;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity2 extends AppCompatActivity implements View.OnClickListener {


    public static final String KEY_TRUES = "trues";
    public static final String KEY_MISTAKES = "mistakes";
    public static final String KEY_TYPE = "type";

    private TextView NameType, Trues, Mistakes, starView;
    private Button menuButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        backButton = findViewById(R.id.back_button);
        menuButton = findViewById(R.id.menu_button);
        menuButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        int trues = bundle.getInt(KEY_TRUES);
        int mistakes = bundle.getInt(KEY_MISTAKES);
        String type = bundle.getString(KEY_TYPE);

        starView = findViewById(R.id.star_view);
        NameType = findViewById(R.id.name_test);
        Trues = findViewById(R.id.true_result);
        Mistakes = findViewById(R.id.mistakes_result);

        NameType.setText("" + type);
        Trues.setText("" + trues);
        Mistakes.setText("" + mistakes);

        if (trues <= 1) {
            starView.setText("");
        } else if (trues > 1 && trues <= 3) {
            starView.setText("⭐️⭐️");
        } else if (trues > 3 && trues <= 5) {
            starView.setText("⭐️⭐️⭐️️");
        } else if (trues > 5 && trues < 8) {
            starView.setText("⭐️⭐️⭐️⭐️");
        } else {
            starView.setText("⭐️⭐️⭐️⭐⭐️");
        }
    }

    @Override
    public void onClick(View view) {

    }
}