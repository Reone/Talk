# Talk
[![](https://jitpack.io/v/Reone/Talk.svg)](https://jitpack.io/#Reone/Talk)

a simple easy thing toast

* 一个简单的容易使用的toast
* 它可以在任何线程中使用
* 连续弹出的toast，第二条会将第一条覆盖，而不需要等待第一条弹完
* 如果第二次需要显示的内容与第一条一致，且第一条没有显示完，则不会做任何事情


## 引用，添加依赖
```
allprojects {
    repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
dependencies {
	implementation 'com.github.Reone:Talk:1.0.1'
}

```

## 使用，它有如下三种使用方式
1. 如果你的Application中没有做什么事情的话，可以考虑将你应用的Application换成TalkApp
```xml
<application
	...
	android:name="com.reone.talklibrary.TalkApp"
	...>
</application>
```

需要弹出Toast的时候，你可以这样
```java
TalkApp.talk("text");
```

2. 如果你的Application中做了很多事情，你可以在你的Application中添加这些方法
```java
@SuppressLint("StaticFieldLeak")
    private static Talk talk;

    @Override
    public void onCreate() {
        super.onCreate();
        talk = new Talk(getApplicationContext());
    }

    public static void talk(String text){
        talk.talk(text);
    }

    public static void talk(int textId){
        talk.talk(textId);
    }
```

3. 如前两种方式，你可以在任何一个拿的到Context的地方使用new Talk(Context)获得talk的实例，然后使用。