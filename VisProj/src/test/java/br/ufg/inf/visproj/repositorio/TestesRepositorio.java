package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;
import br.ufg.inf.visproj.util.FabricaDeObjetos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

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

    private static IRepositorio repositorio;
    private static Projeto projeto;

    @BeforeClass //construtor devera ser vinculado ao @BeforeClass dentro do junit.
    public static void beforeClass() throws IOException, JAXBException {
        repositorio = new Repositorio();
        repositorio.criaDiretorio();
        repositorio.limpaDiretorio();
        projeto = FabricaDeObjetos.getInstancia().criarProjeto("X9");
        repositorio.salvarOuAtualizarProjeto(projeto);
    }

    @AfterClass
    public static void afterClass() throws IOException {
        repositorio.limpaDiretorio();
    }
    
    @After
    public void after(){
    	repositorio.removaDiretorio();
    }

    @Test
    public void testaSalvarProjetoInexistente() throws IOException, JAXBException {

        Projeto projeto = FabricaDeObjetos.getInstancia().criarProjeto("ProjetoX");

        repositorio.salvarOuAtualizarProjeto(projeto);
        Projeto projetoConsultado = repositorio.consultarProjeto(projeto.getId());

        Assert.assertNotNull(projetoConsultado);
        Assert.assertEquals(projetoConsultado.getId(), projeto.getId());

        repositorio.excluirProjeto(projeto.getId());
    }   

    @Test
    public void testaSalvarProjetoExistente() throws IOException, JAXBException {
        Configuracao config = new Configuracao();
        config.setEquacao("Equacao");
        this.projeto.setConfiguracao(config);
        boolean projetoSalvo = repositorio.salvarOuAtualizarProjeto(projeto);

        Projeto projetoConsultado = repositorio.consultarProjeto(this.projeto.getId());
        Assert.assertTrue(projetoSalvo);
        Assert.assertNotNull(projetoConsultado);
        Assert.assertEquals(projeto.getConfiguracao().getEquacao(), projetoConsultado.getConfiguracao().getEquacao());
    }
    
    @Test
    public void testaSalvarProjetoComIdNuloOuVazio() throws IOException, JAXBException{
    	boolean projetoSalvo = repositorio.salvarOuAtualizarProjeto(new Projeto());
    	Assert.assertFalse(projetoSalvo);
    	
    	Projeto projeto = new Projeto();
    	projeto.setId("");
    	
    	projetoSalvo = repositorio.salvarOuAtualizarProjeto(new Projeto());
    	Assert.assertFalse(projetoSalvo);
    }

    @Test
    public void testaConsultarProjetoExistente() throws JAXBException
    {
        Projeto projetoConsultado = repositorio.consultarProjeto(projeto.getId());
        Assert.assertNotNull(projetoConsultado);

    }

    @Test
    public void testaConsultarProjetoInexistente() throws JAXBException {
        Projeto projetoConsultado = repositorio.consultarProjeto("batema");
        Assert.assertNull(projetoConsultado);
    }

    @Test
    public void testaConsultarConfiguracaoExistente() throws JAXBException {
        
		Configuracao config = repositorio.consultarConfiguracao(this.projeto.getConfiguracao().getId());
        Assert.assertNotNull(config);
        //objeto config deve ser comparado com o projeto this.projeto.getConfiguracao
        //devera ser comparada todas as propriedades do objeto configuracao.
    }

    @Test
    public void testaConsultarConfiguracaoInexistente() throws JAXBException {
        Configuracao config = repositorio.consultarConfiguracao("idinexistente");
        Assert.assertNull(config);

    }

    @Test @Ignore
    public void testaConsultarListadeProjetosExistentes() throws JAXBException {
        List<Projeto> listaProjetos = repositorio.consultarListaProjetos();
        Assert.assertNotNull(listaProjetos);
        Assert.assertEquals(1, listaProjetos.size());
        //devera analisar a qualidade de projetos que a listaProjetos conseguiu retornar.
        //neste caso como somente um projeto foi cadastrado Globalmente, o resultado devera ser igual a 1.
        //devera ser criado um for que chama o metodo que compara projetos
        //para comparar todos os projetos que foram retornados na listaProjetos()
    }

    @Test
    public void testaConsultarListadeProjetoInexistentes() throws JAXBException, IOException {
        repositorio.excluirProjeto(this.projeto.getId());
        List<Projeto> listaProjetos = repositorio.consultarListaProjetos();
        Assert.assertEquals(0 , listaProjetos.size());
        if (listaProjetos.size() == 0) {
            repositorio.salvarOuAtualizarProjeto(this.projeto);
        }
    }
    
    @Test
    public void testaExcluirProjetoInexistente() throws JAXBException{
    	boolean projetoExcluido = repositorio.excluirProjeto("projetoqualquer");
    	Assert.assertFalse(projetoExcluido);
    }
}
