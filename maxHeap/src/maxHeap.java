public class maxHeap{

    private int heap[];

    private int heapSize;

    public maxHeap(int size){

        heapSize = 0;

        heap = new int [ size + 1 ];

        for ( int i = 0; i < size; i++)
            heap[i] = -1;

    }

    private int parent( int pos ){

        return (pos-1)/2;

    }

    private void heapifyUp(int pos){

        int temp = heap[pos];

        while( pos > 0 && temp > heap[ parent(pos) ] ){

            heap[pos] = heap[parent(pos)];

            pos = parent(pos);

        }

        heap[pos] = temp;

    }

    public void insert(int n){

        if( heapSize == heap.length )
            return;

        heap[heapSize++] = n;

        heapifyUp(heapSize-1);

    }

    public void printHeap(){

        System.out.println("Heap is");

        for( int i = 0; i < heapSize; i++ ){
            System.out.print( heap[i] + " ");
        }

    }

    public static void main(String[] args) {

        maxHeap dsa = new maxHeap(10);

        dsa.insert(1);

        dsa.insert(2);

        dsa.insert(3);

        dsa.insert(4);

        dsa.insert(5);

        dsa.insert(6);

        dsa.insert(7);

        dsa.insert(8);

        dsa.printHeap();

    }
}