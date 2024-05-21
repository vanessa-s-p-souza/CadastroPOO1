package model;

import model.PessoaFisica;
import model.PessoaFisicaRepo;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Instanciar o repositório de pessoas físicas
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        // Adicionar duas pessoas físicas
        PessoaFisica pessoa1 = new PessoaFisica(1, "João", "123.456.789-10", 30);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Maria", "987.654.321-00", 25);
        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);

        // Invocar o método de persistência em repo1
        repo1.persistir("pessoas_fisicas.dat");

        // Invocar o método de recuperação em repo2
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("pessoas_fisicas.dat");

        System.out.println();
        System.out.println("-------------------------------");
        // Exibir os dados de todas as pessoas físicas recuperadas
        List<PessoaFisica> pessoasRecuperadas = repo2.obterTodos();
        System.out.println("Dados de pessoas físicas armazenados.");
        System.out.println("Dados de pessoas físicas Recuperados.");
        System.out.println();
        for (PessoaFisica pessoa : pessoasRecuperadas) {
            System.out.println("Id: " + pessoa.getId());
            System.out.println("nome: " + pessoa.getNome());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println("Idade: " + pessoa.getIdade());
        }

        // Instanciar o repositório de pessoas jurídicas repo3
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        // Adicionar duas pessoas jurídicas
        PessoaJuridica empresa1 = new PessoaJuridica(1, "Empresa Luwa Tech", "12345678901234");
        PessoaJuridica empresa2 = new PessoaJuridica(2, "Empresa Apple", "98765432109876");

        repo3.inserir(empresa1);
        repo3.inserir(empresa2);

        // Invocar o método de persistência em repo3
        repo3.persistir("pessoas.dat");

        // Instanciar outro repositório de pessoas jurídicas repo4
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("pessoas.dat");

        // Exibir os dados de todas as pessoas jurídicas recuperadas
        List<PessoaJuridica> pessoasJuridicasRecuperadas = repo3.obterTodos();

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Dados de pessoas jurídicas armazenados.");
        System.out.println("Dados de pessoas jurídicas Recuperados.");
        System.out.println();
        for (PessoaJuridica pessoaJuridica : pessoasJuridicasRecuperadas) {
            System.out.println("Nome:" + pessoaJuridica.getNome());
            System.out.println("CNPJ:" + pessoaJuridica.getCnpj());
        }
        System.out.println();
    }
}

