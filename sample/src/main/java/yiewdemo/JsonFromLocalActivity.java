package yiewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arthas.xjsonview.XViewMain;
import com.arthas.xjsonview.bean.XView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class JsonFromLocalActivity extends AppCompatActivity {


    private JsonFromLocalActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;

        String s = Util.readFile(context, "complaintDetail.json");
        XView yiew_1 = Util.gson.fromJson(s, XView.class);

        View contentView = XViewMain.startProcess(context,  yiew_1 );

        setContentView(contentView);



//        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/complaintDetail.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        XView yiew_1 = Util.gson.fromJson(s, XView.class);

                        View contentView = XViewMain.startProcess(context,  yiew_1 );
                        setContentView(contentView);



                    }
                });
    }




    public void refresh() {

        load();

    }
//    public void gotoDataSource() {
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://onzew89e9.bkt.clouddn.com/complaintDetail.json")));
//    }


}
