package test.main;

import main.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    public void testMainBasicFlow() {
        String simulatedInput = "1\nLara\n2023001\n9\n8\n10\n2\n3";

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        String output = out.toString();

        assertTrue(output.contains("Escolha uma das opções"));
        assertTrue(output.contains("Lara"));
        assertTrue(output.contains("Média: 9.0"));
        assertTrue(output.contains("Situação: Aprovado"));

        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
