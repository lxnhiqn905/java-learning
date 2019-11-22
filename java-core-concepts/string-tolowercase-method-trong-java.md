---
layout: default
title: Method String toLowercase() và toUpperCase() trong Java với ví dụ.
description: Method String toLowercase() và toUpperCase() trong Java với ví dụ.
---

# 1. Method toLowercase() trong Java String
Method Java này sẽ chuyển đổi mọi ký tự của string cụ thể thành chữ thường bằng cách sử dụng các quy tắc của default locale.
**Lưu ý**: Method này phụ thuộc vào default local, sẽ có trường hợp có kết quả không mong muốn vì sử dụng các chuỗi đặc trưng.

## Cú pháp:
```java
public String toLowerCase()
```
## Parameters:
```java
NA
```

## Return Value:
```java
Nó trả về một String mà đã được chuyển đổi thành chữ thường.
```

## Ví dụ:
```java
public class Guru99 {
    public static void main(String args[]) {
        String S1 = new String("UPPERCASE CONVERTED TO LOWERCASE");
        //Convert to LowerCase
        System.out.println(S1.toLowerCase());

    }
}
```

## Kết quả:
```java
uppercase converted to lowercase
```

# 2. Method toUppercase () trong Java String
Method toUpperCase() được sử dụng để chuyển đổi tất cả các ký tự của một chuỗi đã cung cấp thành chữ hoa.

## Cú pháp:
```java
toUpperCase()
```
## Parameters:
```java
NA
```

## Return Value:
```java
Chuỗi của các ký tự in hoa.
```

## Ví dụ:
```java
public class Guru99 {
    public static void main(String args[]) {
        String S1 = new String("lowercase converted to uppercase");
        //Convert to UpperCase
        System.out.println(S1.toUpperCase());
    }
}
```

## Kết quả:
```java
LOWERCASE CONVERTED TO UPPERCASE
```

[Back](./)
