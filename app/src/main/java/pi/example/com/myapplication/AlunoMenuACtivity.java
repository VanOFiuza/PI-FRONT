package pi.example.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AlunoMenuACtivity extends AppCompatActivity {

    private ListView list_disciplinas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_menu_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cliente);
        setSupportActionBar(toolbar);


         List<String> lista = new ArrayList<>();
        for(int i = 0 ; i<= 15 ; i++){
            lista.add("BATATA");
        }
        list_disciplinas = (ListView) findViewById(R.id.list_disciplinas);
        DisciplinaAdapter adapter = new DisciplinaAdapter(lista, this);
        list_disciplinas.setAdapter(adapter);

        list_disciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AlunoMenuACtivity.this, FaltasDetalhadasAlunoActivity.class);
                startActivity(intent);
            }
        });


    }
}
