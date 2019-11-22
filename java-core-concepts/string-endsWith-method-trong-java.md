---
layout: default
title: Method String endsWith() trong Java với ví dụ.
description: Method String endsWith() trong Java với ví dụ.
---

# Method String endsWith() trong Java là gì ?
Method Java endsWith được dùng để kiểm tra rằng một String có kết thúc với một chuỗi con mà người dùng chỉ định hay không. Dựa trên sự so sánh này, nó sẽ trả về giá trị boolean True hoặc False.

## Cú pháp:
```java
public endsWith(suffix) 
```
## Parameters:
```java
suffix – Đây là chuỗi con hậu tố.
```

## Return Value:
```java
False: Ký tự tuần tự được cung cấp bởi tham số "suffix" không khớp với các ký tự tuần tự cuối cùng của String đang gọi.
True: Ký tự tuần tự được cung cấp bởi tham số "suffix" khớp với các ký tự tuần tự cuối cùng của String đang gọi.
```

## Lỗi:
```java
None
```

## Ví dụ:
```java
public class StringEx1 {
    public static void main(String[] args) {
        String str_Sample = "Java String endsWith example";
        //Check if ends with a particular sequence
        System.out.println("EndsWith character 'e': " + str_Sample.endsWith("e"));
        System.out.println("EndsWith character 'ple': " + str_Sample.endsWith("ple"));
        System.out.println("EndsWith character 'Java': " + str_Sample.endsWith("Java"));
    }
}
```

## Kết quả:
```java
EndsWith character 'e': true
EndsWith character 'ple': true
EndsWith character 'Java': false
```

Method java.lang.String.endsWith() sẽ trả về giá trị **true** nếu string này kết thúc với hậu tố được chỉ định.

[Back](./)
