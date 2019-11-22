#=============================================
# jsps-and-servlets
# Lý thuyết
#=============================================

# Step 1: Setup
	- Download tomcat7
	- Downoad eclipse
	- Create new Apache web server - Tomcat 7 and start. Confirm URL: http://localhost:8080/

# Step 2: Create Dynamic Web Project with name SimpleServletProject
	- In folder /SimpleServletProject/WebContent, create new HTML page index.html - content: This is index page.
	- Run Project on Server
	- Confirm http://localhost:8080/SimpleServletProject

# Step 3: Create Servlet with URL path is SimpleServletPath
	- Tạo class SimpleServletPath.java
	```java
	@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" })
	public class SimpleServlet extends HttpServlet {
		// doGet
		// doPost
	}
	```
	- Run Project on Server
	- Confirm http://localhost:8080/SimpleServletProject/SimpleServletPath
 
# Step 4: Understanding about Servlet
	 - http://localhost:8080/ - Server is runing so display Tomcat homepage
	 - http://localhost:8080/SimpleServletProject - When you run SimpleServletProject on Server, Tomcat will add SimpleServletProject into Module web server, hence Tomcat can access your project resource. And welcome page configued in web.xml will display. 
	 - http://localhost:8080/SimpleServletProject/SimpleServletPath - SimpleServletPath is a URLPath which mapping with your servlet class, not is a servlet class. Tomcat will find SimpleServletPath inside SimpleServletProject project. If not found then throw 404 HTTP error. Because request from browser so default method is GET and doGet() method will be perform.
 
## Summary:
	- Browser -[URL]-> Tomcat --> [App1, App2, SimpleServletProject[SimpleServletPath, Servlet2]]
	- Tomcat create HTTPRequest and HTTPRespone to store parameter data and send to Servlet. Servlet will get parameter data from HTTPRequest, perform and return result to Tomcat by HTTPRespone.

# Step 5: Create XML servlet configued
	- Create clsas XmlServlet, extends HttpServlet and create doGet method

	- In web.xml, config servlet as below:
	```xml
	  <servlet>
		<servlet-name>xmlServlet</servlet-name>
		<servlet-class>vn.neways.learning.XmlServlet</servlet-class>
	  </servlet>
	  <servlet-mapping>
		<servlet-name>xmlServlet</servlet-name>
		<url-pattern>/xmlServletPath</url-pattern>
	  </servlet-mapping>
	```
	- Confirm http://localhost:8080/SimpleServletProject/xmlServletPath

## Summary: 
	- So sánh với Step 2 ta thấy rằng config trong web.xml có tác dung như annotation WebServlet với urlPatterns là "xmlServletPath".
	- Về cơ bản, Tomcat khi khởi chạy sẽ tìm kiếm trong web.xml để tìm kiếm servlet với url-pattern tương ứng để thực thi class chỉ định. Tương tự như tìm kiếm trong @WebServlet ở step 2.
	- Về cơ bản, sử dụng annotation là đơn giản hơn nên nó được dùng để thay thế cho config ở web.xml. Tuy nhiên, đối với hệ thống nhiều màn hình muốn quản lý tập trung và muốn tái sử dụng lại servlet config đã được định nghĩa thì người ta dùng XML config.

# Step 6: Tạo doPost method và xử lý dữ liệu
	- Sử dụng class ở Step 5 và tạo thêm method doPost
	- Dữ liệu gửi từ browser đến Tomcat server bằng parameter. Có thể lấy ra dữ liệu của parameter bằng method request.getParameter()
	- Gửi dữ liệu đến server có nhiều method, thưởng dùng là get/post.
		- get: Data gửi đi hiển thị trên URL, người dùng có thể được
		- post: Data gửi đi bằng một form bên trong request nên không thấy trên URL
	- Đối với get method thì có thể gửi đi parameter bằng cách gõ trực tiếp trên URL name=value
	- Đối với post method thì cần phải tạo HTML form và định nghĩa method post và action đích để gửi dữ liệu
	- Phía Servlet cần có method doGet và doPost tương ứng để xử lý cho từng method gửi đi từ URL

# Step 7: Gửi đi nhiều parameter
	- Ta có thể gửi đi nhiều parameter bằng cách tạo nhiều input trên HTML form đối với method Post hoặc gõ trực tiếp trên URL đối với method Get, điều kiện là không trùng tên parameter.

