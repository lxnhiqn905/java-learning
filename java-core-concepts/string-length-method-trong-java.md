---
layout: default
title: Method String Length trong Java với ví dụ.
description: Method String Length trong Java với ví dụ.
---

# Method String Length trong Java là gì ?
Chức năng này được dùng để lấy độ dài của một Java String. Method String length trả về số ký tự được viết trong chuỗi String. Method này trả về độ dài của bất kỳ String nào mà bằng số ký tự 16-bit Unicode có trong chuỗi.

## Cú pháp:
```java
public int length()
```
## Parameters:
```java
NA
```

## Return Value:
```java
Trả về độ dài của String.
```

## Ví dụ:
Trong chương trình này, chúng ta có 2 String, và chúng ta tìm ra độ dài của chúng bằng cách sử dụng method length().
```java
public class Sample_String {
    public static void main(String[] args) {
        //declare the String as an object S1 S2
        String S1 = "Hello Java String Method";
        String S2 = "RockStar";

        //length() method of String returns the length of a String S1.
        int length = S1.length();
        System.out.println("Length of a String is: " + length);
        //8 Length of a String RockStar
        System.out.println("Length of a String is: " + S2.length());
    }
}
```

## Output:
```java
Length of a String is: 24
Length of a String is: 8
```

[Back](./)
