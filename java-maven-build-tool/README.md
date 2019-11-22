# ================================
# Maven project
# ================================

# Step 1: Maven là gì
	- maven là gì ?
		1. Build tool
		2. Project management tool
		
	- Các vấn đề phổ biến trong 1 dự án
		1. Có rất nhiều file jar
		2. Bản thân mỗi file jar phụ thuộc vào version
		3. Kiến trúc project phức tạp, cần phải có cơ chế build đồng bộ
		4. Build, publish và deploy project
		
	- Setup maven
		1. Download from https://maven.apache.org/download.cgi
		2. Add thư mục **bin** của maven vào biến môi trường **PATH**
		3. Kiểm tra: mvn --version
		
	- Generate 1 project 1 các tự động
		1. mvn archetype:generate
		2. Select archetype number
		3. Nhập giá trị cho các thuộc tính được yêu cầu
		
# Step 2: Thao tác cơ bản với Maven
	- Compile
		mvn compile
		
	- Đóng gói - Tùy đinh dạng đã khai báo mà đóng gói tương ứng (jar, war, ear)
		mvn package
	
	- Chạy file đã đóng gói 
		java ../../XXX.jar ../../YYY.class - YYY là main class của file JAR

# Step 3: Tìm hiểu về Maven và pom.xml
	- Maven cung cấp
		- Project template - rất nhiều
		- Cơ chế build
		
	- Kiến trúc Maven thể hiện ở 2 yếu tố
		1. Cấu trúc folder dự án
		2. File pom.xml để quản lý dependency, resources, pluggin và trình tự build
	
	- Sử dụng template project bằng cách generate: mvn archetype:generate
		1. archetype - Template project
		2. groupId - Group owner của project
		3. artifactId  - Tên định danh project
		4. version - Version phát triển
		5. package - Kiểu đóng gói (jar, war, ear)
		
	- Cấu trúc file pom.xml
		1. Khai báo sử dụng Maven
		2. Thông tin project
		3. resources và dependency
		4. Build
		
# Step 4: Tìm hiểu về cách Maven thực thi
	- Maven build
		1. Build lifecycle
			validate -> compile -> test -> package -> install -> deploy
		2. Khi chỉ định phase nào đó trong quá trình trên, thì các phase trước nó sẽ thực thi mội cách tự động 

	- Tìm hiểu một vài phase	
		1. validate - validate source code trước khi compile
		2. compile -> Biên dịch file java thành file class
		3. test -> Run các Unit test được chỉ định trong project
		4. pagekage - Đóng gói theo kiểu đã chỉ định
		5. install - Đưa file đóng gói vào local repo để share cho các project khác nhau ở local, lưu ý không phải install lên web server để chạy.
		6. deploy - Đưa file đóng gói lên online repo, cần phải có chỉ định URL ở online repo, lưu ý không phải deploy lên web server để chạy.
		
# Step 5: Thêm một Dependency vào project
	- Khi sử dụng maven, chúng ta có thể sử dụng các class đã được đóng gó và publish ở repositories.
	- Để sử dụng, ở file pom.xml chúng ta cần khai báo vào trong tag dependencies bằng tag dependency gồm các thông tin groupId, artifactId, version - Có thể dùng maven search để tìm kiếm thư viện chứa class mà chúng ta cần dùng.
	- Cách maven hoạt động:
		- Download gói jar với thông tin được khai báo trong pom về local repo.
		- Attach jar file vào class path của project.
		- Khi đó, ở project chúng ta có thể dùng các class có ở gói jar đã khai báo.
	
	- Thêm một dependency vào project và chạy thử: log4j
		- Truy cập : https://mvnrepository.com/artifact/log4j/log4j/1.2.17
		- Copy khai báo sau vào pom.xml
			<!-- https://mvnrepository.com/artifact/log4j/log4j -->
			<dependency>
				<groupId>log4j</groupId>
				<artifactId>log4j</artifactId>
				<version>1.2.17</version>
			</dependency>
		- Run mvn compile, file jar log4j sẽ được download và sau đó chúng ta có thể dùng class Logger để ghi log project
	- Lưu ý, khi khai báo 1 dependency, thì cần quan tâm đến scope sử dụng
		- Chi tiết: https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Dependency_Scope
		- Default là compile
		
# Step 6: Build web-app với maven
	- Sử dụng template project bằng cách generate: 
		- mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4
	- Vào thư mục dự án đã tạo, thực hiện compile và đóng gói
		- mvn compile -> mvn package
	- Deploy lên Tomcat server và kiểm chứng
		- Start Tomcat
		- Truy cập http://localhost:8080/manager/html 
		- WAR file to deploy => Chọn file WAR đã đóng gói và chạy thử

# Step 7: Maven Compile plugin
	- Plug-in là một dạng cấu hình lúc thực hiện build project
	- Maven Compile plugin là công cụ dùng để thiết lập các cấu hình các thông tin cần cho quá trình compile
	
# Step 8: Jetty pluggin
	- Jetty là một web app serve, giống như tomcat, ta có thể deploy project lên Jetty để chạy
	- Khai báo Jetty trog tag <pluggin>
			<plugin>
			  <groupId>org.mortbay.jetty</groupId>
			  <artifactId>maven-jetty-plugin</artifactId>
			  <version>6.1.10</version>
			</plugin>
	- Run project với Jetty mvn jetty:run - Trong đó jetty:run là quy tắc được định nghĩa để khởi động Jetty
	- Ngoài ra, có thể cấu hình để Jetty có thể nhận biết sự thay đổi source code để tự động deploy bằng tag configuration -> scanInteral (5s)
	- Tương tự cho các pluggin khác, ta có thể cấu hình thêm những thông tin mà ta muốn thực hiện lúc build project
	- Để sử dụng thành thạo các pluggin thì cần hiểu về chức năng và các quy tắc để khởi động pluggin đó
	- Truy cập http://localhost:8080/ và xác nhận kết quả
	
# Step 9: Eclipse pluggin và Maven pluggin trong Eclipse
	- Để import 1 maven project vào eclipse thì cần những file meta để eclipse hiểu được. Ở đây ta dùng eclipse pluggin
		- mvn eclipse:eclipse
		- Sau khi chạy thì file .project và file .classpath sẽ được tạo, từ đây thì mới import được project vào eclipse
	- Ngược lại, eclipse muốn build được maven project thì cần có maven pluggin. Cài đặt từ Help -> New Install -> Maven
		- Đối với các eclipse mới, maven dường như đã được cài dặt
	- Sau cùng, có thể thao tác build, compile và run project
	- Đối với build, compile thì dùng menu trên click chuột trái trên project
	- Đối với run thì chạy Run As và cài đặt goal thực thi. Ví dụ như chạy Jetty thì: jetty:run

# Step 10: Tạo một Maven Project ở Eclipse
	- Sau khi có Maven Plug-in, ta dễ dàng tạo 1 project maven với archetype tùy chọn
	- Cài đặt dependencies và pluggin
	- Compile và khởi chạy
