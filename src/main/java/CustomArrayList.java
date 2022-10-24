import java.util.*;

public class CustomArrayList<E> implements List<E> {
  private E[] array;

  @Override
  public int size() {
    return array.length;
  }

  @Override
  public boolean isEmpty() {
    return array.length == 0;
  }

  @Override
  public boolean contains(Object o) {
    return this.indexOf(o) > -1;
  }

  @Override
  public Iterator iterator() {
    return new Iterator() {

      private int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex < array.length;
      }

      @Override
      public Object next() {
        return array[currentIndex++];
      }
    };
  }

  @Override
  public Object[] toArray() {
    E[] result = (E[]) new Object[array.length];
    System.arraycopy(array, 0, result, 0, array.length);
    return result;
  }

  @Override
  public boolean add(E e) {
    try {
      E[] temp = array;
      array = (E[]) new Object[temp.length + 1];
      System.arraycopy(temp, 0, array, 0, temp.length);
      array[array.length - 1] = (E) e;
      return true;
    } catch (ClassCastException ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean remove(Object o) {
    if (this.contains(o)) {
      int index = this.indexOf(o);
      E[] temp = array;
      int amountElementAfterIndex = temp.length - index - 1;
      array = (E[]) new Object[array.length - 1];
      System.arraycopy(temp, 0, array, 0, index);
      System.arraycopy(temp, index + 1, array, index, amountElementAfterIndex);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean addAll(Collection c) {
    E[] temp = array;
    Object[] secondArray = c.toArray();
    array = (E[]) new Object[temp.length + secondArray.length];
    System.arraycopy(temp, 0, array, 0, temp.length);
    System.arraycopy(secondArray, 0, array, temp.length, secondArray.length);
    return true;
  }

  @Override
  public boolean addAll(int index, Collection c) {
    if (index >= array.length) {
      throw new IndexOutOfBoundsException();
    }
    E[] temp = array;
    Object[] secondArray = c.toArray();
    array = (E[]) new Object[temp.length + secondArray.length];
    System.arraycopy(temp, 0, array, 0, index);
    System.arraycopy(secondArray, 0, array, index, secondArray.length);
    System.arraycopy(temp, index, array, index + secondArray.length, temp.length - index);
    return true;
  }

  @Override
  public void clear() {
    array = (E[]) new Object[0];
  }

  @Override
  public E get(int index) {
    return array[index];
  }

  @Override
  public Object set(int index, Object element) {
    if (index < array.length) {
      E baseElement = this.get(index);
      array[index] = (E) element;
      return baseElement;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public void add(int index, Object element) {
    if (index < array.length) {
      E[] temp = array;
      array = (E[]) new Object[temp.length + 1];
      System.arraycopy(temp, 0, array, 0, index);
      array[index] = (E) element;
      System.arraycopy(temp, index, array, index + 1, temp.length - index);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public E remove(int index) {
    if (index < array.length) {
      E element = array[index];
      this.remove(element);
      return element;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public int indexOf(Object o) {
    if (o == null) {
      for (int i = 0; i < array.length; i++) {
        if (array[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < array.length; i++) {
        if (o.equals(array[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    int index = -1;
    if (o == null) {
      for (int i = 0; i < array.length; i++) {
        if (array[i] == null) {
          index = i;
        }
      }
    } else {
      for (int i = 0; i < array.length; i++) {
        if (o.equals(array[i])) {
          index = i;
        }
      }
    }
    return index;
  }

  @Override
  public ListIterator listIterator() {
    return new ListIterator() {
      private int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex < array.length;
      }

      @Override
      public Object next() {
        return array[currentIndex++];
      }

      @Override
      public boolean hasPrevious() {
        return currentIndex > 0;
      }

      @Override
      public Object previous() {
        return array[currentIndex--];
      }

      @Override
      public int nextIndex() {
        if (this.hasNext()) {
          return currentIndex + 1;
        } else {
          return array.length;
        }
      }

      @Override
      public int previousIndex() {
        if (this.hasPrevious()) {
          return currentIndex - 1;
        } else {
          return -1;
        }
      }

      @Override
      public void remove() {

      }

      @Override
      public void set(Object o) {

      }

      @Override
      public void add(Object o) {

      }
    };
  }

  @Override
  public ListIterator listIterator(int index) {
    return null;
  }

  @Override
  public CustomArrayList subList(int fromIndex, int toIndex) {
    if (toIndex >= array.length) {
      throw new IndexOutOfBoundsException();
    }
    E[] temp = array;
    this.clear();
    this.addAll(Arrays.asList(temp).subList(fromIndex, toIndex + 1));
    return this;
  }

  @Override
  public boolean retainAll(Collection c) {
    Object[] secondArray = c.toArray();
    var count = array.length;
    boolean result = false;
    boolean flag = false;
    for (int i = 0; i < count; i++) {
      for (Object o : secondArray) {
        if (array[i] == o) {
          result = true;
        }
      }
      if (!result) {
        this.remove(i);
        i -= 1;
        count -= 1;
        flag = true;
      } else {
        result = false;
      }
    }
    return flag;
  }

  @Override
  public boolean removeAll(Collection c) {
    Object[] secondArray = c.toArray();
    boolean result = false;
    for (Object o : secondArray) {
      for (int j = 0; j < array.length; j++) {
        if (o == array[j]) {
          this.remove(j);
          result = true;
        }
      }
    }
    return result;
  }

  @Override
  public boolean containsAll(Collection c) {
    var secondArray = c.toArray();
    var result = false;
    var flag = false;
    for (Object o : secondArray) {
      for (E e : array) {
        if (o.equals(e)) {
          result = true;
        }
      }
      if (result) {
        result = false;
        flag = true;
      } else {
        flag = false;
        break;
      }
    }
    return flag;
  }

  @Override
  public Object[] toArray(Object[] a) {
    return array;
  }

  public CustomArrayList() {
    array = (E[]) new Object[0];
  }

  public CustomArrayList(int size) {
    array = (E[]) new Object[size];
  }
}
