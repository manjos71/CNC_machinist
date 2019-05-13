package layout;

import android.app.AlertDialog;
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
    Double rs;
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
        ra = (EditText) view.findViewById(R.id.editRa2);
        re = (EditText) view.findViewById(R.id.editRe);
        rt = (TextView) view.findViewById(R.id.textRt2);
        fmax = (TextView) view.findViewById(R.id.textFmax2);
        cl = (Button) view.findViewById(R.id.button1);
        ex = (Button) view.findViewById(R.id.button2);


        // Set a listener
        cl.setOnClickListener(this);
        ex.setOnClickListener(this);

        //


        // Set text Ra
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double ra2 = 0;

                if (TextUtils.isEmpty(ra.getText().toString())
                        || TextUtils.isEmpty(re.getText().toString())) {
                    return;
                }

                ra2 = Double.parseDouble(ra.getText().toString());

                if ((double) ra2 == 0.4) {
                    rt.setText("2.0");
                }
                if ((double) ra2 == 0.8) {
                    rt.setText("4.0");
                }
                if ((double) ra2 == 1.2) {
                    rt.setText("6.0");
                }
                if ((double) ra2 == 1.6) {
                    rt.setText("8.0");
                }
                if ((double) ra2 == 2.0) {
                    rt.setText("10.0");
                }
                if ((double) ra2 == 2.4) {
                    rt.setText("12.0");
                }
                if ((double) ra2 == 3.2) {
                    rt.setText("15.0");
                }
                if ((double) ra2 == 6.3) {
                    rt.setText("27.0");
                }
                if ((double) ra2 == 12.5) {
                    rt.setText("45.0");
                }
            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {

        float v1 = 0;
        float v2 = 0;

        DecimalFormat df = new DecimalFormat("0.00");

        if (TextUtils.isEmpty(ra.getText().toString())
                || TextUtils.isEmpty(ra.getText().toString())) {
            return;
        }
        //
        v1 = Float.parseFloat(rt.getText().toString());
        v2 = Float.parseFloat(re.getText().toString());



            switch (v.getId()) {
                case R.id.button2:

                    op = " = ";
                    rs = Math.sqrt((v1 * 8 * v2) / 1000);
                    break;
                default:
                    break;
            }
            fmax.setBackgroundColor(getResources().getColor(R.color.cyan));
            fmax.setText(op + df.format(rs));


            switch (v.getId()) {
                case R.id.button1:
                    rt.setText("");
                    re.setText("");
                    fmax.setText("");
                    rt.setBackgroundColor(getResources().getColor(R.color.transparent));
                    re.setBackgroundColor(getResources().getColor(R.color.transparent));
                    fmax.setBackgroundColor(getResources().getColor(R.color.transparent));


                    break;

            }
        //}
    }}
