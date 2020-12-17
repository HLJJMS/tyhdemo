# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

			#指定代码的压缩级别
    		-optimizationpasses 5

    		#包明不混合大小写
    		-dontusemixedcaseclassnames

    		#不去忽略非公共的库类
    		-dontskipnonpubliclibraryclasses

    		 #优化  不优化输入的类文件
    		-dontoptimize

    		 #不做预校验
    		-dontpreverify

    		 #混淆时是否记录日志
    		-verbose

    		 # 混淆时所采用的算法
    		-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

    		#保护注解
    		-keepattributes *Annotation*

    		# 保持哪些类不被混淆
    		-keep public class * extends android.app.Fragment
    		-keep public class * extends android.app.Activity
    		-keep public class * extends android.app.Application
    		-keep public class * extends android.app.Service
    		-keep public class * extends android.content.BroadcastReceiver
    		-keep public class * extends android.content.ContentProvider
    		-keep public class * extends android.app.backup.BackupAgentHelper
    		-keep public class * extends android.preference.Preference



    		##记录生成的日志数据,gradle build时在本项目根目录输出##

    		#apk 包内所有 class 的内部结构
    		-dump class_files.txt
    		#未混淆的类和成员
    		-printseeds seeds.txt
    		#列出从 apk 中删除的代码
    		-printusage unused.txt
    		#混淆前后的映射
    		-printmapping mapping.txt

    		########记录生成的日志数据，gradle build时 在本项目根目录输出-end######


    		#####混淆保护自己项目的部分代码以及引用的第三方jar包library#######

    		#-libraryjars libs/umeng-analytics-v5.2.4.jar

    		#三星应用市场需要添加:sdk-v1.0.0.jar,look-v1.0.1.jar
    		#-libraryjars libs/sdk-v1.0.0.jar
    		#-libraryjars libs/look-v1.0.1.jar

    		#项目特殊处理代码

    		#忽略警告
    		-dontwarn com.lippi.recorder.utils**
    		#保留一个完整的包
    		-keep class wlm.DownLoadIntentService.*

    		-keep class  wlm.diyview.*

	        -keep class  wlm.bean.*

	        -keep class  wlm.base.*

	        -keep class  wlm.adapter.*
    		#如果引用了v4或者v7包
    		-dontwarn android.support.**

    		####混淆保护自己项目的部分代码以及引用的第三方jar包library-end####

    		-keep public class * extends android.view.View {
    		    public <init>(android.content.Context);
    		    public <init>(android.content.Context, android.util.AttributeSet);
    		    public <init>(android.content.Context, android.util.AttributeSet, int);
    		    public void set*(...);
    		}

    		#保持 native 方法不被混淆
#    		-keepclasseswithmembernames class * {
#    		    native <methods>;
#    		}

    		# Keep names - Native method names. Keep all native class/method names.
            -keepclasseswithmembers,allowshrinking class * {
                native <methods>;
            }

    		#保持自定义控件类不被混淆
    		-keepclasseswithmembers class * {
    		    public <init>(android.content.Context, android.util.AttributeSet);
    		}

    		#保持自定义控件类不被混淆
    		-keepclassmembers class * extends android.app.Activity {
    		   public void *(android.view.View);
    		}

    		#保持 Parcelable 不被混淆
    		-keep class * implements android.os.Parcelable {
    		  public static final android.os.Parcelable$Creator *;
    		}

    		#保持 Serializable 不被混淆
    		-keepnames class * implements java.io.Serializable

    		#保持 Serializable 不被混淆并且enum 类也不被混淆
    		-keepclassmembers class * implements java.io.Serializable {
    		    static final long serialVersionUID;
    		    private static final java.io.ObjectStreamField[] serialPersistentFields;
    		    !static !transient <fields>;
    		    !private <fields>;
    		    !private <methods>;
    		    private void writeObject(java.io.ObjectOutputStream);
    		    private void readObject(java.io.ObjectInputStream);
    		    java.lang.Object writeReplace();
    		    java.lang.Object readResolve();
    		}

    		#保持枚举 enum 类不被混淆 如果混淆报错，建议直接使用上面的 -keepclassmembers class * implements java.io.Serializable即可
    		#-keepclassmembers enum * {
    		#  public static **[] values();
    		#  public static ** valueOf(java.lang.String);
    		#}

    		-keepclassmembers class * {
    		    public void *ButtonClicked(android.view.View);
    		}

    		#不混淆资源类
    		-keepclassmembers class **.R$* {
    		    public static <fields>;
    		}
    		-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
              public *;
            }
            -keepclassmembers class * extends android.webkit.WebViewClient {
              public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
              public boolean *(android.webkit.WebView, java.lang.String);
            }
            -keepclassmembers class * extends android.webkit.WebViewClient {
              public void *(android.webkit.WebView, jav.lang.String);
            }
