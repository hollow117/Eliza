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


import java.util.Arrays;
import java.util.Scanner; 

/**
 * Class ElizaTests will look for patterns of words and reply with a prepared
 * response based on the matched pattern.
 *
 * no known bugs
 *
 * @author Jason Choe
 */

public class Eliza {

	/**
	 * This method randomly picks one of the strings from the list. If list is
	 * null or has 0 elements then null is returned.
	 * 
	 * @param list
	 *            An array of strings to choose from.
	 * @return One of the strings from the list.
	 */
	public static String chooseString(String[] list) {

		// if list is null or empty, return null
		if (list == null || list.length == 0) { 
			return null;
		}

		// choosing random string inside the String list using 
		// random number generator that uses length of list as input. 
		int index = Config.RNG.nextInt(list.length);

		// return String list that is in integer index's place in String
		// list array
		return list[index];
	}

	/**
	 * If the word is found in the wordList then the index of the word is
	 * returned, otherwise -1 is returned. If there are multiple matches the
	 * index of the first matching word is returned. If either word or wordList
	 * is null then -1 is returned.
	 * 
	 * @param word
	 *            A word to search for in the list.
	 * @param wordList
	 *            The list of Strings in which to search.
	 * @return The index of list where word is found, or -1 if not found.
	 */
	public static int inList(String word, String[] wordList) {
		
		// when both parameters are not null or empty, enter if statement
		if (word != null && word.length() != 0 && wordList != null && 
				wordList.length != 0) {		

			int wordListIndex = -1;

			// by using loop, program will look to see if what is in the 
			// wordList has a match for word and if it does, it will 
			// terminate the loop and return the index value
			for (int i = 0; i < wordList.length; i++) {
				if (wordList[i].equals(word)) {
					wordListIndex = i;
					break;
				}
			}
			return wordListIndex;

			// when both parameters are null or empty, return -1
		} else {
			return -1;
		}

	}

	/**
	 * Combines the Strings in list together with a space between each and
	 * returns the resulting string. If list is null then null is returned.
	 * 
	 * @param list
	 *            An array of words to be combined.
	 * @return A string containing all the words with a space between each.
	 */
	public static String assemblePhrase(String[] list) {
		
		// if list is not null, String elements in the list array will 
		// be added onto the new array called makeNewArray with space next to 
		// each element. This method will return String value with removing 
		// spaces on left end and right end by using trim.
		if (list != null) {
			String makeNewArray = "";
			for (int i = 0; i < list.length; i++) {
				makeNewArray += list[i] + " ";
			}
			return makeNewArray.trim();
			
			// if list is null, the method will return null.
		} else {
			return null;
		}
	}

	/**
	 * Returns the longest sentence, based on the String length, from the array
	 * of sentences. Removes spaces from the beginning and end of each sentence
	 * before comparing lengths. If sentences is null or has a length of 0 then
	 * null is returned.
	 * 
	 * Note: String trim method may be useful.
	 * 
	 * @param sentences
	 *            The array of sentences passed in.
	 * @return The longest sentence without spaces at the beginning or end.
	 */
	public static String findLongest(String[] sentences) {

		// creating a new String array
		String[] trimmedSentences = new String[sentences.length];

		// by using for loop, it will remove spaces from the beginning and end
		// of each sentence 
		for (int i = 0; i < trimmedSentences.length; i++) {
			trimmedSentences[i] = sentences[i].trim();
		}

		// if sentences is not null or 0 length, the program will compare
		// length of each element in sentences by comparing the first element's
		// length with the rest of element using for loop. The loop will 
		// go around and update at which index the element contains 
		// longest length of element
		if (sentences != null || trimmedSentences.length != 0) {
			int index = 0;
			int elementLength = trimmedSentences[0].length();
			for (int i = 1; i < trimmedSentences.length; i++) {
				if (trimmedSentences[i].length() > elementLength) {
					index = i;
					elementLength = trimmedSentences[i].length();
				} else if (sentences[i].length() == elementLength) {
					break;
				}
			}
			return trimmedSentences[index];

			// if sentence is null or has 0 length, return null
		} else {
			return null;
		}
	}

