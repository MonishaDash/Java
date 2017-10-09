package bigfoot.wordsearch;

import java.util.Objects;

/**
 * Describes the start and end locations of a word in the grid where the top left coordinate is 0,0 
 * and N,N where N is the height and width of the grid. 
 */
public class WordVector {
    public String word;
    public int startX;
    public int startY;
    public int endX;
    public int endY; 

    public WordVector(String word, int startX, int startY, int endX, int endY) {

        this.word = word;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public String toString() {

        return "word='" + word + '\'' + ", start=[" + startX + ", " + startY + "], end=" + endX + ", " + endY + "]";
    }
}
