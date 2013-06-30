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
    
    void salvarProjeto(Projeto projeto) throws IOException, JAXBException;
    
    void salvarConfiguracao (Projeto projeto) throws IOException;
    
    ResultadoDoProjeto getResultadoDoProjeto(String idDoProjeto) throws JAXBException;
    
    List<ResultadoDoProjeto> getListaResultadoDosProjetos() throws JAXBException;
    
    void excluirTodosProjetos();
    
}
