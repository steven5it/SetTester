/*  Student information for assignment:
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: SCL346
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

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;


/*
CS 314 Students, put your results to the experiments and answers to
questions here:

/*
 * DRACULA ***** CS314 SortedSet: *****
 * Time to add the elements in the text to this set: elapsed time: 0.589885417 seconds.
 * Total number of words in text including duplicates: 51375
 * Number of distinct words in this text 8696
 * 
 * ****** CS314 UnsortedSet: *****
 * Time to add the elements in the text to this set: elapsed time: 0.714903139 seconds.
 * Total number of words in text including duplicates: 51375
 * Number of distinct words in this text 8696
 * 
 * ***** Java HashSet ******
 * Time to add the elements in the text to this set: elapsed time: 0.091126597 seconds.
 * Total number of words in text including duplicates: 51375
 * Number of distinct words in this text 8696
 * 
 * ***** Java TreeSet ******
 * Time to add the elements in the text to this set: elapsed time: 0.106736754 seconds.
 * Total number of words in text including duplicates: 51375
 * Number of distinct words in this text 8696
 * 
 * HOW TO ANALYZE PEOPLE ON SIGHT
 * ***** CS314 SortedSet: *****
Time to add the elements in the text to this set: elapsed time: 0.867601362 seconds.
Total number of words in text including duplicates: 64270
Number of distinct words in this text 11392
 * 
 * ****** CS314 UnsortedSet: *****
Time to add the elements in the text to this set: elapsed time: 1.286358717 seconds.
 * 
 * ***** Java HashSet ******
Time to add the elements in the text to this set: elapsed time: 0.083725596 seconds.
 * 
 * ***** Java TreeSet ******
Time to add the elements in the text to this set: elapsed time: 0.144053678 seconds.
 * 
 * THE ART OF WAR ***** CS314 SortedSet: *****
Time to add the elements in the text to this set: elapsed time: 0.413566375 seconds.
Total number of words in text including duplicates: 38847
Number of distinct words in this text 8760
 * 
 * ****** CS314 UnsortedSet: *****
Time to add the elements in the text to this set: elapsed time: 0.629967083 seconds.

 * 
 * ***** Java HashSet ******
Time to add the elements in the text to this set: elapsed time: 0.053318162 seconds.
 * 
 * ***** Java TreeSet ******
Time to add the elements in the text to this set: elapsed time: 0.06688312 seconds.
 * 
 * THE WAR OF THE WORLDS ***** CS314 SortedSet: *****
Time to add the elements in the text to this set: elapsed time: 0.308331324 seconds.
Total number of words in text including duplicates: 15462
Number of distinct words in this text 4159
 * 
 * ****** CS314 UnsortedSet: *****
Time to add the elements in the text to this set: elapsed time: 0.180007137 seconds.
 * 
 * ***** Java HashSet ******
Time to add the elements in the text to this set: elapsed time: 0.019158833 seconds.
 * 
 * ***** Java TreeSet ******
Time to add the elements in the text to this set: elapsed time: 0.028050313 seconds.
 * 
 * Answers:
 * SortedSet: O(M) where M is number of distinct words
 * UnsortedSet: O(M^2) where M is number of distinct words
 * HashSet: O(N) where N is total number of words
 * TreeSet: O(N) where N is total number of words
 * 
 * The Big-O of my add methods are O(N). The Big-Os for the HashSet and TreeSet methods are probably better - O(1) for HashSet, O(logN) for TreeSet
 * 
 * TreeSet is for the most part sorted, but HashSet is not sorted
 */

/*
 * CS314 Students, why is it unwise to implement all three of the
 * intersection, union, and difference methods in the AbstractSet class:
 * 
 * 
 */


public class SetTester {

