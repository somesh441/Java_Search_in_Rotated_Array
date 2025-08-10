public class Rotated_Bs_LC_33{
    public static void main(String[] args) {
    int[] arr = {4,5,6,7,1,2,3};
    int target = 2;
    System.out.println(search(arr,target));
    }
    static int search(int[] arr,int target){
        int pivot = findPivot(arr);

        if(pivot==-1){
//            just do normal BS;
            return binarySearch(arr,target,0,arr.length-1);
        }
        if(arr[pivot]==target){
            return pivot;
        }
        if(arr[0]>target){
            return binarySearch(arr,target,pivot+1,arr.length-1);
        }else{
            return binarySearch(arr,target,0,pivot-1);
        }

        //if pivot if find,then 2 asc arrays are found
    }
//pivot:largest element in the array
    
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] >= arr[start]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr,int target,int start,int end){
        while(start<=end){
            int mid = (start + end)/2;
            if(arr[mid]>target){
                end = mid-1;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
