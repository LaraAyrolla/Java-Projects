package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um aluno com todos os seus campos e realiza operações relacionadas.
 */
public class Aluno implements Comparable<Aluno> {
    private String nome, matricula, situacao;
    List<Float> notas = new ArrayList<>();
    private float media = 0;

    public final String SITUACAO_APROVADO = "Aprovado";
    public final String SITUACAO_REPROVADO = "Reprovado";
    public final int NOTA_MINIMA_APROVACAO = 7;

    /**
     * Construtor que recebe campos obrigatórios para criar a nova instância de Aluno.
     *
     * @param String nome
     * @param String matricula
     * @param List<Float> notas
     */
    public Aluno(String nome, String matricula, List<Float> notas)
    {
        this.setNome(nome);
        this.setMatricula(matricula);
        this.setNotas(notas);
    }

    /**
     * Sobrescreve o método de comparação da interface Comparable para comparar alunos com base no nome.
     * Utilizada para ordenação por ordem alfabética.
     *
     * @param Aluno other
     * @return int
     */
    @Override
    public int compareTo(Aluno other) {
        return this.nome.compareTo(other.nome);
    }

    /**
     * @param String novoNome
     */
    public void setNome(String novoNome)
    {
        this.nome = novoNome;
    }

    /**
     * @return String
     */
    public String getNome()
    {
        return this.nome;
    }

    /**
     * @param String novaMatricula
     */
    public void setMatricula(String novaMatricula)
    {
        this.matricula = novaMatricula;
    }

    /**
     * @return String
     */
    public String getMatricula()
    {
        return this.matricula;
    }

    /**
     * @param String novaSituacao
     */
    public void setSituacao(String novaSituacao)
    {
        this.situacao = novaSituacao;
    }

    /**
     * @return String
     */
    public String getSituacao()
    {
        return this.situacao;
    }

    /**
     * @param List<Float> novasNotas
     */
    public void setNotas(List<Float> novasNotas)
    {
        this.notas = novasNotas;
    }

    /**
     * @return List<Float>
     */
    public List<Float> getNotas()
    {
        return this.notas;
    }

    /**
     * @param float novaMedia
     */
    public void setMedia(float novaMedia)
    {
        this.media = novaMedia;
    }

    /**
     * @return float
     */
    public float getMedia()
    {
        return this.media;
    }

    /**
     * Calcula, salva e retorna a média com base na lista de notas do aluno.
     *
     * @return float
     */
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

    /**
     * Verifica, salva e retorna a situação do aluno.
     * Utiliza como base de comparação a média do aluno e o valor mínimo para aprovação configurado.
     *
     * @return String
     */
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
