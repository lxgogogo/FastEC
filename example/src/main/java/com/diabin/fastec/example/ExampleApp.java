package com.diabin.fastec.example;

import android.support.multidex.MultiDexApplication;

import com.flj.latte.app.Latte;
import com.diabin.fastec.example.event.TestEvent;
import com.flj.latte.ec.database.DatabaseManager;
import com.flj.latte.ec.icon.FontEcModule;
import com.flj.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by 傅令杰 on 2017/3/29
 */
public class ExampleApp extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://192.168.31.80:8080/RestServer/api/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withWeChatAppId("wxfcdcecd9df8e0faa")
                .withWeChatAppSecret("a0560f75335b06e3ebea70f29ff219bf")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                .configure();
//        initStetho();
        DatabaseManager.getInstance().init(this);
    }

//    private void initStetho() {
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                        .build());
//    }
}
