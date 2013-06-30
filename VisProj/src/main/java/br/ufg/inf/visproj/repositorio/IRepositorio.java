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

    Projeto consultarProjeto(String id) throws JAXBException;

    Configuracao consultarConfiguracao(String idProjeto) throws JAXBException;

    boolean salvarOuAtualizarProjeto(Projeto projeto) throws IOException;

    List<Projeto> consultarListaProjetos() throws JAXBException;

    boolean excluirProjeto(String id) throws JAXBException;

    boolean limpaDiretorio();
    
    boolean removaDiretorio();
}
