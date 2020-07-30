# AndroidUIBlockTesting
Android UI 卡顿检测例子
参考 [Android UI性能优化 检测应用中的UI卡顿](https://blog.csdn.net/lmj623565791/article/details/58626355)

目前已经有两种比较典型方式来检测了：

1. 利用UI线程Looper打印的日志
2. 利用Choreographer
两种方式都有一些开源项目，例如：

1. https://github.com/markzhai/AndroidPerformanceMonitor [方式1]
2. https://github.com/wasabeef/Takt [方式2]
3. https://github.com/friendlyrobotnyc/TinyDancer [方式2]
