import java.util.*;
public class MyPriorityQueue<T extends Comparable <? super T>> {
	dHeap<T> thisHeap;
	T[] track;
	int iTrack;
	public MyPriorityQueue(int initialSize){
		thisHeap = new dHeap(initialSize);
		track = (T[])new Comparable[initialSize];
	}
	public boolean add(T data){
		if(data == null){
			throw new NullPointerException();
			
		}
		int counter = 0;
		if(iTrack != 0){
		for(int i = 0; i < thisHeap.size(); i++){
			if(track[i].compareTo(data) == 0){
				counter++;
			}
		} 
		}
		track[iTrack] = data;
		iTrack++;
		if(counter >= 1){return false;}
		else{
		thisHeap.add(data);
		return true;
		}
	}
	public T poll(){
		
		if(thisHeap.size() == 0){
			return null;
		}
		return thisHeap.removeSmallest();
	}

}
