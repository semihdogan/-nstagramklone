package com.example.lenovo.pars2ntagramklon;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/*Feed aktivitede list view tan�mlad�m 
Ve image list olu�turmak i�in layout ta yeni bir dosta olu�turdum.
Ve orada linear layout ekledim 
Orientatin vertical yazd�m
Cust viev ve feed activity balamak i�in post clas olu�turdum*/
//get View blogukullandım ama çıkmayınca örnek kodlardan aldım .
//daha sonra feed aktiviteye gittim ve array listleri bağladım.


public class PostClass extends ArrayAdapter<String> {
    private  final ArrayList<String> username;
    private  final ArrayList<String> userComment;
    private final  ArrayList<Bitmap> userImage;
    private  final Activity context;
    public PostClass(ArrayList<String> username,ArrayList<String> userComment,ArrayList<Bitmap> userImage,Activity context){

super(context,R.layout.custview,username);
        this.username=username;
        this.userComment=userComment;
        this.userImage=userImage;
        this.context=context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custview,null,true);

        TextView usernameText=customView.findViewById(R.id.textView);
       TextView commentText=customView.findViewById(R.id.textView2);
        ImageView ımageView=customView.findViewById(R.id.imageView);


        usernameText.setText(username.get(position));
       ımageView.setImageBitmap(userImage.get(position));
        commentText.setText(userComment.get(position));


        return customView;
    }
}

