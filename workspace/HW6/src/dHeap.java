

import java.util.*;


public class dHeap <T extends Comparable <? super T>> implements dHeapInterface<T> {
	int size, d, heapSize;
	T[] heapArr;
	
			
	//The constructor  takes one argument: an initial capacity
	//Used when binary heap is needed.
	public dHeap (int heapSize)
    {
		this.heapSize = heapSize;
		size = 0;
		d = 2;
		heapArr = (T[]) new Comparable[heapSize];
			
	}

	//The constructor takes two arguments: an initial capacity
	//and the number of children, d
	//if d is less than one, throw IllegalArgumentException();
	public dHeap (int d, int heapSize) {
		if(d < 1){
			throw new IllegalArgumentException();
		}
		this.d = d;
		this.heapSize = heapSize;
		size = 0;
		heapArr = (T[])new Comparable[heapSize];
	}

	public int size () {  
		return size;
	}
	
	public void add (T data) {
		if(data == null){
			throw new NullPointerException();
			
		}
		if(size == heapSize){
			resize();
			
		}
		int currentV = size;
		int parentV = getParent(currentV);
		while(currentV != 0 && data.compareTo(heapArr[parentV]) < 0){
			heapArr[currentV] = heapArr[parentV];
			currentV = parentV;
			parentV = getParent(currentV);
			
			
		}
		heapArr[currentV] = data;
		size++;
	}

		
	public T removeSmallest() {
		if(size == 0){
			
			throw new NoSuchElementException();
		}
		T theSmallest = heapArr[0];
		heapArr[0] = heapArr[size - 1];
		int theSwap = down(0);
		T theSwapV = heapArr[theSwap];
		heapArr[theSwap] = heapArr[0];
		heapArr[0] = theSwapV;
		size--;
		return theSmallest;
		
	}
	private int getParent(int val){
		return(val -  1)/d;
	}
	
	private int down(int indx){
		int down = indx;
		for(int i = 1;i < size; i++){
	    if(((Comparable)heapArr[down]).compareTo((Comparable)heapArr[i])> 0){
				down = i;
				
			}
	
		}
		return down;
	}
	private void resize(){
		T[]heapArr2 = (T[]) new Comparable[heapSize*2];
		for(int i = 0 ; i < heapSize; i++){
			heapArr2[i] = heapArr[i];
			
		}
		heapSize = heapSize*2;
		heapArr = heapArr2;
		
	}

}
