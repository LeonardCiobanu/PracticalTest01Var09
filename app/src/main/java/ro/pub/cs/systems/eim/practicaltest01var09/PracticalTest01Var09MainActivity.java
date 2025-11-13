package ro.pub.cs.systems.eim.practicaltest01var09;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var09MainActivity extends AppCompatActivity {

    private EditText next_term;
    private Button add;
    private TextView all_terms;
    private Button compute;

    private AddButtonListener addButtonListener = new AddButtonListener();
    private class AddButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            int next_term_string = 0;
            try {
                next_term_string = Integer.valueOf(next_term.getText().toString());
                if (all_terms.getText().equals("")) {
                    all_terms.setText(String.valueOf(next_term_string));
                } else {
                    all_terms.setText(all_terms.getText() + " + " + next_term_string);
                }
                next_term.setText("");
            } catch (Exception e) {

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test_01_var09_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        next_term = (EditText)findViewById(R.id.next_term);
        add = (Button)findViewById(R.id.add);
        all_terms = (TextView) findViewById(R.id.all_terms);
        compute = (Button)findViewById(R.id.compute);

        add.setOnClickListener(addButtonListener);
    }
}