# Step 8: Hiểu về POST và GET
	- Tìm hiểu thêm sau

# Step 9: Tìm hiểu về Request, Session và Context trong Servlet
	1. Servlet được quản lý trong Tomcat container
	2. HTTPRequest và HttpServletResponse là những object
	3. Bản thân Servlet cũng là object, những chỉ khởi tạo 1 lần, khi nhiều request tới, nó chạy bằng threads, không khởi tạo lại object

	Quá trình 1 URL được xử lý:
	- Browser gửi đến Tomcat 1 URL, Tomcat tạo 2 đối tượng HTTPRequest và HTTPRespone, HTTPRequest dùng để chứa tham số gửi từ browser và đưa tới Servlet. HTTPRespone thì ban đầu là không có gì, nó gửi đến Servlet để Servlet sử dụng để truyền dữ liệu trả về cho Tomcat. Tomcat kết thúc quá trình bằng cách gửi về cho browser một HTML, có chứa cả dữ liệu của HTTPRespone mà Servlet đã trả về.
	- Lưu ý rằng: Ở 2 thời điểm, browser gửi 2 URL giống hệt nhau, thì Tomcat sẽ tạo ra 2 đối tượng HTTPRequest và HTTPRespone riêng biệt. Nói đơn giản là HTTPRequest và HTTPRespone được tạo dựa trên mỗi truy cập tới Tomcat.
	- Còn đối với Servlet thì 2 thời điểm, browser gửi 2 URL giống hệt nhau, nghĩa là url-pattern giống nhau thì đối tượng Servlet đã tạo sẽ được sử dụng lại. Servlet được quản lý ở Tomcat container, life cycle của Servlet được điều khiển qua 2 method init, service và detroys.
	- Mặc dù Servlet object được sử dụng lại nhưng cách chúng thực thi hoàn toàn độc lập thông qua các thread, các request khác nhau sẽ có các thread khác nhau, không phải tạo lại instance của Servlet đó. Đó cũng là lý do mà Servlet được sử dụng phổ biến.

	- Để hiểu thêm về Request/Respones thi cần hiểu về khái hiện HTTP protocol. HTTP là giao thức không lưu trạng thái, nghĩa là mỗi request được gửi đi bằng giao thức HTTP thì ngay sau nhận được response trả về thì nó không còn chứa gì nữa. 
	- Tuy nhiên, trong nhiều trường hợp chúng ta cần lưu lại thông tin khi có request được gửi đến server, khi đó ta dùng session. Session là thứ gì đó, được dùng để lưu lại dữ liệu trong request ở server. Đối với Tomcat, nó cung cấp HttpSession để có thể lưu trữ thông tin - bản thân nó được attach trong HTTPRequest để gửi đế Servlet. Servlet muốn lưu thông tin vào session thì lấy nó ra và gán các giá trị mong muốn lưu trữ vào nó.
- Session nói chung có nhiều cách lưu trữ ví dụ DB, file, ...

# Step 10: Tìm hiểu về Request, Session và Context trong Servlet - Path 2
- request object
	- HTTP protocol
	
- session object
	- Được tạo cho mỗi user/machine
	- Nó chứa bên trong request object
	- Thường dùng cho login/shopping crat
	- Mỗi request object đều có một xử lý đến session object
	
- context object
	- Nó chứa bên trong request object
	- Thường dùng cho login/shopping crat
	- Có thể chia sẻ cho nhiều user/machin và servlets
	- Mỗi request object đều có một xử lý đến context object
	- context object là object do Tomcat cung cấp, nó cung cấp cho chúng ta phương thức để lấy ra một object. Có 2 cách để dùng. Tuy nhiên đề cập ở đây cách dùng như đối với HttpSession.
	```java
		ServletContext context = request.getServletContext();
		context.setAttribute("count", count++);
	```

# Step 10: Tìm hiểu init, service method và ServletConfig
Nhìn lại: 
- request, session, context: Là 3 object quan trọng. request dùng để truyền dữ liệu từ Tomcat đến Servlet, session dùng để lưu trữ dữ liệu theo từng user, context dùng để chia sẻ dữ liệu trên nhiều servlet khác nhau, cho nhiều user khác nhau
- Servlet: Chạy bằng Threads, không new object. Mỗi request tới Servlet thì 1 thread của Servlet được tạo ra. Tùy method submit mà có thể là doPost hay doGet sẽ thực thi

