# ======================
# Struts 2
# ======================

# 1. Khái niệm MVC
- MVC là Model, View, Controller - Là mô hình phát triển web
- Vấn đề và cách giải quyết - Để hiểu ta lấy ví dụ về 1 nhà hàng
	1. Nhà hàng chỉ có 1 người, kiêm nhiệm phục vụ, đầu bếp. Khi có khách hàng, người này phải đi tiếp khách, nhận đặt món, đi chế biến rồi mang ra cho khách. Trong quá trình này, nếu có thêm khách thì phải chờ vì người khách trước đó chưa xử lý xong.
	=> Điều này tương tự như web với servlet đơn thuần, mọi việc đều được làm tuần tự từ nhận request -> xử lý -> lấy data -> format HTML trả về. Trường hợp có nhiều request thì trạng thái chờ xảy ra, khả năng mở rộng website thấp.
	2. Nhà hàng nâng cấp, lúc này thuê thêm 1 người đầu bếp chuyên nghiệp, việc này giảm tải cho người phục vụ, người này chỉ cần tiếp khách, nhận đặt món và đưa cho đầu bếp xử lý, sau đó đến nhận món và trả về cho khách khi đầu bếp làm xong. Việc này làm cho nhà hàng khả năng tiếp được nhiều khách hơn.
	=> Tương tự ở web, thay vì servlet làm từ đầu đến cuối thì có thể để việc xử lý -> lấy data cho 1 đối tượng chuyên trách hơn xử lý - trong Java gọi là bean. Việc này giảm tải cho servlet, servlet chỉ cần nhận request và nhận dữ liệu trả về từ bean và format HTML để trả về. Việc này tạo nên tính cơ động cao hơn. Có khả năng tiếp nhận được nhiêu request hơn.
	3. Đến lúc này, thay vì chỉ xử lý món ăn đơn thuần, nhà hàng cần có người trang trí cho món ăn. Khi đó họ tuyển thêm 1 người nữa. Quy trình làm việc như sau: phục vụ tiếp khách nhận đặt món và đưa tới đầu bếp, đầu bếp làm xong thì nói cho phục vụ biết, phục vụ đêm đồ ăn đến nhờ trang trí và sau đó đem cho khách hàng. Ở đây, ngoài việc xử lý thì sản phẩm đưa cho khách hàng đẹp hơn trước nhiều.
	=> Tuong tự web, việc servlet tự format sẽ tốn nhiều thời gian và không hiệu quả thay vào đó họ dùng các công cụ khác hỗ trợ như JSP chẳng hạn, khi đó quy trình như sau: servlet nhận yêu cầu, chuyển đến cho bean xử lý và trả về data cho servlet, servlet chuyển data và yêu cầu format HTML đến JSP, JSP format HTML xong thì trả về(điểm này khác với ví dụ ở nhà hàng). Việc này khiến cho việc phát triển web trở nên dễ hàng và linh động hơn, servlet chỉ nhận request và điều hướng, gọi là Controller sau đó chuyển đến bean để xử lý dữ liệu - gọ là Model, sau đó Controller nhận dữ liệu trả về từ Model thì yêu cầu JSP - View format HTML để trả về. Mô hình xử lý như trên gọi là MVC.

# 2. Giới thiệu Struts 2

## Hiểu về khái niệm pattern và framework
- Pattern là tập hợp các hướng dẫn để tạo ra thứ gì đó, ví dự như MVC pattern thì có tập hợp các hướng dẫn để phát triển web với 3 đối tượng Model Controller và View
- Framework là tập hợp các thư viện, công cụ hỗ trợ cho việc phát triển cái gì đó, nó có thể được xây dựng dự trên các hướng dẫn của 1 pattern nào đó, việc phát triển sản phẩm trên framework phải hoàn toàn dự trên nguyên các framework đưa ra, nếu không tuần thủ sẽ bị lỗi. Ví dụ như với MVC pattern thì có nhiều framework triển khai nó như Struts, Struts 2, Spring..., nếu phát triển web trên Struts thì phải tuần theo nguyên tắc của Struts, không thì sẽ phát sinh lỗi.

