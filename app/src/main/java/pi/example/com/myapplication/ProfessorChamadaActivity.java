package pi.example.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProfessorChamadaActivity extends AppCompatActivity {

    private ListView list_alunos;
    private ImageView btn_salva_chamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_chamada);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cliente);
        setSupportActionBar(toolbar);

        list_alunos = (ListView) findViewById(R.id.list_alunos);
        btn_salva_chamada = (ImageView) findViewById(R.id.btn_salva_chamada);
        List<String> lista = new ArrayList<>();
        for(int i = 0 ; i<= 15 ; i++){
            lista.add("BATATA");
        }

        AlunosAdpter adapter = new AlunosAdpter(this, lista);
        list_alunos.setAdapter(adapter);
        btn_salva_chamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfessorChamadaActivity.this, ProfessorMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        new ExemploRequisicao(ProfessorChamadaActivity.this,"03253670000108").execute();
    }
}
