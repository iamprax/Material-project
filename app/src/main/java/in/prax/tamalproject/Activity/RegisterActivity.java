package in.prax.tamalproject.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.prax.tamalproject.R;
import in.prax.tamalproject.view.MyEditText;
import in.prax.tamalproject.view.MyTextView;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtfill)
    MyTextView txtfill;
    @BindView(R.id.edtusername)
    MyEditText edtusername;
    @BindView(R.id.edtpassword)
    MyEditText edtpassword;
    @BindView(R.id.edtpassword1)
    MyEditText edtpassword1;
    @BindView(R.id.chkterm)
    AppCompatCheckBox chkterm;
    @BindView(R.id.btnRegister)
    AppCompatButton btnRegister;
    @BindView(R.id.registerstep1)
    RelativeLayout registerstep1;
    @BindView(R.id.txtfill1)
    MyTextView txtfill1;
    @BindView(R.id.cardRegister)
    CardView cardRegister;
    @BindView(R.id.nextstep)
    AppCompatTextView nextstep;
    @BindView(R.id.txtcheckmail)
    AppCompatTextView txtcheckmail;
    @BindView(R.id.btnSendemailagain)
    AppCompatButton btnSendemailagain;
    @BindView(R.id.backtostep1)
    AppCompatButton backtostep1;
    @BindView(R.id.registerstep2)
    RelativeLayout registerstep2;
    @BindView(R.id.txtfill2)
    MyTextView txtfill2;
    @BindView(R.id.edtCompanyname)
    MyEditText edtCompanyname;
    @BindView(R.id.edtaddress)
    MyEditText edtaddress;
    @BindView(R.id.edtpersonname)
    MyEditText edtpersonname;
    @BindView(R.id.edtjobtitle)
    MyEditText edtjobtitle;
    @BindView(R.id.btnNextstep4)
    AppCompatButton btnNextstep4;
    @BindView(R.id.registerstep3)
    RelativeLayout registerstep3;
    @BindView(R.id.txtfill3)
    MyTextView txtfill3;
    @BindView(R.id.cardRegister4)
    CardView cardRegister4;
    @BindView(R.id.btnConfirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.backtostep3)
    AppCompatButton backtostep3;
    @BindView(R.id.registerstep4)
    RelativeLayout registerstep4;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerstep2.setVisibility(View.VISIBLE);
                registerstep3.setVisibility(View.GONE);
                registerstep4.setVisibility(View.GONE);
                registerstep1.setVisibility(View.GONE);
            }
        });
        nextstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerstep3.setVisibility(View.VISIBLE);
                registerstep2.setVisibility(View.GONE);
                registerstep4.setVisibility(View.GONE);
                registerstep1.setVisibility(View.GONE);
            }
        });
        btnNextstep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerstep4.setVisibility(View.VISIBLE);
                registerstep2.setVisibility(View.GONE);
                registerstep3.setVisibility(View.GONE);
                registerstep1.setVisibility(View.GONE);
            }
        });
        btnSendemailagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerstep3.setVisibility(View.VISIBLE);
                registerstep2.setVisibility(View.GONE);
                registerstep4.setVisibility(View.GONE);
                registerstep1.setVisibility(View.GONE);
            }
        });
        backtostep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerstep1.setVisibility(View.VISIBLE);
                registerstep3.setVisibility(View.GONE);
                registerstep4.setVisibility(View.GONE);
                registerstep2.setVisibility(View.GONE);
            }
        });

        backtostep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerstep1.setVisibility(View.VISIBLE);
                registerstep3.setVisibility(View.GONE);
                registerstep4.setVisibility(View.GONE);
                registerstep2.setVisibility(View.GONE);
            }
        });

    }

}