## Làm thế nào để xây dựng 1 framework MVC
- Để xây dựng duodjc framework ta phải hiểu được các công việc cần làm, từ đó tạo ra các thành phần cần có để xử lý công việc đó và đóng gói thành các  thư việc, công cụ hỗ trợ
- Quá trình xử lý 1 request: Client -> request -> bóc tác tham số -> Tìm Model để chuyển tiếp -> xử lý dữ liệu -> generate HTML -> trả về client.
- Nhóm các công việc theo MVC pattern như dưới đây:	
	- Controller xử lý request
		- Bộ xử lý tham số truyền đến từ client trong request, bóc tách thành URL và tham số
		- Cầu hình điều hướng request, tham số đền Model - Mapping URL - Model xử lý
	- Model
		- Tập hợp các xử lý cơ bản để hỗ trợ xử lý dữ liệu
	- View
		- Tập hợp các tag lib để hỗ trợ việc generate HTML để trả về

## Struts 2 như thế nào
- Struts 2 là MVC framework của Apache
- Nhóm các công việc theo MVC pattern như dưới đây:	
	- Controller xử lý request
		- Bộ xử lý tham số truyền đến từ client trong request -> Interceptor
		- Cầu hình điều hướng request, tham số đền Model -> Struts config - XML config
	- Model
		- Tập hợp các xử lý cơ bản để hỗ trợ xử lý dữ liệu -> Action class
	- View
		- Tập hợp các tag lib để hỗ trợ việc generate HTML để trả về -> JSP

- Struts cung cấp tập hợp các class cho chúng ta để có thể extends hoặc sử dụng để phát triển website

## Sử dụng Struts 2 như thế nào
- Như ở trên ta thấy việc phát triển web thì cần Interceptor, Struts config, Action class và JSP. Tuy nhiên Interceptor đã được Struts dưới dạng common nên ta có thể dùng lại, việc còn của chúng ta là cấu hình Struts config bằng file XML để điều hướng request đến Action class, implement Action class để xử lý yêu cầu và implement JSP để format HTML như mong muốn của chúng  ta.
- Cụ thể chúng ta sẽ tìm hiểu ở bước tiếp theo nhé

# 3. Setup Struts 2
- Download từ https://struts.apache.org/download.cgi và unzip
- Tạo Dynamic Web project
- Attach thư viện Struts 2 cần thiết vào Java Build Path
- Cấu hình Web Deployment Assembly để thêm vào thư viện Struts 2 - lấy từ Java Build Path để deploy các thư viện đó vào thư mục lib của ứng dụng - khi đó mới dùng được
- Tạo server để khởi chạy ứng dụng - lưu ý dùng java8 thì dùng tomcat8, nêu dùng tomcat7 thì bị lỗi version

# 4. Viết ứng dung web bằng Struts 2
- Như đã giới thiệu ở trên, Struts 2 có 4 thành phần chính:
	- Interceptor => Xử lý nhận request
	- Struts config => Cấu hình để mapping URL request với 1 class xử lý
	- Action clsas => Class xử lý chính
	- JSP => Format HTML trả về, 1 Action có thể có nhiều JSP, tùy vào kết quả trả về của Action class mà chúng ta có thể cầu hình JSP trả về tương ứng
- Tuy nhiên, phần Interceptor đã được Struts 2 implement sẵn nên chúng ra chỉ cần dùng lại. Chúng ta chỉ cần triển khai 3 thành phần còn lại là có thể thực hiện được một web aplication.
- Các bước thực hiện:
	- Struts config
		- Tạo file struts.xml
		- Cấu hình action tag với 1 URL và 1 class tương ứng
		```xml
		/my-web-struts-2/src/struts.xml
		<action name="getTutorial" class="vn.neways.action.TutorialAction">
			<result name="success">/success.jsp</result>
			<result name="failed">/error.jsp</result>
		</action>
		```
	- Tạo Action class
		- Đối với Action class thì method mặc định thực thi là execute()
		- Cần chỉ định loại method của request là post hay get, sẽ tìm hiểu kỹ ở phần sau
		```java8
		/my-web-struts-2/src/vn/neways/action/TutorialAction.java
		public class TutorialAction {
			public String execute() {
				System.out.println("Toturial action - execute");
				return "failed";
			}
		}
		```
	- Tạo JSP
		- JSP đại diện cho 1 HTML template muốn trả về. Việc JSP nào được gọi sẽ được thể hiện trong Struts config
			- Tạo 2 file success.jsp và error.jsp

