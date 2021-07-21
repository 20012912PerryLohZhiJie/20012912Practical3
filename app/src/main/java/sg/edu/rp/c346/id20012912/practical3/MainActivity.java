package sg.edu.rp.c346.id20012912.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText name, amount;
    TextView sales;
    Button btngo;
    ListView lv;
    ArrayList<Client> al;
    ListView Lv;
    ArrayAdapter<Client> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editname);
        amount = findViewById(R.id.editamt);
        sales = findViewById(R.id.textviewsales);
        btngo = findViewById(R.id.btngo);
        Lv = findViewById(R.id.lv);

        al = new ArrayList<Client>();
        aa = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btngo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String data = name.getText().toString();
                int cash = Integer.parseInt(amount.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);

                long inserted_client = dbh.insertClient(data, cash);

                if (inserted_client != null)
                {

                    al.clear();
                    al.addAll(dbh.getClients());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
                lv.setText("Total sales Potential: "+inserted_cleint);
            }
        });




    }
}