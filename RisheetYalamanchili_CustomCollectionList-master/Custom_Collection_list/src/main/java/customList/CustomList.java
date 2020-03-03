package customList;

import java.util.Arrays;

public class CustomList<CL> {
    private int size = 0;

    //Default capacity of list is 20
    private static final int DEFAULT_CAPACITY =20;

    //This array will store  elements 
    private Object ele[];
    public CustomList() {
        ele = new Object[DEFAULT_CAPACITY];
    }


    public void add(CL e) {
        if (size == ele.length) {
            ensureCapacity();
        }
        ele[size++] = e;
    }

    private void ensureCapacity() {
        int newSize = ele.length * 2;
        ele = Arrays.copyOf(ele, newSize);
    }

    public CL get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (CL) ele[i];
    }

    public CL remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = ele[i];
        int noOfEle = ele.length - ( i + 1 ) ;
        System.arraycopy( ele, i + 1, ele, i, noOfEle ) ;
        size--;
        return (CL) item;
    }

    public int size() {
        return size;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(ele[i].toString());
            if(i<size-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }


}
