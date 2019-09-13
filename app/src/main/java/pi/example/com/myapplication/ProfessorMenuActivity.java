package pi.example.com.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment.OnDateSetListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProfessorMenuActivity extends AppCompatActivity implements OnDateSetListener {

    private ListView list_turmas;
    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";
    private CalendarDatePickerDialogFragment cdp;
    private Dialog dialog_tipo_chamdada;
    private TextView teste;

    //DIALOG

    private LinearLayout ll_qr_code, ll_manual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_menu);

        list_turmas = (ListView) findViewById(R.id.list_turmas);

        teste = (TextView) findViewById(R.id.teste);

        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(ProfessorMenuActivity.this);
                cdp.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cliente);
        setSupportActionBar(toolbar);
        List<String> lista = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            lista.add("BATATA");
        }
        TurmaAdapter adapter = new TurmaAdapter(this, lista);
        list_turmas.setAdapter(adapter);

        list_turmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(ProfessorMenuActivity.this, ProfessorChamadaActivity.class);
//                startActivity(intent);
//                cdp = new CalendarDatePickerDialogFragment()
//                        .setOnDateSetListener(ProfessorMenuActivity.this);
//                cdp.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);

                dialog_seleciona_tipo_chamada();
            }
        });


    }
    private void dialog_seleciona_tipo_chamada(){

        dialog_tipo_chamdada  = new Dialog(this);
        dialog_tipo_chamdada.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_tipo_chamdada.setContentView(R.layout.dialog_tipo_chamada);
        dialog_tipo_chamdada.setTitle("My Custom Dialog");

        ll_manual   = (LinearLayout) dialog_tipo_chamdada.findViewById(R.id.ll_manual);
        ll_qr_code  = (LinearLayout) dialog_tipo_chamdada.findViewById(R.id.ll_qr_code);

        ll_qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfessorMenuActivity.this, ProfessorChamadaActivity.class);
                startActivity(intent);
            }
        });

        ll_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfessorMenuActivity.this, ProfessorChamadaActivity.class);
                startActivity(intent);
            }
        });

        dialog_tipo_chamdada.show();
    }


    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {

    }

}