- Chạy web application với tomcat8.5
	- Mặc định Tomcat sẽ nhận cấu hình web ở file web.xml. Vì vậy, để điều hướng request từ tomcat đến struts ta cần phải cấu hình thêm ở web.xml. Dùng filter và filter-mapping để tìm ra tất cả URL request đến và chuyển đến struts.
	```xml
	/my-web-struts-2/web/WEB-INF/web.xml
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	```
	- Như ở trên là nếu tìm thấy bất cứ URL nào tới thì chuyển đến cho StrutsPrepareAndExecuteFilter xử lý. StrutsPrepareAndExecuteFilter là class mà struts cung cấp để xử lý request.
	- Kiểm chứng trên URL http://localhost:8080/my-web-struts-2/getTutorial

# 5. Namespace trong Struts
- Vấn đề: Hãy đặt URL cho các hoạt động của một đối tượng TODO trong ứng dụng ví dụ như list, add, delete, update, link, ...
=> URL sẽ là: addTodo, listAllTodo, updateTodo, linkTodo, deleteTodo
=> Đánh giá: Về cơ bản thì không sai nhưng nếu nhìn thì thấy không đẹp lắm

- Cách giải quyết: Sử dụng namespace của struts.
=> URL format: http://<server>:<port>/<app-name>/<namespace>/<action>.action
=> Cho phép chúng ta nhóm các hoạt động của một đối tượng lại, và sử dụng tên đối tượng như là một namespace
=> /todo/add, /todo/delete, /todo/list, ... Dễ hiểu hơn nhiều đúng không nào

- Cách implement: Dùng tag <package namespace = ""></package>
=> Đóng gói nhiều action trong 1 package, tăng tường sự rõ ràng trong quá trình phát triển.
```xml
	<package name="default" namespace="tutorials" extends="struts-default">
		<action name="list" class="vn.neways.action.TutorialAction">
			<result name="success">/success.jsp</result>
			<result name="failed">/error.jsp</result>
		</action>
	</package>
	=> Xác nhận: http://localhost:8080/my-web-struts-2/tutorials/list
```
=> Như ở trên, tất cả các URL của action sẽ nhận namespace được định nghĩa ở package tag

# 6. Sử dụng struts tag - Implement 1 business đơn giản
- Business context: Tutorials application MVC, access 1 URL, config để call 1 Action xử lý, business sẽ được implement ở layout Services, JSP hiển thị giá trị động.
- Flow: URL -> struts-config -> Action -> Services -data-> Action -> JSP - Using struts tag để hiển thị
- Thực hiện: 
	- Tạo struts.xml
	- Tạo Action
	- Tạo Services -> trả về giá trị cho Action
	- Tạo JSP
	=> Vậy làm cách nào truyền giá trị từ Action class đến JSP ?
	=> Như đã làm với servlet thuần, ta sẽ dùng session hoặc application context để lưu giá trị và ở JSP truy cập thông qua các attribute đã gán trong session hoặc request hoặc context
	=> Tuy nhiên đối với struts, ta không cần phải làm như vậy. Thay vào đó, trong struts, mỗi Action class khi được request được xem như 1 đối tượng, nên muốn truyền đi giá trị từ Action ta chỉ cần khai báo thuộc tính và set giá trị, ở JSP sẽ lấy giá trị bằng tag mà struts hỗ trợ với properties name là tên thuộc tính mà chúng ta muốn lấy ra.
- Sử dụng struts tag:
	=> <%@ taglib prefix="s" uri="/struts-tags" %>
	=> Vì struts xem Action class như là một đối tượng nên là các thuộc tính khai báo trong Action class nếu muốn JSP dùng được thì hoặc là khai báo bằng public hoặc khai báo bằng private thì phải có method getXXX()
	=> Khi sử dụng thì dùng <s:property value="XXX"/> với XXX là tên thuộc tính, trường hợp không có thuộc tính XXX thì không có giá trị để hiển thị, không phát sinh lỗi runtime.
	
# 7. Value Stack ->  Nơi chứa dữ liệu của 1 request
- Đầu tiên, bản chất của struts là servlet, nên việc truyền đi giá trị từ servlet đến JSP(sub servlet) cần phải dùng session hoặc request object.
- Ở struts, cứ mỗi request tới, 1 instance của Action class sẽ được tạo ra và gán vào Value Stack và gán cho request với attribute là “struts.valueStack”, nhờ vậy mà JSP có thể truy cập được các thuộc tính bên trong Action class như ở mục 6
- Value Stack trong struts là vùng chứa các object, mỗi request đến sẽ tạo ra 1 object Action class, bên trong đó chứa các data member, cho phép JSP có thể dễ dàng truy cập chúng.
- Ngoài Action class object thì Value Stack còn chứa request, parameters, session, aplication của 1 servlet
- Value Stack không phải là kiểu dữ liệu stack mà có cơ chế first in last out, nó là một kho chứa
- Mỗi request sẽ có một object Action class tương ứng nên sẽ không xảy ra xung đột trong Value Stack kể cả trường hợp cùng tên thuộc tính

