package pdm.ifpb.edu.br.projetotiago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AppActivity extends AppCompatActivity {

    private TextView tvApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        this.tvApp = (TextView)findViewById(R.id.tvApp);

    }
}
