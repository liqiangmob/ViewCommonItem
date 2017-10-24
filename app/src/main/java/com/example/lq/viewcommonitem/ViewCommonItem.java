package com.example.lq.viewcommonitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by lq on 17/10/24.
 */

public class ViewCommonItem extends RelativeLayout {

    ImageView itemImage;
    TextView itemTitle;
    TextView itemDescription;
    ImageView itemRightImage;
    View itemBottomLine;
//    RelativeLayout container;


    private int defaultImageWidth = 18;
    private int defaultImageHeight = 18;
    private int defaultImageLeftMargin = 20;

    private int ImageWidth;
    private int ImageHeight;
    private int ImageLeftMargin;


    private boolean defaultTvTitleSingle = false;
    private float defaultTvTitleSize = 14;
    private int defaultTvTitleColor;
    private int defaultTvTitleLeftMargin = 5;

    private boolean tvTitleSingle = false;
    private float tvTitleSize;
    private int tvTitleColor;
    private int tvTitleLeftMargin;

    private boolean defaultTvDescriptionSingle = true;
    private float defaultTvDescriptionSize = 12;
    private int defaultTvDescriptionColor;
    private int defaultTvDescriptionRightMargin = 20;

    private boolean tvDescriptionSingle;
    private float tvDescriptionSize;
    private int tvDescriptionColor;
    private int tvDescriptionRightMargin;

    private int defaultRightImgHeight = 18;
    private int defaultRightImgWidth = 8;
    private int defaultRightImgRightMargin = 20;

    private int rightImgHeight;
    private int rightImgWidth;
    private int rightImgRightMargin;


    private boolean defaultBottomLineShow = true;


    private Context mContext;


    private void initView() {


        itemImage = new ImageView(mContext);
        itemTitle = new TextView(mContext);
        itemDescription = new TextView(mContext);
        itemRightImage = new ImageView(mContext);
        itemBottomLine = new View(mContext);
//        container = new RelativeLayout(mContext);

    }

    public ViewCommonItem(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public ViewCommonItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ViewCommonItem);
        if (attributes != null) {

            initImageView(attributes);

            initItemTitle(attributes);

            initItemDescription(attributes);

            initItemBottomLine(attributes);

            initRightImageView(attributes);
        }
        attributes.recycle();

    }

    private void initImageView(TypedArray attributes) {


        ImageWidth = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_width, defaultImageWidth);
        ImageHeight = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_height, defaultImageHeight);
        ImageLeftMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_left_margin, defaultImageLeftMargin);

        Glide.with(mContext).load(attributes.getResourceId(R.styleable.ViewCommonItem_img_src, R.mipmap.ic_launcher)).into(itemImage);

        LayoutParams layoutParams = new LayoutParams(ImageWidth, ImageHeight);
        layoutParams.addRule(Gravity.CENTER_VERTICAL, TRUE);
        layoutParams.setMargins(ImageLeftMargin, 0, 0, 0);
        addView(itemImage, layoutParams);

    }

    private void initItemTitle(TypedArray attributes) {


        tvTitleSize = attributes.getDimension(R.styleable.ViewCommonItem_tv_title_size, defaultTvTitleSize);
        tvTitleColor = attributes.getColor(R.styleable.ViewCommonItem_tv_title_color, 0);
        tvTitleLeftMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_left_margin, defaultTvTitleLeftMargin);
        tvTitleSingle = attributes.getBoolean(R.styleable.ViewCommonItem_tv_title_single, defaultTvTitleSingle);

        String title = attributes.getString(R.styleable.ViewCommonItem_tv_title);

        itemTitle.setText(StringUtil.safe(title));
        itemTitle.setTextColor(tvTitleColor);
        itemTitle.setTextSize(tvTitleSize);
        if (tvTitleSingle) {
            itemTitle.setSingleLine();
            itemDescription.setEllipsize(TextUtils.TruncateAt.END);
        }
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(Gravity.CENTER_VERTICAL, TRUE);
        layoutParams.setMargins(ImageLeftMargin, 0, 0, 0);
        addView(itemImage, layoutParams);


    }

    private void initItemDescription(TypedArray attributes) {

        tvDescriptionSize = attributes.getDimension(R.styleable.ViewCommonItem_tv_description_size, defaultTvDescriptionSize);
        tvDescriptionColor = attributes.getColor(R.styleable.ViewCommonItem_tv_description_color, 0);
        tvDescriptionRightMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_tv_description_right_margin, defaultTvDescriptionRightMargin);
        tvDescriptionSingle = attributes.getBoolean(R.styleable.ViewCommonItem_tv_description_single, defaultTvDescriptionSingle);

        String description = attributes.getString(R.styleable.ViewCommonItem_tv_description);
        itemDescription.setText(StringUtil.safe(description));
        itemDescription.setTextColor(tvDescriptionColor);
        itemDescription.setTextSize(tvDescriptionSize);
        if (tvDescriptionSingle) {
            itemDescription.setSingleLine();
            itemDescription.setEllipsize(TextUtils.TruncateAt.END);
        }

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(Gravity.CENTER_VERTICAL, TRUE);
        layoutParams.setMargins(0, 0, tvDescriptionRightMargin, 0);
        addView(itemDescription, layoutParams);


    }

    private void initRightImageView(TypedArray attributes) {


        rightImgWidth = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_width, defaultRightImgWidth);
        rightImgHeight = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_height, defaultRightImgHeight);
        rightImgRightMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_left_margin, defaultRightImgRightMargin);

        Glide.with(mContext).load(attributes.getResourceId(R.styleable.ViewCommonItem_right_img, R.mipmap.ic_launcher)).into(itemRightImage);

        LayoutParams layoutParams = new LayoutParams(rightImgWidth, rightImgHeight);
        layoutParams.addRule(Gravity.CENTER_VERTICAL, TRUE);
        layoutParams.setMargins(0, 0, rightImgRightMargin, 0);
        addView(itemRightImage, layoutParams);

    }


    private void initItemBottomLine(TypedArray attributes) {
        if (attributes.getBoolean(R.styleable.ViewCommonItem_bottom_line_show, defaultBottomLineShow)) {
            itemBottomLine.setVisibility(VISIBLE);
        } else {
            itemBottomLine.setVisibility(GONE);
        }
    }


    public void setData(int imageResource, String sTitle, String sDescription) {

        Glide.with(mContext).load(imageResource).into(itemImage);
        itemTitle.setText(StringUtil.safe(sTitle));
        itemDescription.setText(StringUtil.safe(sDescription));


    }


    public int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
