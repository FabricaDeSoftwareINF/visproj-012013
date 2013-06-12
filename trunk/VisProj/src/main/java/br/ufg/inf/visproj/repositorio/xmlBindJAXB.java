package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by IntelliJ IDEA.
 * Package: br.ufg.inf.visproj.repositorio
 * Class: xmlBindJAXB
 * User: ArthurNote
 * Date: 07/06/13
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */

public class xmlBindJAXB {


    public static void main(String args[]) {


        //Creating booking object for marshaling into XML document
        Map<String, Float> metricas = new HashMap();
        HashSet configMetricas = new HashSet<String>();
        configMetricas.add("complexidade");

        Nivel nivelSatisfatorio = new Nivel();
        nivelSatisfatorio.setMelhorQuandoMaior(true);
        nivelSatisfatorio.setValorFinal(3.5f);
        nivelSatisfatorio.setValorInicial(0f);

        Nivel nivelInsatisfatorio = new Nivel();
        nivelInsatisfatorio.setMelhorQuandoMaior(true);
        nivelInsatisfatorio.setValorInicial(0f);
        nivelInsatisfatorio.setValorFinal(4.0f);

        Nivel nivelPoucoSatisfatorio = new Nivel();
        nivelPoucoSatisfatorio.setMelhorQuandoMaior(false);
        nivelPoucoSatisfatorio.setValorFinal(5.5f);
        nivelPoucoSatisfatorio.setValorInicial(0.1f);


        Configuracao config = new Configuracao();
        config.setId("id_config");
        config.setEquacao("equacao");
        config.setMetricas(configMetricas);
        config.setNivelInsatisfatorio(nivelInsatisfatorio);
        config.setNivelSatisfatorio(nivelSatisfatorio);
        config.setNivelPoucoSatisfatorio(nivelPoucoSatisfatorio);


        GerenteDeProjeto gerenteDeProjeto = new GerenteDeProjeto();
        gerenteDeProjeto.setEmail("gerenteEmail");
        gerenteDeProjeto.setNome("gerenteNome");
        Versao versaoAtual = new Versao();
        versaoAtual.setData(Calendar.getInstance());
        versaoAtual.setMetricas(metricas);
        versaoAtual.setNivel(EnumNivelDoProjeto.SATISFATORIO);
        versaoAtual.setResultadoDaEquacao(88);
        Versao versaoAnterior = new Versao();

        Projeto projeto = new Projeto();
        projeto.setId("id_projeto_666");
        projeto.setConfiguracao(config);
        projeto.setGerenteDeProjeto(gerenteDeProjeto);
        projeto.setStatusDoProjeto(EnumStatusDoProjeto.MELHOROU);
        projeto.setVersaoAtual(versaoAtual);


        JAXBContext jaxbCtx = null;
        StringWriter xmlWriter = null;


        try {
            //XML Binding code using JAXB

            File file = new File("projeto.xml");

            jaxbCtx = JAXBContext.newInstance(Projeto.class);

            xmlWriter = new StringWriter();
            Marshaller jaxbMarshaller = jaxbCtx.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            jaxbCtx.createMarshaller().marshal(projeto, file);
            jaxbCtx.createMarshaller().marshal(projeto, xmlWriter);

            System.out.println("XML Marshal example in Java");
            System.out.println(xmlWriter);

            Projeto xmlout = (Projeto) jaxbCtx.createUnmarshaller().unmarshal(
                    new StringReader(xmlWriter.toString()));
            System.out.println("XML Unmarshal example in JAva");
            System.out.println(xmlout.toString());

            jaxbMarshaller.marshal(projeto, file);


        } catch (JAXBException ex) {
            Logger.getLogger(xmlBindJAXB.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public String getClassPath() {
        return this.getClass().getSimpleName();
    }
}



