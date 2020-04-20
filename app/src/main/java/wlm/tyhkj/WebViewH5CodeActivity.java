package wlm.tyhkj;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;;
import android.webkit.WebView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WebViewH5CodeActivity extends AppCompatActivity {

    @InjectView(R.id.wvIntroduce)
    WebView wvIntroduce;
    StringBuilder sb = new StringBuilder();
    String a = "<p>\n" +
            "\t<div style=\"margin:0px;padding:0px;\">\n" +
            "\t\t<div style=\"margin:0px auto;padding:0px;\">\n" +
            "\t\t\t<ul class=\"detail-list\">\n" +
            "\t\t\t\t<li class=\"on\" style=\"text-align:center;color:#424242;\">\n" +
            "\t\t\t\t\t<a>详情描述</a>\n" +
            "\t\t\t\t</li>\n" +
            "\t\t\t\t<li class=\"\" style=\"text-align:center;color:#424242;\">\n" +
            "\t\t\t\t\t<a>规格参数</a>\n" +
            "\t\t\t\t</li>\n" +
            "\t\t\t\t<li style=\"text-align:center;color:#424242;\">\n" +
            "\t\t\t\t\t<a>评价晒单(<span>0</span>)</a>\n" +
            "\t\t\t\t</li>\n" +
            "\t\t\t</ul>\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\t<div style=\"margin:0px;padding:0px;\">\n" +
            "\t\t<div style=\"margin:0px;padding:0px;text-align:center;\">\n" +
            "\t\t\t<div style=\"margin:0px auto;padding:0px;\">\n" +
            "\t\t\t\t<div style=\"margin:0px;padding:0px;\">\n" +
            "\t\t\t\t\t<p>\n" +
            "\t\t\t\t\t\t<img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_01(1).jpg\" width=\"1300\" height=\"1271\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_02.jpg\" width=\"1300\" height=\"1271\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_03(1).jpg\" width=\"1300\" height=\"1270\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_04.jpg\" width=\"1300\" height=\"1271\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_05(1).jpg\" width=\"1300\" height=\"1271\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_06.jpg\" width=\"1300\" height=\"1271\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_08.jpg\" width=\"1300\" height=\"1270\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_09(1).jpg\" width=\"1300\" height=\"1271\" alt=\"\" /><img src=\"http://shop.yiju.tm/images/upload/Image/BAO%E5%8D%95%E5%B1%82%E5%BA%8A_10.jpg\" width=\"1300\" height=\"1271\" alt=\"\" />\n" +
            "\t\t\t\t\t</p>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "</p>\n" +
            "<p>\n" +
            "\t<img src=\"http://asks.oss-cn-beijing.aliyuncs.com/aging/test/20190806/1565072470_zZx7Z.jpg\" width=\"273\" height=\"84\" alt=\"\" />\n" +
            "</p>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_h5_code);
        ButterKnife.inject(this);
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Our Love</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h2>Love<a href=\"http://love.shiningchen.cc\">"
                + "Shining</a></h2>");
        sb.append("</body>");
        sb.append("</html>");
        wvIntroduce.loadDataWithBaseURL(null, a.toString(), "text/html", "utf-8", null);
    }
}
