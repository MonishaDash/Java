package bigfoot.wordsearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordFinderTest {

    @Test
    public void testFindWords() throws Exception {

        WordFinder grid = new WordFinder("BIGFOOTKGNLNWQDRFSISIBAMBUSSACEZRLFNEAIQVIACCRPNANANABYSAREAKSXT");
        List<WordVector> found = grid.findWords(Arrays.asList("BIGFOOT", "INSULIN", "RACECAR", "ISF", "CARBS", "ICING", "BANANA"));

        Assert.assertEquals(2, found.stream().filter(i -> "ISF".equals(i.word)).count());
        Assert.assertEquals(2, found.stream().filter(i -> "RACECAR".equals(i.word)).count());
        Assert.assertEquals(1, found.stream().filter(i -> "BIGFOOT".equals(i.word)).count());
        Assert.assertEquals(1, found.stream().filter(i -> "INSULIN".equals(i.word)).count());
        Assert.assertEquals(1, found.stream().filter(i -> "CARBS".equals(i.word)).count());
        Assert.assertEquals(1, found.stream().filter(i -> "ICING".equals(i.word)).count());
        Assert.assertEquals(2, found.stream().filter(i -> "BANANA".equals(i.word)).count());
    }

    @Test
    public void testInvalidInput() {

        try {
            WordFinder grid = new WordFinder("ABCDEFGHIJ");
            Assert.fail("Invalid input should throw an Exception");
        } catch (Throwable t) {
            // Success!
        }
    }
}
