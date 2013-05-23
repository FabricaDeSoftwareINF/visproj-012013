package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;

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

    private IRepositorio repositorio;
    private Projeto projeto;

    //construtor devera ser vinculado ao @BeforeClass dentro do junit.
    public TestesRepositorio() {
        repositorio.limpaDiretorio();
        repositorio = new Repositorio();
        projeto = criarProjeto("Projeto de Teste");
        repositorio.salvarOuAtualizarProjeto(this.projeto);
    }

    public void testaSalvarProjetoInexistente() {

        Projeto projeto = criarProjeto("ProjetoX");

        repositorio.salvarOuAtualizarProjeto(projeto);
        Projeto projetoConsultado = repositorio.consultarProjeto(projeto.getId());
        /**
         * assert.isNotNull(projetoConsultado);
         * assert.areEquals(projeto.getStatusDoProjeto(), projetoConsultado.getStatusDoProjeto())

         */
        repositorio.excluirProjeto(projeto.getId());

    }


    public void testaSalvarProjetoExistente() {
        Configuracao config = new Configuracao();
        config.setEquacao("Equacao");
        this.projeto.setConfiguracao(config);
        repositorio.salvarOuAtualizarProjeto(projeto);

        Projeto projetoConsultado = repositorio.consultarProjeto(this.projeto.getId());

        //criar os assert equals para todos as propriedades do objeto CONFIGURACAO
        // o return de todos os assert equals devem ser iguais, exceto para a propriedade EQUACAO,
        //como foi alterada devera retornar diferente do existente.

    }

    public void testaConsultarProjetoExistente() {
        Projeto projetoConsultado = repositorio.consultarProjeto(this.projeto.getId());
        // Assert.isNotNull();

    }

    public void testaConsultarProjetoInexistente() {
        Projeto projetoConsultado = repositorio.consultarProjeto("batema");
        // Assert.isNull();

    }

    public void testaConsultarConfiguracaoExistente() {
        Configuracao config = repositorio.consultarConfiguracao(this.projeto.getConfiguracao().getId());
        //     Assert.IsNotNull();
        //objeto config deve ser comparado com o projeto this.projeto.getConfiguracao
        //devera ser comparada todas as propriedades do objeto configuracao.
    }

    public void testaConsultarConfiguracaoInexistente() {
        Configuracao config = repositorio.consultarConfiguracao(this.projeto.getConfiguracao().getId());
        //Asset.isNull()   ;

    }

    public void testaConsultarListadeProjetosExistentes() {
        List<Projeto> listaProjetos = repositorio.consultarListaProjetos();
        //Assert.isNotNull();
        //Assert.areEquals(1, listaProjetos.size());
        //devera analisar a qualidade de projetos que a listaProjetos conseguiu retornar.
        //neste caso como somente um projeto foi cadastrado Globalmente, o resultado devera ser igual a 1.
        //devera ser criado um for que chama o metodo que compara projetos
        //para comparar todos os projetos que foram retornados na listaProjetos()
    }

    public void testaConsultarListadeProjetoInexistentes() {
        repositorio.excluirProjeto(this.projeto.getId());
        List<Projeto> listaProjetos = repositorio.consultarListaProjetos();
        //Assert.areEquals(0 , listaProjetos.size());  ---- size = zero significa que nao existe projetos.
        //devera ser retornado a lista vazia, com zero projetos cadastrados.
        if (listaProjetos.size() == 0) {
            repositorio.salvarOuAtualizarProjeto(this.projeto);
        }
    }

    private Projeto criarProjeto(String id) {
        // projeto.setID("ProjetoX")  todas as outras propriedades
        //criar valores randomicos para todas as propriedades do objeto projeto
        return new Projeto();
    }

}
