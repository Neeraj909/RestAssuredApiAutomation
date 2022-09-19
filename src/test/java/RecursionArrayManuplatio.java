public class RecursionArrayManuplatio {
    public static void main(String[] args) {
        int arr[] = {5, 3, 9, 1, 0, 7, 2, 6, 8, 4};
        int size = arr.length;
        recurArray(arr,size);
    }
    public static int recurArray(int arr[],int size) {

        size--;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int count=0;
        int arr1[] = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - min == 0) {
                continue;
            } else {
                arr1[count] = arr[i] - min;
                count++;
            }
        }
        if (size <= 0) {

        }
        else{
            recurArray(arr1,size);
        }

        return 0;
    }
}
