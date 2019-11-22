---
layout: default
title: Method String indexOf() trong Java với ví dụ.
description: Method String indexOf() trong Java với ví dụ.
---

# Method String indexOf() trong Java là gì ?
Method indexOf được sử dụng để lấy giá trị số nguyên của một chỉ mục cụ thể của một đối tượng String, dựa trên chỉ định trong tham số của method indexOf.
Một tình huống phổ biến có thể là khi system admin muốn tìm chỉ mục của ký tự **@** của một email id của một khách hàng và sau đó muốn lấy các chuỗi con còn lại. Trong tình huống đó, method indexOf được sử dụng.


## Cú pháp:
```java
public int indexOf(int cha)
```
## Parameters:
```java
cha − a character.
```

## Return Value:
```java
Method này trả về chỉ mục xuất hiện đầu tiên của ký tự được chỉ đinh bên trong chuỗi String. Nó trả về -1 nếu ký tự đó không xuất hiện trong chuỗi.
```

## Các biến thể:
String indexOf trong Java có 4 biến thể. Tất cả đều trả về giá trị số nguyên, đại diện cho chỉ mục trả về. Các biến thể này có sự khác nhau về kiểu và số tham số truyền vào.

### **IndexOf(char b)**
Method này trả về chỉ mục của ký tự **b** được truyền vào bởi tham số. Nếu ký tự này không có trong chuỗi, chỉ mục trả về là -1.

### **IndexOf(char c, int startindex)**
Method này trả về chỉ mục của sự xuất hiện đầu tiên của ký tự **c** phía sau số chỉ mục được truyền vào dưới dạng tham số thứ 2 **startindex**. Tất cả các sự xuất hiện của ký tự **c** ở phía trước **startindex** sẽ được bỏ qua.

### **IndexOf(String substring)**
Method này trả về chỉ mục của ký tự đầu tiên của chuỗi con được truyền vào bởi tham số. Nếu chuỗi con này không có trong chuỗi, chỉ mục trả về là -1.

### **IndexOf(String substring, int startindex)**
Method này trả về chỉ mục của ký tự đầu tiên của sự xuất hiện đầu tiên của chuỗi con được truyền vào dưới dạng tham số thứ nhất, phía sau số chỉ mục được truyền vào dưới dạng tham số thứ 2 **startindex**. Tất cả các sự xuất hiện của chuỗi con ở phía trước **startindex** sẽ được bỏ qua.


## Ví dụ:
```java
public class Sample_String {
    public static void main(String args[]) {

        String str_Sample = "This is Index of Example";
        //Character at position
        System.out.println("Index of character 'x': " + str_Sample.indexOf('x'));
        //Character at position after given index value
        System.out.println("Index of character 's' after 3 index: " + str_Sample.indexOf('s', 3));
        //Give index position for the given substring
        System.out.println("Index of substring 'is': " + str_Sample.indexOf("is"));
        //Give index position for the given substring and start index
        System.out.println("Index of substring 'is' form index:" + str_Sample.indexOf("is", 5));
    }
}
```

## Output:
```java
Index of character 'x': 12
Index of character 's' after 3 index: 3
Index of substring 'is': 2
Index of substring 'is' form index:5
```

[Back](./)