	/**
	 * Counts the number of times the substring is in the str. Does not count
	 * overlapping substrings separately. If either parameter substring or str
	 * is null then -1 is returned.
	 * 
	 * Note: String methods indexOf may be useful for finding whether substring
	 * occurs within str. One of the indexOf methods has a parameter that says
	 * where to start looking in the str. This might be useful to find the
	 * substring again in str, once you have found a substring once.
	 * 
	 * @param str
	 *            The string to be searched.
	 * @param substring
	 *            The string to be searched for within str.
	 * @return The number of times substring is found within str or -1 if either
	 *         parameter is null parameter.
	 */
	public static int howMany(String substring, String str) {
		
		// if substring or str is not null, method will count number of 
		// substring found in str using for loop.
		if (substring != null || str != null) {
			int count = 0;
			for (int index = 0; index < str.length() ; index++) {
				
				// using indexOf, when the substring is found in str from 
				// initial index, it will count the number of substring found
				// and update start index value.
				int found = str.indexOf(substring, index);
				if (found >= 0 && found < str.length() ) {
					count++;
					index = found;
				}
			}
			return count;
		
			// if substring or str is null, it will return -1.	
		} else {
			return -1;
		}
	}

	/**
	 * This method performs the following processing to the userInput. -
	 * substitute spaces for all characters but (alphabetic characters, numbers,
	 * and ' , ! ? .). - Change (,!?.) to (!). Parenthesis not included.
	 * 
	 * @param userInput
	 *            The characters that the user typed in.
	 * @return The character array containing the valid characters.
	 */
	public static char[] filterChars(String userInput) {

		// initializing string variables spaceCharacter, exclamation, and
		// backslash
		String spaceCharacter = " ";
		String exclamation = "!";
		String backslash = "\\";
		// if userInput is not null or is not 0 length
		// using for loop, it will go through each character of userInput
		// and change (,!?.) to (!) and (#, -, space) to spaceCharacter and
		// (') to (\) to the newUserInput. Return newUserInput.
		if (userInput != null && userInput.length() != 0){
		char[] newUserInput = new char[userInput.length()];
		for (int i = 0; i < userInput.length(); i++) {

			char c = userInput.charAt(i);

			if (Character.isAlphabetic(c) == true || 
					Character.isDigit(c) == true) {
				newUserInput[i] = c;
			} else if ((c == ' ') || (c == 043) || (c == 055)) {
				newUserInput[i] = spaceCharacter.charAt(0);
			} else if ((c == ',') || (c == '!') || (c == '?') || (c == '.')) {
				newUserInput[i] = exclamation.charAt(0);
			} else if (c == 047) {
				newUserInput[i] = '\'';
			}
		}
		return newUserInput; 
		
		// if userInput is null or is 0 length, return null
		}else {
			return null;
			}
		}

	/**
	 * Reduces all sequences of 2 or more spaces to 1 space within the
	 * characters array. If any spaces are removed then the same number of Null
	 * character '\u0000' will fill the elements at the end of the array.
	 * 
	 * @param characters
	 *            The series of characters that may have more than one space in
	 *            a row when calling. On return the array of characters will not
	 *            have more than one space in a row and there may be '\u0000'
	 *            characters at the end of the array.
	 */
	public static void removeDuplicateSpaces(char[] characters) {

		// initialize count to 0 and by using for loop that goes through each
		// element in characters array, whenever it detects space characters
		// on two different elements, it will re-organize the array by moving
		// element down one index and reduce the lastElementIndex by one.
		// lastElementIndex is reduced by one so that during the loop, it won't
		// confuse spaces caused by characters moving forward as duplicate
		// spaces
		int count = 0;
		int lastElementIndex = characters.length - 1;
		for (int i = 0; i < lastElementIndex; i++) {
			while (characters[i] == ' ' && characters[lastElementIndex - 
			                              (lastElementIndex - i - 1)] == ' ') {
				for (int j = i; j < lastElementIndex; j++) {
					characters[j] = characters[lastElementIndex - 
					                           (lastElementIndex - j - 1)];
				}
				count++;
				lastElementIndex--;
			}
		}

		// re-initializing lastElementIndex to its original value and
		// with for loop and count (counted the number of duplicate spaces)
		// program will assign '\u0000' from the end of index
		lastElementIndex = characters.length - 1;
		for (int n = 0; n < count; n++) {
			characters[lastElementIndex - n] = '\u0000';
		}
	}

