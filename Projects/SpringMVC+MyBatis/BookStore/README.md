关于目录，强推该插件：https://github.com/summerblue/github-toc#toc4



# 概况
该项目为实现一个简单的网上书店demo，涉及不同权限登录、书籍形成购买记录（类似订单）、后台书籍增删改查等。初始结构采用了jsp+servlet+jdbc的形式，分三次大步骤最终将该项目转化为jsp+springMVC+MyBatis的形式。

 - 将servlet担任的controller角色更替为springMVC；
 - 将jdbc的持久层更改为MyBatis形式；
 - 对springMVC和MyBatis进行整合。


----------


# 关于todo
代码中大量使用了注释，其中不同开头对我个人代表不同的含义。

 - todo：表示还没有解决的问题，或者自己的疑惑；
 - hint：表示学习中的知识点，用于帮助自己提示和学习；
 - origin：该注释出现在源码中，主要用来帮助自己对于源码的解读和学习。

----------


# 项目收获小结
## 1）SpringMVC的基本模型
<img src="https://github.com/deng-cc/KeepLearning/raw/master/pics/spring/springMVC_model_01.JPG" width="700"  /><br>
<img src="https://github.com/deng-cc/KeepLearning/raw/master/pics/spring/springMVC_model_02.JPG" width="700"  />

 1. **请求 --> DispatcherServlet**：前端控制器作为统一访问点，自己不处理请求，而是委托给其他解析器进行处理，它本身用来进行全局的流程控制；
 2. **DispatcherServlet --> HandlerMapping**：HandleMapping把请求映射为HandlerExecutionChain对象（包含一个Handler处理器（页面控制器）对象、多个HandlerInterceptor拦截器）对象；
 3. **DispatcherServlet --> HandlerAdapter**：HandlerAdapter将会把处理器包装为适配器，从而支持多种类型的处理器，即适配器设计模式的应用；
 4. **HandlerAdapter --> 处理器功能处理方法的调用**：HandlerAdapter将会根据适配的结果调用真正的处理器的功能处理方法，完成功能处理，并返回一个ModelAndView对象（包含模型数据、逻辑视图名）；
 5. **ModelAndView的逻辑视图名 --> ViewResolver**：ViewResolver将把逻辑视图名解析为具体的View，通过这种策略模式，很容易更换其他视图技术；
 6. **View --> 渲染**：View会根据传进来的Model模型数据进行渲染，此处的Model实际是一个Map数据结构，因此很容易支持其他视图技术；
 7. **返回控制权给DispatcherServlet**：由DispatcherServlet返回响应给用户，到此一个流程结束（此处流程只描述了核心，未考虑拦截器等）。


<font color=#FF0000 size=4>**所以具体的核心开发步骤为**</font><br>
1、DispatcherServlet在web.xml中的部署描述；<br>
2、HandlerMapping的配置<br>
e.g.
>&lt;bean id="handlerMapping" class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"&gt;
>>默认的映射处理器，该映射处理器表示将请求的URL和Bean名字映射，如URL为 “上下文/hello”，则Spring配置文件必须有一个名字为“/hello”的Bean。所以后端控制器的beanName必须"/"开头，同时也支持通配符。

3、HandlerAdapter的配置，从而支持多种类型的处理器；<br>
4、ViewResolver的配置，从而将逻辑视图名解析为具体视图技术；<br>
5、处理器（页面控制器）的配置，从而进行功能处理。


	  
参考链接：
- [第二章 Spring MVC入门 —— 跟开涛学SpringMVC][1]
- [跟开涛学SpringMVC（4.5）：Controller接口控制器详（5）][2]（关键字：InternalPathMethodNameResolver）
- [学无止境：springMVC][3]（关键字：MultiActionController）
<br>

## 2）DispatcherServlet和ApplicationContext
<img src="https://github.com/deng-cc/KeepLearning/blob/master/pics/spring/springMVC_withWebApplicationContext.jpg?raw=true" width="700"  /><br>
之前也有提到，DispatcherServlet不作为请求的处理，而是控制，这里它会进行一个容器的初始化，包括容器中的Controller、HandlerMapping、ViewResolver等。
<br>
在源码中，大致的流程如下图（同时可参考源码中的origin注释）：
<img src="https://github.com/deng-cc/KeepLearning/blob/master/pics/spring/springMVC_dispatcherAndApplicationContext.jpg?raw=true" width="800"  />
<br>

