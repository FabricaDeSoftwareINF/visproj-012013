package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;
import br.ufg.inf.visproj.util.FabricaDeObjetos;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * Package: br.ufg.inf.visproj.repositorio
 * Class: testesRepositorio
 * User: ArthurNote
 * Date: 22/05/13
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */

public class TestesRepositorio {

    private static Repositorio repositorio;
    private static Projeto projeto;

    @BeforeClass //construtor devera ser vinculado ao @BeforeClass dentro do junit.
    public static void beforeClass() throws IOException {
        repositorio = new Repositorio();
        repositorio.limpaDiretorio();
        projeto = FabricaDeObjetos.criarProjeto("X9");
        repositorio.salvarOuAtualizarProjeto(projeto);
    }


    @Test
    public void testaSalvarProjetoInexistente() throws IOException, JAXBException {

        Projeto projeto = FabricaDeObjetos.criarProjeto("ProjetoX");

        repositorio.salvarOuAtualizarProjeto(projeto);
        Projeto projetoConsultado = repositorio.consultarProjeto(projeto.getId());

        assertNotNull(projetoConsultado);
        assertEquals(projetoConsultado.getId(), projeto.getId());


        repositorio.excluirProjeto(projeto.getId());

    }

    @AfterClass //construtor devera ser vinculado ao @BeforeClass dentro do junit.
    public static void afterClass() throws IOException {
        repositorio.limpaDiretorio();
    }

    public void testaSalvarProjetoExistente() throws IOException, JAXBException {
        Configuracao config = new Configuracao();
        config.setEquacao("Equacao");
        this.projeto.setConfiguracao(config);
        repositorio.salvarOuAtualizarProjeto(projeto);

        Projeto projetoConsultado = repositorio.consultarProjeto(this.projeto.getId());

        //criar os assert equals para todos as propriedades do objeto CONFIGURACAO
        // o return de todos os assert equals devem ser iguais, exceto para a propriedade EQUACAO,
        //como foi alterada devera retornar diferente do existente.

    }

    public void testaConsultarProjetoExistente() throws JAXBException {
        Projeto projetoConsultado = repositorio.consultarProjeto(this.projeto.getId());
        // Assert.isNotNull();

    }

    public void testaConsultarProjetoInexistente() throws JAXBException {
        Projeto projetoConsultado = repositorio.consultarProjeto("batema");
        // Assert.isNull();

    }

    public void testaConsultarConfiguracaoExistente() throws JAXBException {
        Configuracao config = repositorio.consultarConfiguracao(this.projeto.getConfiguracao().getId());
        //     Assert.IsNotNull();
        //objeto config deve ser comparado com o projeto this.projeto.getConfiguracao
        //devera ser comparada todas as propriedades do objeto configuracao.
    }

    public void testaConsultarConfiguracaoInexistente() throws JAXBException {
        Configuracao config = repositorio.consultarConfiguracao(this.projeto.getConfiguracao().getId());
        //Asset.isNull()   ;

    }

    public void testaConsultarListadeProjetosExistentes() throws JAXBException {
        List<Projeto> listaProjetos = repositorio.consultarListaProjetos();
        //Assert.isNotNull();
        //Assert.areEquals(1, listaProjetos.size());
        //devera analisar a qualidade de projetos que a listaProjetos conseguiu retornar.
        //neste caso como somente um projeto foi cadastrado Globalmente, o resultado devera ser igual a 1.
        //devera ser criado um for que chama o metodo que compara projetos
        //para comparar todos os projetos que foram retornados na listaProjetos()
    }

    public void testaConsultarListadeProjetoInexistentes() throws JAXBException, IOException {
        repositorio.excluirProjeto(this.projeto.getId());
        List<Projeto> listaProjetos;
        listaProjetos = repositorio.consultarListaProjetos();
        //Assert.areEquals(0 , listaProjetos.size());  ---- size = zero significa que nao existe projetos.
        //devera ser retornado a lista vazia, com zero projetos cadastrados.
        if (listaProjetos.size() == 0) {
            repositorio.salvarOuAtualizarProjeto(this.projeto);
        }
    }
}