#fastjson
-keepnames class * implements  java.io.Serializable
-keep public class * implements  java.io.Serializable {
   public *;
}
-keepclassmembers class * implements  java.io.Serializable {
    static final long serialVersionUID;
    private static final  java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject( java.io.ObjectOutputStream);
    private void readObject( java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# FastJson 混淆代码
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.** { *; }
-keepattributes Signature
-keepattributes *Annotation*
#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
 **[] $VALUES;
 public *;
}

#okhttp
-dontwarn okio.**
-keep class okio.**{*;}
-keep interface okio.**{*;}
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}
-keep interface okhttp3.**{*;}

#Rxjava
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
  long producerIndex;
  long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
  rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
  rx.internal.util.atomic.LinkedQueueNode consumerNode;
}
##--------------- Gson ----------
# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Prevent R8 from leaving Data object members always null
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
##--------------- Gson ----------
#retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keep public class * extends retrofit2.Converter {*;}
#baidu
-keep class com.baidu.** {*;}
-keep class vi.com.** {*;}
-dontwarn com.baidu.**

##################################信鸽######################################
-keep class com.tencent.android.tpush.** {* ;}
-keep class com.tencent.mid.** {* ;}
-keep class com.qq.taf.** {*;}
-keep public class * extends com.qq.taf.jce.JceStruct{*;}

##--------------- JzVD ----------
-keep public class cn.jzvd.JZMediaSystem {*; }
-keep public class cn.jzvd.demo.CustomMedia.CustomMedia {*; }
-keep public class cn.jzvd.demo.CustomMedia.JZMediaIjk {*; }
-keep public class cn.jzvd.demo.CustomMedia.JZMediaSystemAssertFolder {*; }

-keep class tv.danmaku.ijk.media.player.** {*; }
-dontwarn tv.danmaku.ijk.media.player.*
-keep interface tv.danmaku.ijk.media.player.** { *; }
##--------------- JzVD ----------

##--------------- QmUi ----------
-keep class **_FragmentFinder { *; }
-keep class androidx.fragment.app.* { *; }

-keep class com.qmuiteam.qmui.arch.record.RecordIdClassMap { *; }
-keep class com.qmuiteam.qmui.arch.record.RecordIdClassMapImpl { *; }

-keep class com.qmuiteam.qmui.arch.scheme.SchemeMap {*;}
-keep class com.qmuiteam.qmui.arch.scheme.SchemeMapImpl {*;}
##--------------- QmUi ----------
##--------------- EventBus ----------
-keep class org.simple.** { *;}
-keep interface org.simple.** { *;}
-keepclassmembers class * {
    @org.simple.eventbus.Subscriber <methods>;
}
##--------------- EventBus ----------

#gsyvideoplayer
-keep class com.shuyu.gsyvideoplayer.video.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.video.**
-keep class com.shuyu.gsyvideoplayer.video.base.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.video.base.**
-keep class com.shuyu.gsyvideoplayer.utils.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.utils.**
-keep class tv.danmaku.ijk.** { *; }
-dontwarn tv.danmaku.ijk.**

-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}