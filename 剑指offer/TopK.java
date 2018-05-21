public class TopK {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array ={2,4,6,2,3,4,9,6};
        TopK sol = new TopK();
        sol.findKthLargest(array,2);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    public void quickSort(int arr[], int left, int right) {
        if (left >= right) return;
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    // partition subarray a[left..right] so that a[left..j-1] >= a[j] >= a[j+1..right]
// and return index j
    private int partition(int arr[], int left, int right) {
        int i = left, j = right + 1, pivot = arr[left];
        while (true) {
            while (i < right && arr[++i] > pivot)
                if (i == right) break;
            while (j > left && arr[--j] < pivot)
                if (j == left) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, left, j);  // swap pivot and a[j]
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    // quick select to find the kth-largest element
    public int quickSelect(int[] arr, int k, int left, int right) {
        if (left == right) return arr[right];
        int index = partition(arr, left, right);
        if (index - left + 1 > k)
            return quickSelect(arr, k, left, index - 1);
        else if (index - left + 1 == k)
            return arr[index];
        else
            return quickSelect(arr, k - index + left - 1, index + 1, right);

    }
}