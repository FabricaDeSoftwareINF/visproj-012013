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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio
 *
 * Esta classe tem o propósito de persistir ou obter dados do
 * repositório de arquivos e converter no objeto correspondente.
 *
 */ 
public class Repositorio implements IRepositorio {

    private static final String PATH = "Projetos";

    public Repositorio() {
    }   
    
    /**
     * consultarProjeto - Método responsável por consultar um projeto pelo id.
     * @param id	O id do projeto 
     * @return 		O <code>Projeto</code> consultado.
     * @exception	JAXBException se houver algum problema na conversão. 
     * @see Projeto
     */
    public Projeto consultarProjeto(String id) throws JAXBException {

        File file = new File(getPathCompleto(id));
        if (!file.exists()) {
            return null;
        }

        JAXBContext jaxbCtx = null;
        jaxbCtx = JAXBContext.newInstance(Projeto.class);
        Projeto projetoConsultado = (Projeto) jaxbCtx.createUnmarshaller().unmarshal(file);

        return projetoConsultado;
    }

    /**
     * consultarConfiguracao - Método responsável por consultar uma configuração pelo id do projeto.
     * @param 	idProjeto		O id do projeto.
     * @return 					A Configuracao consultada.
     * @exception				JAXBException Se houver algum problema na conversão.
     * @see IRepositorio#consultarConfiguracao(String)
     * @see 	Configuracao
     */
    public Configuracao consultarConfiguracao(String idProjeto) throws JAXBException {

        Projeto projeto = consultarProjeto(idProjeto);
        if (projeto != null) {
            return projeto.getConfiguracao();
        }

        return null;
    }

    /**
     * salvarOuAtualizarProjeto	 -	Salva ou atualiza o projeto informado.	
     * @param projeto 				O projeto que deverá ser salvo ou atualizado.
     * @return						<code>true</code> se o projeto foi salvo ou atualizado ou
     * 								<code>false</code> caso contrário.
     * @throws IOException			Se houver problema para gravar o arquivo.
     * @see Projeto
     * @since 1.0
     */   
    public boolean salvarOuAtualizarProjeto(Projeto projeto) throws IOException {
        JAXBContext jaxbCtx = null;
        Marshaller jaxbMarshaller = null;

        if (projeto.getId() == null || projeto.getId().isEmpty()) {
            return false;
        }
        try {

            File file = new File(getPathCompleto(projeto.getId()));

            jaxbCtx = JAXBContext.newInstance(Projeto.class);
            jaxbMarshaller = jaxbCtx.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(projeto, file);

            return true;
        } catch (JAXBException ex) {
            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE,
                    null, ex);

            return false;
        }
    }

    /**
     * consultarListaProjetos -	Consulta todos os projetos armazenados no diretório padrão.
     * @return 					A lista de projetos existentes.
     * @throws JAXBException	Se houver problema na conversão.
     * @see Projeto
     */
    public List<Projeto> consultarListaProjetos() throws JAXBException {

        File file = new File(PATH);

        File files[] = file.listFiles();
        
        List<Projeto> listaDeProjetos = new ArrayList<>();
        Logger.getLogger("consultarProjetosExistentes").log(Level.INFO, "tamanhoArquivo" + files.length);
        if (files != null && files.length >0) {
        	Unmarshaller jaxbMarshaller = null;
        	JAXBContext jaxbCtx = null;
            for (int i = 0; i < files.length; i++) {
                
                jaxbCtx = JAXBContext.newInstance(Projeto.class);
                jaxbMarshaller = jaxbCtx.createUnmarshaller();
                Projeto projetoConsultado = (Projeto) jaxbMarshaller.unmarshal(files[i]);
                listaDeProjetos.add(projetoConsultado);
            }
        }
        
        return listaDeProjetos;

    }

    /**
     * excluirProjeto     - 	exclui o projeto do id informado.
     * @param id				O id do projeto.
     * @return 					<code>true</code> se o projeto foi excluido ou <code>false</code> caso contrário.
     * @throws JAXBException	Se houver problema na conversão.
     */
    public boolean excluirProjeto(String id) throws JAXBException {
        File file = new File(getPathCompleto(id));
        if (file.exists()) {
            file.delete();

            return true;
        }
        return false;
    }

    /**
     * criaDiretorio - Cria o diretorio padrão para salvar os projetos.
     */
    public void criaDiretorio(){
    	File file = new File(PATH);
    	if(!file.exists() || (file.exists() && !file.isDirectory())){
    		file.mkdir();
    	}
    }
    
    /**
     * limpaDiretorio 	- 	Limpa todos os arquivos armazenados no diretório padrão.
     * @return 				<code>true</code> caso o diretório foi limpo ou <code>false</code> caso contrário.
     */
    public boolean limpaDiretorio() {
        File file = new File(PATH);

        if (file.exists() && file.isDirectory()) {

            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }

            return true;
        }

        return false;
    }   
    
    /**
     * removaDiretorio - Remove o diretório em que os projetos estão armazenados.
     * @return <code>true</code> caso o diretório foi removido ou <code>false</code> caso contrário.
     */
    public boolean removaDiretorio(){
    	File file = new File(PATH);
    	if(file.exists() && file.isDirectory() && file.listFiles().length == 0){
    		file.delete();
    		return true;
    	}
    	
    	return false;
    }

    private String getPathCompleto(String nomeArquivo) {

        return PATH + "\\" + nomeArquivo + ".xml";
    }
}
