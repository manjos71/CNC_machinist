package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marcosantonio.cnc_machinist.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_2 extends Fragment implements View.OnClickListener{
    EditText n1, n2, n3;
    TextView r1, r2, r3;
    Button cl;
    Button ex;
    Double v1, v2, v3, tr, ta, rs1, rs2, rs3;
    String op = "";

    public Fragment_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_2, container, false);

        //find elements
        n1 = (EditText) view.findViewById(R.id.editText1);
        n2 = (EditText) view.findViewById(R.id.editText2);
        n3 = (EditText) view.findViewById(R.id.editText3);
        r1 = (TextView) view.findViewById(R.id.lblres);
        r2 = (TextView) view.findViewById(R.id.labelres1);
        r3 = (TextView) view.findViewById(R.id.labelres2);
        cl = (Button) view.findViewById(R.id.button1);
        ex = (Button) view.findViewById(R.id.button2);

        // Set a listener
        cl.setOnClickListener(this);
        ex.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        float v1 = 0;
        float v2 = 0;
        float v3 = 0;
        DecimalFormat df = new DecimalFormat("0.00");

        if (TextUtils.isEmpty(n1.getText().toString())
                || TextUtils.isEmpty(n2.getText().toString())
                || TextUtils.isEmpty(n3.getText().toString())) {
            return;
        }
        //
        v1 = Float.parseFloat(n1.getText().toString());
        v2 = Float.parseFloat(n2.getText().toString());
        v3 = Float.parseFloat(n3.getText().toString());
        //
        //
        switch (v.getId()) {
            case R.id.button2:
                op = " = ";
                tr = Math.toRadians((180 - v3) / 2);
                ta = Math.tan(tr);
                rs1 = (ta * ((v1 - v2) / 2));
                rs2 = (ta * ((v2) / 2));
                rs3 = (ta * ((v1) / 2));
                break;
            default:
                break;
        }
        r1.setBackgroundColor(getResources().getColor(R.color.light_pink));
        r2.setBackgroundColor(getResources().getColor(R.color.light_pink));
        r3.setBackgroundColor(getResources().getColor(R.color.light_pink));
        r1.setText(op + df.format(rs1));
        r2.setText(op + df.format(rs2));
        r3.setText(op + df.format(rs3));

        switch (v.getId()) {
            case R.id.button1:
                n1.setText("");
                n2.setText("");
                n3.setText("");
                //r1.setBackground(setFeatureDrawableAlpha(R.id.lblres,100));
                //r2.setBackground(setFeatureDrawableAlpha(R.id.labelres1,100);
                //r3.setBackground(setFeatureDrawableAlpha(R.id.labelres2,100);
                r1.setBackgroundColor(getResources().getColor(R.color.transparent));
                r2.setBackgroundColor(getResources().getColor(R.color.transparent));
                r3.setBackgroundColor(getResources().getColor(R.color.transparent));
                r1.setText("");
                r2.setText("");
                r3.setText("");
                break;

        }
    }
}
