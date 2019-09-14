package pi.example.com.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExemploRequisicao extends AsyncTask<Void, Void, String> {

    private Context context;
    private ProgressDialog alertDialog;

    private ProfessorChamadaActivity cadastroProspect;

    String cnpj;

    public Context getContext() {
        return this.context;
    }

    public ExemploRequisicao(Context context, String cnpj) {

        this.context = context;
        this.cnpj = cnpj;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog = ProgressDialog.show(context, "Aguarde", "Carregando", true, true);

    }

    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        String requisicao = "https://www.receitaws.com.br/v1/cnpj/" + cnpj;

        Log.d("URL REQUISICAO", requisicao);

        String resposta = client.post(requisicao, null, context, "GET");


        return resposta;
    }


    @Override
    protected void onPostExecute(String s) {

        try {
            Gson g = new Gson();
            if (!s.isEmpty()) {

                JsonObject j = g.fromJson(s, JsonObject.class);
                JsonObject jsonObject = new JsonObject();

                Log.d("OLHA AQUIIIIIIII", s);
                Log.d("NOME FANTASIA", j.get("nome").toString());

                ProfessorChamadaActivity act = (ProfessorChamadaActivity) context;


                TextView nome_fantasia = (TextView) act.findViewById(R.id.edt_presentes);
                TextView razao_social = (TextView) act.findViewById(R.id.edt_ausentes);




                nome_fantasia.setText(j.get("nome").toString().replaceAll("\"", ""));
                razao_social.setText(j.get("abertura").toString().replaceAll("\"", ""));





            } else {
                Toast.makeText(context, "CNPJ INVÁLIDO", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(context, "ERRO: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        alertDialog.dismiss();

    }
}


