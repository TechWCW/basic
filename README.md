# #Basic

## 项目介绍

本项目采用kotlin开发，封装了安卓mvvm基础，包含BaseActivity和BaseFragment等基类，通过kotlin扩展函数的特效封装了多种常用API,例如toast。将该项目作为module添加依赖，则在使用时，可不用通过`'Toast.makeText(this, "xxx", duration).show()'`这种方式，可使用toast("xxx"),duration作为可选参数。扩展函数会逐步丰富，可有效减少模板代码。

## 项目结构

├── build.gradle
├── proguard-rules.pro
└── src
    ├── main
    │   ├── AndroidManifest.xml
    │   ├── java
    │   │   └── tech
    │   │       └── wcw
    │   │           └── basic
    │   │               ├── BasicConfig.kt
    │   │               ├── Ext.kt---------------------------------------扩展函数封装
    │   │               ├── LifecycleHandler.kt--------------------无内存泄漏风险的Handler
    │   │               ├── adapter
    │   │               │   └── SimpleRecyclerAdapter.kt----简单易用的RecyclerAdapter
    │   │               ├── base
    │   │               │   ├── BaseActivity.kt---------------------基类Activity
    │   │               │   ├── BaseFragment.kt-----------------基类Fragement
    │   │               │   ├── BaseViewModel.kt---------------基类ViewModel
    │   │               │   ├── CallBack.kt--------------------------网络请求回调
    │   │               │   └── Repository.kt----------------------Repository接口，暂无方法
    │   │               ├── bus
    │   │               │   ├── LiveDataBus.kt
    │   │               │   └── StatefulLiveData.kt
    │   │               ├── net
    │   │               │   ├── HttpsHelper.kt
    │   │               │   ├── MyDNS.kt---------------------------自定义DNS解析，用于解决小米手机网络问题
    │   │               │   └── RetrofitFactory.kt----------------Retrofit封装
    │   │               └── widget
    │   │                   └── ListViewInScrollView.kt

## 如何使用

#### Step 1. Add the JitPack repository to your build file

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
#### Step 2. Add the dependency

```groovy
dependencies {
	        implementation 'com.github.TechWCW:basic:v1.0.0.beta'
	}
```

