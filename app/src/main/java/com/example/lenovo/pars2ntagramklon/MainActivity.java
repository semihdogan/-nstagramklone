package com.example.lenovo.pars2ntagramklon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
  //1
    EditText editText;
EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        //4
        ParseUser parseUsers=ParseUser.getCurrentUser();
        if (parseUsers != null){
            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);

        }

    }
    //3
    public  void  giriş(View view){
        ParseUser.logInInBackground(editText.getText().toString(), editText2.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e !=null){

                    Toast.makeText(getApplicationContext(),"Hata var",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"hoşgeldiniz"+user.getUsername(),Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                }

            }
        });




    }
    //2
    public  void üyeol(View view){
        ParseUser parseUser=new ParseUser();
        parseUser.setUsername(editText.getText().toString());
parseUser.setPassword(editText2.getText().toString());
parseUser.signUpInBackground(new SignUpCallback() {
    @Override
    public void done(ParseException e) {
        if (e != null){
            Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }else {Toast.makeText(getApplicationContext(),"kayıt olundu",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);


        }
    }
});
    }
}
