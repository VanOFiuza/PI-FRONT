package pi.example.com.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    public Spinner tipo_usuario;
    public String str_tipo_usuario;
    private Button btnLogin ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cliente);
        setSupportActionBar(toolbar);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        tipo_usuario = (Spinner) findViewById(R.id.spn_tipo_usuario);

        List<String> lista = new ArrayList<>();
        lista.add("ALUNO");
        lista.add("PROFESSOR");
        lista.add("ADMINISTRADOR");
        try {
            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(

                    this, R.layout.support_simple_spinner_dropdown_item, lista) {

                @Override
                public View getDropDownView(int position, View convertView,
                                            ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;

                    if (position % 2 == 1) {
                        // Set the item background color
                        tv.setBackgroundColor(Color.parseColor("#f2f2f2"));
                    } else {
                        // Set the alternate item background color
                        tv.setBackgroundColor(Color.parseColor("#cccccc"));
                    }
                    return view;
                }

            };
            spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            tipo_usuario.setAdapter(spinnerArrayAdapter);

        } catch (Exception ex)

        {
            ex.printStackTrace();
            Toast.makeText(this, "ERRO: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        tipo_usuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedItemText = (String) parent.getItemAtPosition(position);
                str_tipo_usuario = selectedItemText;

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str_tipo_usuario.equals("ALUNO")){
                    Intent intent = new Intent(LoginActivity.this, AlunoMenuACtivity.class);
                    startActivity(intent);
                    finish();
                }
                if(str_tipo_usuario.equals("PROFESSOR")){
                    Intent intent = new Intent(LoginActivity.this, ProfessorMenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


}
