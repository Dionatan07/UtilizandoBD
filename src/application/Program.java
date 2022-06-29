package application;

import entities.Pessoa;
import util.PessoaDao;

import java.util.List;

public class Program {

    public static void main(String[] args) throws Exception {

        PessoaDao pd = new PessoaDao();

        /*
        // ### INCLUIR ###
        try {
            Pessoa p1 = new Pessoa(5, "jose", "jose@gmail.com");
            Pessoa p2 = new Pessoa(6, "joao", "joao@gmail.com");
            pd.incluirPessoa(p1);
            pd.incluirPessoa(p2);
        */

        /*
            // ### ALTERAR ###
                Pessoa pes = pd.consultarPessoaIndividual(3);
                if (pes != null) {
                    pes.setNomePessoa("Dionatan");
                    pes.setEmail("dionatan@gmail.com");
                    // chamar o metodo de contem o comando update
                    pd.alterarPessoa(pes);
                } else {
                    System.out.println("Pessoa nao encontrada ou falha no acesso ao banco de dados");
                }

                // ### LISTAR TODOS ###
                List<Pessoa> listaPessoas = pd.ListarPessoas();
                for(Pessoa p : listaPessoas){
                    System.out.println("Id.: " + p.getIdPessoa());
                    System.out.println("Nome : "  +p.getNomePessoa());
                    System.out.println("Email : " +p.getEmail());
                    System.out.println();
                }
            }
*/

/*
        // ### EXCLUIR ###
        // ### VERIFICAR SE REGISTRO EXISTE NO BANCO ###
        Pessoa pessoa1 = pd.consultarPessoaIndividual(2);
        pd.excluirPessoa(pessoa1);


 */
        // ### LISTAR TODOS ###
        List<Pessoa> listaPessoas = pd.ListarPessoas();
        for (Pessoa p : listaPessoas) {
            System.out.println("Id.: " + p.getIdPessoa());
            System.out.println("Nome : " + p.getNomePessoa());
            System.out.println("Email : " + p.getEmail());
        }


/*
        // ### BUSCANDO UM REGISTRO APENAS ###
        Pessoa pes1 = pd.consultarPessoaIndividual(3);
        System.out.println("Código: " + pes1.getIdPessoa());
        System.out.println("Nome: " + pes1.getNomePessoa());
        System.out.println("Email: " + pes1.getEmail());
*/

    }
}

