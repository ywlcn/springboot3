SpringSecurity



https://qiita.com/opengl-8080/items/7c34053c74448d39e8f5







# 1. 概要   

- SpringFrameworkの一員として提供されている。`org.springframework.boot:spring-boot-starter-security`という依存関係を追加することで適用される
- 提供機能
  - 認証
    - アプリケーションを利用するユーザーの正当性を確認する機能。
  - 認可
    - アプリケーションが提供するリソースや処理に対してアクセスを制御する機能。
  - 他のセキュリティ機能
    - セッション管理機能
    - CSRF   COR
    - セキュリティヘッダ出力機能

https://spring.pleiades.io/spring-security/reference/servlet/architecture.html

# 2. アーキテクチャ

![Architecture](./images/Architecture.png)

- （２）リクエストUrlは安全かどうかのチェックを行う（デフォルトは`DefaultHttpFirewall`、推薦は`StrictHttpFirewall`）

  `RequestRejectedException`という例外が発生する。

- （３）リクエストUrlによって、初めてマッチングした`SecurityFilterChain`を選べて、その`SecurityFilterChain`の`Filter`を実施する

![spring-security](./images/spring-security.bmp)

## 2.1 各種フィルタの機能

- org.springframework.security.web.session.DisableEncodeUrlFilter

  HttpServletResponseを使用したURLのエンコードを無効にする

  URLにセッションIDが含まれる可能性があり、そのままHttpアクセスログに出力すると、セッションIDが漏れる可能性がある。

- org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter

  SecurityContextとWebAsyncManagerを関連するようにする。Callback時SecurityContext関連の処理も呼び出せる

- org.springframework.security.web.context.SecurityContextHolderFilter

  SecurityContextの生成・削除を実施する。（Requestにはマックをつけるのみ、保持はSecurityContextHolderからのStatic関数を利用して取得）

  ログイン済みの場合にはSessionからログイン済み情報をSecurityContextに関連する

- org.springframework.security.web.header.HeaderWriterFilter（★）  Insecure（？）

  HTTPレスポンスヘッダーにセキュリティ関係のものを付与するフィルター(HttpSecurityからカスタマイズ可能)

  ```java
  //addIfNotNull(writers, this.contentTypeOptions.writer);　　　　　X-Content-Type-Options", "nosniff"
  //addIfNotNull(writers, this.xssProtection.writer);　　　　　　　　X-XSS-Protection"
  addIfNotNull(writers, this.cacheControl.writer);　　　　　　　　
  Expires　、　Pragma　、Cache-Control
  
  addIfNotNull(writers, this.hsts.writer);　　Strict-Transport-Security     HTTP Strict Transport Security
  //addIfNotNull(writers, this.frameOptions.writer);　　　　　　　　　X-Frame-Options:　DENY    ->クリックジャッキング
  addIfNotNull(writers, this.hpkp.writer);
  Public-Key-Pins
  Public-Key-Pins-Report-Only
  
  //addIfNotNull(writers, this.contentSecurityPolicy.writer);
  //Content-Security-Policy　　Content-Security-Policy-Report-Only　　　　　　　　　　　　default-src 'self'
  
  
  addIfNotNull(writers, this.referrerPolicy.writer);　　Referrer-Policy
  addIfNotNull(writers, this.featurePolicy.writer);　　　　　　　　Feature-Policy
      
  addIfNotNull(writers, this.permissionsPolicy.writer);　　　　　　　　Permissions-Policy
      
  addIfNotNull(writers, this.crossOriginOpenerPolicy.writer);　　　　　　　Cross-Origin-Opener-Policy
  addIfNotNull(writers, this.crossOriginEmbedderPolicy.writer);　　　　　Cross-Origin-Embedder-Policy
  addIfNotNull(writers, this.crossOriginResourcePolicy.writer);　　　　　　　Cross-Origin-Resource-Policy
  ```

- org.springframework.web.filter.CorsFilter（★）

  ???????????????????

- org.springframework.security.web.csrf.CsrfFilter（★）

  ???????????????????

- org.springframework.security.web.authentication.logout.LogoutFilter（★）

  ログアウト時動作される（ログイン画面でログアウトボタンが押下される場合）

  セッションから関連認証やcsrf情報をクリアして、ログイン画面にリダイレクトする。

- org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter（★）

  ログイン画面でログインボタンを押下する際の動作

- org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter（★）

  `/login`（設定可能）にアクセスやパスワード認証エラーやログアウト成功時のみ当該フィルターが動作される

  ログイン画面のHtml画面を生成して、返す。

