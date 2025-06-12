package entity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Gerencia a lista de alunos e suas respectivas operações.
 */
public class GerenciamentoAlunos {
    List<Aluno> alunos =  new ArrayList<>();
    Scanner scanner;

    /**
     * Construtor padrão utilizando o scanner padrão do sistema.
     */
    public GerenciamentoAlunos() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Construtor alternativo com alteração do scanner, utilizado para as classes de teste.
     * @param Scanner scanner
     */
    public GerenciamentoAlunos(Scanner scanner) {
        this.scanner = scanner;
    }

    private final int QUANTIDADE_NOTAS = 3;

    /**
     * @return List<Aluno>
     */
    public List<Aluno> getAlunos()
    {
        return this.alunos;
    }

    /**
     * @param Scanner novoScanner
     */
    public void setScanner(Scanner novoScanner)
    {
        this.scanner = novoScanner;
    }

    /**
     * Solicita inserção de dados para que o usuário adicione um novo aluno.
     * Cria uma nova instância da classe Aluno e adiciona à lista de alunos.
     */
    public void adicionarAluno()
    {
        System.out.println("Insira os dados do aluno: ");

        System.out.println("Nome: ");
        String nome = this.scanner.nextLine();

        System.out.println("Matrícula: ");
        String matricula = this.scanner.nextLine();

        List<Float> notas = this.inserirNotas();

        this.alunos.add(new Aluno(nome, matricula, notas));
    }

    /**
     * Socilita a inserção de notas válidas para o aluno (valor numérico de 0 a 10).
     * Repete até que a quantidade definida de notas válidas seja alcançada.
     *
     * @return List<Float>
     */
    private List<Float> inserirNotas()
    {
        List<Float> notas = new ArrayList<>();

        for (int i=0; i<QUANTIDADE_NOTAS; i++) {
            System.out.println(STR."Nota (valor entre 0 e 10): (\{i+1}/\{QUANTIDADE_NOTAS}) ");

            Float nota = this.lerNotaValida();
            notas.add(nota);
        }

        return notas;
    }

    /**
     * Faz a leitura das notas inseridas pelo usuário.
     * Retorna a nota quando válida, caso contrário continua a repetição.
     *
     * @return float
     */
    private Float lerNotaValida() {
        String entrada;
        Float nota;

        do {
            entrada = this.scanner.nextLine();
            nota = validarEConverterNota(entrada);

            if (nota == null) {
                System.out.println("Valor inválido! Por favor, insira uma nota numérica válida.");
            }
        } while (nota == null);

        return nota;
    }

    /**
     * Recebe uma String e retorna ela convertida para float caso seja um número de 0 a 10.
     * Retorna null em caso de nota inválida.
     *
     * @param String nota
     * @return float
     */
    private Float validarEConverterNota(String nota) {
        if (!NumberUtils.isCreatable(nota)) {
            return null;
        }

        float valorNumerico = Float.parseFloat(nota);
        if (valorNumerico < 0 || valorNumerico > 10) {
            return null;
        }

        return valorNumerico;
    }

    /**
     * Ordena a lista de alunos por nome em ordem crescente e exibe um relatório com todos os registros.
     */
    public void criarRelatorio()
    {
        Collections.sort(this.alunos);

        System.out.println("\n*** RELATÓRIO DE ALUNOS ***");

        for (Aluno aluno : this.alunos) {
            System.out.println("\nNome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Média: " + aluno.calcularMedia());
            System.out.println("Situação: " + aluno.verificarSituacao());
        }

        System.out.println("\n***************************\n");
    }
}
