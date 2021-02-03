package tech.wcw.simple

import android.app.Application
import android.content.pm.PackageInstaller
import tech.wcw.basic.BasicConfig

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:30
 * @Description:
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        BasicConfig.initialize("http://127.0.0.1")
    }
}