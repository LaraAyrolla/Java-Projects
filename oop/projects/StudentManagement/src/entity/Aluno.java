package entity;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome, matricula, situacao;
    List<Float> notas = new ArrayList<>();
    private float media = 0;

    public final String SITUACAO_APROVADO = "Aprovado";
    public final String SITUACAO_REPROVADO = "Reprovado";
    public final int NOTA_MINIMA_APROVACAO = 7;

    public Aluno(String nome, String matricula, List<Float> notas)
    {
        this.setNome(nome);
        this.setMatricula(matricula);
        this.setNotas(notas);
    }

    public void setNome(String novoNome)
    {
        this.nome = novoNome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setMatricula(String novaMatricula)
    {
        this.matricula = novaMatricula;
    }

    public String getMatricula()
    {
        return this.matricula;
    }

    public void setSituacao(String novaSituacao)
    {
        this.situacao = novaSituacao;
    }

    public String getSituacao()
    {
        return this.situacao;
    }

    public void setNotas(List<Float> novasNotas)
    {
        this.notas = novasNotas;
    }

    public List<Float> getNotas()
    {
        return this.notas;
    }

    public void setMedia(float novaMedia)
    {
        this.media = novaMedia;
    }

    public float getMedia()
    {
        return this.media;
    }

    public float calcularMedia()
    {
        notas = this.getNotas();
        if (notas.isEmpty()) {
            return 0;
        }

        float somaNotas = 0;
        for (Float nota : notas) {
            somaNotas += nota;
        }

        this.setMedia(somaNotas / notas.size());
        return this.getMedia();
    }

    public String verificarSituacao()
    {
        if (this.media >= NOTA_MINIMA_APROVACAO) {
            this.setSituacao(SITUACAO_APROVADO);
        } else {
            this.setSituacao(SITUACAO_REPROVADO);
        }

        return this.getSituacao();
    }
}
