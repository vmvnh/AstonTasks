package arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void mergeSort() {
    int[] originalArr = new int[]{1, 3, 5, 8, 3, 5, 2, 5};
    int sizeArr = originalArr.length;
    MergeSort.mergeSort(originalArr, sizeArr);
    int[] expectedArr = new int[]{1, 2, 3, 3, 5, 5, 5, 8};
    Assertions.assertArrayEquals(originalArr, expectedArr);
  }

  @Test
  void merge() {
    int[] originalArr = new int[8];
    int[] leftArr = new int[]{1, 3, 5, 8};
    int[] rightArr = new int[]{2, 3, 5, 5};
    int leftArrLength = leftArr.length;
    int rightArrLength = rightArr.length;
    MergeSort.merge(originalArr, leftArr, rightArr, leftArrLength, rightArrLength);
    int[] expectedArr = new int[]{1, 2, 3, 3, 5, 5, 5, 8};
    Assertions.assertArrayEquals(originalArr, expectedArr);
  }
}