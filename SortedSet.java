/*  Student information for assignment:
 *
 *  On OUR honor, Steven Lee and Sarah Cervantes, this programming assignment is OUR own work
 *  and WE have not provided this code to any other student.
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID:SCL346
 *  email address: Steven.han.lee@gmail.com
 *  Grader name: Chris Word
 *  Section number: 91150
 *  
 *  Student 2 
  *  UTEID: SNC397
 *  email address: sncervantes22@gmail.com
 *  Grader name: Jacob Schrum
 *  Section number: 91150
 *  
 */

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * 
 * The data type for E must be a type that implements Comparable.
 * 
 * Students are to implement methods that were not implemented in AbstractSet 
 * and override methods that can be done more efficiently. An ArrayList must 
 * be used as the internal storage container. For methods involving two set, 
 * if that method can be done more efficiently if the other set is also a 
 * SortedSet do so.
 */
public class SortedSet <E extends Comparable<? super E>> extends AbstractSet<E> 
{

    private ArrayList<E> myCon;
    private int size;


    /**
     * create an empty SortedSet
     */
    public SortedSet() {
    	myCon = new ArrayList <E>();
    	size = 0;
    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null
     */
    // O(NlogN)
    public SortedSet(ISet<E> other) {
    	this();
    	assert (other != null) : "Violation of precondition: SortedSet(AbstractSet<E> other)";
    	Iterator<E> it = other.iterator();
    	while (it.hasNext()){
    		E temp = it.next();
    		myCon.add(temp);
    	}
    	quickSort(myCon, 0, myCon.size()-1);
    	size = myCon.size();

    }
    
    /**
     * sort the given ArrayList
     * @param unsorted
     * @return
     */
    public void quickSort (ArrayList<E> unsorted, int low, int high)
    {
    	  int lo = low;
    	  int hi = high;

    	  if (lo >= high) 
    	  {
    		  return;
    	  }
    	  
    	  E mid = unsorted.get((lo + hi) / 2);
    	  while (lo < hi) 
    	  {
    		  while (lo < hi && unsorted.get(lo).compareTo(mid) < 0) 
    		  {
    			  lo++;
    		  }
    		  while (lo<hi && unsorted.get(hi).compareTo(mid) > 0) 
    		  {
    			  hi--;
    		  }
    		  if (lo < hi) 
    		  {
    			  E T = unsorted.get(lo);
    			  unsorted.set(lo, unsorted.get(hi));
    			  unsorted.set(hi, T);
    		  }
    	  }
    	  if (hi < lo) 
    	  {
    		  int T = hi;
    		  hi = lo;
    		  lo = T;
    	  }
    	  quickSort(unsorted, low, lo);
    	  quickSort(unsorted, lo == low ? lo+1 : lo, high);
    }

    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    // O(1)
    public E min() {
    	assert size() != 0: "Precondition: size() != 0";
    	return myCon.get(0);

    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    // O(1)
    public E max() {
    	assert size() != 0: "Precondition: size() != 0";
    	return myCon.get(myCon.size()-1);
    }
    
    /**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise.
     */
    // O(N)
    public boolean add(E item)
    {
    	int initSize = size;
    	if (this.contains(item))
    		return false;
    	if (size == 0) 
    	{
    		myCon.add(item);
    		size++;
    	}
    	
    	else 
    	{
    		for (int i = 0; i < size; i++)
    		{
    			E temp = myCon.get(i);
    			//if item is less than the current value at current index, then insert it right before it
    			if (item.compareTo(temp) < 0)
    			{
    				myCon.add (i, item);
    				size++;
    				return true;
    			}
    			
    		}
			//if end of current set reached, then item is greater than all elements in set so add to end
    		myCon.add(item);
			size++;
    	}
    	return this.size() > initSize;
    	
    }
    
    
 	/**
      * A union operation. Add all items of otherSet that are not already present in this set
      * to this set.
      * @param otherSet != null
      * @return true if this set changed as a result of this operation, false otherwise.
      */
    // O(N)
    public boolean addAll(ISet<E> otherSet)
    {
    	assert (otherSet != null) : "Precondition: otherSet != null";
    	int initSize = size;

    	
    	//local var of correct type
    	SortedSet<E> otherSortedSet;
    	
    	//check to see if otherSet is a sortedset already
    	if (!(otherSet instanceof SortedSet<?>))
    		otherSortedSet = new SortedSet<E> (otherSet);
    	else
    		otherSortedSet = (SortedSet<E>) otherSet;
    	
    	//iterator for both sets
    	Iterator <E> it = otherSortedSet.iterator();
    	//local variables to keep track of next item in list
    	E temp;
    	if (it.hasNext())
    	{
    		temp = it.next();
    		int position = 0; //current index of this arraylist
    		while (position < size)
    		{
    			//keep cycling through as long as there are still elements in otherset
    			if (it.hasNext())
    			{
    				if (myCon.get(position).compareTo(temp) < 0)
    				{
    					//increment the index forward since element in otherSet is larger than element in this set
    					position++;
    					temp = it.next();
    				}	
    				else if (myCon.get(position).compareTo(temp) > 0)
    				{
    					//element in otherset is smaller so add it to current position in this set
    					myCon.set(position, temp);
    					temp = it.next();
    					//position is incremented once but is still on same value as before
    					position++;
    					size++;
    				}
    				//if elements are equal in both, don't add and increment both sets forward
    				else
    				{
    					temp = it.next();
    					position++;	
    				}
    				
    			}
    		}
    		//add rest of remaining set to resulting set
    		while (it.hasNext())
    		{
    			myCon.add(temp);
    			size++;
    			temp = it.next();
    		}
    		myCon.add(temp);
    		size++;
    	}
    	
    	return size > initSize;
    }
    
    
    /**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    // O(N)
    public void clear()
    {
    	myCon.clear();
    	size = 0;
    }
    
    /**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    // O(N)
    public boolean contains(E item)
    {
    	assert (item !=null) : "Precondition: item != null";
    	
    	int left = 0;
    	int right = myCon.size()-1;
    	//not found
    	
    	while (left <= right)
    	{
    		int mid = (left + right)/ 2;
    		//if found
    		if (myCon.get(mid).compareTo(item) == 0)
        		return true;
    		else if (myCon.get(mid).compareTo(item) > 0)
        		right = mid - 1;
    		else
    			left = mid + 1;
    		
    	}

    	//return false if not found
    	return false;
    }
    
    
    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    // O(N)
    public boolean containsAll(ISet<E> otherSet)
    {
    	assert (otherSet !=null) : "Precondition: otherset != null";
    	
    	//local var of correct type
    	SortedSet<E> otherSortedSet;
    	
    	//check to see if otherSet is a sortedset already
    	if (!(otherSet instanceof SortedSet<?>))
    		otherSortedSet = new SortedSet<E> (otherSet);
    	else
    		otherSortedSet = (SortedSet<E>) otherSet;
    	
    	//position of this set
    	int pos = 0;
    	Iterator <E> it = otherSortedSet.iterator(); //get iterator for otherSet
    	E temp = it.next();
    	//check if each individual element is in this set
    	while (it.hasNext())
    	{
    		//if element found, move on to next one
    		if (myCon.get(pos).compareTo(temp) == 0)
    		{
    			pos++;
    			temp = it.next();
    		}
    		//if other element is greater than current position of this set, then check next position of this set
    		else if (myCon.get(pos).compareTo(temp) < 0)
    		{
    			pos++;
    		}
    		//if other element in otherSet is less than the current position in this Set, then it does not exist
    		else
    		{
    			return false;
    		}
    	}
    	return true;
    
    	
    }
    
    /**
     * Create a new set that is the difference of this set and otherSet. Return an ISet of 
     * elements that are in this Set but not in otherSet. Also called
     * the relative complement. 
     * <br>Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z] then
     * A.difference(B) would return an ISet with elements [X, Y] while
     * B.difference(A) would return an ISet with elements [W]. 
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the difference of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
    // O(N)
    public ISet<E> difference(ISet<E> otherSet)
    {
    	//local var of correct type
    	SortedSet<E> otherSortedSet;
    	
    	//check to see if otherSet is a sortedset already
    	if (!(otherSet instanceof SortedSet<?>))
    		otherSortedSet = new SortedSet<E> (otherSet);
    	else
    		otherSortedSet = (SortedSet<E>) otherSet;
    	
    	SortedSet <E> result = new SortedSet<E>();
    	
    	//iterator for this set
    	int pos = 0;
    	Iterator <E> it = otherSortedSet.iterator(); //get iterator for otherSet

    	//check if each individual element is in this set
    	//if either of sets reaches the end, then no need to check anymore
    	//if iterator of otherSet reaches end, then add the rest of elements in this set to result
		E temp = it.next();
    	while (pos < size)
    	{
    		//if element found, don't add and move on to next element
    		if (myCon.get(pos).compareTo(temp) == 0)
    		{
    			pos++;
    			if (it.hasNext())
    				temp = it.next();
    		}
    		//if other element is greater than current position of this set, then it is not in other set so add to result
    		else if (myCon.get(pos).compareTo(temp) < 0)
    		{
    			result.add(myCon.get(pos));
    			pos++;
    		}
    		//if the element in otherSet is less than the current position in this Set, then check next element in otherset
    		else
    			if (it.hasNext())
    				temp = it.next();
    	}
    	//add rest of this set to result if otherSet reached end
    	while (pos < myCon.size())
    	{
    		result.add(myCon.get(pos));
    		pos++;
    	}
    	return result;
    }
    
    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    // O(N)
    public boolean equals(Object other)
    {
    	if(! (other instanceof ISet<?>))
    		return false;
    	else
    	{
    		ISet <?> otherSet = (ISet<?>) other;
    		//if it is an unsorted set
    		if(otherSet instanceof UnsortedSet)
        	{
    			return super.equals(otherSet);
        	}


    		else
    		{
    			if(this.size() != otherSet.size())
        		{
        			return false;
        		}
    			//cast otherSet to an ISet of unknown element data types
    			else
    			{
    				Iterator<E> it = this.iterator();
    				Iterator<?> it2 = otherSet.iterator();
    				while(it.hasNext())
    				{
    					if(!it.next().equals(it2.next()))
    					{
    						return false;
    					}
    				}
    			}
    			return true;
    		}		
    	}		
    		
    }
    
    /**
     * create a new set that is the intersection of this set and otherSet.
     * <br>pre: otherSet != null<br>
     * <br>post: returns a set that is the intersection of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the intersection of this set and otherSet
     */
    // O(N)
    public ISet<E> intersection(ISet<E> otherSet)
    {
    	//local var of correct type
    	SortedSet<E> otherSortedSet;
    	
    	//check to see if otherSet is a sortedset already
    	if (!(otherSet instanceof SortedSet<?>))
    		otherSortedSet = new SortedSet<E> (otherSet);
    	else
    		otherSortedSet = (SortedSet<E>) otherSet;
    	
    	SortedSet <E> result = new SortedSet<E>();
    	
    	//iterator for this set
    	Iterator<E> it = otherSortedSet.iterator();
    	
    	//check common elements in this set and add them to result, result will already be sorted
    	int pos = 0;
		E otherTemp = it.next();
    	//if either set has reached end, then no need to look further, the rest of the items will not be intersections
    	while(it.hasNext() && pos < myCon.size())
    	{
    		E temp = myCon.get(pos);
    		//if elements are equal, then it is intersection, add to result
    		if (temp.compareTo(otherTemp) == 0)
    		{
    			result.add(temp);
    			pos++;
    			otherTemp = it.next();
    		}
    		//if this element is greater than otherset element, compare the next element in otherset
    		else if (temp.compareTo(otherTemp) > 0)
    			otherTemp = it.next();	
    		//if this element is less than otherset element, compare next element in this set
    		else
    			pos++;
	
    	}
    	//if iterator doesnt have next, still need to check current element in iterator
    	if (myCon.get(pos).compareTo(otherTemp) == 0)
		{
			result.add(otherTemp);
		}
    	return result;
    	
    }
    
    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * @return an Iterator object for the elements of this set
     */
    // O(1)
	public Iterator<E> iterator() {
		ListIterator <E> it = myCon.listIterator();
		return it;
		
	}
    
    /**
     * Create a new set that is the union of this set and otherSet.
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the union of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     */
	// O(N)
    public ISet<E> union(ISet<E> otherSet)
    {
    	//local var of correct type
    	SortedSet<E> otherSortedSet;
    	
    	//check to see if otherSet is a sortedset already
    	if (!(otherSet instanceof SortedSet<?>))
    		otherSortedSet = new SortedSet<E> (otherSet);
    	else
    		otherSortedSet = (SortedSet<E>) otherSet;
    	
    	SortedSet <E> result = new SortedSet<E>();
    	
    	//iterator for otherSet
    	Iterator <E> it = otherSortedSet.iterator();
    	//local variables to keep track of next item in list
    	E temp2;
    	if (it.hasNext())
    	{
    		temp2 = it.next();
    		{
    			int pos = 0; //index of this set
    			while (pos < size && it.hasNext())
    			{
    				E temp1 = myCon.get(pos);
    				if (temp1.compareTo(temp2) < 0)
    				{
    					//add the smaller element from current set to result
    					result.add(temp1);
    					pos++; //increment index
    				}
    				else if (temp1.compareTo(temp2) > 0)
    				{
    					//add smaller element from otherSet to result
    					result.add(temp2);
    					temp2 = it.next(); //increment index
    				}
    				//if elements are equal in both
    				else
    				{
    					//add element to result and increment both
    					result.add(temp1);
    					pos++;
    					temp2 = it.next();
    			
    				}
    			}
    			//add rest of remaining otherset to resulting set
    			if (pos == size)
    			{
    				while (it.hasNext())
    				{
    					result.add(temp2);
    					temp2 = it.next();
    				}
    				result.add(temp2);
    			}
    			//compare the last remaining iterator element with the rest of this set
    			while (pos < size)
    			{
    				boolean endReached = false; //end of otherset reached
    				E temp1 = myCon.get(pos);
    				if (temp1.compareTo(temp2) < 0 || endReached)
    				{
    					//add the smaller element from current set to result
    					result.add(temp1);
    					pos++; //increment index
    				}
    				else if (temp1.compareTo(temp2) > 0)
    				{
    					//add smaller element from otherSet to result
    					result.add(temp2);
    					endReached = true;
    				}
    				//if elements are equal in both
    				else
    				{
    					//add element to result and increment both
    					result.add(temp1);
    					pos++;	
    					endReached = true;
    				}
    			}
    		}
    			
    	}
    	return result;
    	
    }
    
    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise
     */
    // O(N)
    public boolean remove(E item)
    {
    	int initsize = size;
    	assert item!=null: "Precondition: item != null";
    	for (int i = 0; i < size; i++)
    	{
    		E temp = myCon.get(i);
    		if (temp.compareTo(item) == 0)
    		{
    			myCon.remove(i);
    			size--;
    			return true;
    		}
    		
    	}
    	return (initsize != size);
    	
    }
    
    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    // O(1)
    public int size()
    {
    	return myCon.size();
    }





}
