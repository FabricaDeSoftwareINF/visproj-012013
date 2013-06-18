package br.ufg.inf.visproj.util;

import br.ufg.inf.visproj.model.*;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Package: br.ufg.inf.visproj.util
 * Class: FabricaDeObjetos
 * User: ArthurNote
 * Date: 17/06/13
 * Time: 21:07
 * To change this template use File | Settings | File Templates.
 */

public class FabricaDeObjetos {

    public static Projeto criarProjeto(String id) {
        Projeto projeto = new Projeto();
        projeto.setId(id);
        projeto.setConfiguracao(criarConfiguracao(id));
        projeto.setVersaoAtual(criarVersao(80f));
        projeto.setVersaoAnterior(criarVersao(90f));
        projeto.setGerenteDeProjeto(criarGerenteDeProjeto());
        return projeto;
    }

    public static Configuracao criarConfiguracao(String id) {
        Configuracao config = new Configuracao();
        config.setId(id);
        config.setEquacao("equacao");
        config.setMetricas(criarMetricasConfiguracao());
        config.setNivelInsatisfatorio(criarNivel(10f, 100f, true));
        config.setNivelPoucoSatisfatorio(criarNivel(4f, 10f, false));
        config.setNivelSatisfatorio(criarNivel(0f, 3f, true));

        return config;
    }

    public static Nivel criarNivel(Float valorInicial, Float valorFinal, boolean melhorQuandoMaior) {
        Nivel nivel = new Nivel();
        nivel.setValorInicial(valorInicial);
        nivel.setValorFinal(valorFinal);
        nivel.setMelhorQuandoMaior(melhorQuandoMaior);
        return nivel;
    }

    public static Map<String, Float> criarMapMetricas() {
        Map<String, Float> metricas = new HashMap();
        metricas.put("complexidade", 20f);

        return metricas;
    }

    public static Set<String> criarMetricasConfiguracao() {
        Set<String> metricas = new HashSet();
        metricas.add("complexidade");
        return metricas;
    }

    public static Versao criarVersao(Float resultadoEquacao) {
        Versao versao = new Versao();
        versao.setData(Calendar.getInstance());
        versao.setMetricas(criarMapMetricas());
        versao.setNivel(EnumNivelDoProjeto.SATISFATORIO);
        versao.setResultadoDaEquacao(resultadoEquacao);
        return versao;
    }

    public static GerenteDeProjeto criarGerenteDeProjeto() {
        GerenteDeProjeto gerente = new GerenteDeProjeto();
        gerente.setNome("José da silva");
        gerente.setEmail("josedasilva@gmail.com");
        return gerente;
    }


}
