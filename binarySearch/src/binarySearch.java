public class binarySearch{

    private static int input[]={12,10,2,34,22,45,11,23};
    //private static int n = 10;

    private static void swap (int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void quicksort( int lo, int hi){

        int mid = lo + (hi-lo)/2;

        int pivot = input[mid];

        int i = lo, j = hi;

        while ( i <= j ) {
            while ( input[i] < pivot ) {
                i++;
            }
            while ( input[j] > pivot ) {
                j--;
            }
            if ( i <= j ) {
                swap( i, j);
                i++;
                j--;
            }
            if ( lo < j )
                quicksort ( lo, j);
            if ( i < hi )
                quicksort ( i, hi);
        }
    }

    private static int binSearch(int n, int lo, int hi){

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (input[mid] == n)
                return mid;

            if (input[mid] < n)
                lo = mid + 1;

            else
                hi = mid - 1;

        }

        return -1;

    }

    private static void search(int n){

        quicksort(0,input.length-1);
        System.out.print("Sorted array is: ");
        for(int i=0;i<input.length;i++)
            System.out.print(input[i] + " ");
        System.out.println(" ");

        int found = binSearch(n, 0, input.length-1);

        if ( found == -1 )
            System.out.println("Element not found!");
        else
            System.out.println("Element found at " + found );

    }

    public static void main(String[] args) {

        //int n = 3;
        int n = 10;
        //quicksort(0,input.length-1);

        //for(int i=0;i<input.length;i++)
        //    System.out.println(input[i] + " ");

        search(n);

    }

}