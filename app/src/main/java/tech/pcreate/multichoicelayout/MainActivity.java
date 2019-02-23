package tech.pcreate.multichoicelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MultiChoiceLayout.MultiChoiceOnclick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //click Listener
        MultiChoiceLayout languageOptionsLayout = findViewById(R.id.languageChoices);
        languageOptionsLayout.setOnClickListener(this);

        /* MultiChoiceLayout justOneChoice = findViewById(R.id.justOneChoice);
        justOneChoice.setOnClickListener(this);

        MultiChoiceLayout monthsChoices = findViewById(R.id.monthchoices);
        monthsChoices.setOnClickListener(this);

        MultiChoiceLayout timeChoices = findViewById(R.id.timechoices);
        timeChoices.setOnClickListener(this);

        */
    }

    @Override
    public void onMultiChoiceLayoutClick() {
        int optionClicked = MultiChoiceLayout.getSelection();
        Toast.makeText(this, "Clicked option: " + String.valueOf(optionClicked), Toast.LENGTH_SHORT).show();
    }

}