- org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter（★）

  `/logout`（設定可能）にアクセス時のみ当該フィルターが動作される

  ログアウト画面のHtml画面を生成して、返す。

- org.springframework.security.web.authentication.www.BasicAuthenticationFilter（★）

  ???????????????????

- org.springframework.security.web.savedrequest.RequestCacheAwareFilter

  未ログイン状態でアクセスしてきたユーザに対して、ログイン後、元のリクエストを復元する機能

  RequestCacheの機能により、デフォルトだとHttpSessionにHttpServletRequestの内容が保存されています。

  保存場所はSpringSession機能により切り替えます。

- org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter

  リダイレクトをラップする`SecurityContextHolderAwareRequestWrapper`

- org.springframework.security.web.authentication.AnonymousAuthenticationFilter

  `SecurityContextHolder`に認証情報がないと、匿名の認証情報を作成して`SecurityContextHolder`に格納

- org.springframework.security.web.access.ExceptionTranslationFilter

  https://spring.pleiades.io/spring-security/reference/servlet/architecture.html#servlet-exceptiontranslationfilter

  下りのみ稼働　後続処理から認証・認可に関する例外がThrowされた場合、その例外の内容に応じて処理を行います。

  認証されていない例外の場合はこのフィルターから認証処理を開始する

  認可に関する例外の場合は　AccessDeniedHandlerに処理が異常されます。

  - レスポンスに`Location: http://localhost:8081/login `を付ける

- org.springframework.security.web.access.intercept.AuthorizationFilter

  認可を行う。失敗すると`AccessDeniedException`





## 2.x セキュリティ例外の処理







```java
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
            .addHeaderWriter(new StaticHeadersWriter("x-neko", "nyan"))
    }
```



## 2.3パスワードの生成

```plain
org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration : 

Using generated security password: 14b31fe3-0aef-4441-a977-1bb44cc591fb
```





# 3. 各種セキュリティ対策

## 3.1 [セッション管理の不備](https://www.ipa.go.jp/security/vuln/websecurity/session-management.html)

- セッションIDを推測が困難なものにする

  SpringSessionではSessionId生成のカスタマイズを提供している　　 <検証>

  ```java
  @Bean
  public SessionIdGenerator sessionIdGenerator() {
      return new MySessionIdGenerator();
  }
  
  class MySessionIdGenerator implements SessionIdGenerator {
  
      @Override
      public String generate() {
          // ...
      }
  
  }
  ```

- セッションIDをURLパラメータに格納しない

  

- HTTPS通信で利用するCookieにはsecure属性を加える

  - SpringSecurity

    ```
            http.rememberMe(rememberMe -> {
                rememberMe.useSecureCookie(true);
            });
    ```

  - SpringSession

    ```java
        @Bean
        public CookieSerializer cookieSerializer() {
            DefaultCookieSerializer serializer = new DefaultCookieSerializer();
            serializer.setCookieName("JSESSIONID");
            serializer.setCookiePath("/");
            serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
            serializer.setUseSecureCookie(true);
            return serializer;
        }
    ```

    

- セッションID固定化攻撃

  SpringScurityではログイン成功時Sessionの動きは定義することができる

  | #    | オプション        | 説明                                                         |
  | ---- | :---------------- | :----------------------------------------------------------- |
  | 1    | `changeSessionId` | Servlet 3.1で追加された`HttpServletRequest#changeSessionId()`を使用してセッションIDを変更する。(これはServlet 3.1以上のコンテナ上でのデフォルトの動作である) |
  | 2    | `migrateSession`  | ログイン前に使用していたセッションを破棄し、新たにセッションを作成する。このオプションを使用すると、ログイン前にセッションに格納されていたオブジェクトは新しいセッションに引き継がれる。(Servlet 3.0以下のコンテナ上でのデフォルトの動作の動作である) <br>#1と同じ見た目が、内部的にコピーの作業がある。性能改善のために#1にシフトしているかな |
  | 3    | `newSession`      | このオプションは`migrateSession`と同じ方法でセッションIDを変更するが、ログイン前に格納されていたオブジェクトは新しいセッションに引き継がれない。 |
  | 4    | `none`            | Spring Securityは、セッションIDを変更しない。                |








## 3.2 CSRF(Cross site request forgeries)対策

### 3.2.1 [CSRF概要](https://www.ipa.go.jp/security/vuln/websecurity/csrf.html)

CSRFとは、Webサイトにスクリプトや自動転送(HTTPリダイレクト)を実装することにより、ログイン済みの別のWebサイト上で、ユーザーが意図しない何らかの操作を行わせる攻撃手法のことである。

