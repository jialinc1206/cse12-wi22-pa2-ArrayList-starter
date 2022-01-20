/**
 * Name: Jialin Chen
 * ID: A16636887
 * Email: jic053@ucsd.edu
 * Sources used: None
 * 
 * This file is MyArrayList class
 */

@SuppressWarnings("unchecked")
class MyArrayList<E> implements MyList<E>{
    Object[] data;
    int size;

    public MyArrayList(){
        this.data = (E[]) new Object[5];
    }

    public MyArrayList(int initialCapacity){
        if( initialCapacity<0)  throw new IllegalArgumentException(); 
        else  {
            this.data = (E[]) new Object[initialCapacity];
        }

    }

    public MyArrayList(E[] arr){
        if (arr == null)  this.data = (E[]) new Object[5];
        else  {
            this.data = arr;
            this.size = arr.length;
        }

    }

    public void expandCapacity(int requiredCapacity){
        int currentCapacity = 0;
        if (requiredCapacity < this.getCapacity())  throw new IllegalArgumentException();
        else if (this.getCapacity() == 0) currentCapacity = 5;
        else if (this.getCapacity()*2 > requiredCapacity)  currentCapacity = this.getCapacity()*2;
        else currentCapacity = requiredCapacity;
        
        Object[] expandedArray = (E[]) new Object[currentCapacity];
            for(int i=0; i<this.getCapacity(); i++){
                expandedArray[i] = data[i]; 
            }
            this.data = expandedArray;
        
    }

    public int getCapacity(){
        return this.data.length;
    }

    public void insert(int index, E element){
        if (index < 0 || index > this.size)  throw new IndexOutOfBoundsException();
        else {
             if (this.size == this.getCapacity())  this.expandCapacity(this.getCapacity() + 1 );
             for(int i=this.size; i>index; i--){
                 this.data[i] = this.data[i-1];
             }
             this.data[index] = element;
             this.size++;
        }
    }

    public void append(E element){
        if (this.size == this.getCapacity())  this.expandCapacity(this.getCapacity() + 1);
        this.data[this.size] = element;
        this.size++;
    }

    public void prepend(E element){
        if (this.size == this.getCapacity())  this.expandCapacity(this.getCapacity() + 1);
        for(int i=this.size; i>0; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[0] = element;
        this.size++;
    }

    public E get(int index){
        if (index < 0 || index >= this.size)  throw new IndexOutOfBoundsException();
        return (E) this.data[index];
    }

    public E set(int index, E element){
        if (index < 0 || index >= this.size)  throw new IndexOutOfBoundsException();
        E overwrittenElement = (E) this.data[index];
        this.data[index] = element;
        return overwrittenElement;
    }

    public E remove(int index){
        if (index < 0 || index >= this.size)  throw new IndexOutOfBoundsException();
        E removedElement = (E) this.data[index];
        for(int i=index; i<this.size-1; i++){
            this.data[i] = this.data[i+1];
        }
        this.data[this.size-1] = null;
        this.size--;
        return removedElement;
    }

    public int size(){
        return this.size;
    }
}

