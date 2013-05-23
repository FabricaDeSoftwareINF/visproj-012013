package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Package: br.ufg.inf.visproj.repositorio
 * Class: IRepositorio
 * User: ArthurNote
 * Date: 22/05/13
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */

public interface IRepositorio {

    Projeto consultarProjeto(String id);

    Configuracao consultarConfiguracao(String idProjeto);

    void salvarOuAtualizarProjeto(Projeto projeto);

    List<Projeto> consultarListaProjetos();

    void excluirProjeto(String id);

    void limpaDiretorio();
}
