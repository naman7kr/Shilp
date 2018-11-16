package vision4.com.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import vision4.com.R;

import static android.app.Activity.RESULT_OK;

public class SellProductsFragment extends Fragment implements View.OnClickListener {

    //widgets
    private Button addimg,submitBtn;
    private EditText p_name,p_price,p_category,p_qty,p_desc;
    private ImageView e_name,e_price,e_category,e_qty,e_desc;
    private TextView imgName,err_name,err_price,err_category,err_qty,err_desc;

    //constants
    private static final int PICK_IMAGE_REQUEST = 101;
    private static final String TAG = "SellProductsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sell_products,container,false);
        init(view);
        editInfo();
        selectImg();
        onSubmit();
        return view;

    }

    private void editInfo() {
        e_name.setOnClickListener(this);
        e_desc.setOnClickListener(this);
        e_qty.setOnClickListener(this);
        e_category.setOnClickListener(this);
        e_price.setOnClickListener(this);
    }

    private void init(View v){
        addimg = v.findViewById(R.id.sell_add_img);
        submitBtn = v.findViewById(R.id.sell_submit_button);
        imgName = v.findViewById(R.id.sell_img_name);

        p_name = v.findViewById(R.id.sell_product_name);
        err_name = v.findViewById(R.id.sell_name_err);
        e_name = v.findViewById(R.id.sell_e_name);
        p_name.setTag("name");

        p_price = v.findViewById(R.id.sell_product_price);
        err_price = v.findViewById(R.id.sell_price_err);
        e_price = v.findViewById(R.id.sell_e_price);
        p_price.setTag("price");

        p_category = v.findViewById(R.id.sell_product_category);
        err_category = v.findViewById(R.id.sell_category_err);
        e_category = v.findViewById(R.id.sell_e_category);
        p_category.setTag("category");

        p_qty = v.findViewById(R.id.sell_product_qty);
        err_qty = v.findViewById(R.id.sell_qty_err);
        e_qty = v.findViewById(R.id.sell_e_qty);
        p_qty.setTag("quantity");

        p_desc = v.findViewById(R.id.sell_product_desc);
        err_desc = v.findViewById(R.id.sell_desc_err);
        e_desc = v.findViewById(R.id.sell_e_desc);
        p_desc.setTag("description");

        setAllDisabled();
    }

    private void onSubmit(){
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllDisabled();
                //check necessary fields
                if(checkEmptyFields()){
                    //submit not successful
                }else {
                    //add to database
                    Toast.makeText(getContext(), "Submit Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private boolean checkEmptyFields(){
        TextView[] errs = {err_name,err_desc,err_qty,err_price,err_category};
        EditText[] ets = {p_name,p_desc,p_qty,p_price,p_category};
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
                Intent pickIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(intent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
                startActivityForResult(chooserIntent,PICK_IMAGE_REQUEST);
            }
        });

    }
    private String getRealPathFromURI(Uri contentURI) {
        Cursor cursor = getContext().getContentResolver().query(contentURI, null, null, null, null);
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

    @Override
    public void onClick(View v) {
        removeErrors();
        switch (v.getId()){
            case R.id.sell_e_name:
                //set others uneditable
                setOthersDisabled(p_name);
                //set this editable
                if(p_name.isEnabled()==false){
                    setEditable(p_name);
                    e_name.setImageResource(R.drawable.ic_done);

                }else{
                    p_name.setEnabled(false);
                    e_name.setImageResource(R.drawable.ic_edit);
                }
                break;
            case R.id.sell_e_category:
                setOthersDisabled(p_category);
                if(p_category.isEnabled()==false){
                    setEditable(p_category);
                    Log.e(TAG, "onClick: category");

                    e_category.setImageResource(R.drawable.ic_done);
                }else{
                    p_category.setEnabled(false);
                    e_category.setImageResource(R.drawable.ic_edit);
                }
                break;
            case R.id.sell_e_desc:
                setOthersDisabled(p_desc);
                if(p_desc.isEnabled()==false){
                    setEditable(p_desc);
                    e_desc.setImageResource(R.drawable.ic_done);
                }else{
                    p_desc.setEnabled(false);
                    e_desc.setImageResource(R.drawable.ic_edit);
                }
                break;
            case R.id.sell_e_price:
                setOthersDisabled(p_price);
                if(p_price.isEnabled()==false){
                    setEditable(p_price);
                    e_price.setImageResource(R.drawable.ic_done);
                }else{
                    p_price.setEnabled(false);
                    e_price.setImageResource(R.drawable.ic_edit);
                }
                break;
            case R.id.sell_e_qty:
                setOthersDisabled(p_qty);
                if(p_qty.isEnabled()==false){
                    setEditable(p_qty);
                    e_qty.setImageResource(R.drawable.ic_done);
                }else{
                    p_qty.setEnabled(false);
                    e_qty.setImageResource(R.drawable.ic_edit);
                }
                break;
        }
    }
    private void setEditable(EditText e){
        e.setEnabled(true);
        e.setCursorVisible(true);
        e.setFocusableInTouchMode(true);
        e.requestFocus();
    }
    private void removeErrors(){
        TextView[] errs = {err_name,err_desc,err_qty,err_price,err_category};
        for(TextView err:errs){
            err.setVisibility(View.GONE);
        }
    }
    private void setAllDisabled(){
        EditText[] ets = {p_name,p_desc,p_qty,p_price,p_category};
        ImageView[] imgs = {e_name,e_desc,e_qty,e_price,e_category};
        int i =0;
        for(EditText et:ets){
                et.setEnabled(false);
                imgs[i].setImageResource(R.drawable.ic_edit);
                Log.e(TAG, "setAllDisabled: ");
                i++;
            }

    }

    private void setOthersDisabled(EditText e){
        EditText[] ets = {p_name,p_desc,p_qty,p_price,p_category};
        ImageView[] imgs = {e_name,e_desc,e_qty,e_price,e_category};

        for(int i = 0;i<ets.length;i++){
            if(String.valueOf(ets[i].getTag()).compareTo(String.valueOf(e.getTag()))!=0){
                ets[i].setEnabled(false);
                imgs[i].setImageResource(R.drawable.ic_edit);
                Log.e(TAG, "setOthersDisabled: ");
            }else{
                Log.e(TAG, "setOthersDisabled: "+ets[i].isEnabled());
            }

        }
    }
}
