import java.io.*;
import java.util.Scanner; 

/**
 *
 * @author Josh Freeman
 */
 
 /**********************************
 IMPORTANT!! IMPORTANT!! IMPORTANT!! 
 
 This code does not compile as it lacks the definitions of the two methods you need to write.
 Before you start working on it, make sure to write method stubs (placeholders) first. 
 To get an idea of how to do it, check the files I was giving to you in Asg. 2 and 3 - those had the method stubs you were adding code to.

Methods that need stubs are:

numericPattern()
fileAnalysis()

***********************************/

public class TwoMethodsA04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        testNumericPattern();
        testFileAnalysis();
    }
   
    
   public static String numericPattern(int size,boolean direction) throws IllegalArgumentException {
	   
	   // Instantiate result
	   String result = "";
	   
	   // if size is less than or equal to 0, show error
	   if(size <= 0) {
		   
		   throw new IllegalArgumentException("ERROR. Number entered is not positive.\n");
		   
	   }
	   
	   // if direction is true, start loop from 1
	   if(direction == true) {
		   
		   for(int i = 1;i <= size; i++) {
			   result += i;
		   }
		   
		   for(int j = size - 1; j >= 1; j--) {
			   result += j;
		   }
	   }
	   
	   // if direction == false
	   else if(direction == false) {
		   
		   for(int j = size; j >= 1; j--) {
			   result += j;
		   }
		   for(int i = 2; i <= size; i++) {
			   result += i;
		   }
	   }
	   // if size = 1, show 1 regardless
	   else if(size == 1) {
		   result = "1";
	   }
	   return result;
	   
   }
     
   /**
    * Method runs all test cases for numericPattern() method 
    */ 
   public static void testNumericPattern()
   {
       System.out.println("\n--------- numericPattern() Tests ---------");
         //--- Test 1 ---//
        if(numericPattern(1, true).equals("1")&&numericPattern(1, false).equals("1")) System.out.println("Test 1 for numericPattern() PASSED");
        else System.out.println("Test 1 for numericPattern() Failed");
       
         //--- Test 2 ---//
        if(numericPattern(5, false).equals("543212345")&& numericPattern(6, true).equals("12345654321")) System.out.println("Test 2 for numericPattern() PASSED");
        else System.out.println("Test 2 for numericPattern() Failed");
        
        //--- Test 3 ---//
        try
        {
            String ignoreMe = numericPattern(0, false);
            System.out.println("Test 3 for numericPattern() Failed");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Test 3 for numericPattern() PASSED");
        }
        //--- Test 4 ---//
        try
        {
            String ignoreMe = numericPattern(-55, false);
            System.out.println("Test 4 for numericPattern() Failed");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Test 4 for numericPattern() PASSED");
        }       
       
   }
   
   public static void fileAnalysis(String inputFileName,String outputFileName) throws IOException {
	   
	   // Instantiate variables
	   int min = 0;
	   int max = 0;
	   int sum = 0;
	   int count = 0;
	   int num;
	   
	   // Create file inputFileName
	   File file = new File(inputFileName);
	   
	   // scanner for reading the file
	   Scanner inputFile= new Scanner(file);
	   
	   // while loop will == true until all text is read
	   while(inputFile.hasNext()) {
		   
		   // store content and convert to integer
		   String readFile = inputFile.nextLine();
		   num = Integer.parseInt(readFile);
		   
		   // set first num as max/min
		   if(count == 0) {
			   
			   max = num;
			   min = num;
		   }
		   // if number >= max, max = num
		   if(num >= max) {
			   
			   max = num;
		   }
		   // if number <= min, min = num
		   else if(num <= min) {
			   
			   min = num;
		   }
		   
		   // add numbers
		   sum += num;
		   
		   // count adds 1 each time data is read
		   count++;
	   }
	   // close file
	   inputFile.close();
	  
	  // Create file outputFileName
	  File resultFile = new File(outputFileName);
	  
	  // create a printer to print text
	  PrintWriter outputFile = new PrintWriter(resultFile);
	  
	  // if empty
	  if(count == 0) {
		  outputFile.println("Numeric data file \"" + inputFileName + "\" is empty");
	  }
	  // if only 1 integer
	  else if(count == 1) {
		  outputFile.println("Numeric data file \"" + inputFileName + "\" has only one number: " + sum);
	  }
	  // Display result
	  else {
		  outputFile.println("Numeric Data File \"" + inputFileName + "\" Analysis");
		  outputFile.println("Number of integers: " + count);
		  outputFile.println("The sum of all integers in file: " + sum);
		  outputFile.println("The largest integer in the set: " + max);
		  outputFile.println("The smallest integer in the set: " + min);
	  }
	  // Close file
	  outputFile.close();
   }
  
   /**
    * Method runs all test cases for fileAnalysis() method 
    * The method generates a number of test case files. 
    * Please see those files to make sure your file output format matches the output format in test files
    */
   public static void testFileAnalysis()
   {
      // Data needed for the test cases is built here
      System.out.println("\n--------- fileAnalysis() Tests ---------");
      Integer[] testIn1 = {};
      String[] testOut1 = {"Numeric data file \"testCaseIn1.txt\" is empty"};
      Integer[] testIn2 = {0};
      String[] testOut2 = {"Numeric data file \"testCaseIn2.txt\" has only one number: 0"};
      Integer[] testIn3 = {0, 0};
      String[] testOut3 = {"Numeric Data File \"testCaseIn3.txt\" Analysis", "Number of integers: 2","The sum of all integers in file: 0", "The largest integer in the set: 0", "The smallest integer in the set: 0"};      
      Integer[] testIn4 = {33, 1, 0, 2}; 
      String[] testOut4 = {"Numeric Data File \"testCaseIn4.txt\" Analysis", "Number of integers: 4","The sum of all integers in file: 36", "The largest integer in the set: 33", "The smallest integer in the set: 0"};      
      Integer[] testIn5 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
      String[] testOut5 = {"Numeric Data File \"testCaseIn5.txt\" Analysis", "Number of integers: 2","The sum of all integers in file: -2", "The largest integer in the set: 2147483647", "The smallest integer in the set: 2147483647"};      
      Integer[] testIn6 = {Integer.MIN_VALUE, Integer.MAX_VALUE};
      String[] testOut6 = {"Numeric Data File \"testCaseIn6.txt\" Analysis", "Number of integers: 2","The sum of all integers in file: -1", "The largest integer in the set: 2147483647", "The smallest integer in the set: -2147483648"};      
   
     
      // building test case files 
      try
      {
        buildTestFile("testCaseIn1.txt", testIn1); 
        buildTestFile("testCaseOut1.txt", testOut1);
        buildTestFile("testCaseIn2.txt", testIn2);
        buildTestFile("testCaseOut2.txt", testOut2);
        buildTestFile("testCaseIn3.txt", testIn3);
        buildTestFile("testCaseOut3.txt", testOut3);
        buildTestFile("testCaseIn4.txt", testIn4);
        buildTestFile("testCaseOut4.txt", testOut4);
        buildTestFile("testCaseIn5.txt", testIn5);
        buildTestFile("testCaseOut5.txt", testOut5);
        buildTestFile("testCaseIn6.txt", testIn6);
        buildTestFile("testCaseOut6.txt", testOut6);
      }
      catch(IOException e)
      {
          System.out.println("Trouble with file IO when building test case files");
      }

      try
      {
        //--- Test 1 ---//        
       
        fileAnalysis("testCaseIn1.txt", "test01.txt");
        // comparing resulting files
        if(areEqualFiles("testCaseOut1.txt", "test01.txt"))System.out.println("Test 1 for fileAnalysis() PASSED");
        else System.out.println("Test 1 for fileAnalysis() Failed");
 
        //--- Test 2 ---//        
        fileAnalysis("testCaseIn2.txt", "test02.txt");   
             
        if(areEqualFiles("testCaseOut2.txt", "test02.txt"))System.out.println("Test 2 for fileAnalysis() PASSED");
        else System.out.println("Test 2 for fileAnalysis() Failed");  
        
        //--- Test 3 ---//        
        fileAnalysis("testCaseIn3.txt", "test03.txt");  
        
        if(areEqualFiles("testCaseOut3.txt", "test03.txt"))System.out.println("Test 3 for fileAnalysis() PASSED");
        else System.out.println("Test 3 for fileAnalysis() Failed"); 
        
        //--- Test 4 ---//        
        fileAnalysis("testCaseIn4.txt", "test04.txt"); 
        
        if(areEqualFiles("testCaseOut4.txt", "test04.txt"))System.out.println("Test 4 for fileAnalysis() PASSED");
        else System.out.println("Test 4 for fileAnalysis() Failed"); 
        
        //--- Test 5 ---//        
        fileAnalysis("testCaseIn5.txt", "test05.txt"); 
        
        if(areEqualFiles("testCaseOut5.txt", "test05.txt"))System.out.println("Test 5 for fileAnalysis() PASSED");
        else System.out.println("Test 5 for fileAnalysis() Failed"); 
        
        //--- Test 6 ---//       
        fileAnalysis("testCaseIn6.txt", "test06.txt"); 
        
        if(areEqualFiles("testCaseOut6.txt", "test06.txt"))System.out.println("Test 6 for fileAnalysis() PASSED");
        else System.out.println("Test 6 for fileAnalysis() Failed"); 
 
        
        //--- Test 7 ---//
        // Test on exception(s) that your method is supposed to throw
        fileAnalysis("doesNotExist.txt", "test07.txt"); 
        System.out.println("Test 7 for fileAnalysis() Failed"); 
      }
      catch(FileNotFoundException e)
      {
          System.out.println("Test 7 for fileAnalysis() PASSED");
      }
      catch(IOException e)
      {
          System.out.println("Trouble with file IO when running tests");
      }
   
      
   }
   /**
    * Builds a file with a given name with a content defined by an array of objects that are printed to the file as strings, one string per line  
    * @param fileName name of file to write to
    * @param testCase array of objects to print into file in string format
    * @throws IOException throws exception when file fails to open for writing or writing fails
    */
   public static void buildTestFile(String fileName, Object[] testCase) throws IOException
   {
        FileWriter file = new FileWriter(fileName); 
        PrintWriter outputFile = new PrintWriter(file);
        
        for (Object a: testCase)
        {
            outputFile.println(a);
        }
        outputFile.close();
   }
   /**
    * Compares content of two files and returns true if content is identical, false if not
    * @param fileName1 name of first file to be compared
    * @param fileName2 name of second file to be compared
    * @return true if the files are identical, false if not
    * @throws IOException thrown when files fail to open for reading / writing
    */
   public static boolean areEqualFiles(String fileName1, String fileName2) throws IOException
   {
        FileReader file1 = new FileReader(fileName1); 
        FileReader file2 = new FileReader(fileName2); 
        Scanner input1 = new Scanner(file1);
        Scanner input2 = new Scanner(file2);
        while(input1.hasNext()&&input2.hasNext())
        {
            String s1 = input1.nextLine().trim();
            String s2 = input2.nextLine().trim();
            if(!s1.equals(s2)) 
            {
                input1.close();
                input2.close();
                return false;
            }
        }
        boolean res;
        if(!input1.hasNext()&&!input2.hasNext()) res = true;
        else res = false;
        input1.close();
        input2.close();
        return res;
        
   }
}