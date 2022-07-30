package uz.isystem.quiztest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int test1 = 1;
    private static final int test2 = 2;
    private static final int test3 = 3;
    private static final int test4 = 4;
    public static String LESSON = "Tests";
    Bundle bundle = new Bundle();
    private Button Geographic, Math, Mix, Exit, English;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadButton();

        Geographic.setOnClickListener(this);
        Math.setOnClickListener(this);
        Mix.setOnClickListener(this);
        Exit.setOnClickListener(this);
        English.setOnClickListener(this);
    }


    private void loadButton() {
        Geographic = findViewById(R.id.geographic_button);
        English = findViewById(R.id.english_button);
        Math = findViewById(R.id.math_button);
        Mix = findViewById(R.id.mix_button);
        Exit = findViewById(R.id.exit_button);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.mix_button: {
                Intent intent = new Intent(MainActivity.this, QuizActivity2.class);
                bundle.putInt(LESSON, test1);
                intent.putExtras(bundle);

                startActivity(intent);
                break;

            }
            case R.id.math_button: {
                Intent intent = new Intent(MainActivity.this, QuizActivity2.class);
                bundle.putInt(LESSON, test2);
                intent.putExtras(bundle);

                startActivity(intent);
                break;

            }
            case R.id.english_button: {
                Intent intent = new Intent(MainActivity.this, QuizActivity2.class);
                bundle.putInt(LESSON, test3);
                intent.putExtras(bundle);

                startActivity(intent);
                break;

            }
            case R.id.geographic_button: {
                Intent intent = new Intent(MainActivity.this, QuizActivity2.class);
                bundle.putInt(LESSON, test4);
                intent.putExtras(bundle);

                startActivity(intent);
                break;
            }
            case R.id.exit_button: {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("\n" +
                        "\n" +
                        "O'yindan chiqish!!!\n").setMessage("Siz rostan ham o'yindan chiqishni istaysizmi\n\n\uD83E\uDDD0Aminmisiz!!");
                builder.setPositiveButton("Ha", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Orqaga", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create().show();
            }
            break;
        }
    }
}