## 3）SpringMVC核心架构图
### 3.1 核心架构图的核心流程
<img src="https://github.com/deng-cc/KeepLearning/blob/master/pics/spring/springMVC_workflow.jpg?raw=true" width="700"  /><br>
在DispatcherServlet和ApplicationContext中我们已经了解到了，DispatcherServlet的初始化和容器初始化的关系，那么请求到达DispatcherServlet，再由其发往我们自己写的Action的过程，又是怎样？
<br>
<br>
DispatcherServlet本质来说就是一个Servlet，那么其核心的方法service，就是根据不同的请求进行分发，比如doGet、doPost。
<br>
<br>
从源码中我们分析可以了解到，大概的流程是这样的：DispatcherServlet --> service() --> processRequest() --> doService() --> doDispatch()
<br>
<br>
那么在doDispatch()方法中，我们就可以看到我们熟悉的ModelAndView、HandlerExecutionChain、HandlerAdapter等，以及它会使用handle()方法去驱动我们真正的自定义的Action。（hint：从DispatcherServlet和ApplicationContext关系我们就知道，我们在spring-mvc.xml中配置的ViewResolver，在Tomcat启动时进行了初始化，已经存在了）

``` stylus
//origin doDispatch 重点：ModelAndView（用以表示所有动态的页面信息）
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpServletRequest processedRequest = request;
		HandlerExecutionChain mappedHandler = null; //origin HandlerExecutionChain
		boolean multipartRequestParsed = false;

		WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);

		try {
			ModelAndView mv = null;
			Exception dispatchException = null;

			try {
				processedRequest = checkMultipart(request);
				multipartRequestParsed = processedRequest != request;

				// Determine handler for the current request.
				mappedHandler = getHandler(processedRequest, false);
				if (mappedHandler == null || mappedHandler.getHandler() == null) {
					noHandlerFound(processedRequest, response);
					return;
				}

				// Determine handler adapter for the current request.
				HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler()); //origin HandlerAdapter

				// Process last-modified header, if supported by the handler.
				String method = request.getMethod();
				boolean isGet = "GET".equals(method);
				if (isGet || "HEAD".equals(method)) {
					long lastModified = ha.getLastModified(request, mappedHandler.getHandler());
					if (logger.isDebugEnabled()) {
						logger.debug("Last-Modified value for [" + getRequestUri(request) + "] is: " + lastModified);
					}
					if (new ServletWebRequest(request, response).checkNotModified(lastModified) && isGet) {
						return;
					}
				}
                //origin 前置拦截器
				if (!mappedHandler.applyPreHandle(processedRequest, response)) {
					return;
				}

				try {
					// Actually invoke the handler.
                    //origin handle() --> 驱动真正的Action
					mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
				}
				finally {
					if (asyncManager.isConcurrentHandlingStarted()) {
						return;
					}
				}

				applyDefaultViewName(request, mv);
                //origin 后置拦截器
				mappedHandler.applyPostHandle(processedRequest, response, mv);
			}
			catch (Exception ex) {
				dispatchException = ex;
			}
			processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
		}
		catch (Exception ex) {
			triggerAfterCompletion(processedRequest, response, mappedHandler, ex);
		}
		catch (Error err) {
			triggerAfterCompletionWithError(processedRequest, response, mappedHandler, err);
		}
		finally {
			if (asyncManager.isConcurrentHandlingStarted()) {
				// Instead of postHandle and afterCompletion
				mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest, response);
				return;
			}
			// Clean up any resources used by a multipart request.
			if (multipartRequestParsed) {
				cleanupMultipart(processedRequest);
			}
		}
	}
```
那么我们知道，在Controller完成之后，会将ModelAndView给视图解析器，在源码中，我们可以看到，在handle()方法执行完之后，会调用processDispatchResult ()方法，该方法调用render() --> resolveViewName()调用视图解析器来解析视图 + view.render()，最终转到了我们所看到的页面。
<br>
`注：以上的流程主要涉及核心流程，并非事无巨细地描述。在此处的记录，除了在底层去了解SpringMVC的运行机制以外，也更主要是为了便于今后对源码的回顾解析，起到导向牵引的作用。`
<br>
<br>
下面我们来看下相关的时序图：
<br>
<img src="https://github.com/deng-cc/KeepLearning/blob/master/pics/spring/springMVC_workflow_SequenceDiagram.jpg?raw=true" width="800"  />

### 3.2 核心流程中的doDispatch()和拦截器

`DispatcherServlet --> service() --> processRequest() --> doService() --> doDispatch()`
<br>
由上，我们看到大体的核心流程。那么我们聊一聊在这个关键方法doDispatch()里面发生的事情。<br>
那么在这个方法中，做了以下几个核心步骤：<br>