- Cách mà Servlet thực thi:
	- Trước đó ta thấy, khi có 1 request tới Servlet thì doGet hoặc doPost sẽ thực thi, vậy ai điều hướng để các method đó thực hiện ?
	- Mỗi request tới Servlet thì mỗi thread được tạo ra, vậy điều gì xảy ra nếu 1 triệu request tới ?
	- Servlet sẽ object 1 lần, vậy nó được tạo khi nào, và như thế nào ?
	=> Hãy nhìn flow dưới đây:
		request -> Tomcat -> Servlet Container
									-> init(ServletConfig) - 1 lần - Nếu Object của Servlet này đã có rồi thì không tạo nữa - Singleton Design Pattern
									-> service() - Method đa hình - doGet và doPost sẽ implement. - Sẽ lỗi nếu init không thành công.
										-> doGet - Nếu submit là GET - Các implement chi tiết
										-> doPost - Nếu submit là POST
	
	- Xem xét về Servlet - Class đa hình
		MyServlet -> HttpServlet -> GenericeServlet
			- GenericeServlet - Đây là class cha của HttpServlet, dùng đẻ tạo Servlet object. Có 3 method cần quan tâm
				- init(ServletConfig) - Servlet Container sẽ gọi để khởi tại Servlet để thực hiện các service. Muốn khởi tạo thêm cái gì khác thì override method này, chú ý nhớ config ServletConfig cho Servlet. 
				- init() - Cách đợn giản hơn để override mà không cần thiết lập ServletConfig - việc đó sẽ được thực hiện tự động ở method cha.
				- service() - ServletConfig sẽ gọi để xử lý request. 
				- destroy - Kết thúc của servlet - default là không làm gì, nếu cần thì override nó.
			- HttpServlet - Là class implement của GenericeServlet, cung cấp các method abstract:
				- service() - Điều hướng request nhận từ Servlet Container đến method chi tiết doPost, doGet để xử lý
				- doGet, doPost - Các method detail để xử lý request
			- MyServlet - Là class implement chi tiết các method doGet, doPost
			
			- ServletConfig: Là object chứa các thông tin sử dụng cho Servlet: context, parameter, Servlet name. Được tạo khi Servlet Container khởi tạo Servlet.
			
	- Khởi tạo giá trị cho Servlet để làm gì và làm thế nào để khởi tạo.
		- Để khởi tạo những thứ dùng cho Servlet, như là connection đến DB...
			- init() overriding
		- Khởi tạo các giá trị đầu vào cho Servlet thông qua ServletConfig
			Có 2 cách để khởi tạo:
			- Dùng XML config	
			```xml
					<servlet>
					<servlet-name>xmlServlet</servlet-name>
					<servlet-class>vn.neways.learning.XmlServlet</servlet-class>
					<init-param>
						<param-name>defaultUser</param-name>
						<param-value>NhiLX</param-value>
					</init-param>
				  </servlet>
			```
			- Dùng Annotations
				@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" }, initParams= {@WebInitParam(name="defaultUser", value="NhiLX")})
		
		- Lấy giá trị từ ServletConfig
			- this.getServletConfig().getInitParameter("defaultUser")

# Step 11: JSP
	- JSP cơ bản 1 servlet. Với 1 webpage cần nhiều HTML thì không thể dùng response.getWriter() viết HTML, thay vào đó dùng JSP để viêt.
	- Khai báo JSP trên HTML: <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	- Đối với JSP, ngoài việc HTML thì có thể viết mã Java trên đó.
		- <% %> - Block code cho Java
		- <%= %> - Ghi giá trị ở code Java ra HTML
		- <%! %> - Block code cho method

# Step 12: Hiểu về JSP
	- Điều gì thật sự đang xảy ra khi viết mã HTML và mã Java trên JSP
		- Mã HTML và mã Java được viết sẽ lưu lại dưới dạng 1 java class trong thư mục Tomcat và biên dịch thành file class để thực thi
			Đường dẫn: \tomcat7\work\Catalina\localhost\SimpleServletProject\org\apache\jsp
		- Đối với mã Java, có 3 loại ký hiệu cần phải tuân thủ:
			- <%! %> - jsp:declaration - Định nghĩa 1 method riêng biệt
			- <% %> - jsp:scriptlet - Mã xử lý bình thường xen kẽ với HTML, không cần là 1 method
			- <%= %>  - jsp:expression - Chỉ thị in giá trị mã Java ra HTML
		- Khi nhận được yêu cầu response, Tomcat sẽ gọi file class của JSP tương ứng để gender HTML trả về.

