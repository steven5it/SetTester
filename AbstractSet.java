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

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E> 
{

    /* NO INSTANCE VARIABLES ALLOWED.
     * NO DIRECT REFERENCE TO UnsortedSet OR SortedSet ALLOWED.
     * (In other words the data types UnsortedSet and SortedSet
     * will not appear any where in this class.)
     * Also no direct references to ArrayList or other Java Collections.
     */
	/**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise.
     */
    public abstract boolean add(E item);
    
    
 	/**
      * A union operation. Add all items of otherSet that are not already present in this set
      * to this set.
      * @param otherSet != null
      * @return true if this set changed as a result of this operation, false otherwise.
      */
    public boolean addAll(ISet<E> otherSet)
    {
    	assert (otherSet != null) : "Precondition: otherSet != null";
    	Iterator <E> it = otherSet.iterator();
    	int initSize = this.size();
    	while(it.hasNext())
    	{
    		E temp = it.next();
    		this.add(temp);
    	}
    	
    	return this.size() > initSize;
    }
    

	/**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void clear()
    {
    	Iterator<E> it = this.iterator(); // get an iterator for this set. 
        // go through each element and remove
        while(it.hasNext())
        {
            it.next();
            it.remove();
        }
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
    	Iterator<E> it = this.iterator(); // get an iterator for this set. 
        // do a linear search using the iterator object
        while(it.hasNext()){
            if(it.next().equals(item))
                return true; //if item found
        }
        //item not found
        return false;
    }

    
	/**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    // O(N^2)
    public boolean containsAll(ISet<E> otherSet)
    {
    	assert (otherSet !=null) : "Precondition: otherset != null";
    	Iterator <E> otherIt = otherSet.iterator(); //get iterator for otherSet
    	//check if each individual element is in this set
    	while (otherIt.hasNext())
    	{
    		//if the current element in otherSet is not in this set, return false
    		if (!this.contains(otherIt.next()))
    			return false;
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
    public abstract ISet<E> difference(ISet<E> otherSet);
    
    

    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    public boolean equals(Object other)
    {
    	if(other instanceof AbstractSet)
    	{
    		if(((AbstractSet<E>) other).containsAll
    				(this) && this.containsAll((AbstractSet<E>) other))
    			return true;
    		
    		return false;
    	}
    	
    	else
    		return false;
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
    public abstract ISet<E> intersection(ISet<E> otherSet);
    
    
	/**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * @return an Iterator object for the elements of this set
     */
    public abstract Iterator<E> iterator();
    
    
	/**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise
     */
    // O(N)
    public boolean remove(E item)
    {
    	assert item!=null: "Precondition: item != null";
    	Iterator <E> it = this.iterator(); //get iterator for this set
    	
    	//otherwise, check each individual element to find the target item and remove it
    	while (it.hasNext())
        {
    		E temp = it.next();
        	if (temp.equals(item))
        	{
        		it.remove();
        		return true;
        	}
        }	
    	//if item never found
    	return false;
    }
    
    
	/**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    // O(N)
    public int size()
    {
    	int size = 0;
    	Iterator<E> it = this.iterator(); // get an iterator for this set. 
        // do a count up elements in set
        while(it.hasNext()){
        	it.next();
            size++;
        }
        return size;
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
    public abstract ISet<E> union(ISet<E> otherSet); 
     
      
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
}
