///////////////////////////////////////////////////////////////////////////////
//	
// Title:			 Eliza
// Files:			 ElizaTests.java, Eliza.java
// Semester:		 CS302	Spring 2016
//
// Author:			 Jason Choe
// Email:			 choe2@wisc.edu
// CS Login:		 choe
// Lecturer's Name:  Jim Williams
// Lab Section:		 313
//
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  ElizaTests
// File:             ElizaTests.java
// Semester:         CS302 Spring 2016
//
// Author:           Jason Choe, choe2@wisc.edu
// CS Login:         choe
// Lecturer's Name:  Jim Williams
// Lab Section:      313
//
///////////////////////////////////////////////////////////////////////////////

/** Application that poses as a therapist and asks the user to type in 
 * descriptions of their problems. The program will look for patterns of words
 * and reply with a prepared response based on the matched pattern */

import java.util.Arrays;
//TODO add file, class and method header comments

/**
 * Class ElizaTests will look for patterns of words and reply with a prepared
 * response based on the matched pattern.
 *
 * no known bugs
 *
 * @author Jason Choe
 */

public class ElizaTests {
	/**
	 * This method randomly picks one of the strings from the list. If list 
	 * is null or has 0 elements then null is returned.
	 * 
	 * @param list An array of strings to choose from.
	 * @return One of the strings from the list.
	 */		
	public static void testChooseString() {
		
		//is one of the 3 strings chosen?
		String [] strList = {"The", "happy", "cat"};
		String choice = Eliza.chooseString( strList);
		if ( choice != null && (choice.equals("The") || choice.equals("happy") 
				|| choice.equals("cat"))) {
			System.out.println("testChooseString 1 passed.");
		} else {
			System.out.println("testChooseString 1 failed.");
		}
		
		//if I call it 100 times, are the choices approximately random?
		int countThe = 0;
		int countHappy = 0;
		int countCat = 0;
		for ( int i = 1; i <= 100; i++) {
			choice = Eliza.chooseString( strList);
			if ( choice != null) {
				if ( choice.equals("The")) {
					countThe++;
				} else if ( choice.equals("happy")) {
					countHappy++;
				} else if ( choice.equals("cat")) {
					countCat++;
				}
			}
		}
		if ( countThe >=20 && countThe <= 45 
				&& countHappy >= 20 && countHappy <= 45
				&& countCat >= 20 && countCat <= 45) {
			System.out.println("testChooseString 2 passed. " + countThe
					+ "," + countHappy + "," + countCat);
		} else {
			System.out.println("testChooseString 2 failed. " + countThe
					+ "," + countHappy + "," + countCat);
		}
		
		//additional test suggestions: 
		//What should happen when an array with a single string is provided? 
		//What should happen when null is passed to chooseString?
	}
	
	/**
	 * If the word is found in the wordList then the index of the word
	 * is returned, otherwise -1 is returned. If there are multiple matches
	 * the index of the first matching word is returned. If either word or 
	 * wordList is null then -1 is returned.
	 * 
	 * @param word  A word to search for in the list.
	 * @param wordList  The list of Strings in which to search.
	 * @return The index of list where word is found, or -1 if not found.
	 */
	
	public static void testInList() {
		String [] quitWords = {"bye","goodbye","quit", "bye"};		
		int index = Eliza.inList( "bye", quitWords);
		if ( index >= 0) {
			System.out.println("testInList 1 passed.");
			System.out.println(index);
		} else {
			System.out.println("testInList 1 failed.");
		}
		
		index = Eliza.inList( "seeya", quitWords);
		if ( index == -1) {
			System.out.println("testInList 2 passed.");
		} else {
			System.out.println("testInList 2 failed.");
		}
		
		index = Eliza.inList( "good", quitWords);
		if ( index == -1) {
			System.out.println("testInList 3 passed.");
		} else {
			System.out.println("testInList 3 failed.");
			System.out.println(index);
		}
		
		//test suggestion: 
		//what should happen if "good" is looked for within the quitWords
		//above?
		//Which index is returned if a word is listed more than once in the 
		//list?
		
		//can you think of other tests?
	}
	
	/**
	 * Combines the Strings in list together with a space between each
	 * and returns the resulting string. If list is null then null is
	 * returned.
	 * 
	 * @param list An array of words to be combined.
	 * @return A string containing all the words with a space between each.
	 */
	public static void testAssemblePhrase() {
		String [] words = {"This", "is a", "sentence"};
		String sentence = Eliza.assemblePhrase( words);

		String expectedSentence = "This is a sentence";
		
		if ( sentence.equals( expectedSentence)) {
			System.out.println("testAssembleSentence 1 passed.");
		} else {
			System.out.println("testAssembleSentence 1 failed '" + sentence + 
					"'");
		}
		
		//suggested test: what should happen when null is passed in?
	}
	
