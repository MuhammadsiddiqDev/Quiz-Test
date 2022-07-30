package uz.isystem.quiztest;


import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuizActivity2 extends AppCompatActivity {


    private final ArrayList<QuestionData> data = new ArrayList<>();
    boolean isFinished = false;
    private SeekBar seekBar;
    private TextView currentView, totalView, checkButton, questionView;
    private RadioGroup answerGroup;
    private RadioButton variantA;
    private RadioButton variantB;
    private RadioButton variantC;
    private RadioButton variantD;
    private LinearLayout linearLayout;
    private boolean isAnswered = false;
    private Button buttonFinish, resultButton;
    private int ChooseTests;
    private String Name = "";
    private QuestionMenger manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        loadViews();
        setStateView();
        setListener();
        choseLesson();

        manager = new QuestionMenger(data);
        startQuiz();
    }

    private void choseLesson() {
        Bundle bundle = getIntent().getExtras();

        this.ChooseTests = bundle.getInt(MainActivity.LESSON);

        if (ChooseTests == 1) {
            loadDataMix();
            Name = "Aralash";
        } else if (ChooseTests == 2) {
            loadDataMath();
            Name = "Matematika";
        } else if (ChooseTests == 3) {
            loadDataEngland();
            Name = "Ingiliz";
        } else {
            loadDataGeographic();
            Name = "Geografiya";
        }

    }

    private void startQuiz() {
        questionView.setText(manager.getQuestion());
        variantA.setText(manager.getVariantA());
        variantB.setText(manager.getVariantB());
        variantC.setText(manager.getVariantC());
        variantD.setText(manager.getVariantD());

        currentView.setText(String.valueOf(manager.getCurrentLevel()));
        totalView.setText(String.valueOf(manager.getTotal()));

        seekBar.setProgress(manager.getCurrentLevel() * 100 / manager.getTotal());
    }

    private void clearView() {
        variantA.setBackgroundResource(R.drawable.radio_back);
        variantB.setBackgroundResource(R.drawable.radio_back);
        variantC.setBackgroundResource(R.drawable.radio_back);
        variantD.setBackgroundResource(R.drawable.radio_back);

        variantA.setEnabled(true);
        variantB.setEnabled(true);
        variantC.setEnabled(true);
        variantD.setEnabled(true);

        answerGroup.clearCheck();
    }

    private void loadDataMix() {
        data.add(new QuestionData(
                "Chin so'z mo'tabar,Yaxshi so'z... Maqolni davom ettiring.",
                "muxtasar",
                "muqaddas",
                "masih",
                "muxtasar",
                "mufattar"
        ));
        data.add(new QuestionData(
                "Har bir millat hayoti davomida aloqa-aralashuv vositasi sifatida asosan nechta tildan foydalanadi?",
                "bitta",
                "bitta",
                "bir nechta",
                "Ikkita",
                "uchta"
        ));
        data.add(new QuestionData(
                "Eronda qaysi tilda gaplashiladi? ",
                "fors",
                "ingiliz",
                "arab",
                "fors",
                "rus"
        ));
        data.add(new QuestionData(
                "Dunyodagi eng aholisi ko'p davlat nomini tanlang? ",
                "Xitoy",
                "Xitoy",
                "Russia",
                "USA",
                "Hindiston"
        ));
        data.add(new QuestionData(
                "Dunyodagi eng kichkina davlat nomini toping?",
                "Vatikan",
                "Monaco",
                "Lixtenshiteyn",
                "Vatikan",
                "Bosniya"
        ));
        data.add(new QuestionData(
                "Til - dil... Maqolni davom ettiring",
                "kaliti",
                "ozig'i",
                "kaliti",
                "qulfi",
                "oynasi"
        ));
        data.add(new QuestionData(
                "Qachon o'zbek tiliga davlat tili maqomi berilgan?",
                "1989-yil 21-oktiyabrda",
                "1991-yil 31-avgustda'i",
                "1989-yil 21-oktiyabrda",
                "1989-yil 1-okyiyabrda",
                "1990-yil 8-dekabirda"
        ));
        data.add(new QuestionData(
                "Olimlarning hisob kitobiga ko'ra,yer yuzida taxminan nechta til mavjud?",
                "7000 dan ortiq",
                "3000 dan ortiq",
                "6000 dan ortiq",
                "7000 dan ortiq",
                "1000 dan ortiq"
        ));
        data.add(new QuestionData(
                "Til qanday hodisa?",
                "ijtimoiy",
                "tarixiy",
                "tabiy",
                "fizik",
                "ijtimoiy"
        ));
        data.add(new QuestionData(
                "Ona tilim - jonimga masih. <Masih> so'zining ma'nosi nima?",
                "tiriltirguvchi",
                "qisqa",
                "baxt berguchi",
                "tuzatuvchi",
                "tiriltirguvchi"
        ));
    }

    private void loadDataEngland() {
        data.add(new QuestionData(
                "Our  homework______ very   difficult  yesterday,but  today  It _____easy",
                "Was/is",
                "Were/is",
                "Will/like",
                "Was/was",
                "Was/is"));
        data.add(new QuestionData(
                "______was  she  born? She  was  born  in  Uzbekistan.",
                "Where",
                "When",
                "What",
                "Who",
                "Where"
        ));
        data.add(new QuestionData(
                "The  weather____nice  today,  but  it  _____nasty  yesterday.",
                "Is/was",
                "Is/was",
                "Are/was",
                "Isn’t/were",
                "Was/was"

        ));
        data.add(new QuestionData(
                "He_____some  new  shoes  last  month.",
                "bought",
                "Were bought",
                "bought",
                "Were buy",
                "Buy"

        ));
        data.add(new QuestionData(
                "The  students________very  tired  today.",
                "are",
                "Was",
                "are",
                "Were being",
                "Is"

        ));
        data.add(new QuestionData(
                "How  old _________you  in1990? I  _______10,but  now  I  _____25",
                "Were/was/am",
                "Was/was/am",
                "Are/was/is",
                "Were/was/am",
                "Were/were/am"


        ));
        data.add(new QuestionData(
                "Where____they  born? They_____born in  1999",
                "Were/were",
                "Was/were",
                "Was/am",
                "Was/was",
                "Were/were"

        ));
        data.add(new QuestionData(
                "_______could  you  do  when  you ____seven.",
                "What/were",
                "Where/was",
                "What/was",
                "What/were",
                "Were/was"

        ));
        data.add(new QuestionData(
                "____languages  do  you  know?",
                "How  many",
                "How  much",
                "How  many",
                "Where",
                "Whose"

        ));
        data.add(new QuestionData(
                "Past  simple  zamoniga  oid  gapni  aniqlang.",
                "She  had  a  new  car",
                "She  has  anew  car",
                "She  had  a  new  car",
                "She  have  anew  car",
                "She  has  had  a  new  car"
        ));
    }

    private void loadDataMath() {
        data.add(new QuestionData(
                "Sonlarni yozishda nechta raqam ishlatiladi.",
                " 10ta",
                " 5ta",
                " 9ta",
                " 10ta",
                " 20ta"
        ));
        data.add(new QuestionData(
                "Natural sonlar qatoriga eng kichik natural son qaysi.",
                "1 ta",
                "1 ta",
                "0 ta",
                "2 ta",
                "4 ta"));
        data.add(new QuestionData(
                "Uchburchakning nechta tomoni bor.",
                "3ta",
                "4ta",
                "3ta",
                "2ta",
                "5ta"

        ));
        data.add(new QuestionData(
                "Bir santimetr necha milimetrga teng.",
                "10mm",
                "10mm",
                "100mm",
                "1000mm",
                "1mm"
        ));
        data.add(new QuestionData(
                "ikki million besh yuz oltiming uchyuzi yetmish yetti soni necha xonali.",
                "Yetti",
                "Olti",
                "Besh",
                "Yetti",
                "Sakkiz"
        ));
        data.add(new QuestionData(
                "Kesma bir uchi cheksiz davom etirilsa qanday shakl hosil bo’ladi.",
                "Nur",
                "Kesma",
                "Nur",
                "To’g’ri Chiziq",
                "Tekslik"
        ));
        data.add(new QuestionData(
                "74573+4705 misolni javobini  toping ",
                "79278",
                "80900",
                "79278",
                "79274",
                "76095"
        ));
        data.add(new QuestionData(
                " 12soni  qaysi tenglamani ildizi",
                "X-3=12",
                "X+3=12",
                "X+13=25",
                "X+6=12",
                "X-3=12"

        ));
        data.add(new QuestionData(
                "a 2158-599 misolning javobini toping.",
                "1559",
                "1558 ",
                "1560",
                "1599",
                "1559"

        ));
        data.add(new QuestionData(
                "128-x-89 ifodani soddalashtiring.",
                "39-X",
                "180-X",
                "39-X",
                "40-X",
                "60-X"

        ));
    }

    private void loadDataGeographic() {
        data.add(new QuestionData(
                "Geografiya qaysi so'zdan olingan? ",
                "yunoncha",
                "yunoncha",
                "grekcha",
                "ispan",
                "fransus"

        ));
        data.add(new QuestionData(
                "Geografiya fani bilan shug'ullanuvchilarni kimlar deb ataymiz? ",
                "geograflar",
                "geologlar",
                "olimlar",
                "geograflar",
                "iqtisodchilar"

        ));
        data.add(new QuestionData(
                "Qaysi hududda yil bo'yi bir xil ob- havo kuzatiladi? ",
                "ekvatorda",
                "mo'tadil mintaqada",
                "tropikda",
                "cho'lda",
                "ekvatorda"

        ));
        data.add(new QuestionData(
                "Yerning tasviri asarini kim yozgan?",
                "Xorazmiy",
                "Qoshg'ariy",
                "Xorazmiy",
                "Beruniy",
                "Eratosfen"

        ));
        data.add(new QuestionData(
                "Oy yer atrofini qancha vaqtda aylanib chiqadi?",
                "Deyarli 1 oyda 1 marta",
                "Deyarli 1  yilda",
                "Deyarli 1 oyda 1 marta",
                "2 oyda",
                "15 kunda"

        ));
        data.add(new QuestionData(
                "Quyosh sistemasi o'rtasida nima joylashgan?",
                " Quyosh",
                "oy",
                "yer",
                " Quyosh",
                "yulduzlar"

        ));
        data.add(new QuestionData(
                "Quyosh atrofida nechta sayyora aylanib turadi?",
                "8 ta",
                "6 ta",
                "7 ta",
                "8 ta",
                "9 ta"

        ));
        data.add(new QuestionData(
                "Quyoshga eng uzoq sayyora qaysi?",
                "Neptun",
                "Mars",
                "Neptun",
                "Saturn",
                "Merkuriy"

        ));
        data.add(new QuestionData(
                "Yangi oy qachon qaysi tomondan ko'rinadi?",
                "Quyosh botgandan keyin g'arb  tomondan",
                "Quyosh botgandan keyin g'arb  tomondan",
                "quyosh botgandan keyin sharq  tomondan",
                "quyosh botmasdan   g'arb  tomonda",
                "quyosh  botmasdan  sharqdan"

        ));
        data.add(new QuestionData(
                "Oltin  qoziq  yulduzini yana qanday nom bilan   ataymiz?",
                "Qutb  yulduzi",
                "Katta ayiq",
                "Zuxro",
                "Qutb  yulduzi",
                "Ufq tomoni"

        ));
    }

    private void setListener() {

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int trueCount = manager.getTotalTrue();
                int falseCount = manager.getTotalFalse();

                String TypeName = Name;
                Bundle bundle = new Bundle();

                bundle.putInt(ResultActivity2.KEY_TRUES, trueCount);
                bundle.putInt(ResultActivity2.KEY_MISTAKES, falseCount);
                bundle.putString(ResultActivity2.KEY_TYPE, TypeName);

                Intent intent = new Intent(QuizActivity2.this, ResultActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int trueCount = manager.getTotalTrue();
                int falseCount = manager.getTotalFalse();

                String TypeName = Name;
                Bundle bundle = new Bundle();

                bundle.putInt(ResultActivity2.KEY_TRUES, trueCount);
                bundle.putInt(ResultActivity2.KEY_MISTAKES, falseCount);
                bundle.putString(ResultActivity2.KEY_TYPE, TypeName);

                Intent intent = new Intent(QuizActivity2.this, ResultActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasPressed = variantA.isChecked() || variantB.isChecked() || variantC.isChecked() || variantD.isChecked();
                if (isFinished) {
                    finish();
                } else {
                    if (hasPressed) {
                        if (isAnswered) {
                            if (manager.hasNextQuestion()) {
                                clearView();
                                startQuiz();
                                checkButton.setText("    Tanlash    ");
                            } else {
                                isFinished = true;
                                checkButton.setText("    Natija    ");
                                linearLayout.setVisibility(View.VISIBLE);
                                buttonFinish.setEnabled(false);
                                checkButton.setEnabled(false);

                            }
                            isAnswered = false;
                        } else {
                            RadioButton button = findViewById(answerGroup.getCheckedRadioButtonId());
                            String answer = button.getText().toString();
                            boolean isTrue = manager.checkAnswer(answer);
                            if (isTrue) {
                                button.setBackgroundResource(R.drawable.radio_back_green);
                            } else {
                                button.setBackgroundResource(R.drawable.radio_back_red);
                            }
                            variantA.setEnabled(variantA.isChecked());
                            variantB.setEnabled(variantB.isChecked());
                            variantC.setEnabled(variantC.isChecked());
                            variantD.setEnabled(variantD.isChecked());

                            checkButton.setText("   Keyingisi   ");
                            isAnswered = true;
                        }
                    } else {
                        Toast.makeText(QuizActivity2.this, "choose one of answer!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void loadViews() {
        seekBar = findViewById(R.id.seek_bar);
        currentView = findViewById(R.id.current_question);
        totalView = findViewById(R.id.total_question);

        linearLayout = findViewById(R.id.result_view);

        buttonFinish = findViewById(R.id.finish_test);
        checkButton = findViewById(R.id.check_answer);
        questionView = findViewById(R.id.question_view);

        resultButton = findViewById(R.id.result_button);
        answerGroup = findViewById(R.id.answer_group);

        variantA = findViewById(R.id.answer_a);
        variantB = findViewById(R.id.answer_b);
        variantC = findViewById(R.id.answer_c);
        variantD = findViewById(R.id.answer_d);


    }

    private void setStateView() {
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void openResult(View view) {
    }
}