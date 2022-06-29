package util;

import entities.Pessoa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends ConnectionDB {


    public void incluirPessoa(Pessoa p) throws Exception {
        open();
        String sql = "INSERT INTO pessoa VALUES(?,?,?)";
        stmt = con.prepareStatement(sql);

        stmt.setInt(1, p.getIdPessoa());
        stmt.setString(2, p.getNomePessoa());
        stmt.setString(3, p.getEmail());

        stmt.execute();
        stmt.close();
        close();
    }


    public void alterarPessoa(Pessoa p) throws Exception {
        open();
        stmt = con.prepareStatement("UPDATE pessoa SET nomepessoa = ?, email = ? where idpessoa = ?");
        stmt.setString(1, p.getNomePessoa());
        stmt.setString(2, p.getEmail());
        stmt.setInt(3, p.getIdPessoa());

        stmt.execute();
        stmt.close();
        close();
    }

    public void excluirPessoa(Pessoa p) throws Exception {

        open();
        String sql = "DELETE FROM Pessoa WHERE idPessoa = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, p.getIdPessoa());
        stmt.execute();
        stmt.close();
        close();

    }


    // retornando um objeto
    public Pessoa consultarPessoaIndividual(int cod) throws Exception {
        open();
        String sql = "SELECT * FROM pessoa WHERE idpessoa = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, cod);
        rs = stmt.executeQuery();
        Pessoa p = null;
        if (rs.next()) {
            p = new Pessoa();
            p.setIdPessoa(rs.getInt("idPessoa"));
            p.setNomePessoa(rs.getString("NomePessoa"));
            p.setEmail(rs.getString("email"));
        } else {
            System.out.println("Registro não encontrado");
        }
        close();
        return p;
    }


    public List<Pessoa> ListarPessoas() {
        try {
            open();
            String sql = "SELECT * FROM pessoa";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Pessoa> listaPessoas = new ArrayList<>();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setEmail(rs.getString("email"));
                listaPessoas.add(p);
            }
            close();
            return listaPessoas;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}