# 8. Access input parameter
- Để gửi đi 1 giá trị từ Action class đến JSP thì có Value Stack làm kho chứa, JSP muốn truy cập giá trị thuộc tính bên trong Action class thì sử dụng struts-tag.
- Vậy để gửi đi 1 giá trị đến Action class thì làm thế nào ?
	=> 1. Khai báo tên thuộc tính nhận giá trị bên trong Action class
	=> 2. Lúc truyền giá trị đến Action class thì truyền đùng tên thuộc tính là được. Ví dụ: http://localhost:8080/TutorialsFinder/tutorials/find?language=java 
	=> Muốn truyền đi giá trị language=java thì URL access phải gửi đi input parameter có tên là language và Action class phải định nghĩa 1 thuộc tính có tên là language

- Vậy nó hoạt động thế nào, về cơ bản việc thiết lập giá trị input parameter được xử lý bởi interceptor của struts. Các hoạt động là:
	1. Khi có 1 request đến Action class thì 1 object của Action class đó được tạo ra và đưa vào Value Stack, Value Stack gán vào request
	2. Interceptor tìm kiếm bên trong Action class object ở Value Stack đó có thuộc tính trùng tên với input parameter được truyền đi ở request không, nếu có thì nó tự động set giá trị được truyền đi cho thuộc tính đó.
	3. Về cơ bản, Action class ở Value Stack là 1 object nên nó phải đảm bảo hoặc là public hoặc là private và có method set value thì mới nhận được giá trị
	
- Bài tập: Tạo chức năng để tìm kiếm tutorials, nếu input parameter là java thì trả về là có, không phải thì là chưa hỗ trợ.
	URL: http://localhost:8080/TutorialsFinder/tutorials/find?language=java  => Java Brains
	URL: http://localhost:8080/TutorialsFinder/tutorials/find?language=dotnet  => Not yet support
	
# 9. Post request in struts	
- Làm thế nào để gửi đên Action class 1 request kiểu POST có chứa data muốn gửi đi
1. Đầu tiên ta tạo 1 JSP file, sau đó tạo 1 form để submit data type POST, có 2 cách để tạo form, 1 là dùng HTML form, 2 dùng struts tag. Dùng struts tag thì khi render HTML, struts sẽ tự động tạo thêm HTML để làm đẹp hơn cho Form, vì vậy hãy dùng struts tag
2. Ở form định nghĩa acton đến Action class sẽ thực hiện xử lý, định nghĩa các thuộc tính có tên trùng với thuộc tính khai báo ở form.

- Bài tập: Tạo form search, và hiển thị thông báo là đang search từ khóa là input parameter đã được submit

# 10. Tạo chức năng login
1. Tạo JSP file, 2 file user and pass
2. Ở web.xml, setting welcome page là login.jsp
3. Coding để lấy tham số user và pass, thực hiện kiểm tra logic và trả về trang search tutorials

- Có vài cách để cải thiện source code của bạn ở đây:
	- Sử dụng interfae để sử dụng các trạng thái trả về đã được khai báo sẵn thay vì String  - com.opensymphony.xwork2.Action
	- Tách file struts.xml thành nhiều file để cấu hình riêng biệt cho các nhóm xử lý khác nhau. Chú ý, phải giữ đúng cấu trúc XML đã định nghĩa, dùng <include> tag để include file XML
	- Có thể khai báo action mà không cần class để khai báo action cho 1 JSP với result default không có thuộc tính name
	- Result tag ngoài JSP file có thể là 1 action khác

# 11. Action Wildcards
- Action Wildcards là cách cấu hình ở struts.xml mà cho phép khai báo action dưới dạng regex.
- Ví dụ: Có 4 kiểu check tương ứng 4 action: checkTutorial, checkSeminar, checkTopic, checkOther, ... Thay vì chúng ta cấu hình cho tất cả các action thì chỉ cần cấu hình 1 action kiểu regex
- Code: 
```xml
	<package name="check" namespace="/" extends="struts-default">
		<action name="check*" class="vn.neways.action.{1}CheckAction">
			<result name="success">/check{1}.jsp</result>
		</action>
	</package>
```
- Điều này cho phép chúng ta cấu hình đồng thời cho nhiều action giống nhau

