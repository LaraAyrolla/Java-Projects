package entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

public class GerenciamentoAlunos {
    List<Aluno> alunos =  new ArrayList<>();
    Scanner scanner;

    public GerenciamentoAlunos() {
        this.scanner = new Scanner(System.in);
    }

    public GerenciamentoAlunos(Scanner scanner) {
        this.scanner = scanner;
    }

    private final int QUANTIDADE_NOTAS = 3;

    public List<Aluno> getAlunos()
    {
        return this.alunos;
    }

    public void setScanner(Scanner novoScanner)
    {
        this.scanner = novoScanner;
    }

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

    private List <Float> inserirNotas()
    {
        List<Float> notas = new ArrayList<>();

        for (int i=0; i<QUANTIDADE_NOTAS; i++) {
            System.out.println(STR."Nota (valor entre 0 e 10): (\{i+1}/\{QUANTIDADE_NOTAS}) ");

            Float nota = this.lerNotaValida();
            notas.add(nota);
        }

        return notas;
    }

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

    public void criarRelatorio()
    {
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
