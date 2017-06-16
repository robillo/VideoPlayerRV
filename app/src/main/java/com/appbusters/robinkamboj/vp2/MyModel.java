package com.appbusters.robinkamboj.vp2;

class MyModel {
    private final String image_url;
    private String video_url;
    private final String name;

    MyModel(String video_url, String image_url, String name) {
        this.video_url = video_url;
        this.image_url = image_url;
        this.name = name;
    }

    MyModel(String image_url, String name) {
        this.image_url = image_url;
        this.name = name;
    }

    String getImage_url() {
        return image_url;
    }

    String getVideo_url() {
        return video_url;
    }

    String getName() {
        return name;
    }
}