	/**
	 * Returns the longest sentence, based on the String length, from 
	 * the array of sentences. Removes spaces from the beginning and
	 * end of each sentence before comparing lengths. If sentences is null
	 * or has a length of 0 then null is returned.
	 * 
	 * Note: String trim method may be useful.
	 * 
	 * @param sentences The array of sentences passed in.
	 * @return The longest sentence without spaces at the beginning or end.
	 */
	public static void testFindLongest() {
		String [] sentences = {"short", "This is longer.", 
				"This is the longest one.", "s"};
		String longest = Eliza.findLongest( sentences);
		if ( longest == sentences[2]) {
			System.out.println("testFindLongest 1 passed.");
		} else {
			System.out.println("testFindLongest 1 failed.");
		}
		
		//what additional tests can you create?
	}
	/**
	 * Counts the number of times the substring is in the str. Does not 
	 * count overlapping substrings separately. If either parameter 
	 * substring or str is null then -1 is returned.
	 * 
	 * Note: String methods indexOf may be useful for finding whether
	 *       substring occurs within str. One of the indexOf methods
	 *       has a parameter that says where to start looking in the str.
	 *       This might be useful to find the substring again in str, 
	 *       once you have found a substring once.
	 * 
	 * @param str The string to be searched.
	 * @param substring The string to be searched for within str.
	 * @return The number of times substring is found within str or -1 if
	 *         either parameter is null parameter.
	 */
	public static void testHowMany() {
		int countSpaces = Eliza.howMany( " ", " you me ");
		if ( countSpaces == 3) {
			System.out.println( "testHowMany 1 passed.");
		} else {
			System.out.println( "testHowMany 1 failed.  countSpaces == " 
					+ countSpaces);
		}
		
		int countNum = Eliza.howMany("<2>", "What makes you think I am <2>?");
		if ( countNum == 1) {
			System.out.println( "testHowMany 2 passed.");
		} else {
			System.out.println( "testHowMany 2 failed.  countNum == " 
					+ countNum);
		}
		
		//additional tests

	}		

	/**
	 * This method performs the following processing to the userInput.
	 * - substitute spaces for all characters but (alphabetic characters, 
	 *   numbers, and ' , ! ? .).
	 * - Change (,!?.) to (!). Parenthesis not included.
	 * 
	 * @param userInput The characters that the user typed in.
	 * @return The character array containing the valid characters.
	 */	
	public static void testFilterChars() {
		String userInput = "w? #t   i't e   4t m-s!";
		char [] expectedChars = {'w','!',' ',' ','t',' ',' ',' ','i','\'','t',
				' ','e',' ',' ',' ','4','t',' ','m',' ','s','!'};
		char [] characters = Eliza.filterChars( userInput);
		if ( userInput.length() == characters.length) {
			System.out.println("testFilterChars 1 passed.");
		} else {
			System.out.println("testFilterChars 1 failed.");
		}
		boolean error = false;
		for ( int i = 0; i < expectedChars.length; i++) {
			if ( expectedChars[i] != characters[i]) {
				System.out.print( String.format("characters[%d] '%c'" + 
			" expected '%c'\n", i, characters[i], expectedChars[i]));
				error = true;
			}
		}
		if ( error) {
			System.out.println("testFilterChars 2 failed.");
		} else {
			System.out.println("testFilterChars 2 passed.");
		}
		
		//additional tests
	}
	
	/**
	 * Reduces all sequences of 2 or more spaces to 1 space within the 
	 * characters array. If any spaces are removed then the same number
	 * of Null character '\u0000' will fill the elements at the end of the
	 * array.
	 * 
	 * @param characters The series of characters that may have more than one
	 *     space in a row when calling. On return the array of characters will
	 *     not have more than one space in a row and there may be '\u0000'
	 *     characters at the end of the array.
	 */
	public static void testRemoveDuplicateSpaces() {
		char [] chars1 = {'a', 't', ' ', '.', ' ', ' ', 'g', ' ', 
				' ', 'h', ' '};
		Eliza.removeDuplicateSpaces( chars1);
		char [] expectedResult = {'a', 't', ' ', '.', ' ', 'g', ' ', 'h', ' ',
				'\u0000', '\u0000'};
		
		boolean error = false;
		String errorStr = "";
		for ( int i = 0; i < expectedResult.length; i++) {
			if ( chars1[i] != expectedResult[i]) {
				errorStr += String.format("chars1[%d] '%c' expected '%c'\n", i,
						chars1[i], expectedResult[i]);
				error = true;
			}
		}
		if ( error) {
			System.out.println("testRemoveDuplicateSpaces 1 failed. " + 
		errorStr);
		} else {
			System.out.println("testRemoveDuplicateSpaces 1 passed.");
		}
		
		//additional tests
	}
	
