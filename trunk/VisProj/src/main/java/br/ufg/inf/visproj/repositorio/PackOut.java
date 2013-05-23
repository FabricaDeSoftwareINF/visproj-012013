package br.ufg.inf.visproj.repositorio;


import br.ufg.inf.visproj.model.Projeto;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    Projeto projeto;


    public static void main(String[] args) {

        Element agenda = new Element("PAI");

        //Define Agenda como root

        Document documento = new Document(agenda);


        for (int i = 0; i < 5; i++) {

            Element contato = new Element("Filhos");

            //Adiciona o atributo id ao Contato

            contato.setAttribute("id", Integer.toString(i));

            //Criando os elementos de contato

            Element nome = new Element("nome");

            nome.setText("Arthur");

            Element telefone = new Element("Idade");

            telefone.setText("24");

            Element endereco = new Element("endereco");

            endereco.setText("Av. Amaral Peixoto S/N");

            Element email = new Element("email");

            email.setText("sskkun@gmail.com");

            //Adicionando os elementos nome, telefone,

            //endereco e email em Contato

            contato.addContent(nome);

            contato.addContent(telefone);

            contato.addContent(endereco);

            contato.addContent(email);

            //Adicionado o Contato a Agenda

            agenda.addContent(contato);

        }

        XMLOutputter xout = new XMLOutputter();


        try {

            //Criando o arquivo de saida

            FileWriter arquivo = new FileWriter(

                    new File("c:/arquivo.xml"));

            //Imprimindo o XML no arquivo

            xout.output(documento, arquivo);

        } catch (IOException e) {

            e.printStackTrace();

        }


    }


}