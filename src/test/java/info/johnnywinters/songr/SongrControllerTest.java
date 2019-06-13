package info.johnnywinters.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class SongrControllerTest {

    @Test
    public void test_getHelloWorld() {
        SongrController sc = new SongrController();
        assertEquals("Hello, World!",
                sc.getHelloWorld());
    }

    @Test
    public void test_capitalizePath() {
        SongrController sc = new SongrController();
        assertEquals("HELLO, WORLD!",
                sc.capitalizePath("Hello, World!"));
    }

    @Test
    public void test_capitalizePath_null() {
        SongrController sc = new SongrController();
        assertNull(sc.capitalizePath(null));
    }

    @Test
    public void test_reverseSentence() {
        SongrController sc = new SongrController();
        assertEquals("World! Hello,",
                sc.reverseSentence("Hello, World!"));
    }

    @Test
    public void test_reverseSentence_null() {
        SongrController sc = new SongrController();
        assertNull(sc.reverseSentence(null));
    }
}