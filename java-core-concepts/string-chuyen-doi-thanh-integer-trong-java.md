---
layout: default
title: Chuyển đổi String thành Integer trong Java
description: Chuyển đổi String thành Integer trong Java
---

Có 2 cách để chuyển đổi String thành Integer trong Java
1. Chuyển đổi String sang Integer bằng cách dùng method Integer.parseInt()
1. Chuyển đổi String sang Integer bằng cách dùng method Integer.valueOf()

![Chuyển đổi String thành Integer trong Java](./images/convert-string-to-integer-1.png)

Như đã nói, bạn có một string - **strTest** - nó chứa một giá trị số.
```java
String strTest = “100”;
```

Cố gắng thực hiện một phép toán học như chia cho 4 chẳng hạn - Ngay lập tức nó sẽ hiển thị cho bạn một lỗi compile.

## Ví dụ:
```java
class StrConvert{
  public static void main(String []args){
    String strTest = "100";
    System.out.println("Using String:" + (strTest/4));
  }
}
```

## Lỗi:
```java
/StrConvert.java:4: error: bad operand types for binary operator '/'
    System.out.println("Using String:" + (strTest/4));
```

Vì thế, bạn cần chuyển đổi một String thành một giá trị **int** trước khi bạn thực hiện toán tử số trên nó.

# Ví dụ 1: Chuyển đổi String sang Integer bằng cách dùng Integer.parseInt()
## Cú pháp:
```java
int <IntVariableName> = Integer.parseInt(<StringVariableName>);
```
Đưa vào giá trị String như là một tham số.

Nó sẽ chuyển đổi Java String sang Java Integer và lưu nó vào một biến Integer được chỉ định.

## Mã code:
```java
class StrConvert{
  public static void main(String []args){
    String strTest = "100";
    int iTest = Integer.parseInt(strTest);
    System.out.println("Actual String:"+ strTest);
    System.out.println("Converted to Int:" + iTest);
    //This will now show some arithmetic operation
    System.out.println("Arithmetic Operation on Int: " + (iTest/4));
  }
}
```

## Kết quả:
```java
Actual String:100
Converted to Int:100
Arithmetic Operation on Int: 25
```

# Ví dụ 2: Chuyển đổi String sang Integer bằng cách dùng Integer.valueOf()
Method Integer.valueOf() cũng được sử dụng để chuyển đổi String thành Integer trong Java.

## Mã code:
```java
public class StrConvert{
  public static void main(String []args){
    String strTest = "100";
    //Convert the String to Integer using Integer.valueOf
    int iTest = Integer.valueOf(strTest);
    System.out.println("Actual String:"+ strTest);
    System.out.println("Converted to Int:" + iTest);
    //This will now show some arithmetic operation
    System.out.println("Arithmetic Operation on Int:" + (iTest/4));
  }
}
```

## Kết quả:
```java
Actual String:100
Converted to Int:100
Arithmetic Operation on Int:25
```

# NumberFormatException
NumberFormatException sẽ được bắn ra nếu bạn cố gắng chuyển đổi một chuỗi số không hợp lệ. Ví dụ: String **Guru99** không thể chuyển đổi thành Integer.

## Ví dụ:
```java
public class StrConvert{
  public static void main(String []args){
    String strTest = "Guru99";
    int iTest = Integer.valueOf(strTest);
    System.out.println("Actual String:"+ strTest);
    System.out.println("Converted to Int:" + iTest);
  }
}
```

## Kết quả:
Ví dụ ở trên sẽ đưa ra một lỗi như bên dưới:
```java
Exception in thread "main" java.lang.NumberFormatException: For input string: "Guru99"
```

[Back](./)
