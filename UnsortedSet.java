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

import java.util.Iterator;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet <E extends Comparable<? super E>> extends AbstractSet<E>
{
	private ArrayList<E> myCon;
	private int size;
	
	/**
     * create an empty UnsortedSet
     */
	public UnsortedSet()
	{
		myCon = new ArrayList <E>();
		size = 0;
	}
	
	   /**
     * create a UnsortedSet out of an unsorted set. <br>
     * @param other != null
     */
	public UnsortedSet(ISet<E> other)
	{
		this();
		assert (other != null) : "Precondition: other != null";
    	Iterator<E> it = other.iterator();
    	while (it.hasNext()){
    		E temp = it.next();
    		myCon.add(temp);
    		size++;
    	}
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
    	assert item != null : "Precondition: item != null";
    	if (!this.contains(item))
    	{
    		myCon.add(item);
    		return true;
    	}
    	else
    		return false;
    }
    
    
 	/**
      * A union operation. Add all items of otherSet that are not already present in this set
      * to this set.
      * @param otherSet != null
      * @return true if this set changed as a result of this operation, false otherwise.
      */
    // O(N^2)
    public boolean addAll(ISet<E> otherSet)
    {
    	assert otherSet != null : "Precondition: otherSet != null";
    	boolean hasChanged = false;
		Iterator<E> otherIt = otherSet.iterator();
		while (otherIt.hasNext())
		{
			E item = otherIt.next();
			//if element in otherSet isn't in this set
			if (!this.contains(item))
			{
				//add element if not already in set and let it known it has changed
				myCon.add(item);
				hasChanged = true;
				
			}
		}
		return hasChanged;
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
    // O(N^2)
    public ISet<E> difference(ISet<E> otherSet)
    {
    	assert otherSet != null : "Precondition: otherSet!= null";
    	
    	UnsortedSet <E> result = new UnsortedSet<E>();
		//check each element in this set to see if it exists in otherset
		for (int i = 0; i < myCon.size(); i++)
		{
			//if element is not in otherset, add it to resulting set
			if (!otherSet.contains(myCon.get(i)))
				result.add(myCon.get(i));
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
    // O(N^2)
    public boolean equals(Object other)
    {
    	if(! (other instanceof ISet<?>))
    		return false;
    	else
    	{
    		ISet <?> otherSet = (ISet<?>) other;
    		if(this.size() != otherSet.size())
        	{
        		return false;
        	}
    		else
    		{
    			return super.equals(otherSet);
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
    // O(N^2)
    public ISet<E> intersection(ISet<E> otherSet)
    {  	
    	UnsortedSet <E> result = new UnsortedSet<E>();
    	
    	//iterator for this set
		Iterator<E> it = this.iterator();
		
		//check common elements in this set and add them to result
		while(it.hasNext()){
			E temp = it.next();
			if(otherSet.contains(temp))
				result.add(temp);
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
    // O(N^2)
    public ISet<E> union(ISet<E> otherSet)
    { 	
    	UnsortedSet <E> result = new UnsortedSet<E>();
    	
    	//iterator for both sets
    	Iterator<E> it = this.iterator();
    	Iterator<E> otherit = otherSet.iterator();
    	
    	//add all of elements from this set to result
    	while(it.hasNext())
    	{
    		E temp = it.next();
    		result.add(temp);
    	}
    	
    	//add all of elements from otherset to result
    	while(otherit.hasNext())
    	{
    		E temp2 = otherit.next();
    		if(!result.contains(temp2))
    			result.add(temp2);
    	}
    	
    	return result;
    	
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
