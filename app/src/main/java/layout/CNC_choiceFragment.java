package layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import com.example.marcosantonio.cnc_machinist.R;
import android.text.TextUtils;
import android.widget.*;
import java.text.DecimalFormat;

public class CNC_choiceFragment extends AppCompatActivity implements View.OnClickListener {

    // Declarar variáveis

    TextView txt8, txt9, txtcnv, txtcnc;
    EditText n1, n2, n3, n4, n5;
    Button ex, rs;
    Double v1, v2, v3, v4, v5;
    String cnv, cnc, hs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cnc_choice);

        // find elements

        txt8 = (TextView) findViewById(R.id.textView8);
        txt9 = (TextView) findViewById(R.id.textView9);
        txtcnv = (TextView) findViewById(R.id.textView10);
        txtcnc = (TextView) findViewById(R.id.textView11);

        n1 = (EditText) findViewById(R.id.editText1);
        n2 = (EditText) findViewById(R.id.editText2);
        n3 = (EditText) findViewById(R.id.editText3);
        n4 = (EditText) findViewById(R.id.editText4);
        n5 = (EditText) findViewById(R.id.editText5);

        ex = (Button) findViewById(R.id.button1);
        rs = (Button) findViewById(R.id.button2);

        ex.setOnClickListener(this);
        rs.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        float v1 = 0;
        float v2 = 0;
        float v3 = 0;
        float v4 = 0;
        float v5 = 0;
        float r1 = 0;
        float r2 = 0;
        DecimalFormat df = new DecimalFormat("0.00");

        // check if the fields are empty
        if (TextUtils.isEmpty(n1.getText().toString())
                || TextUtils.isEmpty(n2.getText().toString())
                || TextUtils.isEmpty(n3.getText().toString())
                || TextUtils.isEmpty(n4.getText().toString())
                || TextUtils.isEmpty(n5.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        v1 = Float.parseFloat(n1.getText().toString());
        v2 = Float.parseFloat(n2.getText().toString());
        v3 = Float.parseFloat(n3.getText().toString());
        v4 = Float.parseFloat(n4.getText().toString());
        v5 = Float.parseFloat(n5.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.button1:
                r1 = (v2 + (v1 * v3));
                r2 = (v4 + (v1 * v5));
                txtcnv.setText("CNV" + " " + " " + df.format(r1) + "hs");
                txtcnc.setText("CNC" + " " + " " + df.format(r2) + "hs");
                break;
            case R.id.button2:
                n1.setText("");
                n2.setText("");
                n3.setText("");
                n4.setText("");
                n5.setText("");
                txtcnv.setText("");
                txtcnc.setText("");
                break;
            default:
                break;
        }

    }
}