# Step 13: Các chỉ thị của JSP page
	- Khi cần sử dụng các thư viện, ví dụ như Date chẳng hạn, cần phải import chúng vào JSP page, sử dụng cú pháp: <%@ page import="java.util.Date" %>
	- Khi cần chèn 1 trang JSP khác vào trang JSP đang xử lý, sử dụng <%@ include file="Hello.jsp" %>
	=> <%@ %> - jsp:directives - Dùng để chỉ thị import/chèn/... vào JSP một thứ gì đó để sử dụng.
	
# Step 14: Scopes và ContextPage object trong JSP
	- Tương tự như servlet, JSP cũng có những object cho phép chúng ta lưu trữ dữ liệu
	- request object
	- session object
		- Được tạo cho mỗi user
	- application object (tương tự như servletcontext)
		- Có thể chia sẻ cho nhiều user
	
	- Ngoài ra, JSP còn có pageContext, là đối tượng chung cho 3 đối tượng ở trên, khi lưu vào pageContext thì có thể chỉ thị Scope tương ứng
	- Có 4 scopes ở JSP: request/session/application/page(default - chỉ dùng cho chính JSP đó)

# Step 15: jspInit và InitParam ở JSP
	- Tương tự như servlet, JSP cũng có thể khởi tạo các giá trị ban đầu trước khi thực thi mã ở JSP để dùng vào việc gì đó tùy ý
	- Đối với InitParam: Có thể cấu hình ở web.xml, thay vì định nghĩa servlet-class thì dùng jsp-file
		```xml
			<servlet>
			<servlet-name>initParams</servlet-name>
			<jsp-file>/inits.jsp</jsp-file>
			<init-param>
				<param-name>initUser</param-name>
				<param-value>NhiLX</param-value>
			</init-param>
		  </servlet>
		  <servlet-mapping>
			<servlet-name>initParams</servlet-name>
			<url-pattern>/inits.jsp</url-pattern>
		  </servlet-mapping>
		  
		```
	- Đối với jspInit thì dùng jsp:declaration <%! %>
		```java
		<%!
			public void jspInit() {
				String user = getServletConfig().getInitParameter("initUser");
				ServletContext context = getServletContext();
				context.setAttribute("contextInitJsp", user);
			}
		%>
		```
# Step 16: Tìm hiểu về mô hình MVC
	- MVC là mô hình để phát triển một ứng dụng web
	- C - Servlet, V - JSP, M - Java Beans
	- User -> Servlet -> Beans -> Trả data về cho Servlet -> Servlet chuyển data đến JSP đển gender HTML trả về User
	
# Step 17: Viết một ứng dụng MVC
	- Login application - MVC pattern
		- Controller - LoginServlet
		- Business layout - LoginService
		- Model - LoginResult
		- View - Login.jsp and Success.jsp
	- Chỉ định JSP sẽ sử dụng từ Servlet: response.redirect("jsp-file")
	- Gửi 1 object từ Servlet đến JSP dùng: session, context, ...
	- Cũng gửi 1 object từ Servlet đến JSP dùng request, thì dùng RequestDispatcher.forward để chuyển tiếp request.

# Step 18: Tìm hiểu JSTL và useBean tag
	- JSTL là tập hợp các script cho phép ta dễ dàng tương tác với các object mà không cần phải dùng code Java ở JSP
	- useBean là các đơn giản để lấy ra 1 object: <jsp:useBean id="" class="" scope="" >
	
# Step 19: setProperty và getProperty
	



#=============================================
# Bài tập
#=============================================
## Tạo một Shopping Appp
1. Yêu cầu
- Login
- Add card
- Mock data

2. Sử dụng
- jsp/servlet
- request/reponse
- session/context
- servletconfig/initparameter
- mvc pattern

** Lưu ý:
	- Servlet context sẽ reset value khi re-start khi reload lại context ứng dụng
	- Session được lưu bởi tomcat, chỉ bị xóa khi tắt browser, reload lại context ứng dụng không ảnh hưởng
