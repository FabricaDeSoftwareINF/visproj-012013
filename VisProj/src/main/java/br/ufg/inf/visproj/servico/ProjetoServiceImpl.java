 /**
  * Esse documento é parte do código fonte e artefatos relacionados 
  * ao projeto VisProj, em desenvolvimento pela Fábrica de Software
  * da UFG.
  * 
  *  Links relevantes:
  *  Fábrica de Software: http://fs.inf.ufg.br/
  *  Instituto de Informática UFG: http://www.inf.ufg.br
  *
  * Copyleft © UFG.
  * 
  * Licenciado sobre a licença GNU-GPL v3
  *  * Você pode obter uma cópia da licença em 
http://www.gnu.org/licenses/gpl.html
  * 
  * A menos que especificado ou exigido por legislação local, o software é 
  * fornecido "da maneira que está", sem garantias ou condições de qualquer 
  * tipo, nem expressas nem implícitas. Em caso de dúvidas referir a licença 
GNU-GPL.
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
 * ProjetoServiceImpl
 *
 * Esta classe tem o propósito de servir de fachada para a
 * classe repositório encapsulado as regras de negócio.
 *
 */ 
public class ProjetoServiceImpl implements IProjetoService{        
    
    private IRepositorio repositorio;
    
    /**
     * O construtor padrão que inicia o repositório.
     */
    public ProjetoServiceImpl(){
        this.repositorio = new Repositorio();
    }
    
    /**
     * O construtor do <code>ProjetoServiceImpl</code>.
     * @param repositorio O repositorio padrão.
     */
    public ProjetoServiceImpl(IRepositorio repositorio){
    	this.repositorio = repositorio;
    }

    /**
	 * salvarProjeto		- 	calcula a equação e grava o projeto em um arquivo.
	 * @param projeto			O projeto a ser gravado ou atualizado.
	 * @throws IOException		Se houver falha para salvar o arquivo.
	 * @throws JAXBException	Se houver falha na conversão para o arquivo xml.
	 */
    @Override
    public void salvarProjeto(Projeto projeto) throws IOException, JAXBException {
    	Configuracao configuracao = repositorio.consultarConfiguracao(projeto.getId());
    	projeto.setConfiguracao(configuracao);
    	projeto.getVersaoAtual().setResultadoDaEquacao(resultadoEquacao(projeto));
        repositorio.salvarOuAtualizarProjeto(projeto);
    }

    /**
     * salvarConfiguracao   - 	Salva ou atualiza a configuração para determinado projeto.
     * @param projeto			O projeto contendo a configuracao a ser salvo ou atualizado.
     * @throws IOException		Se houver falha para salvar o arquivo.
     * @see Projeto
     */
    @Override
    public void salvarConfiguracao(Projeto projeto) throws IOException {
        repositorio.salvarOuAtualizarProjeto(projeto);
    }

    /**
     * getResultadoDoProjeto - 	Obtém o resultado do projeto pelo id.
     * @param idDoProjeto		O id do projeto.
     * @return 					O resultado do projeto.
     * @throws JAXBException	Se houver falha na conversão do arquivo.
     * @see ResultadoDoProjeto
     */
    @Override
    public ResultadoDoProjeto getResultadoDoProjeto(String idDoProjeto) throws JAXBException {
        Projeto projeto = repositorio.consultarProjeto(idDoProjeto);
        ResultadoDoProjeto resultado = obtenhaResultadoDoProjeto(projeto);
        
        return resultado;
    }

    /**
     * getListaResultadoDosProjetos - 	Obtém a lista de resultado de todos os projetos.
     * @return							A lista do resultado de todos os projetos.
     * @throws JAXBException			Se houver falha na conversão do projeto.
     * @see ResultadoDoProjeto
     */
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

    /**
     * excluirTodosProjetos - Exclui todos os projetos incluindo o diretório.
     */
    @Override
    public void excluirTodosProjetos() {
        repositorio.limpaDiretorio();
        repositorio.removaDiretorio();
    }    
    
    private Float resultadoEquacao(Projeto projeto) {

        String equacaoFormatada = projeto.getConfiguracao().getEquacao();

        Map<String, Float> mapMetricas = projeto.getVersaoAtual().getMetricas();
        Set<String> metricas = mapMetricas.keySet();

        for (String metrica : metricas) {

            equacaoFormatada = equacaoFormatada.replaceAll("<" + metrica + ">", mapMetricas.get(metrica).toString());
        }

        Float resultado = 0f;

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
        try {
            resultado = (Float) scriptEngine.eval(equacaoFormatada);
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
