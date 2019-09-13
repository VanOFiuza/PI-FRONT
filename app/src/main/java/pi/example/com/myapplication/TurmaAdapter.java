package pi.example.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class TurmaAdapter  extends BaseAdapter {

    private Context context;
    private List<String> lista;

    public TurmaAdapter(Context context, List<String> lista) {

        this.context = context;
        this.lista =lista;



    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lista_turmas,null);
        try {





        }catch (Exception ex){

            return view;

        }
        return view;

    }
}
