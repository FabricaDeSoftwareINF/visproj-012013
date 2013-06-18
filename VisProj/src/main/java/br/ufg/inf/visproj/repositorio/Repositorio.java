package br.ufg.inf.visproj.repositorio;

import br.ufg.inf.visproj.model.Configuracao;
import br.ufg.inf.visproj.model.Projeto;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Package: br.ufg.inf.visproj.repositorio
 * Class: Repositorio
 * User: ArthurNote
 * Date: 22/05/13
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */

public class Repositorio implements IRepositorio {


    private final boolean DIRETORIO_CRIADO;
    private final String PATH = "Projetos";
    private File arquivo;


    public Repositorio() {
        this.DIRETORIO_CRIADO = new File(PATH).mkdir();
    }


    public Projeto consultarProjeto(String id) throws JAXBException {

        File file = new File(getPathCompleto(id));
        if (!file.exists()) {
            return null;
        }

        JAXBContext jaxbCtx = null;
        jaxbCtx = JAXBContext.newInstance(Projeto.class);
        Projeto projetoConsultado = (Projeto) jaxbCtx.createUnmarshaller().unmarshal(file);

        return projetoConsultado;
    }

    public Configuracao consultarConfiguracao(String idProjeto) throws JAXBException {

        Projeto projeto = consultarProjeto(idProjeto);
        if (projeto != null) {
            return projeto.getConfiguracao();
        }

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean salvarOuAtualizarProjeto(Projeto projeto) throws IOException {
        JAXBContext jaxbCtx = null;
        StringWriter xmlWriter = null;
        Marshaller jaxbMarshaller = null;

        if (projeto.getId() == null || projeto.getId().isEmpty()) {
            return false;
        }
        try {

            File file = new File(getPathCompleto(projeto.getId()));

            jaxbCtx = JAXBContext.newInstance(Projeto.class);

            //xmlWriter = new StringWriter();
            jaxbMarshaller = jaxbCtx.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(projeto, file);

            return true;
        } catch (JAXBException ex) {
            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE,
                    null, ex);

            return false;

        }

    }

    public List<Projeto> consultarListaProjetos() throws JAXBException {

        File file = new File(PATH);

        File files[] = file.listFiles();


        List<Projeto> listaDeProjetos = new ArrayList<>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                JAXBContext jaxbCtx = null;
                jaxbCtx = JAXBContext.newInstance(Projeto.class);
                Projeto projetoConsultado = (Projeto) jaxbCtx.createUnmarshaller().unmarshal(file);
                listaDeProjetos.add(projetoConsultado);
            }
        }
        return listaDeProjetos;

    }

    public boolean excluirProjeto(String id) throws JAXBException {
        File file = new File(getPathCompleto(id));
        if (file.exists()) {
            file.delete();

            return true;
        }
        return false;
    }

    public boolean limpaDiretorio() {
        File file = new File(PATH);

        if (file.exists() && file.isDirectory()) {

            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
            file.delete();

            file.mkdir();
            return true;
        }

        return false;
    }

    private String getPathCompleto(String nomeArquivo) {

        return PATH + "\\" + nomeArquivo + ".xml";
    }

}
