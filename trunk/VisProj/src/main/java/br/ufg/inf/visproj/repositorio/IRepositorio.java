package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
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

    Projeto consultarProjeto(String id) throws JAXBException;

    Configuracao consultarConfiguracao(String idProjeto) throws JAXBException;

    boolean salvarOuAtualizarProjeto(Projeto projeto) throws IOException;

    List<Projeto> consultarListaProjetos() throws JAXBException;

    boolean excluirProjeto(String id) throws JAXBException;

    boolean limpaDiretorio();
}
