package layout;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.marcosantonio.cnc_machinist.R;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_1 extends Fragment implements View.OnClickListener{
    private TextView lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21;
    private RadioGroup rgSelection;
    private RadioButton rdUp, rdDown;
    private EditText n1, n2;
    private Button ex, rs;
    private Double  i;
    private Integer dn1;
    private String op = "", txt = "", inc;

    public Fragment_1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_1, container, false);

        rgSelection = ((RadioGroup) view.findViewById(R.id.radiogroup));
        final RadioButton rdDown = (RadioButton) view.findViewById(R.id.radioButton);
        final RadioButton rdUp = (RadioButton) view.findViewById(R.id.radioButton2);
        lbl12 = (TextView) view.findViewById(R.id.textView12);
        lbl13 = (TextView) view.findViewById(R.id.textView13);
        lbl14 = (TextView) view.findViewById(R.id.textView14);
        lbl15 = (TextView) view.findViewById(R.id.textView15);
        lbl16 = (TextView) view.findViewById(R.id.textView16);
        lbl17 = (TextView) view.findViewById(R.id.textView17);
        lbl18 = (TextView) view.findViewById(R.id.textView18);
        lbl19 = (TextView) view.findViewById(R.id.textView19);
        lbl20 = (TextView) view.findViewById(R.id.textView20);
        lbl21 = (TextView) view.findViewById(R.id.textView21);

        final EditText n1 = (EditText) view.findViewById(R.id.editText1);
        final EditText n2 = (EditText) view.findViewById(R.id.editText2);

        ex = (Button) view.findViewById(R.id.button1);
        rs = (Button) view.findViewById(R.id.button2);

        // Set a listener
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v1 = 0;
                float v2 = 0;
                int den = 0;
                double r12 = 0;
                int r13 = 0;
                double r14 = 0;
                float r15 = 0;
                int r16 = 0;
                int r18 = 0;
                int r19 = 0;
                float r20 = 0;
                int c = 0;
                double pol = 25.4;
                DecimalFormat df = new DecimalFormat("0.0000");
                DecimalFormat df2 = new DecimalFormat("0.00");

                if (n1.getText().toString().equals("") || n2.getText().toString().equals("")) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
                    dlg.setMessage(R.string.Message);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                    return;
                }

                v1 = Double.parseDouble(n1.getText().toString());
                v2 = Float.parseFloat(n2.getText().toString());

                //
                        dn1 = (int) (v2);//denominador da polegada

                if ((dn1 != 128) && (dn1 != 64) && (dn1 != 32) && (dn1 != 16) && (dn1 != 8) && (dn1 != 4) && (dn1 != 2)) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
                    dlg.setMessage(R.string.Message2);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                } else {

                            op = "/";
                            inc = "'";
                            den = (int)v2;//denominador da polegada
                            r12 = (v1 / pol);//polegada decimal
                            r13 = (int) r12;//medida em mm / 25.4 (encontra polegadas inteiras)
                            r14 = (r12 - r13);//polegada decimal - polegadas inteiras
                            r15 = (1/v2);//precisão da polegada fracionaria em decimal
                            if (rdDown.isChecked()) {
                                r16 = (int)(r14/r15);//novo numerador ((polegada decimal bruta (256.21...) / polegada decimal desejada (128))
                            } else {
                                r16 = (int)((r14/r15)+1);//novo numerador ((polegada decimal bruta (256.21...) / polegada decimal desejada (128))
                            }
                            c = gcd(r16, den);//maior divisor comum do numerador e denominador brutos
                            r18 = (r16 / c);
                            r19 = (den / c);
                            r20 = (float)(((r12-r14)+(r16/v2))*pol);
                            lbl12.setText(txt + df.format(r12));
                            lbl13.setText(txt + r13);
                            lbl14.setText(txt + df.format(r14));
                            lbl15.setText(txt + (r15));
                            lbl16.setText(txt + r16);
                            lbl17.setText(r16 + op + den);
                            lbl18.setText(txt + r18 + op + r19);
                            if ((r13 == 0)&&(r18 != r19)) {
                                lbl19.setText(txt + r18 + op + r19 + inc + inc);
                            } else if ((r13 == 0) && (r18 == r19)) {
                                lbl19.setText(txt + 1 + inc + inc);
                            } else if ((r13 != 0) && (r18 != r19)) {
                                lbl19.setText(txt + r13 + " " + r18 + op + r19 + inc + inc);
                            } else if ((r13 != 0) && (r18 == r19)) {
                                lbl19.setText(txt + (r13 + 1) + inc + inc);
                            }
                            lbl20.setText(txt + df2.format(r20));
                        }}


        });
        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1.setText("");
                n2.setText("");
                lbl12.setText("");
                lbl13.setText("");
                lbl14.setText("");
                lbl15.setText("");
                lbl16.setText("");
                lbl17.setText("");
                lbl18.setText("");
                lbl19.setText("");
                lbl20.setText("");
                n1.requestFocus();
                rdDown.requestFocus();
            }
        });


        return view;}

    public int gcd(int a, int b) {

        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    //public void denom1 () {

    //}
    public int fraction(int d ) {
        i=(double)1;
        d=  2;
        while (d <= 128) {
            i = i++;
            d = (int)(Math.pow(d, i));
        }return d;
    }

    @Override
    public void onClick(View view) {



    }
}
