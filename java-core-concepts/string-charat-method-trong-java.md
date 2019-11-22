---
layout: default
title: Method String charAt() trong Java với ví dụ.
description: Method String charAt() trong Java với ví dụ.
---

# Method String charAt() trong Java là gì ?
Method charAt trả về ký tự ở chỉ mục được xác đinh. Trong method này, giá trị chỉ mục phải nằm trong khoảng từ 0 và độ dài của String trừ 1.

## Cú pháp:
```java
public char charAt(int index)
```
## Parameters:
```java
index – Method này chỉ chấp nhận một tham số đơn với kiểu dữ liệu là số nguyên.
```

## Return Value:
```java
Method này trả về một dữ liệu kiểu ký tự dựa trên chỉ mục truyền vào.
```

## Lỗi:
Ném ra lỗi java.lang.StringIndexOutOfBoundsException nếu chỉ mục truyền vào không nằm trong khoảng từ 0 đến độ dài của String trừ 1.

## Ví dụ:
Trong chương trình này, chúng ta có 2 String, và chúng ta tìm ra độ dài của chúng bằng cách sử dụng method length().
```java
public class CharAtGuru99 {
    public static void main(String args[]) {
        String s1 = "This is String CharAt Method";
        //returns the char value at the 0 index
        System.out.println("Character at 0 position is: " + s1.charAt(0));
        //returns the char value at the 5th index
        System.out.println("Character at 5th position is: " + s1.charAt(5));
        //returns the char value at the 22nd index
        System.out.println("Character at 22nd position is: " + s1.charAt(22));
        //returns the char value at the 23th index
        char result = s1.charAt(-1);
        System.out.println("Character at 23th position is: " + result);
    }
}
```

## Output:
```java
Character at 0 position is: T
Character at 5th position is: i
Character at 22nd position is: M
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -1
```

## Một số điều quan trọng về method String charAt này.
- Method này luôn nhận 1 tham số là kiểu số nguyên(int)
- Method này trả về ký tự kiểu char cho đối số kiểu int đã cho. Giá trị int chỉ định phải bắt đầu từ 0.
- Nếu giá trị của chỉ mục lớn hơn độ dài của chuỗi hoặc là số âm thì IndexOutOfBounds Exception sẽ được ném ra.
- Chỉ mục cần phải nằm trong khoảng 0 đến string_length - 1

[Back](./)
