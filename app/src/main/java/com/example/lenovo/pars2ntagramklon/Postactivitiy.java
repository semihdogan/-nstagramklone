 package com.example.lenovo.pars2ntagramklon;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Postactivitiy extends AppCompatActivity {
    EditText editText;
    ImageView ımageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postactivitiy);
        editText=findViewById(R.id.editText);
        ımageView=findViewById(R.id.ımageView);
    }
    public  void  yükle(View view){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,50,byteArrayOutputStream);
        byte[] bytes=byteArrayOutputStream.toByteArray();
        ParseFile parseFile=new ParseFile("image.png",bytes);

        String comment=editText.getText().toString();

        ParseObject parseObject=new ParseObject("postlar");
        parseObject.put("image",parseFile);
        parseObject.put("comment",comment);
parseObject.put("username",ParseUser.getCurrentUser());
parseObject.saveInBackground(new SaveCallback() {
    @Override
    public void done(ParseException e) {
        if (e != null){
            Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"başaralı",Toast.LENGTH_LONG).show();
            Intent intent =new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
        }


    }
});
    }
    public  void tıkla(View view){

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
        }else {Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==2){
            if (grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1 &&  resultCode==RESULT_OK && data != null){

            Uri uri=data.getData();
            try {
                bitmap =MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                ımageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }





}
