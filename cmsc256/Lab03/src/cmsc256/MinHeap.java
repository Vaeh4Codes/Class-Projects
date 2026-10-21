public class MinHeap <E extends Comparable<? super E>>{
    private E[] heap;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 8;

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity){
        if(capacity > 0){
            Object[] temp;   //create object array due to type
            temp = new Comparable[capacity];   //type erasure
            heap = (E[]) temp;   //cast to generic type
        } else{
            throw new IllegalArgumentException("Array size must be greater than 0.");
        }
    }

    public MinHeap(){
        this(DEFAULT_CAPACITY);
    }


    public int getSize() {
        return size;
    }

    public E[] getHeap() {
        return heap;
    }
}
