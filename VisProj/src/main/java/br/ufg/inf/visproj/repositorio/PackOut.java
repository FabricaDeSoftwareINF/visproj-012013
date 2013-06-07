package br.ufg.inf.visproj.repositorio;


import br.ufg.inf.visproj.model.Projeto;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Package: PACKAGE_NAME
 * Class: packOut
 * User: ArthurNote
 * Date: 15/05/13
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */


public class PackOut {

    private File diretorio;
    private File arquivo;


    private boolean diretorioExiste(File diretorio) {
        if (diretorio.exists()) {
            System.out.println("Diretório existe!");
            return true;
        }
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    boolean consultaArquivo(File diretorio, File arquivo) {


        if (!diretorio.equals(arquivo.getAbsolutePath())) {
            System.out.println("o Arquivo informado não pertence a este diretorio.");
            return false;
        }

        if (diretorioExiste(this.diretorio)) {
            if (arquivo.exists()) {
                System.out.println("Diretório existe!");
                return true;
            }

        }
        return false;

    }


    boolean projeto2XML(Projeto projeto) {

        projeto.getId();
        projeto.getGerenteDeProjeto();
        projeto.getConfiguracao();
        projeto.getStatusDoProjeto();
        projeto.getVersaoAnterior();
        projeto.getVersaoAtual();


        Attribute id = new Attribute("id", Integer.toString(1));
        Element arquivoProjeto = new Element("PROJETO");
        arquivoProjeto.setAttribute(id.setValue("1"));

        //Define Agenda como root

        Document documento = new Document(arquivoProjeto);

        //Cria o elemento Contato

        for (int i = 0; i < 5; i++) {
            Element metrica = new Element("METRICA");

            //Adiciona o atributo id ao Contato

            metrica.setAttribute("id", "123");

            //Criando os elementos de contato

            Element nomeMetrica = new Element("nome");

            nomeMetrica.setText("NOME_DA_METRICA");

            Element classificacaoMetrica = new Element("CLASSIFICACAO_DA_METRICA");

            classificacaoMetrica.setText("123-456");

            Element endereco = new Element("endereco");

            endereco.setText("Av. Amaral Peixoto S/N");

            Element email = new Element("email");

            email.setText("glaucioguerra@gmail.com");

            //Adicionando elementos nome, telefone, endereco e email no Contato

            metrica.addContent(nomeMetrica);

            metrica.addContent(classificacaoMetrica);

            metrica.addContent(endereco);

            metrica.addContent(email);

            //Adicionado o Contato a Agenda

            arquivoProjeto.addContent(metrica);

            //Classe responsável para imprimir / gerar o XML

        }
        XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());

        try {

            //Criando o arquivo de saida

            FileWriter arquivo = new FileWriter(

                    new File("c:/arquivo.xml"));

            //Imprimindo o XML no arquivo

            xout.output(documento, arquivo);
            return true;


        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }


    }


    String coletaUltimoIdProjeto() {
        String retorno = null;
        File dados = new File("c://arquivo.xml");
        SAXBuilder sb = new SAXBuilder();
        Document projetoReader = null;
        try {
            projetoReader = sb.build(dados);
        } catch (JDOMException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Element projeto = projetoReader.getRootElement();

        List elements = projeto.getChildren();

        Iterator i = elements.iterator();

        //Iteramos com os elementos filhos, e filhos dos filhos
        while (i.hasNext()) {
            Element element = (Element) i.next();
            retorno = "ID: " + projeto.getAttributeValue("id");
        }


        return retorno;
    }


    Projeto xml2Projeto(Integer id) {
        Projeto projeto = null;
        File dados = new File("c://arquivo.xml");
        SAXBuilder sb = new SAXBuilder();
        Document projetoReader = null;
        try {
            projetoReader = sb.build(dados);
        } catch (JDOMException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Element elementoProjeto = projetoReader.getRootElement();

        List elements = elementoProjeto.getChildren();

        Iterator i = elements.iterator();

        //Iteramos com os elementos filhos, e filhos dos filhos
        while (i.hasNext()) {
            Element element = (Element) i.next();
            projeto.setId(elementoProjeto.getAttributeValue("id"));
        }


        return projeto;
    }


    private class arquivoDir {
        private String diretorio;
        private String arquivo;
        private String idProjeto;

        private arquivoDir(String diretorio, String arquivo, String idProjeto) {
            this.diretorio = diretorio;
            this.arquivo = arquivo;
            this.idProjeto = idProjeto;
        }

        public String getDiretorio() {
            return diretorio;
        }

        public void setDiretorio(String diretorio) {
            this.diretorio = diretorio;
        }

        public String getArquivo() {
            return arquivo;
        }

        public void setArquivo(String arquivo) {
            this.arquivo = arquivo;
        }

        public String getIdProjeto() {
            return idProjeto;
        }

        public void setIdProjeto(String idProjeto) {
            this.idProjeto = idProjeto;
        }
    }
}