	/**
	 * Looks for each word in words within the wordList. 
	 * If any of the words are found then true is returned, otherwise false.
	 * 
	 * @param words List of words to look for.
	 * @param wordList List of words to look through.
	 * @return Whether one of the words was found in wordList.
	 */
	public static void testFindAnyWords() {
		String[] someWords = {"Going", "now", "goodbye"};
		boolean found = Eliza.findAnyWords( someWords, Config.QUIT_WORDS);
		if ( found) {
			System.out.println("testFindAnyWords 1 passed.");
		} else {
			System.out.println("testFindAnyWords 1 failed.");
		}
		
		String[] someMoreWords = {"Hello", "how", "are", "you"};
		found = Eliza.findAnyWords( someMoreWords, Config.QUIT_WORDS);
		if ( !found) {
			System.out.println("testFindAnyWords 2 passed.");
		} else {
			System.out.println("testFindAnyWords 2 failed.");
		}
		
	
		//additional tests
	}
	
	/**
	 * This method performs the following processing to the userInput and 
	 * returns the longest resulting sentence.
	 * 1) Converts all characters to lower case  
	 * 		See String toLowerCase() method.
	 * 2) Removes any extra spaces at the beginning or end of the input
	 * 		See String trim() method.
	 * 3) Substitute spaces for all characters but alphabetic characters, 
	 *    numbers, and ',.!? and then substitute ! for ,.?
	 *      See filterChars method.
	 * 4) Reduce all sequences of 2 or more spaces to be one space.
	 *      See removeDuplicateSpaces method.
	 * 5) Divide input into separate sentences based on !
	 *      Construct a String from a character array with 
	 *      	String str = new String( arrayName);
	 *      See String split method.
	 *      Example: String[] sentences = str.split("!");
	 * 6) Determine which sentence is longest in terms of characters and
	 *    return it. 
	 *      See findLongest method.
	 * 
	 * @param userInput The characters that the user typed in.
	 * @return The longest sentence from the input.
	 */
	public static void testInitialProcessing() {
		String sentence = Eliza.initialProcessing("What? This isn't the "
					+ "    4th messy-sentence!");
		if ( sentence != null 
				&& sentence.equals( "this isn't the 4th messy sentence")){
			System.out.println("testInitialProcessing 1 passed.");
		} else {
			System.out.println("testInitialProcessing 1 failed:" + sentence);
		}
		
		//additional tests
	}
	
	/**
	 * This method creates a new words list replacing any words it finds in
	 * the beforeList with words in the afterList. An array of the resulting
	 * words is returned.  
	 * 
	 * @param words List of words to look through.
	 * @param beforeList List of words to look for.
	 * @param afterList List of words to replace, if the corresponding word in  
	 * 				the before list is found in the words array.
	 * @return The new list of words with replacements.
	 */
	public static void testReplacePairs() {
		String [] someWords = {"i'm", "cant", "recollect"};
		String [] beforeList = {"dont", "cant", "wont", "recollect", "i'm"};
		String [] afterList = {"don't", "can't", "won't", "remember", "i am"};
		String [] result = Eliza.replacePairs( someWords, 
				beforeList, afterList);
		if ( result != null && result[0].equals("i") && result[1].equals("am") 
				&& result[2].equals("can't") && result[3].equals("remember")) {
			System.out.println("testReplacePairs 1 passed.");
		} else {
			System.out.println("testReplacePairs 1 failed.");
		}
		
		//additional tests
	}

