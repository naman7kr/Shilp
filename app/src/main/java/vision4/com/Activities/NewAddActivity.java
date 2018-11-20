package vision4.com.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import vision4.com.R;

public class NewAddActivity extends AppCompatActivity  {

    //widgets
    private EditText title,short_desc,long_desc,category,contact_no,email;
    private TextView err_title,err_short_desc,err_long_desc,err_category,err_contact_no,err_email,imgName;
    private ImageView  e_title,e_short_desc,e_long_desc,e_category,e_contact_no,e_email;
    private Button addimg,submitBtn;

    //constants
    private static final int PICK_IMAGE_REQUEST = 101;
    private static final String TAG = "NewAddActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adds);
        init();
//        editInfo();
//        selectImg();
//        onSubmit();
    }
//    private void editInfo() {
//        e_title.setOnClickListener(this);
//        e_short_desc.setOnClickListener(this);
//        e_long_desc.setOnClickListener(this);
//        e_category.setOnClickListener(this);
//        err_email.setOnClickListener(this);
//        e_contact_no.setOnClickListener(this);
//    }

    private void init(){
        addimg = findViewById(R.id.sell_add_img);
        submitBtn = findViewById(R.id.sell_submit_button);
        imgName = findViewById(R.id.sell_img_name);

        title = findViewById(R.id.adds_title);
        err_title = findViewById(R.id.adds_title_err);
        e_title = findViewById(R.id.adds_e_title);
        title.setTag("title");

        short_desc = findViewById(R.id.adds_short_desc);
        err_short_desc = findViewById(R.id.adds_short_desc_err);
        e_short_desc = findViewById(R.id.adds_e_short_desc);
        short_desc.setTag("short_desc");

        long_desc = findViewById(R.id.adds_long_desc);
        err_long_desc = findViewById(R.id.adds_long_desc_err);
        e_long_desc = findViewById(R.id.adds_e_long_desc);
        long_desc.setTag("long_desc");

        category = findViewById(R.id.adds_category);
        err_category = findViewById(R.id.adds_category_err);
        e_category = findViewById(R.id.adds_e_category);
        category.setTag("category");

        contact_no = findViewById(R.id.adds_contact_no);
        err_contact_no = findViewById(R.id.adds_category_err);
        e_contact_no = findViewById(R.id.adds_e_contact);
        contact_no.setTag("contact_no");

     //   setAllDisabled();
    }

    private void onSubmit(){
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   setAllDisabled();
                //check necessary fields
                if(checkEmptyFields()){
                    //submit not successful
                }else {
                    //add to database
                    Toast.makeText(getApplicationContext(), "Submit Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private boolean checkEmptyFields(){
        TextView[] errs = {err_title,err_short_desc,err_long_desc,err_contact_no,err_category,err_email};
        EditText[] ets = {title,short_desc,long_desc,contact_no,category,email};
        boolean flag = false;
        for(int i =0;i<ets.length;i++){
            if(ets[i].getText().toString().compareTo("")==0){
                errs[i].setVisibility(View.VISIBLE);
                flag = true;
            }else{
                errs[i].setVisibility(View.GONE);
            }
        }
        return flag;
    }
    private void selectImg(){
        addimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get imgage from mobile resources

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(intent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
                startActivityForResult(chooserIntent,PICK_IMAGE_REQUEST);
            }
        });

    }
    private String getRealPathFromURI(Uri contentURI) {
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            //get image uri & img name
            Uri uri = data.getData();
            String path = getRealPathFromURI(uri);

            String img_name = path.substring(path.lastIndexOf("/")+1);

            Log.e(TAG, "onActivityResult: "+path.substring(path.lastIndexOf("/")+1));
            imgName.setText(img_name);


        }
    }

//    @Override
//    public void onClick(View v) {
//        removeErrors();
//        switch (v.getId()){
//            case R.id.adds_title:
//                //set others uneditable
//                setOthersDisabled(title);
//                //set this editable
//                if(title.isEnabled()==false){
//                    setEditable(title);
//                    e_title.setImageResource(R.drawable.ic_done);
//
//                }else{
//                    title.setEnabled(false);
//                    e_title.setImageResource(R.drawable.ic_edit);
//                }
//                break;
//            case R.id.adds_short_desc:
//                setOthersDisabled(short_desc);
//                if(short_desc.isEnabled()==false){
//                    setEditable(short_desc);
//                    Log.e(TAG, "onClick: category");
//
//                    e_category.setImageResource(R.drawable.ic_done);
//                }else{
//                    short_desc.setEnabled(false);
//                    e_short_desc.setImageResource(R.drawable.ic_edit);
//                }
//                break;
//            case R.id.adds_long_desc:
//                setOthersDisabled(long_desc);
//                if(long_desc.isEnabled()==false){
//                    setEditable(long_desc);
//                    e_long_desc.setImageResource(R.drawable.ic_done);
//                }else{
//                    long_desc.setEnabled(false);
//                    e_long_desc.setImageResource(R.drawable.ic_edit);
//                }
//                break;
//            case R.id.adds_category:
//                setOthersDisabled(category);
//                if(category.isEnabled()==false){
//                    setEditable(category);
//                    e_category.setImageResource(R.drawable.ic_done);
//                }else{
//                    category.setEnabled(false);
//                    e_category.setImageResource(R.drawable.ic_edit);
//                }
//                break;
//            case R.id.adds_contact_no:
//                setOthersDisabled(contact_no);
//                if(contact_no.isEnabled()==false){
//                    setEditable(p_qty);
//                    e_qty.setImageResource(R.drawable.ic_done);
//                }else{
//                    p_qty.setEnabled(false);
//                    e_qty.setImageResource(R.drawable.ic_edit);
//                }
//                break;
//        }
//    }
//    private void setEditable(EditText e){
//        e.setEnabled(true);
//        e.setCursorVisible(true);
//        e.setFocusableInTouchMode(true);
//        e.requestFocus();
//    }
//    private void removeErrors(){
//        TextView[] errs = {err_name,err_desc,err_qty,err_price,err_category};
//        for(TextView err:errs){
//            err.setVisibility(View.GONE);
//        }
//    }
//    private void setAllDisabled(){
//        EditText[] ets = {p_name,p_desc,p_qty,p_price,p_category};
//        ImageView[] imgs = {e_name,e_desc,e_qty,e_price,e_category};
//        int i =0;
//        for(EditText et:ets){
//            et.setEnabled(false);
//            imgs[i].setImageResource(R.drawable.ic_edit);
//            Log.e(TAG, "setAllDisabled: ");
//            i++;
//        }
//
//    }

//    private void setOthersDisabled(EditText e){
//        EditText[] ets = {p_name,p_desc,p_qty,p_price,p_category};
//        ImageView[] imgs = {e_name,e_desc,e_qty,e_price,e_category};
//
//        for(int i = 0;i<ets.length;i++){
//            if(String.valueOf(ets[i].getTag()).compareTo(String.valueOf(e.getTag()))!=0){
//                ets[i].setEnabled(false);
//                imgs[i].setImageResource(R.drawable.ic_edit);
//                Log.e(TAG, "setOthersDisabled: ");
//            }else{
//                Log.e(TAG, "setOthersDisabled: "+ets[i].isEnabled());
//            }
//
//        }
//    }
}
