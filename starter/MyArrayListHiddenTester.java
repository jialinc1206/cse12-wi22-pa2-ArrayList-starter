/**
 * Name: Jialin Chen
 * ID: A16636887
 * Email: jic053@ucsd.edu
 * Sources used: None
 * 
 * This is a test file that contains various unit tests for MyArrayList.java
 * It has implemented tests that check if MyArrayList.java could correctly
 * handle special cases.
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings("unchecked")
public class MyArrayListHiddenTester {

    static final int DEFAULT_CAPACITY = 5;
    static final int MY_CAPACITY = 3;
    static final int INVALID_ARG = -1;

    Object[] arr = new Object[10];
    Integer[] arrInts = { 1, 2, 3 };
    Object[] NULL_ARG;

    private MyArrayList listInt;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        listInt = new MyArrayList<Integer>(arrInts);
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        int outPut = 0;
        try{
            MyArrayList test = new MyArrayList(INVALID_ARG);
        }
        catch(IllegalArgumentException e){
            outPut = -1;
        }
        assertEquals(-1, outPut);
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        MyArrayList list = new MyArrayList(NULL_ARG);

        assertEquals(0, list.size);
        assertEquals(5, list.getCapacity());
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        listInt.append(4);

        assertEquals(4, listInt.size);
        assertEquals(6, listInt.getCapacity());
        assertEquals(4, listInt.get(3));
        assertEquals(1, listInt.get(0));
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        listInt.prepend(null);

        assertEquals(4, listInt.size);
        assertEquals(6, listInt.getCapacity());
        assertEquals(null, listInt.get(0));
        assertEquals(3, listInt.get(3));
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
        int outPut1 = 0;
        int outPut2 = 0;
       try{
           listInt.insert(-1, 4);
       }
       catch(IndexOutOfBoundsException e){
            outPut1 = -10;
       }
       try{
        listInt.insert(4, 4);
       }
       catch(IndexOutOfBoundsException e){
            outPut2 = -11;
       }
       assertEquals(-10, outPut1);
       assertEquals(-11, outPut2);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for(int i = 0; i < 1000; i++){
            listInt.insert(1,i);
        }
        assertEquals(1003, listInt.size);
        assertEquals(1536, listInt.getCapacity());
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        int outPut1 = 0;
        int outPut2 = 0;
        try{
            listInt.get(-1);
        }
        catch(IndexOutOfBoundsException e){
            outPut1 = -10;
        }
        try{
            listInt.get(3);
        }
        catch(IndexOutOfBoundsException e){
            outPut2 = -11;
        }
        assertEquals(-10, outPut1);
        assertEquals(-11, outPut2);
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        int outPut1 = 0;
        int outPut2 = 0;
        try{
            listInt.set(-1,4);
        }
        catch(IndexOutOfBoundsException e){
            outPut1 = -10;
        }
        try{
            listInt.set(3,4);
        }
        catch(IndexOutOfBoundsException e){
            outPut2 = -11;
        }
        assertEquals(-10, outPut1);
        assertEquals(-11, outPut2);
    }


    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        int outPut1 = 0;
        int outPut2 = 0;
        try{
            listInt.remove(-1);
        }
        catch(IndexOutOfBoundsException e){
            outPut1 = -10;
        }
        try{
            listInt.remove(3);
        }
        catch(IndexOutOfBoundsException e){
            outPut2 = -11;
        }
        assertEquals(-10, outPut1);
        assertEquals(-11, outPut2);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        int outPut = 0;
        try{
            listInt.expandCapacity(2);
        }
        catch(IllegalArgumentException e){
            outPut = -1;
        }
        assertEquals(-1, outPut);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode(){
        listInt.expandCapacity(8);
        
        assertEquals(3, listInt.size);
        assertEquals(8, listInt.getCapacity());
        assertEquals(1, listInt.get(0));
    }

}
