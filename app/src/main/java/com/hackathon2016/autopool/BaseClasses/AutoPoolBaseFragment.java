package com.hackathon2016.autopool.BaseClasses;
import android.app.Fragment;

import io.realm.Realm;

/**
 * Created by itayh on 21/11/2016.
 */

public abstract class AutoPoolBaseFragment extends Fragment {

    private Realm realm;

    @Override
    public void onStart() {
        super.onStart();
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onStop() {
        super.onStop();
        realm.close();
    }
}
