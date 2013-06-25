/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.servico;

import br.ufg.inf.visproj.model.Projeto;
import br.ufg.inf.visproj.model.ResultadoDoProjeto;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

public interface IProjetoService {
    
    public void salvarProjeto(Projeto projeto) throws IOException, JAXBException;
    
    public void salvarConfiguracao (Projeto projeto) throws IOException;
    
    public ResultadoDoProjeto getResultadoDoProjeto(String idDoProjeto) throws JAXBException;
    
    public List<ResultadoDoProjeto> getListaResultadoDosProjetos() throws JAXBException;
    
    public void excluirTodosProjetos();
    
}