	/**
	 * Looks for each word in words within the wordList. If any of the words are
	 * found then true is returned, otherwise false.
	 * 
	 * @param words
	 *            List of words to look for.
	 * @param wordList
	 *            List of words to look through.
	 * @return Whether one of the words was found in wordList.
	 */
	public static boolean findAnyWords(String[] words, String[] wordList) {
		
		// using outer for loop that goes through each element of 
		// array wordList and inner for loop that goes through each element of 
		// array words, whenever program detects the same element on both
		// arrays, it will count the number of same element found. If count
		// value is bigger than 0, it will assign true to yes and the program
		// will return that value.
		boolean yes = false;
		int count = 0;
		for (int i = 1; i < wordList.length; i++) {
			for (int j = 1; j < words.length; j++) {
				if (wordList[i] == words[j]) {
					count++;
				}
			}
		}
		if (count > 0) {
			yes = true;
			return yes;
			
		// if there were no same element found from array words and wordList,
		// program will return false.
		} else {
			return yes;
		}
		
		
	}

	/**
	 * This method performs the following processing to the userInput and
	 * returns the longest resulting sentence. 1) Converts all characters to
	 * lower case See String toLowerCase() method. 2) Removes any extra spaces
	 * at the beginning or end of the input See String trim() method. 3)
	 * Substitute spaces for all characters but alphabetic characters, numbers,
	 * and ',.!? and then substitute ! for ,.? See filterChars method. 4) Reduce
	 * all sequences of 2 or more spaces to be one space. See
	 * removeDuplicateSpaces method. 5) Divide input into separate sentences
	 * based on ! Construct a String from a character array with String str =
	 * new String( arrayName); See String split method. Example: String[]
	 * sentences = str.split("!"); 6) Determine which sentence is longest in
	 * terms of characters and return it. See findLongest method.
	 * 
	 * @param userInput
	 *            The characters that the user typed in.
	 * @return The longest sentence from the input.
	 */
	public static String initialProcessing(String userInput) {
		
		// if userInput is not null, userInput's string value will be trimmed
		// and changed to lower case initially. Then that userInput will go 
		// through filterChars and removeDuplicateSpaces methods to 
		// make slight modification and that value will be placed into 
		// new string str. The value will then be split whenever program 
		// detects ! character and by using findLongest method, program will
		// find the longest resulting sentence and return the result.
		
		if (userInput != null) {
			String userInputTrimmedLowerCase = userInput.toLowerCase().trim();
			char[] characters = Eliza.filterChars(userInputTrimmedLowerCase);
			Eliza.removeDuplicateSpaces(characters);
			String str = new String(characters);
			String[] sentences = str.split("!");
			String longest = Eliza.findLongest(sentences);

			return longest;
			
		// if userInput is null, program will return null.
		} else {
			return null;
		}
	}

	/**
	 * This method creates a new words list replacing any words it finds in the
	 * beforeList with words in the afterList. An array of the resulting words
	 * is returned.
	 * 
	 * @param words
	 *            List of words to look through.
	 * @param beforeList
	 *            List of words to look for.
	 * @param afterList
	 *            List of words to replace, if the corresponding word in the
	 *            before list is found in the words array.
	 * @return The new list of words with replacements.
	 */
	public static String[] replacePairs(String[] words, String[] beforeList, 
			String[] afterList) {
		
		// if array words, beforeList, and afterList are not null, the program
		// will go through outer for loop that goes through every element in
		// array words and inner loop that goes through every element in 
		// array beforeList and when it detects the same element, 
		// the element in array words will be replaced with what is found in 
		// afterList on index where the same element was found in beforeList.
		// Program will return list of words with replacements.
		if (words != null && beforeList != null && afterList != null) {
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < beforeList.length; j++) {
					if (words[i] == beforeList[j]) {
						words[i] = afterList[j];
					}
				}
			}
			return Eliza.assemblePhrase(words).split(" ");
			
