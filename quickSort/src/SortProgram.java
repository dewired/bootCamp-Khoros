public class SortProgram {

    private static int input[]={12,10,2,34,22,45,11,23};

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

    public static void main(String[] args) {
        quicksort(0,input.length-1);
        for(int i=0;i<input.length;i++)
            System.out.println(input[i] + " ");
    }
}