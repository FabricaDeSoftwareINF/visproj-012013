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

public class TestesProjetoService  {

	private static IProjetoService projetoService;
	
	private static IRepositorio repositorio;
	
	@BeforeClass
	public static void setUp(){		
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
	public void TestaConsultaProjetoExistente() throws JAXBException{
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
	
	private void Compara(List<ResultadoDoProjeto> resultadoEsperado, List<ResultadoDoProjeto> resultadoObtido){
		assertNotNull(resultadoEsperado);
		assertNotNull(resultadoObtido);
		for(int i=0; i<resultadoEsperado.size(); i++ ){
			assertEquals(resultadoEsperado.get(i).getNivelDoProjeto(),resultadoObtido.get(i).getNivelDoProjeto());
			assertEquals(resultadoEsperado.get(i).getResultadoDaEquacao(),resultadoObtido.get(i).getResultadoDaEquacao(), 0);
			assertEquals(resultadoEsperado.get(i).getStatusDoProjeto(),resultadoObtido.get(i).getStatusDoProjeto());
		}
	}
	
	private List<Projeto> getListaDeProjetosEsperados(){
		Projeto projeto = FabricaDeObjetos.getInstancia().criarProjeto("1");
		List<Projeto> projetos = new ArrayList<Projeto>();
		projetos.add(projeto);
		
		return projetos;
	}
	
	private void setProjetosCadastrados(List<Projeto> projetos) throws JAXBException{
		when(repositorio.consultarListaProjetos()).thenReturn(projetos);
	}
}
