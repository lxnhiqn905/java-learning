---
layout: default
title:  Interface và abstract class trong Java
description: Interface và abstract class trong Java
---

# Interface là gì ?
Interface là một bản vẽ thiết kế mà có thể được sử dụng để triển khai một class. Interface không chứa phần thân của methods. Tất cả các methods của một interface đều là abstract methods.

Một Interface không thể được khởi tạo. Tuy nhiên, những class triển khai interface thì có thể được khởi tạo. Interface không bao giờ chứa các biến instance nhưng có thể chứa các biến static final như là biến constant chẳng hạn.

# Abstract class là gì?
Một class mà có từ khóa abstract trong phần khai báo của nó thì được gọi là abstract class. Abstract class phải có ít nhất một abstract method, method không có phần thân. Nó có thể chứa nhiều method có xử lý rõ ràng.

Abstract class cho phép bạn tạo các bản thiết kế cho các class cụ thể. Nhưng class kế thừa phải triển khai các method abstract. 

Abstract class khong thể được kế thừa.

# Lý do quan trọng nên dùng Interface
- Interface được sử dụng để đóng gói trừu tượng
- Được thiết kế để hỗ trợ giải pháp method động trong lúc run time
- Nó giúp tạo những kết nối
- Nó giúp bạn tách phần định nghĩa method ra khỏi phần triển khai của các cấp kế thừa

[Back](./)
