package com.youngmanster.collectionlibrary.config;

import android.content.Context;

import java.util.Map;


/**
 * 使用项目需要的配置
 * Created by yangyan
 * on 2018/3/17.
 */

public class Config {
    /**必传参数**/
    //是否为BuildConfig.DEBUG,日志输出需要
    public static boolean DEBUG;
    //设置Context
    public static Context CONTEXT;
    /**Retrofit**/
    //网络请求的域名
    public static String URL_DOMAIN;
    //网络缓存地址
    public static String URL_CACHE;
    //设置OkHttp的缓存机制的最大缓存时间,默认为一天
    public static long MAX_CACHE_SECONDS= 60 * 60 * 24;
    //缓存最大的内存,默认为10M
    public static long MAX_MEMORY_SIZE=10 * 1024 * 1024;
    //设置网络请求json通用解析类
    public static Class MClASS;
    public static String EXPOSEPARAM;
    /**SharePreference**/
    public static String USER_CONFIG="collection_android_library_user_config";

    /***请求接口超时设定**/
    public static int CONNECT_TIMEOUT_SECONDS=60;
    public static int READ_TIMEOUT_SECONDS=60;
    public static int WRITE_TIMEOUT_SECONDS=60;

    /***设置全局请求头***/
    public static Map<String,String> HEADERS;

    /*****数据库设置**/
    public static String SQLITE_DB_NAME="collection_android_library.db";
    public static int SQLITE_DB_VERSION=0;
}
