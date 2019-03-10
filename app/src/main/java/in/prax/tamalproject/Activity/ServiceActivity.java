package in.prax.tamalproject.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.prax.tamalproject.Fragment.RepairService;
import in.prax.tamalproject.Fragment.SalesServiceFragment;
import in.prax.tamalproject.Fragment.ServiceFragment;
import in.prax.tamalproject.R;

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.chkSpareparts)
    AppCompatCheckBox chkSpareparts;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.chkRepairService)
    AppCompatCheckBox chkRepairService;
    @BindView(R.id.chkSalesService)
    AppCompatCheckBox chkSalesService;
    @BindView(R.id.servicecontainer1)
    FrameLayout servicecontainer1;

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
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Service and repair");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chkRepairService.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    RepairService productsfragment = new RepairService();
                    assert getSupportFragmentManager() != null;
                    getSupportFragmentManager().beginTransaction().add(R.id.servicecontainer1, productsfragment, "Services and repair").addToBackStack("").commit();

                }

//                chkSpareparts.setChecked(!isChecked);
//                chkSalesService.setChecked(!isChecked);
            }
        });
        chkSpareparts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ServiceFragment productsfragment = new ServiceFragment();
                    assert getSupportFragmentManager() != null;
                    getSupportFragmentManager().beginTransaction().add(R.id.servicecontainer1, productsfragment, "Services and repair").addToBackStack("").commit();
                }
//                chkRepairService.setChecked(!isChecked);
//                chkSalesService.setChecked(!isChecked);
            }
        });
        chkSalesService.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SalesServiceFragment productsfragment = new SalesServiceFragment();
                    assert getSupportFragmentManager() != null;
                    getSupportFragmentManager().beginTransaction().add(R.id.servicecontainer1, productsfragment, "SalesServiceFragment").addToBackStack("").commit();
                }
//                chkSpareparts.setChecked(!isChecked);
//                chkRepairService.setChecked(!isChecked);
            }
        });
    }


}
