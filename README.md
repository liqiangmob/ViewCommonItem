# ViewCommonItem

 ![image](https://github.com/liqiangmob/ViewCommonItem/blob/master/img/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202017-10-25%20%E4%B8%8B%E5%8D%886.12.51.png)
 
 为了解决这种最常见的item样式的偷懒工作
 
 极简模式
    app:show_img="false"//默认显示图片，必须设置为false
    app:tv_description="adsfasdf"
    app:tv_title="zhege"
    
详情模式
<com.example.lq.viewcommonitem.ViewCommonItem
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="@null"
        app:img_left_margin="20dp"
        app:show_img="true"
        app:img_src="@mipmap/ic_launcher"
        app:right_img="@mipmap/icon_share"
        app:right_img_right_margin="10dp"
        app:tv_description="adsfasdf"
        app:tv_description_color="@color/cyan_70df57"
        app:tv_description_right_margin="30dp"
        app:tv_description_size="12sp"
        app:tv_title="zhege"
        app:tv_title_color="@color/orange_ff651a"
        app:tv_title_left_margin="10dp"
        app:tv_title_size="10sp"

        ></com.example.lq.viewcommonitem.ViewCommonItem>
