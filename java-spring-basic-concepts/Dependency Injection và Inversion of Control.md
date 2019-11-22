# =============================
# Dependency Injection và Inversion of Control
# =============================

# Dependency Injection 
- Dependency Injection hay còn gọi là DI, là một design pattern, mục đích giảm liên kết ràng buộc của các class.
- Nguyên tắc của DI là các class nên phụ thuộc vào abtraction, không phụ thuộc vào class implement(Class cấp thấp)

# Học qua ví dụ:
## Bài toán: Thiết lập chương trình khởi tạo thông tin người mẫu, và khởi tạo các thuộc tính liên quan cho họ như quần áo, mẫu tóc, phụ kiện thời trang.
## Cách code 1:
- Tạo các class quần áo, mẫu tóc, phụ kiện thời trang.
- Khởi tạo một người mẫu và gán các thể hiện của các class trên cho họ.
- Cho họ ra trình diễn.
=> Bài toán, giả sử thay đổi bất cứ điều gì ở 3 class trên thì gần như phải thay đổi toàn bộ source code

## Cách code 2: 
- Tạo các interface quần áo, mẫu tóc, phụ kiện thời trang.
- Tạo các class implement interface quần áo, mẫu tóc, phụ kiện thời trang.
- Khởi tạo một người mẫu và gán các thể hiện của các class trên cho họ.
- Cho họ ra trình diễn.
=> Ở đây, người mẫu không phụ thuộc vào class mà chỉ phụ thuộc vào interface(abtraction) nhưng việc khởi tạo các thể hiện của  quần áo, mẫu tóc, phụ kiện thời trang bên trong người mẫu vẫn tạo nên sự phụ thuộc chặt chẽ. 
=> Giả sử có sự thay đổi, vẫn phải thay đổi class người mẫu.

## Cách code 3:
- Tạo các interface quần áo, mẫu tóc, phụ kiện thời trang.
- Tạo các class implement interface quần áo, mẫu tóc, phụ kiện thời trang.
- Tạo các thể hiện của class  quần áo, mẫu tóc, phụ kiện thời trang.
- Khởi tạo người mẫu và truyền các thể hiện  quần áo, mẫu tóc, phụ kiện thời trang vào người mẫu thông qua contructor()
- Cho họ ra trình diễn.
=> Ta thấy ở đây các thể hiện được tạo độc lập, khi cần thì đưa vào bên trong người mẫu. Người mẫu chỉ nhận phần phụ thuộc qua contructor với các tham số kiểu interface. Việc này giảm thiểu sự phụ thuộc giữa người mẫu và các class  quần áo, mẫu tóc, phụ kiện thời trang.
=> Nếu bài toán thay đổi quần áo hay phụ kiện, ta chỉ cần khởi tạo thể hiện và đưa vào cho người mẫu, bản thân người mẫu không quan tâm các thể hiện chi tiết, chỉ cần đó là các implement của interface là đủ.
=> Thiết kế như trên gọi là Dependency Injection. Nó giúp giảm thiểu sự phụ thuộc giữa các class và tăng cường khả năng mở rộng code.

# Inversion of Control
- Inversion of Control là một nguyên lý giúp chúng ta hỗ trợ chúng ta quản lý các DI.
- Như cách code ở trên, để áp dụng Dependency Injection, chúng ta cần thiết phải khởi tạo các đối tượng và cung cấp cho đối tượng cần dùng nó. Vậy đối với 1 class mà có quá nhiều phụ thuộc thì việc tạo ra quá nhiều đối tượng sẽ trở nên rắc rối, chưa kể nếu quá nhiều đối tượng được tạo ra thì khả năng dư thừa tăng lên và ảnh hưởng đến performance. 
=> Để giải quyết vấn đề trên, Inversion of Control là nguyên lý mà ở đó nên có một cái kho(container) giúp chúng ta khởi tạo và quản lý các đối tượng, khi cần thì tự động inject các dependency vào đối tượng của chúng ta.
=> Spring là một framework xây dựng dựa trên nguyên lý trên, có IoC container để chứa các object và giúp chúng ta tự động inject và các đối tượng
=> Nguyên lý hoạt động ở trên gọi là đảo chiều điều khiển, thay vì chúng ta tự điều khiển thì để framework làm giúp ta điều đó, ta chỉ cần tập trung vào các xử lý cần thiết hơn, từ đó giúp quá trình phát triển dự án nhanh hơn.
=> Google Guice cũng là một framework mà xây dựng trên nguyên tắc Inversion of Control
