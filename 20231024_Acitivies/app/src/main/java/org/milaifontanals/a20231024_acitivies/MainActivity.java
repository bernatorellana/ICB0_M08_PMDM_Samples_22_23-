package org.milaifontanals.a20231024_acitivies;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button mBtnDetall, mBtnPhoto;
    ImageView mImgPhoto;
    EditText mEdtName;
    private static final int DETALL_ACTIVITY = 1983434;// Powered by Jordi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnDetall = findViewById(R.id.btnDetall);
        mEdtName = findViewById(R.id.edtName);
        mBtnPhoto = findViewById(R.id.btnPhoto);
        mImgPhoto = findViewById(R.id.imgPhoto);

        mBtnPhoto.setOnClickListener(view -> {

//            String url = "http://www.zoom.com";
//            Intent i = new Intent(Intent.ACTION_VIEW);
//            i.setData(Uri.parse(url));
//            startActivity(i);

            dispatchTakePictureIntent();
        });

        mBtnDetall.setOnClickListener(view -> {

            Intent i = new Intent(this,
                    DetallActivity.class);
            i.putExtra(DetallActivity.PARAM_NOM, mEdtName.getText()+"");

            Persona p = new Persona(1, mEdtName.getText()+"");
            i.putExtra("PERSONA", p);

            startActivityForResult(i, DETALL_ACTIVITY);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (
                requestCode == DETALL_ACTIVITY &&
                resultCode == DetallActivity.RESULT_CODE_OK) {
            String nom = data.getStringExtra(DetallActivity.PARAM_NOM);
            mEdtName.setText(nom);
        }
        else
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImgPhoto.setImageBitmap(imageBitmap);
        }
    }


    static final int REQUEST_IMAGE_CAPTURE = 176;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }


}