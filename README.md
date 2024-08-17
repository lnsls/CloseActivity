# CloseActivity
Activity是Android最常用的组件之一，Activity可以用来显示界面，被打开的Activity始终要关闭，本Demo将介绍几种常用的Activity关闭方法。

## 关闭当前Activity
```java
//关闭当前Activity方法一  
finish();  
      
//关闭当前Activity方法二  
android.os.Process.killProcess(android.os.Process.myPid());  
      
//关闭当前Activity方法三  
System.exit(0);  
  
//关闭当前Activity方法四  
this.onDestroy(); 
```

## 关闭指定Activity

例如:在ActivityB中关闭ActivityA.

1.在ActivityA里创建静态变量instance，初始化为this
```java
public static ActivityA instance = null;
instance = this;
```

2.在 ActivityB里执行ActivityA.instance.finish()来关闭ActivityA
```java
ActivityA.instance.finish();
```

## 关闭所有Activity

1.创建用来处理Activity的类

```java
public class MyApplication extends Application {

    //使用list来保存每一个activity
    private List<Activity> mList = new LinkedList<Activity>();

    //为了实现每次使用该类时不创建新的对象而创建的静态对象  
    private static MyApplication instance;

    //构造方法  
    private MyApplication() {

    }

    //实例化一次  
    public synchronized static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }

    // add Activity    
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    //关闭每一个list里的Activity
    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    //杀进程  
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

}  
```

2.在每个Activity被创建时将该Activity添加到list中去
```java
MyApplication.getInstance().addActivity(this);
```

3.调用MyApplication的exit方法关闭所有Activity
```java
MyApplication.getInstance().exit();
```

## 参考
admin1
## 交个朋友
欢迎右上角Start/Fork！
你也可以关注[我的博客](http://lns666.me/)，和我做朋友。

