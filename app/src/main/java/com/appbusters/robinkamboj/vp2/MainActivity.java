package com.appbusters.robinkamboj.vp2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.allattentionhere.autoplayvideos.AAH_CustomRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<MyModel> modelList = new ArrayList<>();
    AAH_CustomRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("ONCREATE", "MA");

        recyclerView = (AAH_CustomRecyclerView) findViewById(R.id.rv_home);

        Picasso p = Picasso.with(this);

        //todo before setAdapter
        recyclerView.setActivity(this);

        modelList.add(new MyModel("https://youtu.be/HRzzglgC180", "https://1.bp.blogspot.com/-KOrgmRC8Nj0/WSh6_7z7ryI/AAAAAAAAASc/_O4UwRnmDsAZ2IFzIAh_eKXuVh9gti_CACK4B/s320/yoga2.jpg", "MP4 VIDEO"));
        modelList.add(new MyModel("http://www.sample-videos.com/video/flv/240/big_buck_bunny_240p_2mb.flv", "https://3.bp.blogspot.com/-O-kG5WpcVa8/WSh-Fh2m0_I/AAAAAAAAAS8/TwAT0D23cx0sQ0oCu_cKkPVL8MdAACtWgCK4B/s320/Buddha%2BSpiritual%2BBuddha%2B%2BAbstract%2B3D%2Band%2BCG%2BHD%2BDesktop%2BWallpaper.jpg", "FLV VIDEO"));
        modelList.add(new MyModel("https://2.bp.blogspot.com/-WRX6ve0MElM/WIo5bgJHUwI/AAAAAAAAAEE/MyQEbOh2Rho7PMHck98bFfoa9fCZ83qvQCLcB/s320/1.jpg", "JPG IMAGE"));
        modelList.add(new MyModel("http://www.sample-videos.com/video/flv/240/big_buck_bunny_240p_2mb.flv", "https://3.bp.blogspot.com/-TS-cRx0ckOY/WJ4h0MiepKI/AAAAAAAAAGY/6Im2ByybWEQ7PLOT9qLzvWUlsc6Wk3sjgCLcB/s320/one.jpg", "MKV VIDEO"));
        modelList.add(new MyModel("http://www.sample-videos.com/video/3gp/240/big_buck_bunny_240p_5mb.3gp", "https://1.bp.blogspot.com/-osLp51eo35c/WJ4hzg9lmKI/AAAAAAAAAGU/SrD1dvItE-g0--55uao-H3HdN1nbAMJ3ACLcB/s320/two.jpg", "3GP VIDEO"));
        modelList.add(new MyModel("https://3.bp.blogspot.com/-7Fbv9Mcj8Ho/WIo5cjN-EOI/AAAAAAAAAEM/CtwvYPu184goLOWknhMyxSg8eQX55EaCACLcB/s320/5.jpg", "JPG IMAGE TOO"));

        MyVideosAdapter mAdapter = new MyVideosAdapter(modelList, p);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //optional - to play only first visible video
        recyclerView.setPlayOnlyFirstVideo(true); // false by default

//        //optional - by default we check if url ends with ".mp4". If your urls do not end with mp4, you can set this param to false and implement your own check to see if video points to url
//        recyclerView.setCheckForMp4(false);
//
//        //optional - download videos to local storage (requires "android.permission.WRITE_EXTERNAL_STORAGE" in manifest or ask in runtime)
//        recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default
//
//        recyclerView.setDownloadVideos(true); // false by default
//
//        //extra - start downloading all videos in background before loading RecyclerView
//        List<String> urls = new ArrayList<>();
//        for (MyModel object : modelList) {
//            if (object.getVideo_url() != null && object.getVideo_url().contains("http"))
//                urls.add(object.getVideo_url());
//        }
//        recyclerView.preDownload(urls);

        recyclerView.setAdapter(mAdapter);
        //to init videos before scrolling
        recyclerView.smoothScrollBy(0, 1);
        recyclerView.smoothScrollBy(0, -1);

    }
}
