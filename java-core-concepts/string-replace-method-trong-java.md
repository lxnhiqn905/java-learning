---
layout: default
title: Method String replace(), replaceFirst() & replaceAll() trong Java với ví dụ.
description: Method String replace(), replaceFirst() & replaceAll() trong Java với ví dụ.
---

String trong Java có 3 loại method replace()
1. replace
2. replaceAll
3. replaceFirst

Với sự trợ giúp của 3 method này, bạn có thể thay thế các ký tự trong chuỗi của bạn. Hãy tìm hiểu từng chi tiết từng method:

# 1. Method replace() trong Java String
Method này trả về một chuỗi mới kết quả từ việc thay thế mọi xuất hiện của ký tự với một ký tự mới.

## Cú pháp:
```java
public Str replace(char oldC, char newC)
```
## Parameters:
```java
oldCh − Ký tự gốc.
newCh − Ký tự sẽ thay thế.
```

## Return Value:
```java
Chức năng này trả về một chuỗi được thay thế oldCh bằng newCh.
```

## Ví dụ:
```java
public class Guru99Ex1 {
    public static void main(String args[]) {
        String S1 = new String("the quick fox jumped");
        System.out.println("Original String is ': " + S1);
        System.out.println("String after replacing 'fox' with 'dog': " + S1.replace("fox", "dog"));
        System.out.println("String after replacing all 't' with 'a': " + S1.replace('t', 'a'));

    }
}
```

## Kết quả:
```java
Original String is ': the quick fox jumped
String after replacing 'fox' with 'dog': the quick dog jumped
String after replacing all 't' with 'a': ahe quick fox jumped
```

# 2. Method replaceAll() trong Java String
Method Java String replaceAll() trả về một chuỗi thay thế tất cả các chuỗi ký tự khớp với biểu thức tìm kiếm bằng một chuỗi thay thế.

## Cú pháp:
```java
public Str replaceAll(String regex, String replacement)  
```
## Parameters:
```java
regx: Biểu thức tìm kiếm
replacement: Chuỗi các ký tự sẽ thay thế
```

## Return Value:
```java
Chức năng này trả về một chuỗi được thay thế các chuỗi khớp với biểu thức tìm kiếm bằng replacement.
```

## Ví dụ:
```java
public class Guru99Ex2 {
    public static void main(String args[]) {
        String str = "Guru99 is a site providing free tutorials";
        //remove white spaces
		// \\s is regular expression to find white spaces
        String str2 = str.replaceAll("\\s", "");
        System.out.println(str2);
    }
}
```

## Kết quả:
```java
Guru99isasiteprovidingfreetutorials
```

# 3. Method replaceFirst() trong Java String
Method thay thế chuỗi con đầu tiên của chuỗi nếu khớp với biểu thức tìm kiếm.

## Cú pháp:
```java
public Str replaceFirst(String rgex, String replacement)
```
## Parameters:
```java
rgex − Biểu thức tìm kiếm
replacement − Chuỗi thay thế cho kết quả của biểu thức tìm kiếm
```

## Return Value:
```java
Method này trả về một chuỗi kết quả đã được thay thế.
```

## Ví dụ:
```java
public class Guru99Ex2 {
    public static void main(String args[]) {
        String str = "This website providing free tutorials";
        //Only Replace first 's' with '9' 
        String str1 = str.replaceFirst("s", "9");
        System.out.println(str1);
    }
}
```

## Kết quả:
```java
Thi9 website providing free tutorials
```
Chỉ có một ký tự **s** đầu tiên được thay thế.


[Back](./)
