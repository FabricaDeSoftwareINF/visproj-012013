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

import br.ufg.inf.visproj.model.Projeto;
import br.ufg.inf.visproj.model.ResultadoDoProjeto;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 * IProjetoService
 *
 * A interface com as capacidades do serviço.
 *
 */ 
public interface IProjetoService {
    
	/**
	 * salvarProjeto		- 	calcula a equação e grava o projeto em um arquivo.
	 * @param projeto			O projeto a ser gravado ou atualizado.
	 * @throws IOException		Se houver falha para salvar o arquivo.
	 * @throws JAXBException	Se houver falha na conversão para o arquivo xml.
	 */
    void salvarProjeto(Projeto projeto) throws IOException, JAXBException;
    
    /**
     * salvarConfiguracao   - 	Salva ou atualiza a configuração para determinado projeto.
     * @param projeto			O projeto contendo a configuracao a ser salvo ou atualizado.
     * @throws IOException		Se houver falha para salvar o arquivo.
     * @throws JAXBException 	Se houver falha na conversão do arquivo.
     * @see Projeto
     */
    void salvarConfiguracao (Projeto projeto) throws IOException, JAXBException;
    
    /**
     * getResultadoDoProjeto - 	Obtém o resultado do projeto pelo id.
     * @param idDoProjeto		O id do projeto.
     * @return 					O resultado do projeto.
     * @throws JAXBException	Se houver falha na conversão do arquivo.
     * @see ResultadoDoProjeto
     */
    ResultadoDoProjeto getResultadoDoProjeto(String idDoProjeto) throws JAXBException;
    
    /**
     * getListaResultadoDosProjetos - 	Obtém a lista de resultado de todos os projetos.
     * @return							A lista do resultado de todos os projetos.
     * @throws JAXBException			Se houver falha na conversão do projeto.
     * @see ResultadoDoProjeto
     */
    List<ResultadoDoProjeto> getListaResultadoDosProjetos() throws JAXBException;
    
    /**
     * excluirTodosProjetos - Exclui todos os projetos incluindo o diretório.
     */
    void excluirTodosProjetos();
    
}
