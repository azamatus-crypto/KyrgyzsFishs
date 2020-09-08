package Settings;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.base.kyrgyzsfishs.R;

public class SettingsActivity extends AppCompatActivity {
    private ActionBar actionbar22;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!=null){
            actionbar22=getSupportActionBar();
            actionbar22.setDisplayShowHomeEnabled(true);
            actionbar22.setTitle(getString(R.string.action_settings));

        }
getFragmentManager().beginTransaction().replace(android.R.id.content,new SettingFragment());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return true;
    }
}
