package test.entity;

import entity.Aluno;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    public void testSetGetNome()
    {
        Aluno aluno = new Aluno("Maria", "123", Arrays.asList(8.0f, 7.0f, 9.0f));
        aluno.setNome("João");
        assertEquals("João", aluno.getNome());
    }

    @Test
    public void testSetGetMatricula()
    {
        Aluno aluno = new Aluno("Maria", "123", Arrays.asList(8.0f, 7.0f, 9.0f));
        aluno.setMatricula("456");
        assertEquals("456", aluno.getMatricula());
    }

    @Test
    public void testSetGetSituacao()
    {
        Aluno aluno = new Aluno("Maria", "123", Arrays.asList(8.0f, 7.0f, 9.0f));
        aluno.setSituacao(aluno.SITUACAO_APROVADO);
        assertEquals(aluno.SITUACAO_APROVADO, aluno.getSituacao());
    }

    @Test
    public void testSetGetNotas()
    {
        Aluno aluno = new Aluno("Maria", "123", Collections.emptyList());
        aluno.setNotas(Arrays.asList(5.0f, 6.0f, 7.0f));
        assertEquals(3, aluno.getNotas().size());
    }

    @Test
    public void testSetGetMedia()
    {
        Aluno aluno = new Aluno("Maria", "123", Arrays.asList(5.0f, 6.0f, 7.0f));
        aluno.setMedia(6.0f);
        assertEquals(6.0f, aluno.getMedia());
    }

    @Test
    public void testCalcularMedia()
    {
        Aluno aluno = new Aluno("Maria", "123", Arrays.asList(6.0f, 7.0f, 8.0f));
        assertEquals(7.0f, aluno.calcularMedia());
    }

    @Test
    public void testCalcularMediaNotasVazias()
    {
        Aluno aluno = new Aluno("Maria", "123", Collections.emptyList());
        assertEquals(0f, aluno.calcularMedia());
    }

    @Test
    public void testVerificarSituacaoAprovado()
    {
        Aluno aluno = new Aluno("Maria", "123", Arrays.asList(9.0f, 8.0f, 10.0f));
        aluno.calcularMedia();
        assertEquals(aluno.SITUACAO_APROVADO, aluno.verificarSituacao());
    }

    @Test
    public void testVerificarSituacaoReprovado()
    {
        Aluno aluno = new Aluno("Maria", "123", Arrays.asList(5.0f, 5.5f, 6.0f));
        aluno.calcularMedia();
        assertEquals(aluno.SITUACAO_REPROVADO, aluno.verificarSituacao());
    }
}
