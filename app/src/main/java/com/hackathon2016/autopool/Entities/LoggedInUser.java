package com.hackathon2016.autopool.Entities;

import io.realm.RealmObject;

/**
 * Created by itayh on 23/11/2016.
 */

public class LoggedInUser extends RealmObject {

    private String Email;
    private String Name;
    private String PhoneNumber;
    private PickUpPoint DefaultPickupPoint;
}
