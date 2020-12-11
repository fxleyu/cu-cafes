# Hello Java
主要涉及 Java JDK 中的 API 学习、测试

主要知识点：
- 集合
- 并发
- 反射等

# JVM
## 使用 CMS
指定参数 `-XX:+UseConcMarkSweepGC`, 获取 GC 信息如下：
```
CodeCacheManager : [Code Cache]
Metaspace Manager : [Metaspace, Compressed Class Space]
ParNew : [Par Eden Space, Par Survivor Space]
ConcurrentMarkSweep : [Par Eden Space, Par Survivor Space, CMS Old Gen]
```

