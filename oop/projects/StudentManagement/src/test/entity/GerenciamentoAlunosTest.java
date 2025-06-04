package test.entity;

import entity.Aluno;
import entity.GerenciamentoAlunos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciamentoAlunosTest {

    private GerenciamentoAlunos gerenciamento;

    @BeforeEach
    public void setUp() {
        gerenciamento = new GerenciamentoAlunos();
    }

    @Test
    public void testAdicionarAlunoECalculoCorreto()
    {
        String simulatedInput = "Ana\n2022001\n8\n9\n7\n";
        InputStream originalIn = System.in;
        gerenciamento.setScanner(new Scanner(new ByteArrayInputStream(simulatedInput.getBytes())));

        gerenciamento.adicionarAluno();

        List<Aluno> alunos = gerenciamento.getAlunos();
        assertEquals(1, alunos.size());

        Aluno aluno = alunos.get(0);
        assertEquals("Ana", aluno.getNome());
        assertEquals("2022001", aluno.getMatricula());
        assertEquals(3, aluno.getNotas().size());
        assertEquals(8.0f, aluno.calcularMedia());
        assertEquals(aluno.SITUACAO_APROVADO, aluno.verificarSituacao());

        System.setIn(originalIn);
    }

    @Test
    public void testNotaInvalidaENovaEntrada()
    {
        String simulatedInput = "Joao\n2022002\nlaranja\n11\n7.5\n8\n9\n";
        InputStream originalIn = System.in;
        gerenciamento.setScanner(new Scanner(new ByteArrayInputStream(simulatedInput.getBytes())));

        gerenciamento.adicionarAluno();

        Aluno aluno = gerenciamento.getAlunos().getFirst();
        assertEquals("Joao", aluno.getNome());
        assertEquals(3, aluno.getNotas().size());
        assertEquals(8.17f, aluno.calcularMedia(), 0.01f);
        assertEquals(aluno.SITUACAO_APROVADO, aluno.verificarSituacao());

        System.setIn(originalIn);
    }

    @Test
    public void testAdicionarMultiplosAlunosECriarRelatorio()
    {
        String simulatedInput = "Ana\n2022001\n8\n9\n7\nBruno\n2022002\n7\n5\n6";

        gerenciamento.setScanner(new Scanner(new ByteArrayInputStream(simulatedInput.getBytes())));

        gerenciamento.adicionarAluno();
        gerenciamento.adicionarAluno();

        List<Aluno> alunos = gerenciamento.getAlunos();
        assertEquals(2, alunos.size());

        Aluno aluno1 = alunos.getFirst();
        assertEquals("Ana", aluno1.getNome());
        assertEquals(8.0f, aluno1.calcularMedia(), 0.01f);
        assertEquals(aluno1.SITUACAO_APROVADO, aluno1.verificarSituacao());

        Aluno aluno2 = alunos.get(1);
        assertEquals("Bruno", aluno2.getNome());
        assertEquals(6.0f, aluno2.calcularMedia(), 0.01f);
        assertEquals(aluno2.SITUACAO_REPROVADO, aluno2.verificarSituacao());

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        gerenciamento.criarRelatorio();

        String output = outContent.toString();

        assertTrue(output.contains("Ana"));
        assertTrue(output.contains("Bruno"));
        assertTrue(output.contains("Média: 8.0"));
        assertTrue(output.contains("Média: 6.0"));
    }


    @Test
    public void testCriarRelatorioVazio()
    {
        gerenciamento.criarRelatorio();
    }
}
