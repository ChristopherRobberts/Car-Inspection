package se.kth.ict.carinspection.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringBuilderHelperTest {
    private StringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new StringBuilder();
        builder.append("This is a test");
    }

    @AfterEach
    void tearDown() {
        builder = null;
    }

    @Test
    void endSection() {
        StringBuilderHelper.endSection(builder);
        String expResult = "This is a test\n";
        String result = builder.toString();

        assertEquals(expResult, result);
    }

    @Test
    void appendLine() {
        StringBuilderHelper.appendLine(builder, "test2");

        String expResult = "This is a testtest2\n";
        String result = builder.toString();
        assertEquals(expResult, result);
    }

    @Test
    void stylizeLine() {
        StringBuilderHelper.stylizeLine(builder, "hej52", "---");

        String expResult = "This is a test---\nhej52\n---\n";
        String result = builder.toString();
        assertEquals(expResult, result);
    }

}