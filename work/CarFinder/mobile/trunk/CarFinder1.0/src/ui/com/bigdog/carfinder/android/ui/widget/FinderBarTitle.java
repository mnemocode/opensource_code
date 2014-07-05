package com.bigdog.carfinder.android.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bigdog.carfinder.android.R;

/**
 * Created with IntelliJ IDEA.
 * User: bigdog
 * Date: 7/27/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class FinderBarTitle {

    private Button leftButton;
    private TextView middleLiner;
    private Button rightButton;
    private Context mContext;
    private View titleBar;

    public FinderBarTitle(Context context) {
        mContext=context;
        titleBar=View.inflate(mContext, R.layout.title_center,null);
        initViews(titleBar);
    }

    private void initViews(View titleBar) {
        leftButton= (Button) titleBar.findViewById(R.id.title_left_button);
        rightButton= (Button) titleBar.findViewById(R.id.title_right_function_button);
        middleLiner= (TextView) titleBar.findViewById(R.id.middile_text);
    }

    public void setLeftButtonOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener!=null&&leftButton!=null) {
            leftButton.setVisibility(View.VISIBLE);
            leftButton.setOnClickListener(onClickListener);
        }
    }
    public void setRightButtonOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener!=null&&rightButton!=null) {
            rightButton.setVisibility(View.VISIBLE);
            rightButton.setOnClickListener(onClickListener);
        }
    }
    public void removeRightButton() {
        if (rightButton != null) {
            rightButton.setText("");
            rightButton.setVisibility(View.GONE);
            rightButton.setOnClickListener(null);
        }
    }
    public void setMidText(String mid_text_email) {
        if (!"".equals(mid_text_email)&&mid_text_email!=null) {
            middleLiner.setVisibility(View.VISIBLE);
            middleLiner.setText(mid_text_email);
        }
    }
    public void setLeftText(String leftText){
        if (!"".equals(leftText)&&leftText!=null) {
            leftButton.setVisibility(View.VISIBLE);
            leftButton.setText(leftText);
        }
    }
    public void setRightText(String rightText){
        if (!"".equals(rightText)&&rightText!=null) {
            rightButton.setVisibility(View.VISIBLE);
            rightButton.setText(rightText);
        }
    }

    public void hideTitle(boolean hide) {
        if (hide) {
            leftButton.setVisibility(View.GONE);
            rightButton.setVisibility(View.GONE);
            middleLiner.setVisibility(View.GONE);
        }else {
            leftButton.setVisibility(View.VISIBLE);
            rightButton.setVisibility(View.VISIBLE);
            middleLiner.setVisibility(View.VISIBLE);
        }
    }

    public View getTitleBar() {
        return titleBar;
    }
}
