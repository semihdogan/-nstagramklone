package com.example.lenovo.pars2ntagramklon;

import android.app.Application;

import com.parse.Parse;

public class Parsbaşlatıcı extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)


        .applicationId("2mo9hpX8fUsFLwmhs5boXK4hkYgTn8rq2YG3IbbN")
.clientKey("Y4dVDOB1OUaZHZrOguOq6MkULRilLZc3l7MQNzDf")
                .server("https://parseapi.back4app.com/")
                .build()

//manisefeste gidip name adı girdim aplıcation altında

        );



    }
}
