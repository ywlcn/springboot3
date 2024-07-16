
JPA controller cities



GraphQL:

https://blog.csdn.net/weixin_40292704/article/details/126571912

https://github.com/graphql-java/java-dataloader

https://blog.csdn.net/weixin_40292704/article/details/122640307?spm=1001.2014.3001.5501

https://qiita.com/kazuki43zoo/items/ce88dea403c596249e8a



# 課題

- 非同期リクエスト発生するの根本的な制御ところはどこ？
  - HandlerFunction(GraphQlHttpHandler)                  GraphQlWebMvcAutoConfiguration
    - GraphQlHttpHandlerでDefaultAsyncServerResponseを作成して返す。

Servletで　ResoponseのwriteToを呼び出す　　　→　　DefaultAsyncServerResponseのwriteAsync　　 Tomcatの状態変更

​		Finish時のCallBackを登録　CompletableFuture<ServerResponse>

​		startDeferredResultProcessing



Servletコンテイナ

```
if (asyncManager.isConcurrentHandlingStarted()) {
    return;
}
```



- WebAsyncManagerの役割
- DeferredResultProcessingInterceptor、CallableProcessingInterceptor