	/**
	 * Checks to see if the pattern matches the sentence. In other words, 
	 * checks to see that all the words in the pattern are in the sentence 
	 * in the same order as the pattern. If the pattern matches then this
	 * method returns the phrases before, between and after the 
	 * pattern words. If the pattern does not match then null is returned.
	 * 
	 * @param pattern The words to match, in order, in the sentence.
	 * @param sentence Each word in the sentence.
	 * @return The phrases before, between and after the pattern words
	 * 		or null if the pattern does not match the sentence.
	 */	
	
	
	public static void testFindPatternInSentence() {
		String [] pattern1 = { "computer"};
		String [] sentence1 = {"are", "you", "a", "computer"};
		
		String [] matches = Eliza.findPatternInSentence( pattern1, sentence1);
		if ( matches != null && matches.length == 2 
				&& matches[0].equals( "are you a") && matches[1].equals("")) {
			System.out.println("testFindPatternInSentence 1 passed.");
		} else {
			System.out.println("testFindPatternInSentence 1 failed.");
			System.out.println( Arrays.toString(matches));
		}
		
		String [] pattern2 = { "computer"};
		String [] sentence2 = {"computer", "are", "you"};
		
		matches = Eliza.findPatternInSentence( pattern2, sentence2);
		if ( matches != null && matches.length == 2 && matches[0].equals("") 
				&& matches[1].equals( "are you")) {
			System.out.println("testFindPatternInSentence 2 passed.");
		} else {
			System.out.println("testFindPatternInSentence 2 failed.");
			System.out.println( Arrays.toString(matches));
		}
		
		String [] pattern5 = { "computer"};
		String [] sentence5 = {"does", "that", "computer", "on", "your", 
					"desk", "work"};
		matches = Eliza.findPatternInSentence( pattern5, sentence5);
		if ( matches != null && matches.length == 2 
				&& matches[0].equals( "does that") 
				&& matches[1].equals( "on your desk work")) {
			System.out.println("testFindPatternInSentence 3 passed.");
		} else {
			System.out.println("testFindPatternInSentence 3 failed.");
			System.out.println( Arrays.toString(matches));
		}

		String [] pattern6 = {"you", "me"};
		String [] sentence6 = {"why", "don't", "you", "like",  "me"};
		matches = Eliza.findPatternInSentence( pattern6, sentence6);
		if ( matches != null && matches.length == 3 
				&& matches[0].equals( "why don't") 
				&& matches[1].equals( "like") && matches[2].equals("")) {
			System.out.println("testFindPatternInSentence 4 passed.");
		} else {
			System.out.println("testFindPatternInSentence 4 failed.");
			System.out.println( Arrays.toString(matches));
		}
		
		String [] pattern7 = {"you", "me"};
		String [] sentence7 = {"me", "don't", "like", "you"};
		matches = Eliza.findPatternInSentence( pattern7, sentence7);
		if ( matches == null) {
			System.out.println("testFindPatternInSentence 5 passed.");
		} else {
			System.out.println("testFindPatternInSentence 5 failed.");
			System.out.println( Arrays.toString(matches));
		}
		
		String [] pattern8 = {"faith", "lack"};
		String [] sentence8 = {"i", "find", "your", "lack", "of", "faith", 
				"disturbing"};
		matches = Eliza.findPatternInSentence( pattern8, sentence8);
		if ( matches == null) {
			System.out.println("testFindPatternInSentence 6 passed.");
		} else {
			System.out.println("testFindPatternInSentence 6 failed.");
			System.out.println( Arrays.toString(matches));
		}
		
	}
	
	/**
	 * Replaces words in the phrase if they are in the 
	 * Config.POST_PROCESS_BEFORE with the corresponding words from 
	 * Config.POST_PROCESS_AFTER.
	 * 
	 * @param phrase One or more words separated by spaces.
	 * @return A string composed of the words from phrase with replacements.
	 */
	public static void testPrepareUserPhrase()  {
		String someWords = "i'm happy";
		String result = Eliza.prepareUserPhrase( someWords);
		if ( result != null && result.equals("you are happy")) {
			System.out.println("testPrepareUserPhrase 1 passed.");
		} else {
			System.out.println("testPrepareUserPhrase 1 failed. '" + result + 
					"'");
		}
		
	}
	
