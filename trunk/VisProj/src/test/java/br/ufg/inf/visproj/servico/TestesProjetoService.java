/**
 *
 */
package br.ufg.inf.visproj.servico;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;
import br.ufg.inf.visproj.servico.IProjetoService;
import br.ufg.inf.visproj.model.Projeto;
import br.ufg.inf.visproj.model.ResultadoDoProjeto;
import br.ufg.inf.visproj.repositorio.*;
import br.ufg.inf.visproj.util.*;

public class TestesProjetoService {

    private static IProjetoService projetoService;
    private static IRepositorio repositorio;

    @BeforeClass
    public static void setUp() {
        repositorio = mock(Repositorio.class);
        projetoService = new ProjetoServiceImpl(repositorio);
    }

    @Test
    public void TestaConsultaProjetosInexistentes() throws JAXBException {
        setProjetosCadastrados(new ArrayList<Projeto>());
        List<ResultadoDoProjeto> listaResultados = projetoService.getListaResultadoDosProjetos();
        assertEquals(new ArrayList<ResultadoDoProjeto>(), listaResultados);
    }

    @Test
    public void TestaConsultaProjetoExistente() throws JAXBException {
        List<Projeto> projetos = getListaDeProjetosEsperados();
        setProjetosCadastrados(projetos);

        ResultadoDoProjeto resultado = new ResultadoDoProjeto();
        resultado.setNivelDoProjeto(projetos.get(0).getVersaoAtual().getNivel());
        resultado.setResultadoDaEquacao(projetos.get(0).getVersaoAtual().getResultadoDaEquacao());
        resultado.setStatusDoProjeto(projetos.get(0).getStatusDoProjeto());

        List<ResultadoDoProjeto> listaResultadosEsperados = new ArrayList<>();
        listaResultadosEsperados.add(resultado);

        List<ResultadoDoProjeto> listaResultados = projetoService.getListaResultadoDosProjetos();

        assertNotNull(listaResultados);
        Compara(listaResultadosEsperados, listaResultados);
    }

    private void Compara(List<ResultadoDoProjeto> resultadoEsperado, List<ResultadoDoProjeto> resultadoObtido) {
        assertNotNull(resultadoEsperado);
        assertNotNull(resultadoObtido);
        for (int i = 0; i < resultadoEsperado.size(); i++) {
            assertEquals(resultadoEsperado.get(i).getNivelDoProjeto(), resultadoObtido.get(i).getNivelDoProjeto());
            assertEquals(resultadoEsperado.get(i).getResultadoDaEquacao(), resultadoObtido.get(i).getResultadoDaEquacao(), 0);
            assertEquals(resultadoEsperado.get(i).getStatusDoProjeto(), resultadoObtido.get(i).getStatusDoProjeto());
        }
    }

    private List<Projeto> getListaDeProjetosEsperados() {
        Projeto projeto = FabricaDeObjetos.getInstancia().criarProjeto("1");
        List<Projeto> projetos = new ArrayList<Projeto>();
        projetos.add(projeto);

        return projetos;
    }

    private void setProjetosCadastrados(List<Projeto> projetos) throws JAXBException {
        when(repositorio.consultarListaProjetos()).thenReturn(projetos);
    }

    /**
     * Test of salvarProjeto method, of class ProjetoServiceImpl.
     */
    @Test
    public void testSalvarProjeto() throws Exception {
        System.out.println("salvarProjeto");
        Projeto projeto = null;

        projetoService.salvarProjeto(projeto);
        assertEquals("O projeto não foi salvo com sucesso",projeto, repositorio.consultarProjeto(projeto.getId()));
          

    }

    /**
     * Test of salvarConfiguracao method, of class ProjetoServiceImpl.
     */
    @Test
    public void testSalvarConfiguracao() throws Exception {
        System.out.println("salvarConfiguracao");
        Projeto projeto = null;

        projetoService.salvarConfiguracao(projeto);
        assertEquals("O configuração não foi salva com sucesso",projeto, repositorio.consultarProjeto(projeto.getId()));
        


    }

    /**
     * Test of getResultadoDoProjeto method, of class ProjetoServiceImpl.
     */
    @Test
    public void testGetResultadoDoProjeto() throws Exception {
        System.out.println("getResultadoDoProjeto");
        String idDoProjeto = "";

        ResultadoDoProjeto expResult = null;
        ResultadoDoProjeto result = projetoService.getResultadoDoProjeto(idDoProjeto);
        assertEquals(expResult, result);
        
        //Falta implementar

    }

    /**
     * Test of getListaResultadoDosProjetos method, of class ProjetoServiceImpl.
     */
    @Test
    public void testGetListaResultadoDosProjetos() throws Exception {
        System.out.println("getListaResultadoDosProjetos");

        List expResult = null;
        List result = projetoService.getListaResultadoDosProjetos();
        assertEquals(expResult, result);

        //Falta implementar
    }

    /**
     * Test of excluirTodosProjetos method, of class ProjetoServiceImpl.
     */
    @Test
    public void testExcluirTodosProjetos() {
        System.out.println("excluirTodosProjetos");

        projetoService.excluirTodosProjetos();
        assertTrue("O(s) projeto(s) não foram excluídos",repositorio.limpaDiretorio());

    }
}