# 12. ActionSupport Class
- Có nhiều các để viết 1 action trong struts:
	- POJO
	- Implement Action interfae
	- Extends ActionSupport Class

- ActionSupport Class để được gì ?
	- Sử dụng những method đã thiết kế sẵn để hỗ trợ cho việc phát triển ứng dụng web. Ví dụ như validate() trước khi execute(), sử dụng validation để ghi lỗi và trả về để thông báo cho người dùng

- Bài tập: Sử dụng ActionSupport để validate user id và password ở trang login, hiển thị lỗi nếu có.
	- Đối với validate() thì trường hợp bị lỗi, có gán addFieldError() thì phải định nghĩa tag result trả về với name là input, nếu không sẽ bị lỗi
	
- Dùng những method mà ActionSupport hỗ trợ sẵn sẽ giúp cho việc phát triển ứng dụng dễ dàng hơn

# 13. Cấu hình method trong Action mapping
- Từ trước đến giờ chúng ta thấy rằng trong Action class luôn chỉ có method execute() để thực thi yêu cầu. Vậy có cách nào để tạo thêm method nào khác ngoài method execute() cũng với mục đích thực thi yêu cầu trong Action class, và làm thế nào để cầu hình cho nó?
=> method execute() là method mặc định, trường hợp không có chỉ thị method cụ thể thì method execute() sẽ thực thi
=> Nếu muốn cấu hình để thực thi bằng một method khác thì làm như sau:
	- struts config: Sử dụng thuộc tính method trong <action> tag
	- Action class: Tạo method có method name trùng với method đã cấu hình ở struts config
=> Nhờ vào điều này mà ta có thể nhóm nhiều hoạt động của yêu cầu vào một Action class để quản lý thay vì mỗi hoạt động là mỗi Action class như trước

- Bài tập: Tạo 1 Action class với 5 method: list, get, add, update, delete cho đối tượng Seminar, và cấu hình để chạy nó.

# 14. Model Object
- Có nhiều cách để mapping thuộc tinh ở Action và JSP
	- Khai báo thuộc tính đơn - Như đã làm ở các ví dụ trên.
	- Khai báo object
		- Cũng như thuộc tính đơn, nhưng khi dùng object thì cần tạo instance cho nó trước khi sử dụng
		- Ở JSP cần chỉ rõ đối tượng và thuộc tính cần gán/lấy giá trị
	- Implement ModelDrive
		- Đây là interface hỗ trợ việc tạo Model object, khi dùng cái này thì ở JSP không cần chỉ đối tượng, chỉ cần chỉ thuộc tính là đủ
	
# 15. Khái niệm Interceptor trong struts
- Interceptor được hiểu đơn giản là những tính năng tự động của struts
- Các interceptor chúng ta dùng được định nghĩa ở struts-default trong thư viện struts, các công việc như xử lý exception, validation, parameter mapping, ... mà ở servlet chúng ta từng làm thì ở struts sẽ được tự động
- Ở Tomcat, ta cấu hình để thực thi servlet bằng servlet-mapping và filter, servlet-mapping định nghĩa logic và filter sẽ điều hướng URL, nếu mọi thứ đều làm ở web.xml của Tomcat thì thật sự rất rắc rối, thay vào đó ra cấu hình để đưa đến controller của struts, sau đó phần còn lại là các interceptor tự động làm những việc cần làm sau đó gọi đến các Action class cụ thể để xử lý
- Interceptor ở struts được thực thi trên từng request, vậy nên có tên gọi là cross-cutting concerm

# 16. Cấu hình Interceptor
- Để sử dụng Interceptor ta cần thực hiện 2 việc
	1. Cấu hình
	2. Tạo class thực thi interceptor
- Cấu hình như sau:
	1. Khai báo interceptor bằng tag interceptor ở struts.xml - thuộc tính cần có là name và class
	2. Sử dụng bằng cách gọi name ở tag action - Nhiều interceptor thì có thể gọi nhiều lần
	3. Để nhóm 1 vài interceptor vào 1 nhóm thì có thể khai báo bằng interceptor stack
- Tham khảo struts-default.xml ở thư viện struts để tạo interceptor

# 17. Ứng dụng Interceptor
- Giả sử tạo 1 interceptor và 1 class và sử dụng nó


