    public static void main(String[] args){

    	// 50 Tests - All methods for Sorted and Unsorted
    	
    	//Constructor Tests [1-4]
    	
    	ISet<Integer> unsortedOne = new UnsortedSet<Integer>();
        unsortedOne.add(1);
        unsortedOne.add(18);
        unsortedOne.add(8);
        unsortedOne.add(91);
        unsortedOne.add(43);
        unsortedOne.add(6);
        unsortedOne.add(1);
        unsortedOne.add(1);
        unsortedOne.add(7);
        unsortedOne.add(12);
        unsortedOne.add(9);
        unsortedOne.add(27);

        ISet<Integer> sortedOne = new SortedSet<Integer>();
        sortedOne.add(1);
        sortedOne.add(18);
        sortedOne.add(8);
        sortedOne.add(91);
        sortedOne.add(43);
        sortedOne.add(6);
        sortedOne.add(1);
        sortedOne.add(1);
        sortedOne.add(7);
        sortedOne.add(12);
        sortedOne.add(9);
        sortedOne.add(27);
        
        String unsortedString = "(1, 18, 8, 91, 43, 6, 7, 12, 9, 27)";
        String sortedString = "(1, 6, 7, 8, 9, 12, 18, 27, 43, 91)";
        
        //Test 1
        if (unsortedOne.toString().equals(unsortedString))
        	System.out.println("Passed Test 1");
        else
        	System.out.println("FAILED Test 1 - UnsortedSet Constructor (default)");
        
        //Test 2
        if (sortedOne.toString().equals(sortedString))
        	System.out.println("Passed Test 2");
        else
        	System.out.println("FAILED Test 2 - SortedSet Constructor (default)");
        
        ISet<Integer> unsortedFromSorted = new UnsortedSet<Integer>(sortedOne);
        ISet<Integer> sortedFromUnsorted = new SortedSet<Integer>(unsortedOne);
        
        //Test 3
        if (unsortedFromSorted.toString().equals(sortedString))
        	System.out.println("Passed Test 3");
        else
        	System.out.println("FAILED Test 3 - UnsortedSet Constructor (given SortedSet)");
        
        //Test4
        if (sortedFromUnsorted.toString().equals(sortedString))
        	System.out.println("Passed Test 4");
        else
        	System.out.println("FAILED Test 4 - SortedSet Constructor (given UnsortedSet)");
        
        //Contains Tests [5-10]
        
        //Test 5
        if (unsortedOne.contains(43))
        	System.out.println("Passed Test 5");
        else
        	System.out.println("FAILED Test 5 - SortedSet Contains");
        
        //Test 6
        if (sortedOne.contains(43))
        	System.out.println("Passed Test 6");
        else
        	System.out.println("FAILED Test 6 - SortedSet Contains");
        
        //Test 7
        if (!unsortedOne.contains(32))
        	System.out.println("Passed Test 7");
        else
        	System.out.println("FAILED Test 7 - UnsortedSet Contains");
        
        //Test 8
        if (!sortedOne.contains(32))
        	System.out.println("Passed Test 8");
        else
        	System.out.println("FAILED Test 8 - SortedSet Contains");
        
        //Test 9
        if (unsortedOne.containsAll(unsortedFromSorted))
        	System.out.println("Passed Test 9");
        else
        	System.out.println("FAILED Test 9 - UnsortedSet ContainsAll");
        
        //Test 10
        if (sortedOne.containsAll(unsortedFromSorted))
        	System.out.println("Passed Test 10");
        else
        	System.out.println("FAILED Test 10 - UnsortedSet ContainsAll");
        
        //Clear Tests [11-12]
        
        //Test 11
        unsortedFromSorted.clear();
        if (unsortedFromSorted.size() == 0)
        	System.out.println("Passed Test 11");
        else 
        	System.out.println("FAILED Test 11 - UnsortedSet Clear");
        
        //Test 12
        sortedFromUnsorted.clear();
        if (sortedFromUnsorted.size() == 0)
        	System.out.println("Passed Test 12");
        else
        	System.out.println("FAILED Test 12 - SortedSet Clear");
        
        //Remove Tests [13-16]
        
        //Test 13
        if (!unsortedOne.remove(4))
        	System.out.println("Passed Test 13");
        else
        	System.out.println("FAILED Test 13 - UnsortedSet Remove");
        
        //Test 14
        if (!sortedOne.remove(4))
        	System.out.println("Passed Test 14");
        else
        	System.out.println("FAILED Test 14 - SortedSet Remove");
        
        //Test 15
        unsortedString = "(1, 8, 91, 43, 6, 7, 12, 9, 27)";
        if (unsortedOne.remove(18) && unsortedOne.toString().equals(unsortedString))
        	System.out.println("Passed Test 15");
        else
        	System.out.println("FAILED Test 15 - UnsortedSet Remove");
        
        //Test 16
        sortedString = "(1, 6, 7, 9, 12, 18, 27, 43, 91)";
        if (sortedOne.remove(8) && sortedOne.toString().equals(sortedString))
        	System.out.println("Passed Test 16");
        else
        	System.out.println("FAILED Test 16 - SortedSet Remove");
        
        //Add Tests [17-20]
        
        //Test 17
        unsortedOne.add(31);
        unsortedString = "(1, 8, 91, 43, 6, 7, 12, 9, 27, 31)";
        if (unsortedOne.toString().equals(unsortedString))
        	System.out.println("Passed Test 17");
        else
        	System.out.println("FAILED Test 17 - UnsortedSet Add");
        
        //Test 18
        sortedOne.add(5);
        sortedString = "(1, 5, 6, 7, 9, 12, 18, 27, 43, 91)";
        if (sortedOne.toString().equals(sortedString))
        	System.out.println("Passed Test 18");
        else
        	System.out.println("FAILED Test 18 - SortedSet Add");
        
        //Test 19
        unsortedFromSorted.addAll(sortedOne);
        if (unsortedFromSorted.toString().equals(sortedString))
        	System.out.println("Passed Test 19");
        else
        	System.out.println("FAILED Test 19 - UnsortedSet AddAll");
        
        //Test 20
        sortedFromUnsorted.addAll(unsortedOne);
        sortedString = "(1, 6, 7, 8, 9, 12, 27, 31, 43, 91)";
        if (sortedFromUnsorted.toString().equals(sortedString))
        	System.out.println("Passed Test 20");
        else
        	System.out.println("FAILED Test 20 - SortedSet AddAll");
        
        //Size Tests [21-22]
        
        //Test 21
        int realSize = 10;
        if (unsortedOne.size() == realSize)
        	System.out.println("Passed Test 21");
        else
        	System.out.println("FAILED Test 21 - UnsortedSet Size");
        
        //Test 22
        if (sortedOne.size() == realSize)
        	System.out.println("Passed Test 22");
        else
        	System.out.println("FAILED Test 22 - SortedSet Size");
        
        //Iterator Tests [23-24]
        
        //Test 23
        Iterator<Integer> it = unsortedOne.iterator();
        if (it.hasNext()) {
        	it.next();
        	it.next();
        	if (it.next() == 91)
        		System.out.println("Passed Test 23");
            else
            	System.out.println("FAILED Test 23 - UnsortedSet Iterator (next)");
        } else System.out.println("FAILED Test 23 - UnsortedSet Iterator (hasNext)");
        
        //Test 24
        it = sortedOne.iterator();
        if (it.hasNext()) {
        	it.next();
        	it.next();
        	if (it.next() == 6)
        		System.out.println("Passed Test 24");
            else
            	System.out.println("FAILED Test 24 - SortedSet Iterator (next)");
        } else System.out.println("FAILED Test 24 - SortedSet Iterator (hasNext)");
        
        //Difference Tests [25-26]
        
        //Test 25
        unsortedFromSorted = unsortedOne.difference(sortedOne);
        unsortedString = "(8, 31)";
        if (unsortedFromSorted.toString().equals(unsortedString))
        	System.out.println("Passed Test 25");
        else
        	System.out.println("FAILED Test 25 - UnsortedSet Difference");
        
        //Test 26
        sortedFromUnsorted = sortedOne.difference(unsortedOne);
        sortedString = "(5, 18)";
        if (sortedFromUnsorted.toString().equals(sortedString))
        	System.out.println("Passed Test 26");
        else
        	System.out.println("FAILED Test 26 - SortedSet Difference");
        
        //Test 27
        ISet<Integer> resultISet = unsortedFromSorted.difference(unsortedOne);
        unsortedString = "()";
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 27");
        else
        	System.out.println("FAILED Test 27 - UnsortedSet Difference");
        
        //Test 28
        resultISet = sortedFromUnsorted.difference(sortedOne);
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 28");
        else
        	System.out.println("FAILED Test 28 - SortedSet Difference");
        
        //Test 29
        resultISet = unsortedFromSorted.difference(sortedFromUnsorted);
        unsortedString = "(8, 31)";
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 29");
        else
        	System.out.println("FAILED Test 29 - UnsortedSet Difference");
        
        //Test 30
        resultISet = sortedFromUnsorted.difference(unsortedFromSorted);
        sortedString = "(5, 18)";
        if (resultISet.toString().equals(sortedString))
        	System.out.println("Passed Test 30");
        else
        	System.out.println("FAILED Test 30 - SortedSet Difference");
        
        //Intersection Tests [31-36]
        
        //Test 31
        resultISet = unsortedOne.intersection(sortedOne);
        unsortedString = "(1, 91, 43, 6, 7, 12, 9, 27)";
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 31");
        else
        	System.out.println("FAILED Test 31 - UnsortedSet Intersection");
        
        //Test 32

        resultISet = sortedOne.intersection(unsortedOne);
        sortedString = "(1, 6, 7, 9, 12, 27, 43, 91)";
        if (resultISet.toString().equals(sortedString))
        	System.out.println("Passed Test 32");
        else
        	System.out.println("FAILED Test 32 - SortedSet Intersection");
        
        //Test 33
        resultISet = unsortedFromSorted.intersection(sortedFromUnsorted);
        unsortedString = "()";
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 33");
        else
        	System.out.println("FAILED Test 33 - UnsortedSet Intersection");
        
        //Test 34
        resultISet = sortedFromUnsorted.intersection(unsortedFromSorted);
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 34");
        else
        	System.out.println("FAILED Test 34 - SortedSet Intersection");
        
        //Test 35
        resultISet = unsortedOne.intersection(unsortedOne);
        unsortedString = "(1, 8, 91, 43, 6, 7, 12, 9, 27, 31)";
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 35");
        else
        	System.out.println("FAILED Test 35 - UnsortedSet Intersection");
        
        //Test 36
        resultISet = sortedOne.intersection(sortedOne);
        sortedString = "(1, 5, 6, 7, 9, 12, 18, 27, 43, 91)";
        if (resultISet.toString().equals(sortedString))
        	System.out.println("Passed Test 36");
        else
        	System.out.println("FAILED Test 36 - SortedSet Intersection");
        
        //Union Tests [37-42]
        
        //Test 37
        resultISet = unsortedOne.union(unsortedOne);
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 37");
        else
        	System.out.println("FAILED Test 37 - UnsortedSet Union");
        
        //Test 38
        resultISet = sortedOne.union(sortedOne);
        if (resultISet.toString().equals(sortedString))
        	System.out.println("Passed Test 38");
        else
        	System.out.println("FAILED Test 38 - SortedSet Union");
        
        //Test 39
        resultISet = unsortedOne.union(sortedOne);
        unsortedString = "(1, 8, 91, 43, 6, 7, 12, 9, 27, 31, 5, 18)"; 
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 39");
        else
        	System.out.println("FAILED Test 39 - UnsortedSet Union");
        
        //Test 40
        resultISet = sortedOne.union(unsortedOne);
        sortedString = "(1, 5, 6, 7, 8, 9, 12, 18, 27, 31, 43, 91)";
        if (resultISet.toString().equals(sortedString))
        	System.out.println("Passed Test 40");
        else
        	System.out.println("FAILED Test 40 - SortedSet Union");
        
        //Test 41
        sortedFromUnsorted.clear();
        unsortedFromSorted.clear();
        resultISet = unsortedFromSorted.union(sortedFromUnsorted);
        unsortedString = "()";
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 41");
        else
        	System.out.println("FAILED Test 41 - SortedSet Union");
        
        //Test 42
        resultISet = sortedFromUnsorted.union(unsortedFromSorted);
        if (resultISet.toString().equals(unsortedString))
        	System.out.println("Passed Test 42");
        else
        	System.out.println("FAILED Test 42 - SortedSet Union");
        
        //Min and Max Tests [43-44]
        
        //Test 43
        Integer bound = ((SortedSet<Integer>) sortedOne).min();
        if (bound == 1)
        	System.out.println("Passed Test 43");
        else
        	System.out.println("FAILED Test 43 - Sorted Min");
        
        //Test 44
        bound = ((SortedSet<Integer>) sortedOne).max();
        if (bound == 91)
        	System.out.println("Passed Test 44");
        else
        	System.out.println("FAILED Test 44 - Sorted Min");
        
        //Equals Tests [45-50]
        
        //Test 45
        sortedFromUnsorted.addAll(unsortedOne);
        if (unsortedOne.equals(sortedFromUnsorted))
        	System.out.println("Passed Test 45");
        else
        	System.out.println("FAILED Test 45 - UnsortedSet Equals (self, sorted)");
        
        //Test 46
        if (!unsortedOne.equals(sortedOne))
        	System.out.println("Passed Test 46");
        else
        	System.out.println("FAILED Test 46 - UnsortedSet Equals (different, sorted)");
        
        //Test 47
        if (!sortedOne.equals(sortedFromUnsorted))
        	System.out.println("Passed Test 47");
        else
        	System.out.println("FAILED Test 47 - SortedSet Equals (different, sorted)");
        
        //Test 48
        if (sortedOne.equals(sortedOne))
        	System.out.println("Passed Test 48");
        else
        	System.out.println("FAILED Test 48 - SortedSet Equals (self)");
        
        //Test 49
        ISet<String> stringSet = new UnsortedSet<String>();
        stringSet.add("1");
        stringSet.add("8");
        stringSet.add("91");
        stringSet.add("43");
        stringSet.add("6");
        stringSet.add("7");
        stringSet.add("12");
        stringSet.add("9");
        stringSet.add("27");
        stringSet.add("31");
        if (!unsortedOne.equals(stringSet))
        	System.out.println("Passed Test 49");
        else
        	System.out.println("FAILED Test 49 - UnsortedSet Equals (other data type)");
        
        //Test 50
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("8");
        arrayList.add("91");
        arrayList.add("43");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("12");
        arrayList.add("9");
        arrayList.add("27");
        arrayList.add("31");
        if (!sortedOne.equals(arrayList))
        	System.out.println("Passed Test 50");
        else
        	System.out.println("FAILED Test 50 - SortedSet Equals (other Object)");      

//         CS314 Students. Uncomment this section when ready to 
//         run your experiments
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                }
//                catch(Exception e) {
//                    System.out.println("Unable to change look and feel");
//                }
//        		Scanner sc = new Scanner(System.in);
//        		String response = "";
//        		do {
//        			largeTest();
//        			System.out.print("Another file? Enter y to do another file: ");
//        			response = sc.next();
//        		} while( response != null && response.length() > 0 
//                      && response.substring(0,1).equalsIgnoreCase("y") );

    }

    /*
     * Method asks user for file and compares run times to add words from file to
     * various sets, including CS314 UnsortedSet and SortedSet and Java's
     * TreeSet and HashSet.
     */
    private static void largeTest(){
        System.out.println();
        System.out.println("Opening Window to select file. You may have to minimize other windows.");
        String text = convertFileToString();
        System.out.println();
        System.out.println("***** CS314 SortedSet: *****");
        processTextCS314Sets(new SortedSet<String>(), text);
        System.out.println("****** CS314 UnsortedSet: *****");
        processTextCS314Sets(new UnsortedSet<String>(), text);
        System.out.println("***** Java HashSet ******");
        processTextJavaSets( new HashSet<String>(), text);
        System.out.println("***** Java TreeSet ******");
        processTextJavaSets( new TreeSet<String>(), text);
    }

    
    /*
     * pre: set != null, text != null
     * Method to add all words in text to the given set. Words are delimited by
     * white space.
     * This version for CS314 sets.
     */
    private static void processTextCS314Sets(ISet<String> set, String text){
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while( sc.hasNext() ){
            totalWords++;
            set.add(sc.next());
        }
        s.stop();
        sc.close();

        showResultsAndWords(set, s, totalWords, set.size());
    }


    /*
     * pre: set != null, text != null
     * Method to add all words in text to the given set. Words are delimited by
     * white space.
     * This version for Java Sets.
     */
    private static void processTextJavaSets(Set<String> set, String text){
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while( sc.hasNext() ){
            totalWords++;
            set.add(sc.next());
        }
        s.stop();
        sc.close();

        showResultsAndWords(set, s, totalWords, set.size());
    }

    
    /*
     * Show results of add words to given set.
     */
    private static <E> void showResultsAndWords(Iterable<E> set, Stopwatch s, 
            int totalWords, int setSize) {

        System.out.println("Time to add the elements in the text to this set: " + s.toString() );
        System.out.println("Total number of words in text including duplicates: " + totalWords);
        System.out.println("Number of distinct words in this text " + setSize);


        System.out.print("Enter y to see the contents of this set: ");
        Scanner sc = new Scanner(System.in);
        String response = sc.next();

        if( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") ){
            for(Object o : set)
                System.out.println(o);
        }	
        System.out.println();
    }


    /*
     * Ask user to pick a file via a file choosing window and
     * convert that file to a String. Since we are evalutatin the file
     * with many sets convert to string once instead of reading through
     * file multiple times.
     */
    private static String convertFileToString() {
        //create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        StringBuilder text = new StringBuilder();
        int retval = chooser.showOpenDialog(null);

        chooser.grabFocus();

        //read in the file
        if (retval == JFileChooser.APPROVE_OPTION) {
            File source = chooser.getSelectedFile();
            try {
                Scanner s = new Scanner( new FileReader( source ) );

                while( s.hasNextLine() ) {
                    text.append( s.nextLine() );
                    text.append(" ");
                }

                s.close();
            }
            catch(IOException e) {
                System.out.println("An error occured while trying to read from the file: " + e);
            }
        }

        return text.toString();
    }
}