1. 通过HandlerMapping的getHandler()获取HandlerExecutionChain mappedHandler
（需要在xml中配置相关的HandlerMapping，用以解析URL）

2. 将HandlerExecutionChain作为参数，获得HandlerAdapter
（需要在xml中配置HandlerMapping对应的HandlerAdapter，用以适配Controller）
`HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());`

3. applyPreHandle()执行前置拦截器，调用拦截器的preHandle()
（如果有自定义拦截器，需要在xml中配置）

4. 调用HandlerAdapter的handle() --> 驱动真正的action（我们自定义的Controller）

5. applyPostHandle()执行后置拦截器

6. processDispatchResult()
- —6.1 render( ModelAndView mv, HttpServletRequest request, HttpServletResponse response )
- ——6.1.1 resolveViewName()
- ———6.1.1.1 viewResolver.resolveViewName() 调用视图解析器解析视图
- ——6.1.2 render() 传递

<br>
关于以上1、2、3点，结合项目中xml代码如下：
``` stylus
<!--映射器、适配器，和拦截器-->
    <bean id="handlerMapping" class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping">
    <!--hint：RequestMappingHandlerMapping，实现了HandlerMapping接口，重要方法HandlerExecutionChain getHandler(HttpServletRequest request)-->
    <!--
    hint：在未配置该handlerMapping之前，程序也正常，原因在于：
    hint：1）多个映射器可以并存，前端控制器判断url能让哪些映射器映射，就让正确的映射器处理；
    hint：2）默认加载的处理器映射器有两个：第一个是根据Bean的名字URL的映射器，第二个是默认的注解处理器映射器
    hint：3）所以要配置配套的映射器和适配器，也可以用<mvc:annotation-driven />自动加载加载RequestMappingHandlerMapping和RequestMappingHandlerAdapter
    -->
        <property name="interceptors">
            <list>
                <ref bean="officeHoursInterceptor"/>
            </list>
        </property>
    </bean>
    <bean id="officeHoursInterceptor" class="com.atguigu.bk.intercept.TimeBaseAccessInterceptor">
        <property name="openingTime" value="9"></property>
        <property name="closingTIme" value="18"></property>
    </bean>

    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"></bean>
```
参考链接：
- [SpringMVC从入门到精通之第三章][4]
- [springMVC学习笔记(二)-----注解和非注解入门小程序][5]

