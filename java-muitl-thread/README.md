# ====================
# Đa luồng trong Java
# ====================

# Thread và Multi Thread
1. Thread: Là một tiến trình con, 1 luồng xử lý nhỏ nhất mà máy tính có thể phân biệt được. Trong Java, thread được quản lý bởi JVM
2. Multi Thread: Là một tiến trình được có nhiều luồng thực hiện đồng thời. Một ứng dụng Java, ngoài luồng xử lý chính có thể có nhiều luồng khác được xử lý đồng thời nhằm giảm thời gian xử lý của chương trình, làm chương trình chạy nhanh hơn.

# Đa nhiệm - Multi Tasking
Multi Tasking là khái niệm để chỉ thực hiện đồng thời một hoặc nhiều chương trình trên máy tính. Việc quản lý Multi Tasking sẽ do hệ điều hành làm, nó sẽ phân bổ bộ nhớ và lên schedule để thực hiện Tasking.
Có 2 cách để triển khai Multi Tasking
1. Multi Tasking bằng Multi Process => Nghĩa là mỗi chương trình chạy sẽ là 1 process, được phân bổ bộ nhớ riêng biệt từ khi khởi tạo đến thực thi => Tốn nhiều tài nguyên.
2. Multi Tasking bằng Multi Thread => 1 chương trình sẽ là 1 process, trong process có nhiều thread chạy đồng thời, bộ nhớ của 1 process được chia sẻ cho các thread => Tiết kiệm tài nguyên hơn => Cái này được dùng nhiều hơn.

# Ưu nhược điểm của Multi Thread
## Ưu điểm:
- Tiết kiệm tài nguyên vì chia sẻ tài nguyên giữa các thread
- Độc lập - Mặc dù tài nguyên dùng chung nhưng bản thân mỗi luồng là 1 process con độc lập nên các xử lý là độc lập. Trường hợp có ngoại lệ thì vẫn không làm cho cả process chết đi.
- Tiết kiệm thời gian - 1 chương trình có thể sử dụng nhiều luồng để xử lý nhiều công việc khác nhau khiến cho chương trình chạy nhanh hơn.

## Nhược điểm:
- Càng nhiều luồng thì càng phức tạp
- Tài nguyên dùng chung nên sẽ xảy ra tranh chấp, xung đột => Việc đồng bộ dữ liệu là phức tạp
- Khả năng phát sinh luồng chết - Luồng được tạo ra mà không làm gì vì xung đột trạng thái => Kiểm soát việc này là khá khó khăn.

# Vòng đời của 1 Thread
- Để làm việc với Thread, ta cần hiểu về các trạng thái mà 1 vòng đời của Thread có.
- Các trạng thái của Thread được định nghĩa ở: Thread.state
	- NEW => Là khi khởi tạo Thread
	- RUNABLE => Là khi start thread, chỉ là cho phép chạy, còn khi nào chạy là do hệ điều hành
	- WAITING => Trạng thái chờ, chờ thread khác gọi nó.
	- BLOCKED => Trạng thái khóa, chờ thread khác gỡ khóa cho nó.
	- TERMINATED => Trạng thái chết => Khi phương thức run() của Thread kết thúc

# Cách tạo Thread trong Java
- Có 2 cách để tạo Thread trong Java
	1. Kế thừa class Thread
	2. Implement interface Runable
- Đối với cách tạo Thread sử dụng Runable thì có thể cho phép class được tạo kế thừa thêm 1 class khác, còn đối với việc kế thừa class Thread thì không vì Java không hỗ trợ đa kế thừa

## Cách 1: Tạo Thread bằng cách Kế thừa class Thread
- Tạo class và Kế thừa class Thread
- Override method run()
- Chạy Thread bằng method start()

- Có lưu ý là: 
	- Để khởi chạy Thread thì dùng start(), còn xử lý là ở run(). Nếu gọi trực tiếp run() thì như gọi đến 1 method trong 1 object bình thường. 
	- Lý do: Thread định nghĩa start() để cho phép tạo thread mới, chuyển trạng thái Thread thành RUNABLE, đến khi hệ điều hành cho phép Thread thực thi thì cấp phát tài nguyên và run() mới được thực thi

## Cách 2: Tạo Thread bằng cách Implement interface Runable
	- Tạo class và implement interface Runable
	- Override method run()
	- Tạo instance Thread với tham số là Runable đã tạo
	- Chạy Thread bằng method start()
	
# Các thông tin của Thread
1. Định danh
	- Id
	- Name
2. Độ ưu tiên
	- Priority
3. Trạng thái
	- Alive
	- State
	- interrupt
	
# Các phương thức liên quan đến Thread hay dùng
1. suspend() - Tạm dừng hoạt động của luồng - Tuy nhiên không dừng ngay tức thì mà Thread xử lý xong, trả về hệ điều hành thì mới dừng => Cách này an toàn cho việc dừng luồng. Muốn chạy tiếp thì đến 2.
2. resume() - Phương thức này là cho tiếp tục chạy Thread đã bị tạm dừng bởi (1)
3. stop() - Cái này là cưỡng chế dừng Thread, không cần quan tâm đang xử lý gì, vì vậy các đối tượng đang được xử lý rất dễ bị treo, dẫn đến các xử lý khác rơi vào trạng thái waiting forever. => Không an toàn.
4. destroy() - Dừng hẳn luồng, không re-run lại được.
5. isAlive() - Kiểm tra Thread đang sống hay chết. Trả về TRUE khi đã start và chưa chết, ngược lại là FALSE.
6. yeild() - Hệ điều hành cho chạy Thread tuần tự, hết Thread này đến Thread khác, method này nói với Hệ điều hành là không cần cung cấp tài nguyên để chạy Thread này, đi tới Thread tiếp theo đi. Bản thân Thread không dừng hay chết mà chỉ 1 lần không cần cung cấp tài nguyên, những lần tiếp theo chạy bình thường.
7. sleep() - Tạm dừng Thread trong XX giây, sau đó chạy tiếp.
8. join() - Dùng để thông báo là Thread này chạy xong thì Thread cha mới được chạy
9. join(long XX)  - Dùng để thông báo là sau XX giây thì Thread cha mới được chạy, không cần phải chờ Thread con chạy xong như ở trên.
10. get/setName() - Lấy tên/Sửa tên Thread
11. getId() - Lấy Id Thread - Không sửa được vì cái này Hệ điều hành tạo ra.
12. getState() - Lấy trạng thái.
13. currentThread() - Lấy về đối tượng tham chiếu của Thread đang chạy
14. get/setPriority() - Lấy/Sửa độ ưu tiên của Thread - Thread có 3 độ ưu tiên tương ứng 1-5-10
15. is/setDeamon() - Kiểm tra/Thiết lập Thread là Deamon hay không => Tìm hiểu thêm về Deamon
16. interrupt() - Method này làm gián đoạn Thread về mặt logic, khi được gọi nó sẽ bật Flg interrupt thành TRUE, trong khi Thread vẫn chạy bình thường. Nếu Thread đang ở trạng thái sleep hoặc waiting thì sẽ lỗi.
17. isInterrupted()/interrupted() - Kiểm tra trạng thái Thread có interrupte không

# Xử lý ngoại lệ của Thread
Dùng Thread.setDefaultUncaughtExceptionHandler() để bắt ngoại lệ và xử lý tiếp theo cho trường hợp Thread.
=> Lý do: Vì Thread khá phức tạp nên rất khó để bắt được hết tất cả các exception của Thread trong quá trình chạy
	

# ====================
# ThreadPool và Executor
# ====================



# ====================
# ThreadPoolExecutor
# ====================




