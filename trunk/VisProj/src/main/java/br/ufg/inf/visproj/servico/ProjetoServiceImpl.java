/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.visproj.servico;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;
import br.ufg.inf.visproj.model.ResultadoDoProjeto;
import br.ufg.inf.visproj.repositorio.Repositorio;
import br.ufg.inf.visproj.repositorio.IRepositorio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author ArturPascualote
 */
public class ProjetoServiceImpl implements IProjetoService{    
    
    private IRepositorio repositorio;
    
    public ProjetoServiceImpl(){
        this.repositorio = new Repositorio();
    }
    
    public ProjetoServiceImpl(IRepositorio repositorio){
    	this.repositorio = repositorio;
    }

    @Override
    public void salvarProjeto(Projeto projeto) throws IOException, JAXBException {
    	Configuracao configuracao = repositorio.consultarConfiguracao(projeto.getId());
    	projeto.setConfiguracao(configuracao);
        repositorio.salvarOuAtualizarProjeto(projeto);
    }

    @Override
    public void salvarConfiguracao(Projeto projeto) throws IOException {
        repositorio.salvarOuAtualizarProjeto(projeto);
    }

    @Override
    public ResultadoDoProjeto getResultadoDoProjeto(String idDoProjeto) throws JAXBException {
        Projeto projeto = repositorio.consultarProjeto(idDoProjeto);
        ResultadoDoProjeto resultado = obtenhaResultadoDoProjeto(projeto);
        
        return resultado;
    }

    @Override
    public List<ResultadoDoProjeto> getListaResultadoDosProjetos() throws JAXBException {
        List<ResultadoDoProjeto> listaDeResultados = new ArrayList<>();
        List<Projeto> listaDeProjetos = repositorio.consultarListaProjetos();
        if(listaDeProjetos != null){
        	for(Projeto projeto : listaDeProjetos){
            	listaDeResultados.add(obtenhaResultadoDoProjeto(projeto));
            }
        }        
        
        return listaDeResultados;
    }

    @Override
    public void excluirTodosProjetos() {
        repositorio.limpaDiretorio();
    }
    
    
    private double resultadoEquacao(Projeto projeto) {

        String equacaoFormatada = projeto.getConfiguracao().getEquacao();

        Map<String, Float> mapMetricas = projeto.getVersaoAtual().getMetricas();
        Set<String> metricas = mapMetricas.keySet();

        for (String metrica : metricas) {

            equacaoFormatada = equacaoFormatada.replaceAll("<" + metrica + ">", mapMetricas.get(metrica).toString());
        }

        double resultado = 0;

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
        try {
            resultado = (Double) scriptEngine.eval(equacaoFormatada);
        } catch (ScriptException ex) {
            Logger.getLogger(ProjetoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
    private ResultadoDoProjeto obtenhaResultadoDoProjeto(Projeto projeto){
    	ResultadoDoProjeto resultado  = new ResultadoDoProjeto();
        resultado.setNivelDoProjeto(projeto.getVersaoAtual().getNivel());
        resultado.setResultadoDaEquacao(projeto.getVersaoAtual().getResultadoDaEquacao());
        resultado.setStatusDoProjeto(projeto.getStatusDoProjeto());
        
        return resultado;
    }
}
