package com.cookandroid.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Camera extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE =672;
    private String imageFilePath;
    private Uri photoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // 권한 체크
        TedPermission.with(getApplicationContext()) // getApplicationContext는 자신이 어떤 어플리케이션을 나타내고 있는지 알려주는 ID역할이다, ActivityManagerService에 접근 할 수 있도록 하는 통로역할
                                                    // getApplicationContext는 앱에 대한 전역 환경정보를 가지고 있다.
                .setPermissionListener(permissionListener)
                .setRationaleMessage("카메라 권한이 필요합니다.") // 권한을 요청하기 전에 이 권한이 필요한 이유에 대해서 설명함
                .setDeniedMessage("거부하셨습니다.") // 사용자가 권한을 거부했을 때 보여지는 메세지이다.
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA) // 필요한 권한을 넣는다.
                .check();

        findViewById(R.id.btn_capture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // 카메라 앱을띄우는 구문, 카메라를 불러서 이미지를 캡쳐하고 리턴해준다.
                if(intent.resolveActivity(getPackageManager()) != null){ // 이 인텐트를 수행할 수 있는 액티비티를 찾는다. ex)태블릿 pc에 카메라가없는경우
                    File photoFile = null;
                    try{
                       photoFile = createImageFile();
                    } catch(IOException e){

                    }

                    if(photoFile != null){
                        photoUri = FileProvider.getUriForFile(getApplicationContext(), getPackageName(), photoFile); // FileProvider는 앱의 내부 파일을 공유하는데 사용된다.
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE); // 다음
                    }
                }
            }
        });
    }

    private File createImageFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); // 파일이름
        String imageFileName = "TEST_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        imageFilePath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath);
            ExifInterface exif = null;

            try{
                exif = new ExifInterface(imageFilePath);
            } catch(IOException e){
                e.printStackTrace();
            }

            int exifOrientation;
            int exifDegree;

            if(exif != null){
                exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                exifDegree = exifOrientationToDegrees(exifOrientation);
            } else{
                exifDegree = 0;
            }

            ((ImageView) findViewById(R.id.iv_result)).setImageBitmap(rotate(bitmap,exifDegree));
        }
    }

    private int exifOrientationToDegrees(int exifOrientation){
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90){
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180){
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }
        return 0;
    }

    private Bitmap rotate(Bitmap bitmap, float degree){
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(getApplicationContext(), "권한이 허용됨", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(getApplicationContext(), "권한이 거부됨", Toast.LENGTH_SHORT).show();
        }
    };
}
