package br.ufg.inf.visproj.repositorio;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        projeto2XML p2xml = new projeto2XML();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date startDate = new Date();
        Date endDate = new Date();
        //System.out.println(new Timestamp(startDate.getTime()));
        startDate = new Timestamp(startDate.getTime());
        endDate = new Timestamp(endDate.getTime() + 100000);


        p2xml.setGerenteDeProjeto("OBJETO GERENTE DE PROJETO");
        p2xml.setStatusDoProjeto("EXECUTANDO AGORA");
        p2xml.setVersaoAnterior(1);
        p2xml.setVersaoAtual(1.1);
        p2xml.setStartDate(startDate);
        p2xml.setEndDate(endDate);
        p2xml.setConfiguracao("*****NOT IMPLEMENTED YET******");


        JAXBContext jaxbCtx = null;

        StringWriter xmlWriter = null;
        try {
            //XML Binding code using JAXB

            File file = new File("C:\\marshal.xml");
            jaxbCtx = JAXBContext.newInstance(projeto2XML.class);

            xmlWriter = new StringWriter();
            Marshaller jaxbMarshaller = jaxbCtx.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            jaxbCtx.createMarshaller().marshal(p2xml, file);
            jaxbCtx.createMarshaller().marshal(p2xml, xmlWriter);

            System.out.println("XML Marshal example in Java");
            System.out.println(xmlWriter);

            projeto2XML xmlout = (projeto2XML) jaxbCtx.createUnmarshaller().unmarshal(
                    new StringReader(xmlWriter.toString()));
            System.out.println("XML Unmarshal example in JAva");
            System.out.println(xmlout.toString());

            jaxbMarshaller.marshal(p2xml, file);

        } catch (JAXBException ex) {
            Logger.getLogger(xmlBindJAXB.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
}


@XmlRootElement(name = "projeto")
@XmlAccessorType(XmlAccessType.FIELD)
class projeto2XML {
    @XmlElement(name = "GerenteDeProjeto")
    private String GerenteDeProjeto;

    @XmlElement(name = "statusDoProjeto")
    private String statusDoProjeto;

    @XmlElement(name = "versaoAtual")
    private double versaoAtual;

    @XmlElement(name = "versaoAnterior")
    private double versaoAnterior;

    @XmlElement(name = "startDate")
    private Date startDate;

    @XmlElement(name = "endDate")
    private Date endDate;

    @XmlElement(name = "configuracao")
    private String configuracao;


    public projeto2XML() {
    }


    public projeto2XML(String GerenteDeProjeto, String statusDoProjeto, Date startDate, Date endDate, String configuracao) {
        this.GerenteDeProjeto = GerenteDeProjeto;
        this.statusDoProjeto = statusDoProjeto;
        this.startDate = startDate;
        this.endDate = endDate;
        this.configuracao = configuracao;
    }

    public String getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }

    public String getStatusDoProjeto() {
        return statusDoProjeto;
    }

    public void setStatusDoProjeto(String statusDoProjeto) {
        this.statusDoProjeto = statusDoProjeto;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getGerenteDeProjeto() {
        return GerenteDeProjeto;
    }

    public void setGerenteDeProjeto(String gerenteDeProjeto) {
        this.GerenteDeProjeto = gerenteDeProjeto;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "projeto{" + "GerenteDeProjeto=" + GerenteDeProjeto + ", statusDoProjeto=" + statusDoProjeto + ", startDate=" + startDate + ", endDate=" + endDate + ", configuracao=" + configuracao + '}';

    }

    public double getVersaoAtual() {
        return versaoAtual;
    }

    public void setVersaoAtual(double versaoAtual) {
        this.versaoAtual = versaoAtual;
    }

    public double getVersaoAnterior() {
        return versaoAnterior;
    }

    public void setVersaoAnterior(double versaoAnterior) {
        this.versaoAnterior = versaoAnterior;
    }
}
