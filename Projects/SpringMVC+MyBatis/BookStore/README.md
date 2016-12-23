# 概况
该项目为实现一个简单的网上书店demo，涉及不同权限登录、书籍形成购买记录（类似订单）、后台书籍增删改查等。初始结构采用了jsp+servlet+jdbc的形式，分三次大步骤最终将该项目转化为jsp+springMVC+MyBatis的形式。

 - 将servlet担任的controller角色更替为springMVC；
 - 将jdbc的持久层更改为MyBatis形式；
 - 对springMVC和MyBatis进行整合。

# 关于Tag
部分需要特别备注的更迭，将会在git中以tag标签的形式进行标记。
 - v1.0：初始结构 jsp+servlet+jdbc; IDEA+Maven


# 项目收获小结
## SpringMVC的基本模型
<img src="https://github.com/deng-cc/KeepLearning/raw/master/pics/spring/springMVC_model_01.JPG" width="700"  /><br>
<img src="https://github.com/deng-cc/KeepLearning/raw/master/pics/spring/springMVC_model_02.JPG" width="700"  />

 1. **请求 --> DispatcherServlet**：前端控制器作为统一访问点，自己不处理请求，而是委托给其他解析器进行处理，它本身用来进行全局的流程控制；
 2. **DispatcherServlet --> HandlerMapping**：HandleMapping把请求映射为HandlerExecutionChain对象（包含一个Handler处理器（页面控制器）对象、多个HandlerInterceptor拦截器）对象；
 3. **DispatcherServlet --> HandlerAdapter**：HandlerAdapter将会把处理器包装为适配器，从而支持多种类型的处理器，即适配器设计模式的应用；
 4. **HandlerAdapter --> 处理器功能处理方法的调用**：HandlerAdapter将会根据适配的结果调用真正的处理器的功能处理方法，完成功能处理，并返回一个ModelAndView对象（包含模型数据、逻辑视图名）；
 5. **ModelAndView的逻辑视图名 --> ViewResolver**：ViewResolver将把逻辑视图名解析为具体的View，通过这种策略模式，很容易更换其他视图技术；
 6. **View --> 渲染**：View会根据传进来的Model模型数据进行渲染，此处的Model实际是一个Map数据结构，因此很容易支持其他视图技术；
 7. **返回控制权给DispatcherServlet**：由DispatcherServlet返回响应给用户，到此一个流程结束（此处流程只描述了核心，未考虑拦截器等）。


`***所以具体的核心开发步骤为***`
1、DispatcherServlet在web.xml中的部署描述；
2、HandlerMappng的配置；
e.g.
>&lt;bean id="handlerMapping" class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"&gt;
>>默认的映射处理器，该映射处理器表示将请求的URL和Bean名字映射，如URL为 “上下文/hello”，则Spring配置文件必须有一个名字为“/hello”的Bean。所以后端控制器的beanName必须"/"开头，同时也支持通配符。

3、HandlerAdapter的配置，从而支持多种类型的处理器；
4、ViewResolver的配置，从而将逻辑视图名解析为具体视图技术；
5、处理器（页面控制器）的配置，从而进行功能处理。


	  
参考链接：<br>
[第二章 Spring MVC入门 —— 跟开涛学SpringMVC][1]<br>
[跟开涛学SpringMVC（4.5）：Controller接口控制器详（5）][2]（关键字：InternalPathMethodNameResolver）<br>
[学无止境：springMVC][3]（关键字：MultiActionController）<br>





## 如何让jsp页面更安全？
MVC模型，正确的流程应该是 `客户端请求-->Controller-->View-->客户端`，但是我们可以通过浏览器地址的方式直接访问jsp，而页面往往需要数据填充，也就是说我们这样直接访问，会出现错误。
>如何避免？
>>我们知道，WEB-INF目录是不对外开放的，外部没法直接通过URL访问。所以，将jsp页面放入到WEB-INF文件夹之下，这样可以限制访问，提供安全性。

当然，这种做法也是褒贬不一，有好处也有坏处。

 - [讨论：关于jsp页面是放在webroot目录下和web-inf下优缺点][4]


  [1]: http://jinnianshilongnian.iteye.com/blog/1594806
  [2]: http://ju.outofmemory.cn/entry/257271
  [3]: http://www.cnblogs.com/duanxz/p/3755788.html
  [4]: http://bbs.csdn.net/topics/320097731