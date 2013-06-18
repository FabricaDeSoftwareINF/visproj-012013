package br.ufg.inf.visproj.repositorio;


import br.ufg.inf.visproj.model.Projeto;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Package: PACKAGE_NAME
 * Class: packOut
 * User: ArthurNote
 * Date: 15/05/13
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */


public class RepositorioUtils {

    private final boolean DIRETORIO_CRIADO;
    private final String PATH = "Projetos";
    private File arquivo;

    public RepositorioUtils() {
        this.DIRETORIO_CRIADO = new File(PATH).mkdir();

    }

    public boolean salvarArquivo(Projeto projeto) throws IOException {
        JAXBContext jaxbCtx = null;
        StringWriter xmlWriter = null;
        Marshaller jaxbMarshaller = null;

        try {

            File file = new File(PATH + "\\" + projeto.getId() + ".xml");

            jaxbCtx = JAXBContext.newInstance(Projeto.class);

            //xmlWriter = new StringWriter();
            jaxbMarshaller = jaxbCtx.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(projeto, file);


            if (arquivo == null || !arquivo.isFile()) {
                return false;
            }


            return true;
        } catch (JAXBException ex) {
            Logger.getLogger(RepositorioUtils.class.getName()).log(Level.SEVERE,
                    null, ex);


        }

        return false;

    }

    private boolean excluirArquivo(Projeto projeto) throws JAXBException {
        JAXBContext jaxbCtx = null;
        StringWriter xmlWriter = null;
        jaxbCtx = JAXBContext.newInstance(Projeto.class);

        jaxbCtx.createMarshaller().marshal(projeto, xmlWriter);

        File file = new File(PATH + "\\" + projeto.getId() + ".xml");

        if (file.exists()) {
            file.delete();

            return true;
        }

        Projeto xmlout = (Projeto) jaxbCtx.createUnmarshaller().unmarshal(new StringReader(xmlWriter.toString()));

        return false;
    }

    private boolean limpaDiretorio() {
        File file = new File(PATH);

        if (file.exists() && file.isDirectory()) {
            file.delete();

            return true;
        }

        return false;
    }

    boolean validaDiretorio() {

        if (!DIRETORIO_CRIADO) {
            System.out.println("o Arquivo informado não pertence a este DIRETORIO_CRIADO.");
            return false;
        }

        if (this.DIRETORIO_CRIADO) {
            if (arquivo.exists()) {
                System.out.println("Diretório existe!");
                return true;
            }

        }
        return false;

    }

    public String coletaClasseDiretorio(String classe) {

        String PROGRAM_DIRECTORY;
        classe = classe + ".class";
        try {
            //Attempt to get the path of the actual JAR file, because the working directory is frequently not where the file is.
            //Example: file:/D:/all/Java/TitanWaterworks/TitanWaterworks-en.jar!/TitanWaterworks.class
            //Another example: /D:/all/Java/TitanWaterworks/TitanWaterworks.class
            PROGRAM_DIRECTORY = getClass().getClassLoader().getResource(classe).getPath(); // Gets the path of the class or jar.

            //Find the last ! and cut it off at that location. If this isn't being run from a jar, there is no !, so it'll cause an exception, which is fine.
            try {
                PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(0, PROGRAM_DIRECTORY.lastIndexOf('!'));
            } catch (Exception e) {
            }

            //Find the last / and cut it off at that location.
            PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(0, PROGRAM_DIRECTORY.lastIndexOf('/') + 1);
            //If it starts with /, cut it off.
            if (PROGRAM_DIRECTORY.startsWith("/"))
                PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(1, PROGRAM_DIRECTORY.length());
            //If it starts with file:/, cut that off, too.
            if (PROGRAM_DIRECTORY.startsWith("file:/"))
                PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(6, PROGRAM_DIRECTORY.length());
        } catch (Exception e) {
            PROGRAM_DIRECTORY = ""; //Current working directory instead.
        }

        return PROGRAM_DIRECTORY;
    }


    /*boolean projeto2XML(Projeto projeto) {

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


    }*/


    String coletaUltimoIdProjeto() {
        String retorno = null;

        URL url = Repositorio.class.getResource("resources/");
        if (url == null) {
            System.err.println("Diretorio de Resources não encontrado.");
        } else {
            File dir = new File(String.valueOf(url));
            for (File nextFile : dir.listFiles()) {
                nextFile.getName();
            }
        }

        return retorno;

    }


}