		// if arrays are null, program will return null.
		} else {
			return null;
		}
	}

	/**
	 * Checks to see if the pattern matches the sentence. In other words, checks
	 * to see that all the words in the pattern are in the sentence in the same
	 * order as the pattern. If the pattern matches then this method returns the
	 * phrases before, between and after the pattern words. If the pattern does
	 * not match then null is returned.
	 * 
	 * @param pattern
	 *            The words to match, in order, in the sentence.
	 * @param sentence
	 *            Each word in the sentence.
	 * @return The phrases before, between and after the pattern words or null
	 *         if the pattern does not match the sentence.
	 */
	public static String[] findPatternInSentence(String[] pattern, 
			String[] sentence) {
		// initially phrase will have length that is one bigger than the
		// length of the pattern
		String[] phrase = new String[pattern.length + 1];
		for (int i = 0; i < phrase.length; i++) {
			phrase[i] = "";
		}
		
		// whenever program sees a matching word, it will concatenate all the 
		// elements prior. When pattern index equals pattern length, it will
		// return null. 
		int patternIndex = 0;
		int userPhraseIndex = 0;
		for (int i = 0; i < sentence.length; i++) {
			if (patternIndex < pattern.length && 
					sentence[i].equals(pattern[patternIndex])) {
				userPhraseIndex++;
				patternIndex++;
			} else {
				if (phrase[userPhraseIndex].equals(""))
					phrase[userPhraseIndex] = sentence[i];
				else
					phrase[userPhraseIndex] += " " + sentence[i];
			}
		}
		if (patternIndex == pattern.length) {
			return phrase;
		} else {
			return null;
		}
	}

		
	

	/**
	 * Replaces words in the phrase if they are in the
	 * Config.POST_PROCESS_BEFORE with the corresponding words from
	 * Config.POST_PROCESS_AFTER.
	 * 
	 * @param phrase
	 *            One or more words separated by spaces.
	 * @return A string composed of the words from phrase with replacements.
	 */
	public static String prepareUserPhrase(String phrase) {
		
		// phrase will be changed to array form by using split.
		String[] phraseArray = phrase.split(" ");

		// by using loop, if any words found in phraseArray equals
		// words found in POST_PROCESS_BEFORE, those words will be 
		// replaced with words found in POST_PROCESS_AFTER
		for (int i = 0; i < phraseArray.length; i++) {
			for (int j = 0; j < Config.POST_PROCESS_BEFORE.length; j++) {
				if (phraseArray[i].equals(Config.POST_PROCESS_BEFORE[j])) {
					phraseArray[i] = Config.POST_PROCESS_AFTER[j];
				}
			}
		}
		
		// creating newPhrase by first switching changed phraseArray to 
		// string and replace any comma space with space.
		String newPhrase = Arrays.toString(phraseArray).replaceAll(", ", " ");

		return newPhrase.substring(1, newPhrase.length() - 1); 
	}

	/**
	 * Prepares a response based on the draftResponse. If draftResponse contains
	 * <1>, <2>, <3> or <4> then the corresponding userPhrase is substituted for
	 * the <1>, <2>, etc. The userPhrase however must be prepared by exchanging
	 * words that are in Config.POST_PROCESS_BEFORE with the corresponding words
	 * from Config.POST_PROCESS_AFTER.
	 * 
	 * @param draftResponse
	 *            A response sentence potentially containing <1>, <2> etc.
	 * @param userPhrases
	 *            An array of phrases from the user input.
	 * @return A string composed of the words from sentence with replacements.
	 */
	public static String prepareResponse(String draftResponse, 
			String[] userPhrases) {

		// if draftResponse is not null or empty and contains string < and 
		// if userPhrases is not null or empty, split make draftResponse into
		// array form and if there is <#> within draftResponseArray,
		// replace <#> with userPhrases
		if (draftResponse != null && draftResponse.length() != 0 && 
				userPhrases != null && userPhrases.length != 0
				&& draftResponse.contains("<")) {
			String[] draftResponseArray = draftResponse.split(", ");
			String result = "";
			for (int i = 0; i < draftResponseArray.length; i++) {
				if (draftResponseArray[i].contains("<")) {
					int start = draftResponseArray[i].indexOf("<");
					String found = userPhrases[Integer.parseInt(
							draftResponseArray[i].substring(start + 1, 
									start + 2))
					                           - 1];
					result = Eliza.prepareUserPhrase(found);
				}
			}
			String output = "";
			for (int j = 0; j < draftResponse.length(); j++) {
				if (draftResponse.charAt(j) == '<') {
					output = draftResponse.replaceAll(
							draftResponse.substring(j, j + 3), result);
					break;
				}
			}
			return output;
			
		// if <#> is not found in the draftResponse, unmodified draftResponse
		// will be returned.
		} else {
			return draftResponse;
		}
	}

	/**
	 * Looks through Config.RESPONSE_TABLE to find the first pattern that
	 * matches the words. When a pattern is matched then a response is randomly
	 * chosen from the corresponding list of responses. If the response has a
	 * parameter denoted with <1>, <2> etc. the parameter is replaced with the
	 * 0th, 1st, etc String from the user phrases returned by the
	 * findPatternInSentence method.
	 * 
	 * @param words
	 *            The words of a sentence.
	 * @return The completed response ready to be shown to the user.
	 */
	public static String matchResponse(String[] words) {
		//boolean end=false;
		
		//if elements in words are not null or don't have 0 length,
		if (words != null && words.length != 0) {
			String response="";
			for (int responseSetIndex = 0 ; responseSetIndex < 
					Config.RESPONSE_TABLE.length; responseSetIndex++) {
				String[][]allResponse = Config.RESPONSE_TABLE[responseSetIndex];
				String[]pattern = allResponse[0];
				String[]responseSet = allResponse[1];

				String [] matches= Eliza.findPatternInSentence(pattern, words);
				if (matches==null){
					continue;
				}
				String choice = Eliza.chooseString( responseSet);
				response = Eliza.prepareResponse( choice, matches);

				return response;
			}
			return response;
			
				
			} else {
			return Eliza.chooseString(Config.NO_MATCH_RESPONSES);
		}


	}

	/**
	 * Takes the input as a parameter and returns a response. If any of the
	 * QUIT_WORDS are found then null is returned.
	 * 
	 * @param userInput
	 *            The problem sentence(s) the user types in.
	 * @return A response string to be shown to the user or null if a QUIT_WORD
	 *         is found.
	 */
	public static String processInput(String userInput) {

		// input userInput will be first go through initialProcessing method
		// and if any QUIT_WORDS are found within initial processed userInput,
		// program will return null. If that is not the case, program will 
		// replace any PRE_PROCESS_BEFORE value found in result with 
		// PRE_PROCESS_AFTER value. Final result will be returned by
		// using matchResponse method  
		
		boolean found=false;
		String result = Eliza.initialProcessing(userInput);


		found = Eliza.findAnyWords( result.split(" "), Config.QUIT_WORDS);
		if (found){
			return null; 
		}

		String [] replace = Eliza.replacePairs( result.split(" "), 
				Config.PRE_PROCESS_BEFORE, Config.PRE_PROCESS_AFTER);
		
		String outcome = Eliza.matchResponse(replace);

		return outcome; 
	} 



	/**
	 * This method displays an INITIAL_MESSAGE, accepts typed input, calls the
	 * processInput method, and prints out the response (of processInput) until
	 * the response is null at which point the FINAL_MESSAGE is shown and the
	 * program terminates.
	 */
	public static void interactive() {
		System.out.println(Config.PROGRAM_NAME + Config.INITIAL_MESSAGE);
		Scanner input = new Scanner(System.in);

		String choice = null;
		String response;
		do {
			System.out.print(Config.USER_NAME);
			choice = input.nextLine();
			response = Eliza.processInput(choice);

			if (response != null)
				System.out.println(Config.PROGRAM_NAME + response);

		} while (response != null);
		System.out.println(Config.FINAL_MESSAGE);

		input.close();

	}

	/**
	 * Program execution starts here.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {

		interactive();

	}
}
