package ro.pub.cs.systems.eim.practicaltest01var09;

import static ro.pub.cs.systems.eim.practicaltest01var09.Constants.SUM_OF_NUMBERS;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var09SecondaryActivity extends AppCompatActivity {

    private Gobacklistener goback = new Gobacklistener();
    private class Gobacklistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(sum, null);
            finish();
        }
    }
    public int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var09_secondary);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var09_secondary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.SUM_OF_NUMBERS)) {

            String stringNumberOfClicks = intent.getStringExtra(Constants.SUM_OF_NUMBERS);
//            Log.w("Info", stringNumberOfClicks);

            String[] list = stringNumberOfClicks.split(" ");
            sum = 0;
            for (String num : list) {
                if (!num.equals("+")) {
                    sum += Integer.valueOf(num);
                }
                Log.w("Number", num);
            }
            TextView text = (TextView)findViewById(R.id.compute_second);
            text.setText(String.valueOf(sum));
            Button back = (Button)findViewById(R.id.go_back);
            back.setOnClickListener(goback);
        }

    }
}