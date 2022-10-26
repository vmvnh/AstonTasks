package arraylist;

import org.junit.jupiter.api.*;

class CustomArrayListTest {
  CustomArrayList<String> arr = new CustomArrayList<>(5);
  CustomArrayList<String> emptyArr = new CustomArrayList<>();
  CustomArrayList<String> auxiliaryArr = new CustomArrayList<>();

  @Test
  void sizeCompletedCollection() {
    // Тестовые данные
    var result = arr.size();

    // Ожидаемый результат
    var expectedResult = 5;

    // Проверка
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void sizeZeroCollection() {
    var result = emptyArr.size();
    var expectedResult = 0;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void isEmptyTrue() {
    var result = emptyArr.isEmpty();
    var expectedResult = true;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void isEmptyFalse() {
    var result = arr.isEmpty();
    var expectedResult = false;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void ifElementContains() {
    arr.add("One");
    arr.add("Two");
    arr.add("Three");
    var result = arr.contains("Two");
    var expectedResult = true;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void ifElementNotContains() {
    arr.add("One");
    arr.add("Two");
    arr.add("Three");
    var result = arr.contains("Four");
    var expectedResult = false;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void iteratorIsExistsNextElement() {
    var result = arr.iterator().hasNext();
    var expectedResultHasNext = true;
    Assertions.assertEquals(result, expectedResultHasNext);
  }

  @Test
  void iteratorIsNotExistsNextElement() {
    var result = emptyArr.iterator().hasNext();
    var expectedResultHasNext = false;
    Assertions.assertEquals(result, expectedResultHasNext);
  }

  @Test
  void toArray() {
    var result = arr.toArray();
    var expectedResult = new Object[5];
    Assertions.assertArrayEquals(result, expectedResult);
  }

  @Test
  void emptyArrayToArray() {
    var result = emptyArr.toArray();
    var expectedResult = new Object[0];
    Assertions.assertArrayEquals(result, expectedResult);
  }

  @Test
  void add() {
    emptyArr.add("One");
    var result = emptyArr.get(0);
    var expectedResult = "One";
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void removeViaObject() {
    emptyArr.add("One");
    emptyArr.remove("One");
    var result = emptyArr.size();
    var expectedResult = 0;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void addAll() {
    CustomArrayList<String> secondArr = new CustomArrayList<>();
    secondArr.add("One");
    secondArr.add("Two");
    emptyArr.addAll(secondArr);

    var result = emptyArr.size();
    var expectedResult = 2;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void testAddAllFromIndex() {
    CustomArrayList<String> secondArr = new CustomArrayList<>();
    secondArr.add("One");
    secondArr.add("Two");
    arr.addAll(3, secondArr);

    var result = arr.get(3);
    var expectedResult = "One";
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void testAddAllBigIndex() {
    CustomArrayList<String> secondArr = new CustomArrayList<>();
    secondArr.add("One");
    secondArr.add("Two");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      arr.addAll(6, secondArr);
    });
  }

  @Test
  void clear() {
    arr.clear();
    var result = arr.size();
    var expectedResult = 0;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void get() {
    emptyArr.add("One");
    var result = emptyArr.get(0);
    var expectedResult = "One";
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void set() {
    emptyArr.add("One");
    emptyArr.set(0, "Two");
    var result = emptyArr.get(0);
    var expectedResult = "Two";
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void testAddForIndex() {
    arr.add(2, "One");
    var result = arr.get(2);
    var expectedResult = "One";
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void removeViaIndex() {
    arr.remove(0);
    var result = arr.size();
    var expectedResult = 4;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void indexOf() {
    emptyArr.add("One");
    var result = emptyArr.indexOf("One");
    var expectedResult = 0;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void indexOfValueNull() {
    emptyArr.add(null);
    var result = emptyArr.indexOf(null);
    var expectedResult = 0;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void lastIndexOf() {
    emptyArr.add("One");
    emptyArr.add("Two");
    emptyArr.add("One");

    var result = emptyArr.lastIndexOf("One");
    var expectedResult = 2;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void listIterator() {
  }

  @Test
  void testListIterator() {
  }

  @Test
  void subList() {
    auxiliaryArr.add("One");
    auxiliaryArr.add("Two");
    auxiliaryArr.add("Three");
    auxiliaryArr.add("Four");
    auxiliaryArr.add("Five");

    var result = auxiliaryArr.subList(1,3).toArray();
    var expectedResult = new Object[]{"Two", "Three", "Four"};
    Assertions.assertArrayEquals(result, expectedResult);
  }

  @Test
  void subListBigIndex() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      var result = auxiliaryArr.subList(1,5).get(0);
    });
  }

  @Test
  void retainAll() {
    auxiliaryArr.add("One");
    auxiliaryArr.add("Two");
    auxiliaryArr.add("Three");
    auxiliaryArr.add("Four");
    auxiliaryArr.add("Five");

    emptyArr.add("Three");
    emptyArr.add("Four");

    auxiliaryArr.retainAll(emptyArr);
    var result = auxiliaryArr.toArray();
    var expectedResult = new Object[]{"Three", "Four"};
    Assertions.assertArrayEquals(result, expectedResult);
  }

  @Test
  void removeAll() {
    auxiliaryArr.add("One");
    auxiliaryArr.add("Two");
    auxiliaryArr.add("Three");
    auxiliaryArr.add("Four");
    auxiliaryArr.add("Five");

    emptyArr.add("Three");
    emptyArr.add("Four");

    auxiliaryArr.removeAll(emptyArr);
    var result = auxiliaryArr.toArray();
    var expectedResult = new Object[]{"One", "Two", "Five"};
    Assertions.assertArrayEquals(result, expectedResult);
  }

  @Test
  void containsAllTrue() {
    auxiliaryArr.add("One");
    auxiliaryArr.add("Two");
    auxiliaryArr.add("Three");
    auxiliaryArr.add("Four");
    auxiliaryArr.add("Five");

    emptyArr.add("Three");
    emptyArr.add("Four");


    var result = auxiliaryArr.containsAll(emptyArr);
    var expectedResult = true;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void containsAllFalse() {
    auxiliaryArr.add("One");
    auxiliaryArr.add("Two");
    auxiliaryArr.add("Three");
    auxiliaryArr.add("Four");
    auxiliaryArr.add("Five");

    emptyArr.add("Three");
    emptyArr.add("Four");
    emptyArr.add("Six");


    var result = auxiliaryArr.containsAll(emptyArr);
    var expectedResult = false;
    Assertions.assertEquals(result, expectedResult);
  }

  @Test
  void testToArray() {
    var result = arr.toArray();
    var expectedResult = new Object[5];
    Assertions.assertArrayEquals(result, expectedResult);
  }
}