サーバ側でCSRFを防ぐには、以下の方法が知られている。

- 秘密情報(トークン)の埋め込み
- パスワードの再入力
- Refererのチェック

CSRF対策機能は、攻撃者が用意したWebページから送られてくる偽造リクエストを不正なリクエストとして扱うための機能である。

CSRF対策が行われていないWebアプリケーションを利用すると、以下のような方法で攻撃を受ける可能性がある。

- 利用者は、CSRF対策が行われていないWebアプリケーションにログインする。
- 利用者は、攻撃者からの巧みな誘導によって、攻撃者が用意したWebページを開いてしまう。
- 攻撃者が用意したWebページは、フォームの自動送信などのテクニックを使用して、偽造したリクエストをCSRF対策が行われていないWebアプリケーションに対して送信する。
- CSRF対策が行われていないWebアプリケーションは、攻撃者が偽造したリクエストを正規のリクエストとして処理してしまう。



![Csrf](./images/Csrf.png)

### 3.2.1 SpringSecurtyの対策

- 設定

  ```Java
      @Bean
      public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http.authorizeHttpRequests((authorize) -> {
                      authorize.requestMatchers("/login").permitAll();
                      authorize.anyRequest().authenticated();
                  }
          );
  
          http.headers(header -> {
              header.crossOriginEmbedderPolicy(policy -> policy.policy(CrossOriginEmbedderPolicyHeaderWriter.CrossOriginEmbedderPolicy.UNSAFE_NONE));
          });
  
          http.csrf(csrf -> {
              csrf.ignoringRequestMatchers("/login");
              csrf.csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler());
              csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository());
          });
          return http.build();
      }
  
  ```

- Jspの埋め込み

  ```html
  <form action="csrf" method="POST">
      <textarea name="text"></textarea><br>
      <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}">
      <input type="submit">
      <p th:text="|CSRFトーク: ${_csrf.token}|" />
  </form>
  ```

ヘッダ？？？



## 3.3 XSS(Cross-site scripting)対策

### 3.2.1 XSS概要

- https://www.ipa.go.jp/security/vuln/websecurity/cross-site-scripting.html

### 3.2.2 SpringSecurtyの対策

`org.springframework.security.web.header.HeaderWriterFilter`で対応している。

- [X-Content-Type-Options](https://developer.mozilla.org/ja/docs/Web/HTTP/Headers/X-Content-Type-Options) クライアント側は指定したMIMEで解析

  ```http
  X-Content-Type-Options: nosniff
  ```

- [X-XSS-Protection](https://developer.mozilla.org/ja/docs/Web/HTTP/Headers/X-XSS-Protection) 標準機能ではなくて、↓ の設定によって、不要

- [Content-Security-Policy](https://developer.mozilla.org/ja/docs/Web/HTTP/Headers/Content-Security-Policy)

  ```http
  Content-Security-Policy: default-src 'self' http://example.com;
                            connect-src 'none';
  Content-Security-Policy: connect-src http://example.com/;
                            script-src http://example.com/
  ```

- [Content-Security-Policy-Report-Only](https://developer.mozilla.org/ja/docs/Web/HTTP/Headers/Content-Security-Policy-Report-Only)　↑ の監視結果をサーバへ通知（監視のような役割）

  ```http
  Content-Security-Policy-Report-Only: default-src 'none'; style-src cdn.example.com; report-uri /_/csp-reports
  ```

### 3.2.3

- XSSはユーザーのブラウザ内でスクリプトを実行することに焦点を当て（スクリプトの実施することで何でもできる・・・）
- CSRFは認証されたユーザーのリクエストを悪用して不正な操作を行わせることに焦点を当て(正式なサーバへ意識せずな操作が行ってしまう)

## 3.4 クリックジャッキング

### 3.4.1 概要

- https://www.ipa.go.jp/security/vuln/websecurity/clickjacking.html

### 3.2.2 SpringSecurtyの対策

`org.springframework.security.web.header.HeaderWriterFilter`でデフォルト対応している。「X-Frame-Options: DENY」というヘッダ

| **設定値** | **意味**                                                 |
| ---------- | -------------------------------------------------------- |
| DENY       | すべてのウェブページにおいてフレーム内の表示を禁止       |
| SAMEORIGIN | 同一オリジンのウェブページのみフレーム内の表示を許可     |
| ALLOW-FROM | 指定したオリジンのウェブページのみフレーム内の表示を許可 |




# 4. 