/**
 * Name: Jialin Chen
 * ID: A16636887
 * Email: jic053@ucsd.edu
 * Sources used: None
 * 
 * This file is MyArrayList class, which is my own implementations of 
 * the ArrayList class. 
 * It contains all the basic function for an ArrayList object.
 */

 /**
  * this class  implements various methods for MyArrayList which 
  * instantiates an empty list of data and records the corrsponging size
  */
@SuppressWarnings("unchecked")
class MyArrayList<E> implements MyList<E>{
    Object[] data;
    int size;

    /** 
     * constructor that initializes the array for no args
     */
    public MyArrayList(){
        this.data = (E[]) new Object[5];
    }

    /**
     * constructor that initializes the array with specific size
     */
    public MyArrayList(int initialCapacity){
        if(initialCapacity<0)  
            throw new IllegalArgumentException(); 
        else
            this.data = (E[]) new Object[initialCapacity];

    }

    /** 
     * constructor that initializes the array 
     * with specific elements and size
     */
    public MyArrayList(E[] arr){
        if (arr == null)  
            this.data = (E[]) new Object[5];
        else  {
            this.data = arr;
            this.size = arr.length;
        }

    }

    /** 
     * expand the capacity of an array
     * @param desired capacity
     */
    public void expandCapacity(int requiredCapacity){
        int currentCapacity = 0;
        if (requiredCapacity < this.getCapacity())  
            throw new IllegalArgumentException();
        else if (this.getCapacity() == 0) 
            currentCapacity = 5;
        // if desired capacity is smaller that current capacity time 2
        // double the current capacity
        else if (this.getCapacity()*2 > requiredCapacity)  
            currentCapacity = this.getCapacity()*2;
        else 
            currentCapacity = requiredCapacity;
        
        // create a new array with expanded capacity
        // and copy the original data to the new array
        Object[] expandedArray = (E[]) new Object[currentCapacity];
            for(int i=0; i<this.getCapacity(); i++){
                expandedArray[i] = data[i]; 
            }
            this.data = expandedArray;
        
    }

    /**
     * @return current capacity
     */
    public int getCapacity(){
        return this.data.length;
    }

    /** insert an element at the desired index
     * and move every element after 1 index behind
     * @param index: desired insert location
     * @param element: inserted element
     */
    public void insert(int index, E element){
        if (index < 0 || index > this.size)  
            throw new IndexOutOfBoundsException();
        else {
            // increment the capacity if array is full
             if (this.size == this.getCapacity())  
                this.expandCapacity(this.getCapacity() + 1 );

            // copy the origial array after the inserted element
             for(int i=this.size; i>index; i--){
                 this.data[i] = this.data[i-1];
             }
             this.data[index] = element;
             this.size++;
        }
    }

    /** 
     * append an element at the end of the array
     * @param element: appended element
     */
    public void append(E element){
        // increment the capacity if array is full
        if (this.size == this.getCapacity())  
            this.expandCapacity(this.getCapacity() + 1);

        this.data[this.size] = element;
        this.size++;
    }

    /**
     * insert an element at the front of the array
     * @param element: element to be inserted
     */
    public void prepend(E element){
        if (this.size == this.getCapacity())  
            this.expandCapacity(this.getCapacity() + 1);
        for(int i=this.size; i>0; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[0] = element;
        this.size++;
    }

    /**
     * return a element at desired index
     * @param index: index for element
     * @return: desired element
     */
    public E get(int index){
        if (index < 0 || index >= this.size)  
            throw new IndexOutOfBoundsException();
        return (E) this.data[index];
    }

     /**
     * change the value of an element to a new value
     * @param index: location of replacement
     * @param element: new value to replace with
     * @return: replaced value
     */
    public E set(int index, E element){
        if (index < 0 || index >= this.size)  
            throw new IndexOutOfBoundsException();
        E overwrittenElement = (E) this.data[index];
        this.data[index] = element;
        return overwrittenElement;
    }

    /**
     * remove the value at desired index and move everything
     * afterwards back by one index
     * @param index: location of removal
     * @return: removed value
     */
    public E remove(int index){
        if (index < 0 || index >= this.size)  
            throw new IndexOutOfBoundsException();
        E removedElement = (E) this.data[index];
        for(int i=index; i<this.size-1; i++){
            this.data[i] = this.data[i+1];
        }
        this.data[this.size-1] = null;
        this.size--;
        return removedElement;
    }

    /**
     * returns the current size
     * @return current size
     */
    public int size(){
        return this.size;
    }
}

