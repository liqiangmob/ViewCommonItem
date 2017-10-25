package com.example.lq.viewcommonitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
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


    private boolean imgShow = true;

    private int defaultImageWidth = 0;
    private int defaultImageHeight = 0;
    private int defaultImageLeftMargin = 20;

    private int ImageWidth;
    private int ImageHeight;
    private int ImageLeftMargin;


    private int defaultTvTitleSize = 14;
    private int defaultTvTitleColor;
    private int defaultTvTitleLeftMargin = 5;

    private float tvTitleSize;
    private int tvTitleColor;
    private int tvTitleLeftMargin;


    private int defaultTvDescriptionSize = 12;
    private int defaultTvDescriptionColor;
    private int defaultTvDescriptionRightMargin = 20;

    private float tvDescriptionSize;
    private int tvDescriptionColor;
    private int tvDescriptionRightMargin;

    private int defaultRightImgHeight = 0;
    private int defaultRightImgWidth = 0;
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

        itemImage.setId(R.id.item_img);
        itemImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageWidth = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_width, defaultImageWidth);
        ImageHeight = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_height, defaultImageHeight);
        ImageLeftMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_img_left_margin, defaultImageLeftMargin);
        imgShow = attributes.getBoolean(R.styleable.ViewCommonItem_show_img, true);

        Glide.with(mContext).load(attributes.getResourceId(R.styleable.ViewCommonItem_img_src, R.mipmap.ic_launcher)).into(itemImage);
        if (ImageHeight == 0 || ImageWidth == 0) {
            ImageHeight = LayoutParams.WRAP_CONTENT;
            ImageWidth = LayoutParams.WRAP_CONTENT;
        }

        LayoutParams layoutParams = new LayoutParams(ImageWidth, ImageHeight);

        layoutParams.setMargins(ImageLeftMargin, 0, 0, 0);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        layoutParams.addRule(RelativeLayout.ALIGN_LEFT);
        addView(itemImage, layoutParams);
        if (imgShow) {
            itemImage.setVisibility(VISIBLE);
        } else {
            itemImage.setVisibility(GONE);
        }


    }

    private void initItemTitle(TypedArray attributes) {
        itemTitle.setId(R.id.item_title);
        tvTitleSize = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_tv_title_size, Utils.sp2px(mContext, defaultTvTitleSize));
        tvTitleColor = attributes.getColor(R.styleable.ViewCommonItem_tv_title_color, 0);
        tvTitleLeftMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_tv_title_left_margin, defaultTvTitleLeftMargin);

        String title = attributes.getString(R.styleable.ViewCommonItem_tv_title);

        itemTitle.setText(Utils.safe(title));
        if (tvTitleColor == 0) {
            itemTitle.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        } else {
            itemTitle.setTextColor(tvTitleColor);
        }

        itemTitle.setTextSize(Utils.px2sp(mContext, tvTitleSize));

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        layoutParams.addRule(RelativeLayout.RIGHT_OF, R.id.item_img);

        if (imgShow) {
            layoutParams.setMargins(tvTitleLeftMargin, 0, 0, 0);
        } else {
            layoutParams.setMargins(Utils.dp2px(mContext, defaultImageLeftMargin), 0, 0, 0);
        }

        addView(itemTitle, layoutParams);


    }

    private void initItemDescription(TypedArray attributes) {

        itemDescription.setId(R.id.item_des);
        tvDescriptionSize = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_tv_description_size, Utils.sp2px(mContext,defaultTvDescriptionSize));
        tvDescriptionColor = attributes.getColor(R.styleable.ViewCommonItem_tv_description_color, 0);
        tvDescriptionRightMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_tv_description_right_margin, defaultTvDescriptionRightMargin);

        String description = attributes.getString(R.styleable.ViewCommonItem_tv_description);
        itemDescription.setText(Utils.safe(description));
        itemDescription.setTextSize(Utils.px2sp(mContext, tvDescriptionSize));
        if (tvDescriptionColor == 0) {
            itemDescription.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        } else {
            itemDescription.setTextColor(tvDescriptionColor);
        }

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        layoutParams.addRule(RelativeLayout.LEFT_OF, R.id.item_right_img);
        layoutParams.setMargins(0, 0, tvDescriptionRightMargin, 0);
        addView(itemDescription, layoutParams);


    }

    private void initRightImageView(TypedArray attributes) {

        itemRightImage.setId(R.id.item_right_img);
        itemRightImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        rightImgWidth = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_right_img_width, defaultRightImgWidth);
        rightImgHeight = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_right_img_height, defaultRightImgHeight);
        rightImgRightMargin = attributes.getDimensionPixelSize(R.styleable.ViewCommonItem_right_img_right_margin, defaultRightImgRightMargin);

        Glide.with(mContext).load(attributes.getResourceId(R.styleable.ViewCommonItem_right_img, R.mipmap.ic_launcher)).into(itemRightImage);

        if (rightImgWidth == 0 || rightImgHeight == 0) {
            rightImgWidth = LayoutParams.WRAP_CONTENT;
            rightImgHeight = LayoutParams.WRAP_CONTENT;
        }


        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rightImgWidth, rightImgHeight);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        layoutParams.setMargins(0, 0, rightImgRightMargin, 0);

        addView(itemRightImage, layoutParams);

    }


    private void initItemBottomLine(TypedArray attributes) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        itemBottomLine.setBackgroundColor(ContextCompat.getColor(mContext, R.color.orange_00000));

        if (attributes.getBoolean(R.styleable.ViewCommonItem_bottom_line_show, defaultBottomLineShow)) {
            addView(itemBottomLine, layoutParams);
        }

    }


    private void setData(String title, String des) {
        if (itemTitle != null) {
            itemTitle.setText(Utils.safe(title));
        }
        if (itemDescription != null) {
            itemDescription.setText(Utils.safe(des));
        }

    }

    private void setData(String title, String imgUrl, String des) {
        if (itemTitle != null) {
            itemTitle.setText(Utils.safe(title));
        }
        if (itemDescription != null) {
            itemDescription.setText(Utils.safe(des));
        }
        if (itemImage != null) {

            Glide.with(mContext).load(imgUrl).into(itemImage);
        }
    }

    private void setData(String title, int imgUrl, String des) {
        if (itemTitle != null) {
            itemTitle.setText(Utils.safe(title));
        }
        if (itemDescription != null) {
            itemDescription.setText(Utils.safe(des));
        }
        if (itemImage != null) {
            Glide.with(mContext).load(imgUrl).into(itemImage);

        }
    }


}