### 3.3 SpringMVC的几个优点总结
- JSP页面可以放在WEB-INF下，增加安全性，强化MVC编程模型；
- 使用annotation与http请求对应，清晰直观；
- 参数传递非常灵活，Struts2往往使用值栈，Action中存在成员变量（e.g. Person person），因为如此，Struts2的Action不能做成单例。SpringMVC的Action就可以做成单例模式，放在了Spring容器中；
- 非常出色的异常处理机制（见[异常处理](#7异常处理)）；
- 支持多种视图的显示，扩展性强；

<br>
<br>


## 4）如何让jsp页面更安全
MVC模型，正确的流程应该是 `客户端请求-->Controller-->View-->客户端`，但是我们可以通过浏览器地址的方式直接访问jsp，而页面往往需要数据填充，也就是说我们这样直接访问，会出现错误。
>如何避免？
>>我们知道，WEB-INF目录是不对外开放的，外部没法直接通过URL访问。所以，将jsp页面放入到WEB-INF文件夹之下，这样可以限制访问，提供安全性。

当然，这种做法也是褒贬不一，有好处也有坏处。

 - [讨论：关于jsp页面是放在webroot目录下和web-inf下优缺点][6]
 <br>
 <br>
 
 

## 5）存储和读取图片的两种方式

 - 在数据库中存储图片的地址，读取的时候通过查找到图片的地址，去对应的地址读取；
 - 在数据库中存储图片的二进制，读取的时候直接使用img标签，src读取出来图片。<br>
 第二种方式并不推荐，加大了数据库的负担，此处也仅做学习使用，具体的操作，可以下如下代码：

``` stylus
    @Test
    public void testGetBookPic() {
        //hint: 如何将图片以二进制的形式存入到oracle中的blob类型
        String sql = "update tbook set pic=? where isbn=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connention = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "test", "test");
            PreparedStatement ps = connention.prepareStatement(sql);

			//hint:  void setBinaryStream(int parameterIndex, java.io.InputStream x)
            File file = new File("C:\\Users\\Administrator\\Desktop\\400501128467508726.jpg");
            FileInputStream in = new FileInputStream(file);
            ps.setBinaryStream(1, in);
            ps.setString(2, "s004");
            ps.executeUpdate();
            connention.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```
<br>
<br>

## 6）文件上传的处理的几个步骤
### 6.1 表单属性的设定<br>
&lt;form action="<%=basePath%>back/BookAddSvl" method="post" **enctype="multipart/form-data"**&gt; 
<br>

enctype 属性规定在发送到服务器之前应该如何对表单数据进行编码。

- application/x-www-form-urlencoded
在发送前编码所有字符（默认）

- multipart/form-data	
不对字符编码。**在使用包含文件上传控件的表单时，必须使用该值**。
<br>
（这表示，信息以文字和字节混合提交，所以是multipart）

- text/plain
空格转换为 "+" 加号，但不对特殊字符编码。
<br>

### 6.2 input的类型
&lt;input **type="file"** name="pic"&gt;
<br>

### 6.3 文件上传的解析
- 传统方式一般使用smartupload.jar进行文件上传的解析
- apache的方式，使用commons-fileupload.jar + commons-io.jar
<br>

### 6.4 spring中文件解析器的配置

``` stylus
<!--文件解析器-->
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="102400" /><!--最大上传量为100k-->
    </bean>
```

### 6.5 Action中的方法添加MultipartFile接受参数(另，@RequestParam)
在对图片进行接收时，图片和图书的其他信息，应该分别接收。

``` stylus
/**
     * 图书上架功能
     * @param book
     * @return
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    //hint：关于springMVC中的文件上传处理，使用MultipartFile file
    public String addBook(TBook book, Model model,@RequestParam("pic2") MultipartFile file) { //hint：相当于基本数据和字节流分开，各自传递
        String result = null;
        if (book != null) {
            BookBiz bookbiz = new BookBiz();
            try {
                if (file != null && !file.isEmpty()) {
                    //将byte[]的图片信息传入到book中
                    byte[] bytes = file.getBytes();
                    book.setPic(bytes);
                }
                bookbiz.addBook(book);
                model.addAttribute("msg", book.getBname() + "--录入成功");
                result = "/back/BookAdd.jsp";
            } catch (Exception e) {
                model.addAttribute("msg", e.getMessage());
                result = "/error.jsp";
            }
        }
        return result;
    }
```

<br>
<br>
## 7）异常处理
### 7.1 信息不得为null的解决方案
- 在前端给该处信息设置一个默认值（该方法不完善，在显示时删除后提交依然会错误）。
<br>

### 7.2 spring提供的异常解析器SimpleMappingExceptionResolver
在spring-mvc.xml中配置spring的异常解析器

``` stylus
<!--异常解析器-->
    <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
        <property name="exceptionMappings">
            <props>
                <!--hint：出现异常未处理，会存到exception中，跳转到相应页面。可以在error.jsp中使用${exception.message}取出-->
                <!--捕获所有异常，Throwable，意味着就算代码部分我们没有catch异常，这个异常解析器也会处理-->
                <prop key="java.lang.Throwable">/error.jsp</prop>

                <!--捕获特定异常，内容超出范围异常的对应跳转-->
                <prop key="org.springframework.web.multipart.MaxUploadSizeExceededException">/error/OverMaxUploadSize.jsp</prop>
            </props>
        </property>
    </bean>
```
如上，出现文件上传大小超出最大限制，跳转到OverMaxUploadSize.jsp；出现其他异常（属于Throwable），跳转到error.jsp。
<br>

### 7.3 信息校验的处理方式
#### 7.3.1 前台处理
在用户提交表单之前，将表单的信息在前台使用JS进行数据校验，符合格式和要求以后才运行进行提交。这种方式可以减少对服务器频繁访问的压力，而7.3.2和7.3.3都是在服务器端处理异常。<br>
这种方式准确地讲类似于先预防异常，而后两种是不预防，但是有处理方法。
<br>

#### 7.3.2 异常捕获 + spring
这个方法可以结合7.2中，引入spring的异常解析器，可以单独配置不同种类的异常错误页面；或者，不太友好地直接设置Throwable，统一跳转到error.jsp。
<br>

#### 7.3.3 异常捕获
在Action中捕获异常进行处理和跳转，异常信息存储到request，或根据情景进行调整。


  [1]: http://jinnianshilongnian.iteye.com/blog/1594806
  [2]: http://ju.outofmemory.cn/entry/257271
  [3]: http://www.cnblogs.com/duanxz/p/3755788.html
  [4]: http://www.imooc.com/article/4293
  [5]: http://www.cnblogs.com/selene/p/4771671.html
  [6]: http://bbs.csdn.net/topics/320097731