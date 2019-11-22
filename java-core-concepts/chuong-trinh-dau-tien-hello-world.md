---
layout: default
title: Chương trình đầu tiên - Hello World!
description: Chương trình đầu tiên - Hello World!
---

# Chương trình đầu tiên - Hello World!
Chúng ta cần 2 chương trình để tạo chương trình Java đầu tiên.
- [Java Development Kit](./cai-dat-java.md)
- Trình soạn thảo, ở hướng dẫn này chúng ta sẽ dùng trình soạn thảo phổ biến Notepad có sẵn ở Windows

Dưới đây là các bước thực hiện tạo chương trình Java đầu tiên.

Step 1: Mở Notepad và viết mã cho chương trình bạn như sau:
- Định nghĩa một lớp A
- Định nghĩa một phương thức chính **public static void main (String args[])**
- Gõ tiếp **System.out.println("Hello world !")**, nó sẽ hiển thị lên màn hình dòng chữ **Hello world !**

```java
class A {
    public static void main (String args[]) {
        System.out.println("Hello world !");
    }
}
```

Step 2: Lưu file chứa mã ở trên với tên **FirstProgram.java** trong thư mục **C:\workspace**

Step 3: Mở Command Prompt và di chuyển đến thưc mục **C:\workspace**

Step 4: Thực hiện biên dịch mã java với lệnh: _javac FirstProgram.java_

Step 5: Bạn sẽ thấy ở thưc mục **C:\workspace** xuất hiện 1 file mới, tên là **A.class**

Step 6: Để chạy chương trình thì ở Command Prompt gõ tiếp: _javac A_ Và kết quả mong muốn là dòng chữ **Hello world !** sẽ hiển thị lên màn hình.

Lưu ý: Java là ngôn ngữ lập trình phân biệt hoa thường, nên khi nhập lệnh bạn cần nhập đúng ký tự hoa thường thì mới thực hiện biên dịch và thực thi được. Ví dụ: FirstProgram không giống với firstprogram đâu nhé.

[Back](./)