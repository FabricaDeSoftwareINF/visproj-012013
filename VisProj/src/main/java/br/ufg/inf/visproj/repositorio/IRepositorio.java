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

package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * IRepositorio
 *
 * Representa a interface IRepositorio.
 *
 */ 
public interface IRepositorio {

	/**
     * consultarProjeto - Método responsável por consultar um projeto pelo id.
     * @param id	O id do projeto 
     * @return 		O <code>Projeto</code> consultado.
     * @exception	JAXBException se houver algum problema na conversão. 
     * @see Projeto
     */
    Projeto consultarProjeto(String id) throws JAXBException;

    /**
     * consultarConfiguracao - Método responsável por consultar uma configuração pelo id do projeto.
     * @param 	idProjeto		O id do projeto.
     * @return 					A Configuracao consultada.
     * @exception				JAXBException Se houver algum problema na conversão.
     * @see 	Configuracao
     */
    Configuracao consultarConfiguracao(String idProjeto) throws JAXBException;

    /**
     * salvarOuAtualizarProjeto	 -	Salva ou atualiza o projeto informado.	
     * @param projeto 				O projeto que deverá ser salvo ou atualizado.
     * @return						<code>true</code> se o projeto foi salvo ou atualizado ou
     * 								<code>false</code> caso contrário.
     * @throws IOException			Se houver problema para gravar o arquivo.
     * @throws JAXBException 
     * @see Projeto
     * @since 1.0
     */    
    boolean salvarOuAtualizarProjeto(Projeto projeto) throws IOException, JAXBException;

    /**
     * consultarListaProjetos -	Consulta todos os projetos armazenados no diretório padrão.
     * @return 					A lista de projetos existentes.
     * @throws JAXBException	Se houver problema na conversão.
     * @throws IOException	    Se houver problema para gravar o arquivo.
     * @see Projeto
     */
    List<Projeto> consultarListaProjetos() throws JAXBException;

    /**
     * excluirProjeto     - 	exclui o projeto do id informado.
     * @param id				O id do projeto.
     * @return 					<code>true</code> se o projeto foi excluido ou <code>false</code> caso contrário.
     * @throws JAXBException	Se houver problema na conversão.
     */
    boolean excluirProjeto(String id) throws JAXBException;

    /**
     * criaDiretorio - Cria o diretorio padrão para salvar os projetos.
     */
    void criaDiretorio();
    
    /**
     * limpaDiretorio 	- 	Limpa todos os arquivos armazenados no diretório padrão.
     * @return 				<code>true</code> caso o diretório foi limpo ou <code>false</code> caso contrário.
     */
    boolean limpaDiretorio();
    
    /**
     * removaDiretorio - Remove o diretório em que os projetos estão armazenados.
     * @return <code>true</code> caso o diretório foi removido ou <code>false</code> caso contrário.
     */
    boolean removaDiretorio();
}
