---
layout: default
title: Hashmap trong Java
description: Hashmap trong Java
---

# Hashmap là gì 
Một Hashmap cơ bản được chỉ định một **key duy nhất** với **giá trị tương ứng** mà có thể truy cập ở bất cứ điểm nào.

![Hashmap trong Java](./images/hashmap-java-1.png)

# Tính năng của Java Hashmap
1. Giá trị có thể được lưu trong Map bằng cách tạo ra một cặp **key-value**. Giá trị có thể được truy cập bằng cách dùng **key** như là tham số truyền vào với một method đúng.
2. Nếu không tồn tại phần từ trong Map, nó sẽ throw ra một lỗi **NoSuchElementException**
3. Haskmap chỉ lưu trữ **đối tượng tham chiếu**. Đó là lý do vì sao nó không thể sử dụng các **kiểu dữ liệu nguyên thủy** như **int** hay **double**. Sử dung wrapper class **Integer** hay **Double** để thay thế.

![Hashmap trong Java](./images/hashmap-java-2.png)

# Sử dụng Hashmap trong chương trình Java
Có 2 cách để khai báo 1 Hashmap:
## Cú pháp:
```java
// Cách 1
HashMap<String. Object> map = new HashMap<String, Object>();
// Cách 2
HashMap x = new HashMap();
```

## Các method quan trọng.
- **get(Object KEY)**: Cái này sẽ trả về giá trị được liên kết với **key** được chỉ định trong Java Hashmap.
- **put(Object KEY, String VALUE)**: Method này lưu trữ một **giá trị** chỉ định và một liên kết nó với một **key** chỉ định trong Hashmap. Vì thế, trong Hashmap, chỉ có lưu tham chiếu đến **giá trị** chứ không lưu giá trị thực tế.

# Ví dụ về Java Hasmap
## Mã code:
```java
import java.util.HashMap;
import java.util.Map;
public class Sample_TestMaps{
  public static void main(String[] args){
    Map<String, String> objMap = new HashMap<String, String>();
    objMap.put("Name", "Suzuki");
    objMap.put("Power", "220");
    objMap.put("Type", "2-wheeler");
    objMap.put("Price", "85000");
    System.out.println("Elements of the Map:");
    System.out.println(objMap);
  }
}
```

## Kết quả:
```java
Elements of the Map:
{Type=2-wheeler, Price=85000, Power=220, Name=Suzuki}
```

# Ví dụ xóa một giá trị trong Hashmap với một key chỉ định
## Mã code:
```java
import java.util.*;  
public class HashMapExample {  
   public static void main(String args[]) {  
   // create and populate hash map  
   HashMap<Integer, String> map = new HashMap<Integer, String>();           
   map.put(1,"Java");  
   map.put(2, "Python");  
   map.put(3, "PHP");  
   map.put(4, "SQL");
   map.put(5, "C++");
   System.out.println("Tutorial in Guru99: "+ map);    
   // Remove value of key 5  
   map.remove(5);  
   System.out.println("Tutorial in Guru99 After Remove: "+ map);
   }
}
```

## Kết quả:
```java
Tutorial in Guru99: {1=Java, 2=Python, 3=PHP, 4=SQL, 5=C++}
Tutorial in Guru99 After Remove: {1=Java, 2=Python, 3=PHP, 4=SQL}
```

# Chúng ta sẽ hỏi thêm Hashmap nên một vài câu hỏi để hiểu thêm về nó:
**Câu hỏi cho Hashmap: Làm thế nào tôi có thể tìm kiếm nếu một key cụ thể đã được gán cho bạn ?**

Hashmap trả lời: Rất tuyệt, bạn có thể dùng method **containsKey(Object KEY)** với tôi, nó sẽ trả về một giá trị Boolen nếu tôi có một giá trị cho **key** đã nhận.

**Câu hỏi: Làm thế nào tôi tìm tất cả các key hợp lệ đã tồn tại trong Map ?**

Trả lời: Tôi có một method được gọi là **keySet()**, nó sẽ trả về tất cả các **key** trong map. 
Trong ví dụ 1 ở trên, nếu bạn viết một dòng code như:

**System.out.println(objMap.keySet());**

Nó sẽ trả về kết quả như là:

[Name, Type, Power, Price]

Tương tự, nếu bạn chỉ cần tất cả các giá trị trong Map, tôi có một mehod **values()**.

**System.out.println(objMap.values());**

Nó sẽ trả về một kết quả:

[Suzuki, 2-wheeler, 220, 85000]

**Câu hỏi: Giả sử, tôi chỉ cần xóa một **key** cụ thể trong Map, tôi cáo cần xóa toàn bộ Map không ?**

Trả lời: Không, tôi có một method là **remove(Object KEY)** mà sẽ chỉ xóa cặp **key-value** cụ thể nào đó.

**Câu hỏi: Làm thế nào chúng tôi có thể kiểm tra xem bạn có thực sự chứa một số cặp key-value nào không ?**

Trả lời: Chỉ cần kiểm tra tôi có trống hay không thôi ! Nói ngắn gọn, sử dụng method **isEmpty()** đối với tôi. :)

[Back](./)
