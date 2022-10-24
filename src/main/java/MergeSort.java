public class MergeSort {
  public static void mergeSort(int[] array, int size) {
    if (size < 2) return;

    int mid = size / 2;
    int[] left = new int[mid];
    int[] right = new int[size - mid];

    System.arraycopy(array, 0, left, 0, mid);
    System.arraycopy(array, mid, right, 0, size - mid);

    mergeSort(left, mid);
    mergeSort(right, size - mid);

    merge(array, left, right, mid, size - mid);
  }

  public static void merge(int[] array, int[] left, int[] right, int leftLength, int rightLength) {
    int k = 0, i = 0, j = 0;

    while (i < leftLength && j < rightLength) {
      if (left[i] <= right[j]) array[k++] = left[i++];
      else array[k++] = right[j++];
    }

    while (i < leftLength) {
      array[k++] = left[i++];
    }

    while (j < rightLength) {
      array[k++] = right[j++];
    }
  }
}
