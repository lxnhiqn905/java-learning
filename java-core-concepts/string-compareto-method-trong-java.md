---
layout: default
title: Method String compareTo() trong Java với ví dụ.
description: Method String compareTo() trong Java với ví dụ.
---

# Method String compareTo() trong Java là gì ?
Method compareTo được sử dụng để xử lý sắp xếp tự nhiên trong String. Sắp xếp tự nhiên nghĩa là thứ thứ tự sắp xếp được áp dụng trên đối tượng, ví dụ: sắp xếp từ vựng trên String, sắp xếp số nguyên trên Integers, ...

Sắp xếp từ vựng không có gì ngoài thứ tự các chữ cái. Method compareTo so sánh tuần tự các chữ cái trong chuỗi có vị trí giống nhau.

Method compareTo được định nghĩa trong interface java.lang.Comparable

## Cú pháp:
```java
public int compareTo(String str)
```
## Parameters:
```java
str – Method này chỉ chấp nhận dữ liệu đầu vào là kiểu String.
```

## Return Value:
Method này trả về một số nguyên dựa trên sự so sánh từ vựng giữa 2 String.
- Trả về < 0 thì String đang gọi method có thứ tự từ vựng nhỏ hơn.
- Trả về == 0 thì 2 String có thứ tự từ vựng bằng nhau.
- Trả về > 0 then tham số được truyền vào để so sành có thứ tự từ vựng nhỏ hơn.

## Ví dụ:
```java
public class Sample_String {
    public static void main(String[] args) {
        String str_Sample = "a";
        System.out.println("Compare To 'a' b is : " + str_Sample.compareTo("b"));
        str_Sample = "b";
        System.out.println("Compare To 'b' a is : " + str_Sample.compareTo("a"));
        str_Sample = "b";
        System.out.println("Compare To 'b' b is : " + str_Sample.compareTo("b"));
    }
}
```

## Kết quả:
```java
Compare To 'a' b is : -1
Compare To 'b' a is : 1
Compare To 'b' b is : 0
```
Ở đây,
- Ký tự **a** đến trước ký tự **b** trong bảng alplabet, vì thế kết quả là -1 
- Ký tự **b** đến sau ký tự **a** trong bảng alplabet, vì thế kết quả là 1 
- Hai ký tự **b** là bằng nhau trong bảng alplabet, vì thế kết quả là 0 

Bạn có thể sử dụng method **compareToIgnoreCase** để so sánh trong trường hợp bạn muốn có kết quả không phân biệt hoa thường.
## Ví dụ:
```java
public class Sample_String {
    public static void main(String[] args) {
        //Compare to a String
        String str_Sample = "RockStar";
        System.out.println("Compare To 'ROCKSTAR': " + str_Sample.compareTo("rockstar"));
        //Compare to - Ignore case
        System.out.println("Compare To 'ROCKSTAR' - Case Ignored: " + str_Sample.compareToIgnoreCase("ROCKSTAR"));
    }
}
```
## Kết quả:
```java
Compare To 'ROCKSTAR': -32
Compare To 'ROCKSTAR' - Case Ignored: 0
```

# Tại sao sử dụng method compareTo()
Method compareTo() được sử dụng để so sánh từ vựng của 2 String. Một ký tự của cả 2 String đều được chuyển đổi thành một giá trị Unicode. Tuy nhiên, nếu cả 2 String bằng nhau thì method này trả về giá trị 0. Ngược lại, nó chỉ trả về hoặc là giá trị âm hoặc là giá trị dương.

Trong method này, nếu String đầu tiên có thứ tự từ vựng lớn hơn String thứ 2 thì nó sẽ trả về một số dương.

Xem xét **a1.compareTo(a2)**:
- Nếu a1 > a2, nó trả về số dương
- nếu a1 < a2, nó trả về số âm
- a1 = a2, nó trả về 0.

## Ví dụ:
```java
public class Compare {
    public static void main(String[] args) {
        String s1 = "Guru1";
        String s2 = "Guru2";
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);

        // Compare the two strings.  
        int S = s1.compareTo(s2);

        // Show the results of the comparison.  
        if (S < 0) { System.out.println("\"" + s1 + "\"" + " is lexicographically higher than " + "\"" + s2 + "\"");
        } else if (S == 0) {
            System.out.println("\"" + s1 + "\"" + " is lexicographically  equal to " + "\"" + s2 + "\"");
        } else if (S > 0) {
            System.out.println("\"" + s1 + "\"" + " is lexicographically less than " + "\"" + s2 + "\"");
        }
    }
}
```
## Kết quả:
```java
String 1: Guru1
String 2: Guru2
"Guru1" is lexicographically higher than "Guru2"
```

[Back](./)
