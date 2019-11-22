---
layout: default
title: Arrays trong Java
description: Arrays trong Java
---

# Array là gì 
Mảng là một kiểu cấu trúc dữ liệu rất phổ biến trong đó tất cả các phần tử cần có kiểu dữ liệu giống nhau. Một khi đã được khai báo, kích thước của một mảng là cố định và không thể tăng để chứa thêm phần tử. Phần tử đầu tiên của mảng bắt đầu từ chỉ số 0.

Nói một cách đơn giản, nó là một cấu trúc lập trình để thay thế:
```java
x0=0;
x1=1;
x2=2;
x3=3;
x4=4;
x5=5;
```
Bằng:
```java
x[0]=0;
x[1]=1;
x[2]=2;
x[3]=3;
x[4]=4;
x[5]=5;
```
Điều làm cho mảng trở nên có ích ở đây là một biến có thể tham chiếu đến một chỉ số(số trong ngoặc []) của mảng để dễ dàng thực hiện vòng lặp.
```java
    for(count=0; count<5; count++) {
        System.out.println(x[count]);
    }
```

# Biến Array
Để sử dụng 1 mảng trong chương trình, thì cần 3 bước:
1. Khai báo mảng
2. Xây dựng mảng
3. Khởi tạo mảng

## Khai báo mảng
### Cú pháp:
```java
<elementType>[] <arrayName>;
```
hoặc
```java
<elementType> <arrayName>[];
```
### Ví dụ:
```java
int intArray[];
 // Defines that intArray is an ARRAY variable which will store integer values
int[] intArray;
```

## Xây dựng mảng
### Cú pháp:
```java
arrayname = new dataType[]
```
### Ví dụ:
```java
intArray = new int[10]; // Defines that intArray will store 10 integer values
```

### Kết hợp giữa khai báo và xây dựng mảng
```java
int intArray[] = new int[10];
```

## Khởi tạo mảng
```java
intArray[0]=1; // Assigns an integer value 1 to the first element 0 of the array
intArray[1]=2; // Assigns an integer value 2 to the second element 1 of the array
```

### Kết hợp giữa khai báo và khởi tạo mảng
### Cú pháp:
```java
[]  = {};
```
### Ví dụ:
```java
 int intArray[] = {1, 2, 3, 4};
// Initilializes an integer array of length 4 where the first element is 1 , second element is 2 and so on.
```

# Tạo chương trình FirstArray
**Bước 1**: Viết đoạn mã như dưới đây
```java
class ArrayDemo{
    public static void main(String args[]) {
        int array[] = new int[7];
        for (int count=0;count<7;count++){
           array[count]=count+1;
        }
        for (int count=0;count<7;count++){
           System.out.println("array["+count+"] = "+array[count]);
        }
         //System.out.println("Length of Array  =  "+array.length);
         // array[8] =10; => Error
    }
}
```
**Bước 2**: Lưu lại và thực thi đoạn mã. Kết quả sẽ là:
```java
array[0] = 1
array[1] = 2
array[2] = 3
array[3] = 4
array[4] = 5
array[5] = 6
array[6] = 7
```

**Bước 3**: Nếu **x** là một tham chiếu đến một mảng, **x.length** sẽ trả về cho bạn độ dài của mảng.

Bỏ comment ở đoạn mã bên dưới và chạy lại chương trình.
```java
System.out.println("Length of Array  =  "+array.length);
```
Kết quả:
```java
Length of Array  =  7
```

**Bước 4**: Không giống như C, Java kiểm tra ranh giới của một mảng trong khi truy cập một phần tử bên trong nó. Java sẽ không cho phép truy cập ngoài ranh giới của nó.

Bỏ comment ở đoạn mã bên dưới và chạy lại chương trình.
```java
array[8] =10;   
```
Kết quả:
```java
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 8
        at ArrayDemo.main(ArrayDemo.java:11)
Command exited with non-zero status 1
```

**Bước 5**: Lỗi ArrayIndexOutOfBoundsException đã được ném ra. Trong trường hợp là C, thì đoạn mã trên sẽ có một giá trị rác.

# Truyền tham số bởi tham chiếu
Mảng trong Java được truyền đến các function thông qua tham chiếu, hoặc là một con trỏ để phiên bản gốc. Có nghĩa là bất cứ điều gì bạn thực hiện với mảng ở bên trong function đều ảnh hưởng đến phiên bản gốc.

## Ví dụ: Để hiểu Mảng được truyền thông qua tham chiếu
**Bước 1**: Viết đoạn mã như dưới đây:
```java
class ArrayDemo {
   public static void passByReference(String a[]){
     a[0] = "Changed";
   }
 
   public static void main(String args[]){
      String []b={"Apple","Mango","Orange"};
      System.out.println("Before Function Call    "+b[0]);
      ArrayDemo.passByReference(b);
      System.out.println("After Function Call    "+b[0]);
   }
}
```
**Bước 2**: Lưu và thực thi chương trình. Kết quả:
```java
Before Function Call    Apple
After Function Call    Changed
```

# Mảng đa chiều trong Java
Mảng đa chiều thực tế là mảng của mảng

Để khai báo một biến mảng đa chiều, chỉ định bổ sung chỉ số được sử dụng các tập hợp khác nhau trong cặp dấu ngoặc []
### Cú pháp:
```java
Ex: int twoD[ ][ ] = new int[4][5] ;
```
Trong khi bạn chỉ định bộ nhớ cho một mảng đa chiều, bạn chỉ cần chỉ định bộ nhớ cho kích thước mảng đầu tiên.

Bạn có thể phân bổ các kích thước còn lại một cách riêng biệt.

Trong Java, độ dài của mỗi mảng trong một mảng đa chiều nằm dưới sự kiểm soát của bạn.

### Ví dụ:
```java
public class Guru99 {
public static void main(String[] args) {

// Create 2-dimensional array.
  int[][] twoD = new int[4][4];

  // Assign three elements in it.
  twoD[0][0] = 1;
  twoD[1][1] = 2;
  twoD[3][2] = 3;
  System.out.print(twoD[0][0] + " ");
}

}
```
### Kết quả:
```java
1
```

[Back](./)
