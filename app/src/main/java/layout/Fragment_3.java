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
public class Fragment_3 extends Fragment implements View.OnClickListener{
    EditText ra, re;
    TextView rt, fmax;
    Button cl;
    Button ex;
    Double v3, tr, ta, rs1, rs2, rs3;
    String op = "";

    public Fragment_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_3, container, false);

        //find elements
        ra = (EditText) view.findViewById(R.id.editText1);
        re = (EditText) view.findViewById(R.id.editText2);
        rt = (TextView) view.findViewById(R.id.lblres);
        fmax = (TextView) view.findViewById(R.id.labelres1);
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

        DecimalFormat df = new DecimalFormat("0.00");

        if (TextUtils.isEmpty(ra.getText().toString())
                || TextUtils.isEmpty(re.getText().toString())) {
            return;
        }
        //
        v1 = Float.parseFloat(ra.getText().toString());
        v2 = Float.parseFloat(re.getText().toString());

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
        fmax.setBackgroundColor(getResources().getColor(R.color.yellow));
        fmax.setText(op + df.format(rs1));


        switch (v.getId()) {
            case R.id.button1:
                fmax.setText("");
                fmax.setBackgroundColor(getResources().getColor(R.color.transparent));
                //fmax.setText("");

                break;

    }
}}
