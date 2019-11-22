---
layout: default
title: Method String contains() trong Java với ví dụ.
description: Method String contains() trong Java với ví dụ.
---

# Method String contains() trong Java là gì ?
Method contains() là Java method để kiểm tra String có chứa một chuỗi con khác hay không. Nó trả về giá trị boolean nên có thể dùng trực tiếp ở mệnh đề **if**

## Cú pháp:
```java
public boolean String.contains(CharSequence s)
```
## Parameters:
```java
S − Là chuỗi con cần kiểm tra.
```

## Return Value:
```java
Method này trả về giá trị true nếu String có chứa "s", ngược lại là false
```

## Lỗi:
```java
NullPointerException − Nếu giá trị "s" truyền vào là null
```

## Ví dụ:
```java
public class Sample_String {
    public static void main(String[] args) {
        String str_Sample = "This is a String contains Example";
        //Check if String contains a sequence
        System.out.println("Contains sequence 'ing': " + str_Sample.contains("ing"));
        System.out.println("Contains sequence 'Example': " + str_Sample.contains("Example"));
        //String contains method is case sensitive  
        System.out.println("Contains sequence 'example': " + str_Sample.contains("example"));
        System.out.println("Contains sequence 'is String': " + str_Sample.contains("is String"));
    }
}
```

## Kết quả:
```java
Contains sequence 'ing': true
Contains sequence 'Example': true
Contains sequence 'example': false
Contains sequence 'is String': false
```

# Vì sao sử dụng method contains()
Nó là một trường hợp phổ biến trong chương trình khi bạn muốn kiểm tra một chuỗi chỉ định có chứa một chuỗi con cụ thể. Ví dụ, bạn muốn kiểm tra rằng chuỗi **The big red fox** có chứa chuỗi con **red** hay không ?. Method này sẽ hữu ích với những tình huống như vậy.

## Ví dụ 2: Java String contains() trong mệnh đề if/else
```java
public class IfExample {
    public static void main(String args[]) {
        String str1 = "Java string contains If else Example";
        // In If-else statements you can use the contains() method

        if (str1.contains("example")) {
            System.out.println("The Keyword :example: is found in given string");
        } else {
            System.out.println("The Keyword :example: is not found in the string");
        }
    }
}
```

## Kết quả:
```java
The Keyword :example: is not found in the string
```

[Back](./)
