package bigfoot.wordsearch;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

/**
 * Implement the functions in this class marked TODO
 */
public class WordFinder {

	/**
	 * Initializes the WordFinder with a word-grid specified as a String of the character lines going from left-right. The
	 * lines are concatenated together from top to bottom. E.g. the String "ABCDEFGHIJKL" would describe the grid:
	 *
	 * ABCD
	 * EFGH
	 * IJKL
	 *
	 * The characters should always form a perfect square grid. Otherwise, you code should throw an exception.
	 */

	private char[][] puzzleboard;

	public WordFinder(String wordGrid) throws Exception  {
		if (wordGrid==null || wordGrid.isEmpty()){
			System.out.println("Bad input");
			throw new Exception();
		}
		double sqrt = Math.sqrt(wordGrid.length());
		int x = (int) sqrt;
		if(Math.pow(sqrt,2) == Math.pow(x,2)){
			System.out.println("Good");
			int M =x ;
			int N = x;
			puzzleboard = new char[M][N];
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					puzzleboard[r][c] = wordGrid.charAt((M*r)+c);
				}
			}

		}else{
			System.out.println("Bad input");
			throw new Exception();
		}

	}

	/**
	 * Given a collection of words, will find and return the location of the words in the initialized wordGrid.
	 * The words can extend in all 8 directions, horizontally, vertically, and diagonally, forwards or backwards.
	 */
	public List<WordVector> findWords(Collection<String> words) {
		//final list to return
		List<WordVector> foundWords = new ArrayList<WordVector>();
		//List of words
		ArrayList<String> wordList = new ArrayList<String> (words);
		// variables
		String current = "";
		char curLetter;
		// direction variables
		boolean left;
		boolean right;
		boolean up;
		boolean down;
		boolean verticaldownright;
		boolean verticaldownleft;
		boolean verticalupleft;
		boolean verticalupright;
		boolean findword;
		//location of x,y in the puzzle board
		int qIndex;
		int pIndex;
		String temp = new String();

		for(int listIndex=0;listIndex<wordList.size();listIndex++){
			// current word
			current = wordList.get(listIndex);
			int currWordLength=current.length();
			// first letter of current word
			curLetter = current.charAt(0);
			up = false;
			down = false;
			left = false;
			right = false;
			verticalupleft = false;
			verticalupright = false;
			verticaldownleft = false;
			verticaldownright = false;
			int size = puzzleboard.length;
			for(int mIndex =0; mIndex<size;mIndex++)
			{
				for(int nIndex =0; nIndex<size;nIndex++){
					if(puzzleboard[mIndex][nIndex] == curLetter)
					{
						// Location saved
						qIndex = nIndex;
						pIndex = mIndex;
					
						findword = false;
						up = false;
						down = false;
						left = false;
						right = false;
						verticalupleft = false;
						verticalupright = false;
						verticaldownleft = false;
						verticaldownright = false;

						//possible for up
						if(mIndex+1 >= currWordLength)
						{
							up = true;
						}
						//possible for down 
						if((mIndex + currWordLength) <= size)
						{
							down = true;
						}
						// possible for left
						if(nIndex+1 >= currWordLength)
						{
							left = true;
						}
						//possible to go right
						if((nIndex + currWordLength) <= size)
						{
							right = true;
						}
						//verticalupleft 
						if(up && left)
						{
							verticalupleft = true;
						}
						// verticalupright 
						if(up && right)
						{
							verticalupright = true;
						}
						//  verticaldownleft 
						if(down && left)
						{
							verticaldownleft = true;
						}
						// verticaldownright 
						if(down && right)
						{
							verticaldownright = true;
						}

						//up
						if(up && !findword)
						{

							temp = "";
							for(int i = 0; i < currWordLength; i++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								pIndex--;
							}


							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						}//up&&findword

						//down
						qIndex = nIndex;
						pIndex = mIndex;                        
						if(down && !findword)
						{                            
							temp = "";
							for(int i = 0; i < currWordLength; i++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								pIndex++;
							}


							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						}//down$$findword
						//left
						qIndex = nIndex;
						pIndex = mIndex;

						if(left && !findword)
						{

							temp = "";
							for(int i = 0; i < currWordLength; i++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								qIndex--;
							}


							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						} //left

						//right
						qIndex = nIndex;
						pIndex = mIndex;

						if(right && !findword)
						{

							temp = "";
							for(int i = 0; i < currWordLength; i++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								qIndex++;
							}


							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						}//right

						//verticalupleft
						qIndex = nIndex;
						pIndex = mIndex;

						if(verticalupleft && !findword)
						{

							temp = "";
							for(int i = 0; i < currWordLength; i++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								qIndex--;
								pIndex--;
							}


							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						}

						//verticalupright
						qIndex = nIndex;
						pIndex = mIndex;

						if(verticalupright && !findword)
						{

							temp = "";
							for(int index = 0; index < currWordLength; index++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								qIndex++;
								pIndex--;
							}


							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						}//

						//verticaldownleft
						qIndex = nIndex;
						pIndex = mIndex;

						if(verticaldownleft && !findword)
						{

							temp = "";
							for(int index = 0; index < currWordLength; index++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								qIndex--;
								pIndex++;
							}   
							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						}

						//verticaldownright
						qIndex = nIndex;
						pIndex = mIndex;

						if(verticaldownright && !findword)
						{
							temp = "";
							for(int index = 0; index < currWordLength; index++)
							{
								temp+=puzzleboard[pIndex][qIndex];
								qIndex++;
								pIndex++;
							}

							if(current.equals(temp))
							{
								WordVector puzWord = new WordVector(current,mIndex,nIndex,pIndex,qIndex);
								foundWords.add(puzWord);

								
								findword = true;
							}
						}



					}
				}

			}

		}

		return foundWords;
	}
}