	/**
	 * Prepares a response based on the draftResponse. If draftResponse
	 * contains <1>, <2>, <3> or <4> then the corresponding userPhrase
	 * is substituted for the <1>, <2>, etc.  The userPhrase however must
	 * be prepared by exchanging words that are in Config.POST_PROCESS_BEFORE
	 * with the corresponding words from Config.POST_PROCESS_AFTER.
	 * 
	 * @param draftResponse A response sentence potentially containing <1>, 
	 *             <2> etc.
	 * @param userPhrases An array of phrases from the user input.
	 * @return A string composed of the words from sentence with replacements.
	 */
	public static void testPrepareResponse() {
		String draftResponse = "Really, <3>?";
		String []userPhrases = {"", "", "about my dog"};
		String response = Eliza.prepareResponse( draftResponse, userPhrases);
		
		String expectedResponse = "Really, about your dog?";
		
		if ( response.equals( expectedResponse)) {
			System.out.println("testPrepareResponse 1 passed.");
		} else {
			System.out.println("testPrepareResponse 1 failed. '" + response + 
					"'");
		}
		
		String draftResponse1 = "<3>, what about it?";
		String []userPhrases1 = {"","about my dog", ""};
		String response1 = Eliza.prepareResponse( draftResponse, userPhrases);
		
		String expectedResponse1 = "about my dog, what about it?";
		
		if ( response.equals( expectedResponse)) {
			System.out.println("testPrepareResponse 2 passed.");
		} else {
			System.out.println("testPrepareResponse 2 failed. '" + response1 +
					"'");
		}
		//additional tests
	}
	
	/**
	 * Looks through Config.RESPONSE_TABLE to find the first pattern 
	 * that matches the words. When a pattern is matched then a response 
	 * is randomly chosen from the corresponding list of responses.
	 * If the response has a parameter denoted with <1>, <2> 
	 * etc. the parameter is replaced with the 0th, 1st, etc String
	 * from the user phrases returned by the findPatternInSentence method.
	 * 
	 * @param words The words of a sentence.
	 * @return The completed response ready to be shown to the user.
	 */
	public static void testMatchResponse() {
		String []words1 = {"are", "you", "a", "computer"};
		String response1 = Eliza.matchResponse( words1);	
		
		
		if ( Eliza.inList( response1, Config.RESPONSE_TABLE[0][1]) >= 0) {
			System.out.println("testMatchResponse 1 passed.");
		} else {
			System.out.println("testMatchResponse 1 failed.");
		}
		
		String []words2 = {"you", "are", "like", "my", "father"};
		String response2 = Eliza.matchResponse( words2);
		
		
		if ( response2 != null && response2.contains( "like your father")) {
			System.out.println("testMatchResponse 2 passed.");
		} else {
			System.out.println("testMatchResponse 2 failed.");
		}
		

	}
	
	private static void testProblem(String problem) {
		//supporting method for testProcessInput
		System.out.println("Patient:  " + problem);
		System.out.println("Eliza: " + Eliza.processInput( problem));
	}
	
	/**
	 * Takes the input as a parameter and returns a response. If any of the
	 * QUIT_WORDS are found then null is returned. 
	 * 
	 * @param userInput The problem sentence(s) the user types in.
	 * @return A response string to be shown to the user or null if a QUIT_WORD
	 *         is found.
	 */
	public static void testProcessInput() {
		//note: the responses may vary as they are randomly selected and the 
		//random generator results will vary based on the previous times it 
		//has been called. Therefore, see if each response is appropriate.
		
		//The following are selected phrases from: 
		//http://web.stanford.edu/group/SHR/4-2/text/dialogues.html
		testProblem("Men are all alike.");
		testProblem("They're always bugging us about something" +
		" specific or other.");
		testProblem("Well, my boyfriend made me come here.");
		testProblem("He says I'm depressed much of the time.");
		testProblem("It's true. I'm unhappy.");
		testProblem("I need some help, that much seems certain.");
		testProblem("Perhaps I could learn to get along with my mother.");
		testProblem("My mother takes care of me.");
		testProblem("My father.");
		testProblem("You are like my father in some ways.");
		testProblem("You are not very aggressive but I think you don't want me" 
				+ " to notice that.");
		testProblem("You don't argue with me.");
		testProblem("You are afraid of me.");
		testProblem("My father is afraid of everybody.");
		testProblem("Bullies.");
	}
		
	/**
	 * Main method is used to invoke different types of methods used for  
	 * ElizaTests. By invoking different methods, the program will look for 
	 * patterns of words to reply with a prepared response.
	 *
	 * @param none used
	 * @return none used
	 */
	public static void main(String[] args) {
		//feel free to comment out tests that are not of current interest
		//in order to focus on certain tests.  Eventually, all the tests
		//should run successfully.

		testChooseString();
		
		testInList();
		testAssemblePhrase();
		testFindLongest();
		testHowMany();

		testFilterChars();
		testRemoveDuplicateSpaces();
		testFindAnyWords();
		testInitialProcessing();

		testReplacePairs();
		testFindPatternInSentence();
		testPrepareUserPhrase();
		testPrepareResponse();

		testMatchResponse();
		testProcessInput();

	}
}
