package com.example.ssl.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listview;
    private List<Map<String,Object>> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listview =(ListView)findViewById(R.id.List_View);
        initdata();
        MyAdapter adapter = new MyAdapter(this,datalist);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        
    }

    private void initdata() {
        datalist = new ArrayList<>();
        int[] imgs={R.drawable.a1,R.drawable.a2,R.drawable.a3};
        String[] titles={"美就对更多中国产品加税开听证会",
                "华为要美企付10亿美元专利费 美政客开始打脸表演",
                "为什么苹果华为腾讯，都要把数据中心建在贵州，有什么好处？"};
        String[] contents={"灾难性的”“大灾难”——美国《纽约时报》16日发文，如此形容美国拟对价值约3000亿美元中国产品加征关税的计划。当地时间6月17日，美国贸易代表办公室将举行公众听证会，讨论这一计划，300多家美国企业将派出代表作证，表达意见。报道称，与美国早前对中国产品加征关税主要针对工业和商业用品不同，下一轮关税的目标是玩具、服装等消费品。美国零售商就此发出警报：“关税威胁在最糟糕的时候到来。”近日，美国企业和行业组织已多次发声，反对扩大对中国产品加征关税，但这能否阻止美国政府越来越疯狂的关税战，是个未知数。",
                "著有《美国陷阱》的法国阿尔斯通前高管曾言：“美国会通过行政手段来打击美国企业的竞争对手。”所谓“枪打出头鸟”，阿尔斯通就曾中过招。但华为并非“小鸟”，而是一只“雄鹰”。",
                "最近两年大数据非常火爆，跟着大数据一起火爆的是贵州省，每年在贵阳举办的大数据峰会更是吸引来了全球各地商界大佬的参与。\n" +
                        "\n" +
                        "而且目前很多知名企业已经在贵阳建设大数据中心或者计划在贵州建设大数据中心，比如在贵安新区中的电子产业信息园内，目前聚集了三大运营商后，戴尔、谷歌、阿里巴巴、腾讯、百度、京东、华为等近300数据项目。\n" +
                        "\n" +
                        "目前贵州是首个国家级大数据综合试验区，贵州已有大数据企业超过9000家，产值超1100亿元，每年有上万名相关人才流入。"};
        for(int i=0;i<imgs.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("img",imgs[i]);
            map.put("title",titles[i]);
            map.put("content",contents[i]);
            datalist.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,InfoActivity.class);
        intent.putExtra("imageID",(int)datalist.get(position).get("img"));
        intent.putExtra("title",(String)datalist.get(position).get("title"));
        intent.putExtra("content",(String)datalist.get(position).get("content"));
        startActivity(intent);
    }
}
