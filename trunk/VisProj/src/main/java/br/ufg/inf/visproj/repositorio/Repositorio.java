package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Package: br.ufg.inf.visproj.repositorio
 * Class: Repositorio
 * User: ArthurNote
 * Date: 22/05/13
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */

public class Repositorio implements IRepositorio {

    public Repositorio() {
    }

    public Projeto consultarProjeto(String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Configuracao consultarConfiguracao(String idProjeto) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void salvarOuAtualizarProjeto(Projeto projeto) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Projeto> consultarListaProjetos() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void excluirProjeto(String id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void limpaDiretorio() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
