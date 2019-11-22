# =============================
# Các khái niệm cơ bản về Spring
# =============================

Mục này sẽ giới thiệu các Annotation(Class) mà Spring cung cấp dựa trên nguyên tắc DI và IoC để giúp chúng ta quản lý các đối tượng mà chúng ta tạo ra và tự động inject nó vào các phụ thuộc mà các đối tượng yêu cầu.
Đầu tiên ra phải thống nhất về thuật ngữ đối tượng được tạo ra:
- Mọi đối tượng được tạo ra ở Spring được gọi là bean
- Các thuộc tính được khai báo trong class được gọi là phụ thuộc - dependency

# 1. IoC Container trong Spring
- Như bài trước, ta thấy việc khởi tạo và quản lý các đối tượng được Spring đảm nhiệm thay chúng ta, vậy nó chứa ở đâu ? Nó chứa trong một IoC Container của Spring.
- Khi khởi tạo 1 đối tượng, những phụ thuộc của đối tượng đó sẽ được tự động inject vào cho nó.
=> Vậy làm thế nào để nó biết đâu là đối tượng, đâu là phụ thuộc và khi nào cần inject vào ?

# 2. Khai báo đối tượng bằng @Component
- @Component là một annotation được Spring cung cấp để khi khai báo một đối tượng chúng ta có thể dùng để báo với Spring đây là một đối tượng.
- @Component được dùng cho 1 class
- Cách Spring hoạt động với @Component: 
	- Spring quét các class, tìm thấy @Component thì khởi tạo đối tượng và đưa vào IoC Container để quản lý
- Đối với @Component thì khi khai báo đối tượng có thể đánh dấu Scope là "prototype" hoặc "singleton"
	- "singleton" là mặc định, nếu không khai báo nó sẽ lấy cái này => Có ý nghĩa là đối tượng là duy nhất trong IoC Container - Singleton design pattern
	- "prototype" nếu muốn dùng thì cần phải khai báo, nó cho phép mỗi lần sử dụng thì tạo một đối tượng mới - new instance.
	- Ngoài ra có các scope dùng cho web application như session, request, ... => Tìm hiểu sau
	
# 2. Inject phụ thuộc cho đối tượng bằng @Autowired
- @Autowired là annotation cho phép đánh dấu các dependency cần inject
- @Autowired dùng cho các thuộc tính hoặc method của đối tượng
- Cách Spring hoạt động: 
	- Khi thực hiện khởi tạo đối tượng, các thuộc tính hoặc method có đánh dấu @Autowired sẽ được Spring tự động tìm kiếm các đối tượng được quản lý ở IoC Container và inject vào cho thuộc tính hoặc method

# 3. Cấu hình các đối tượng cần thiết cho project với @Configuration
- @Configuration là annotation Spring cung cấp để đánh cấu các class được cho là cấu hình của project, khi Spring quét các class trong project để tạo ra các đối tượng thì sẽ ưu tiên cho @@Configuration trước
=> Việc này cho phép chúng ta có thể tổ chức các đối tượng quan trọng để dễ quản lý

# 4. Khai báo đối tượng với @Bean
- @Bean cũng là một dạng khai báo đối tượng như @Component, nhưng khác với @Component là @Bean method có trả về là một đối tượng.
=> Ngoài các class được khởi tạo thành 1 object, ta có thể sử dụng @Bean để khai báo giá trị trả về của một method thành một đối tượng được quản lý trong IoC Container
=> Nó kết hợp với @Configuration để khởi tạo các đối tượng ban đầu cho project
- Cách Spring vận hành:
	- Spring quét các class có đánh dấu @Configuration và thực hiện thực thi các method @Bean để lấy các đối tượng trả về và đưa vào IoC Container quản lý
	
# 5. Giải quyết vấn đề nhiều đối tượng có cùng kiểu.
- Đối với Spring, để áp dụng DI thì khi tạo class chúng ta cần có một abtraction(Interface) để đại diện cho kiểu trả về của nó. Vậy 2 class cùng implement 1 Interface thì như thế nào ? 
=> Lúc này sẽ tạo 2 đối tượng có kiểu như nhau, nếu không đánh dấu để phân biệt hoặc ưu tiên thì Spring sẽ lúng túng khi thực hiện inject khi có yêu cầu.
- Giải pháp:
	- @Primary => Đây là annotation được dùng khi khai báo bean, nó báo với IoC Container đây là đối tượng được ưu tiên nhất nên khi inject thì sẽ dùng cái đã được đánh dấu này.
	- @Bean("name") và @Qualifier("name") => Đây là cặp khai báo với tên tùy biến mà chúng ta tự quản lý, với @Bean("name") thì nó sẽ khai báo đối tượng và gán tên như chúng ta yêu cầu, @Qualifier("name") được dùng khi @Autowired để chỉ thị là inject đối tượng có tên "name".
	
