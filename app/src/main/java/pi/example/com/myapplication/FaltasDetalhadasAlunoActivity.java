package pi.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FaltasDetalhadasAlunoActivity extends AppCompatActivity {

    private TextView txt_qtde_presenca_aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltas_detalhadas_aluno);


        txt_qtde_presenca_aluno = (TextView) findViewById(R.id.txt_qtde_presenca_aluno);


    }
}
