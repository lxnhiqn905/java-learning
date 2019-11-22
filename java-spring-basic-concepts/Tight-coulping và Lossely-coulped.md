# =============================
# Tight-coulping và Lossely-coulped
# Ràng buộc chặt chẽ và cách giảm liên kết ràng buộc
# =============================

# Tight-coulping và Lossely-coulped là 2 khái niệm thể hiện sự ràng buộc của 2 class trong Java. Mức độ thể hiện như sau:
1. tight-coulping thể hiện cho sự ràng buộc chặt chẽ
=> Với cách này, khi thực hiện thay đổi yêu cầu gì đó, các ràng buộc liên quan đến đối tượng cũng sẽ phải thay đổi theo. Nó khiến cho phạm vi chỉnh sửa tăng lên, chi phi tăng theo.
2. lossely-coulped thể hiện cho sự ràng buộc lỏng lẽo - Hay nói cách khác là giảm liên kết ràng buộc.
=> Với cách này, giảm thiểu các liên kết ràng buộc chặt chẽ nhưng vẫn đảm bảo tính nhất quán trong source code. Việc này nếu làm được thì khi có yêu cầu thay đổi ta chỉ cần thay đổi trực tiếp đối tượng được yêu cầu, mà không cần phải thay đổi những liên kết ràng buộc, giảm phạm vi chỉnh sửa.

# Ví dụ:
Bài toán: Viết 1 chương trình thực hiện tính toán, trong đó thực hiện sắp xếp dữ liệu tăng dần trước khi tính toán. Chương trình sẽ được chạy từ 1 class có hàm main().

## Mức độ 1:
Thiết kế: Dự định tạo 3 class với các mục đích sau:
1. Class thực thi với hàm main()
2. Class Service với chức năng xử lý tính toán. Trong đó gọi đến 1 class Utils để sắp xếp dữ liệu.
3. Class Utils để sắp xếp dữ liệu tăng dần

Class SapxepTangDanUtils() {
	sapxep() {
		// Thực hiện sắp xếp và trả về
	}
}


Class TinhToanService() {
	SapxepTangDanUtils utils = new SapxepTangDanUtils();
	tinhtoan() {
		// Sắp xếp dữ liệu trước khi tính toán
		utils.sapxep();
		// Thực hiện tính toán và trả về
	}
}


Class Execute() {
	main() {
		TinhToanService service = new TinhToanService();
		// Thực hiện tính toán
		service.tinhtoan();
	}
}

Đánh giá:
- Xem xét TinhToanService và SapxepTangDanUtils ta thấy sự liên kết rất chặt chẽ. SapxepTangDanUtils được khởi tạo từ TinhToanService nên SapxepTangDanUtils chỉ "sống" khi TinhToanService "sống".

Xem xét thay đổi yêu cầu từ sắp xếp tăng dần sang giảm dần:
- Gần như phải thay đổi cả 2 class TinhToanService và SapxepTangDanUtils

## Mức độ 2:
Thiết kế: Dự định tạo 3 class và 1 interface với các mục đích sau:
1. Class thực thi với hàm main()
2. Class Service với chức năng xử lý tính toán. Trong đó gọi đến 1 class Utils để sắp xếp dữ liệu.
3. Interface để định nghĩa phương thức sắp xếp dữ liệu.
4. Class Utils để triển khai phương thức sắp xếp.

Interface SapxepUtils() {
	sapxep() 
}

Class SapxepTangDanUtils() implement SapxepUtils{
	sapxep() {
		// Thực hiện sắp xếp và trả về
	}
}


Class TinhToanService() {
	SapxepUtils utils;
	
	TinhToanService() {
		utils = new SapxepTangDanUtils();
	}
		
	tinhtoan() {
		// Sắp xếp dữ liệu trước khi tính toán
		utils.sapxep();
		// Thực hiện tính toán và trả về
	}
}

Class Execute() {
	main() {
		TinhToanService service = new TinhToanService();
		// Thực hiện tính toán
		service.tinhtoan();
	}
}

Đánh giá:
- Ở đây, khi dùng interface ta thấy sự liên kết đã giảm đi 1 ít. 

Xem xét thay đổi yêu cầu từ sắp xếp tăng dần sang giảm dần:
- Ta vẫn phải tạo class Utils để requirement mới và chỉnh sửa TinhToanService để khởi tạo đúng class Utils.

## Mức độ 3:
Thiết kế: Dự định tạo 3 class và 1 interface với các mục đích sau:
1. Class thực thi với hàm main() có truyền Utils vào Service như là 1 tham số
2. Class Service với chức năng xử lý tính toán. Trong đó gọi đến 1 class Utils để sắp xếp dữ liệu.
3. Interface để định nghĩa phương thức sắp xếp
4. Class Utils để triển khai phương thức sắp xếp

Interface SapxepUtils() {
	sapxep() 
}

Class SapxepTangDanUtils() implement SapxepUtils{
	sapxep() {
		// Thực hiện sắp xếp và trả về
	}
}


Class TinhToanService() {
	SapxepUtils utils;
	TinhToanService(SapxepUtils utilsTruyenVao) {
		this.utils = utils;
	}
		
	tinhtoan() {
		// Sắp xếp dữ liệu trước khi tính toán
		utils.sapxep();
		// Thực hiện tính toán và trả về
	}
}


Class Execute() {
	main() {
		SapxepUtils utils = new SapxepTangDanUtils();
	
		TinhToanService service = new TinhToanService(utils);
		// Thực hiện tính toán
		service.tinhtoan();
	}
}

Đánh giá, ở đây ta thấy sự liên kết của SapxepTangDanUtils và TinhToanService đã được gỡ bỏ.

Xem xét thay đổi yêu cầu từ sắp xếp tăng dần sang giảm dần:
- Ta chỉ cần tạo class Utils để requirement mới và thay thế từ class thực thi. Ở đây, chúng ta không cần phải chỉnh sửa TinhToanService.

# Tổng kết
Đây là bài toán cơ bản để hiểu về khái hiện Dependency Injection - DI (Tiêm vào sự phụ thuộc) trong Spring.
