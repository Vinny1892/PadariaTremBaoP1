/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.qoppa.pdfWriter.*;
import dao.*;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GestaoCliente;
import model.GestaoEstoque;
import model.GestaoFornecedor;
import model.GestaoGerente;
import model.GestaoProduto;
import model.Padeiro;
import model.Vendedor;

/**
 *
 * @author mateus
 */
public class ControllerInformacao {

    private String type;
    private int codigo;
    private PDFDocument pdfDoc;
    private PDFPage newPage;
    private Graphics2D g2d;

    public ControllerInformacao(String tipo) {
        type = tipo;
        pdfDoc = new PDFDocument();
        newPage = pdfDoc.createPage(new PageFormat());
        g2d = newPage.createGraphics();
        g2d.setFont(PDFGraphics.HELVETICA.deriveFont(18f));
    }

    public void createPDF() {
        int cont = 90;
        switch (type) {
            case "Fornecedor":
                DaoFornecedor df = new DaoFornecedor();
                try {
                    ArrayList<Object> fornecedores = df.getAll();
                    for (int i = 0; i < fornecedores.size(); i++) {
                        GestaoFornecedor f = (GestaoFornecedor) fornecedores.get(i);
                        g2d.drawString("Nome: " + f.getNome(), 100, cont);
                        g2d.drawString("CPNJ: " + f.getCnpj(), 100, cont + 20);
                        g2d.drawString("Endereço: " + f.getEndereco(), 100, cont + 40);
                        g2d.drawString("É recorente: " + String.valueOf(f.isRecorrente()), 100, cont + 60);
                        g2d.drawString("Taxa: " + String.valueOf(f.getTaxaDesconto()), 100, cont + 80);
                        g2d.drawString("-------------------------------", 100, cont + 95);
                        cont = cont + 110;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Produto":
                DaoProduto dp = new DaoProduto();
                try {
                    ArrayList<Object> produtos = (ArrayList<Object>) dp.getAll();
                    for (int i = 0; i < produtos.size(); i++) {
                        GestaoEstoque f = (GestaoEstoque) produtos.get(i);
                        GestaoProduto p = f.getProduto();
                        g2d.drawString("Nome: " + p.getNome(), 100, cont);
                        g2d.drawString("Apelido: " + p.getApelido(), 100, cont + 20);
                        g2d.drawString("Preço Custo: " + p.getPrecoCusto(), 100, cont + 40);
                        g2d.drawString("Fornecedor: " + p.getFornecedor().getNome(), 100, cont + 60);
                        g2d.drawString("Data de validade: " + f.getDataValidade(), 100, cont + 80);
                        g2d.drawString("Quantidade em estoque: " + f.getQtdProduto(), 100, cont + 100);
                        g2d.drawString("-------------------------------", 100, cont + 115);
                        cont = cont + 130;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Cliente":
                DaoCliente dc = new DaoCliente();
                try {
                    ArrayList<Object> clientes = (ArrayList<Object>) dc.getAll();
                    for (int i = 0; i < clientes.size(); i++) {
                        GestaoCliente f = (GestaoCliente) clientes.get(i);
                        g2d.drawString("Nome: " + f.getNome(), 100, cont);
                        g2d.drawString("CPF: " + f.getCpf(), 100, cont + 20);
                        g2d.drawString("Endereço: " + f.getEndereco(), 100, cont + 40);
                        g2d.drawString("Telefone: " + f.getTelefone(), 100, cont + 60);
                        g2d.drawString("Cartao: " + f.getCartaoFidelidade(), 100, cont + 80);
                        g2d.drawString("-------------------------------", 100, cont + 95);
                        cont = cont + 110;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Vendedor":
                DaoVendedor dv = new DaoVendedor();
                try {
                    ArrayList<Object> vendedor = (ArrayList<Object>) dv.getAll();
                    for (int i = 0; i < vendedor.size(); i++) {
                        Vendedor v = (Vendedor) vendedor.get(i);
                        g2d.drawString("Nome: " + v.getNome(), 100, cont);
                        g2d.drawString("CPF: " + v.getCpf(), 100, cont + 20);
                        g2d.drawString("Endereço: " + v.getEndereco(), 100, cont + 40);
                        g2d.drawString("Telefone: " + v.getTelefone(), 100, cont + 60);
                        g2d.drawString("Salario Base: " + v.getSalarioBaseMensal(), 100, cont + 80);
                        g2d.drawString("Meta De Venda: " + v.getMetaVenda(), 100, cont + 100);
                        g2d.drawString("Vendido: R$ " + v.getMontanteVenda(), 100, cont + 120);
                        g2d.drawString("-------------------------------", 100, cont + 135);
                        cont = cont + 150;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Padeiro":
                DaoPadeiro daopadeiro = new DaoPadeiro();
                try {
                    ArrayList<Object> padeiros = (ArrayList<Object>) daopadeiro.getAll();
                    for (int i = 0; i < padeiros.size(); i++) {
                        Padeiro p = (Padeiro) padeiros.get(i);
                        g2d.drawString("Nome: " + p.getNome(), 100, cont);
                        g2d.drawString("CPF: " + p.getCpf(), 100, cont + 20);
                        g2d.drawString("Endereço: " + p.getEndereco(), 100, cont + 40);
                        g2d.drawString("Telefone: " + p.getTelefone(), 100, cont + 60);
                        g2d.drawString("Salario Base: " + p.getSalarioBaseMensal(), 100, cont + 80);
                        g2d.drawString("Horas Trabalhada noturno: " + p.getHorasTrabalhadaNoturno(), 100, cont + 100);
                        g2d.drawString("-------------------------------", 100, cont + 115);
                        cont = cont + 130;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Gerente":
                DaoGerente daog = new DaoGerente();
                try {
                    ArrayList<Object> gerentes = (ArrayList<Object>) daog.getAll();
                    for (int i = 0; i < gerentes.size(); i++) {
                        GestaoGerente p = (GestaoGerente) gerentes.get(i);
                        g2d.drawString("Nome: " + p.getNome(), 100, cont);
                        g2d.drawString("CPF: " + p.getCpf(), 100, cont + 20);
                        g2d.drawString("Endereço: " + p.getEndereco(), 100, cont + 40);
                        g2d.drawString("Telefone: " + p.getTelefone(), 100, cont + 60);
                        g2d.drawString("Salario Base: " + p.getSalarioBaseMensal(), 100, cont + 80);
                        g2d.drawString("-------------------------------", 100, cont + 95);
                        cont = cont + 115;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Impostos":
//                DaoImposto daog = new DaoGerente();
//                    try {
//                        ArrayList<Object> gerentes = (ArrayList<Object>) daog.getAll();
//                        for (int i = 0; i < gerentes.size(); i++) {
//                            GestaoGerente p = (GestaoGerente) gerentes.get(i);
//                            g2d.drawString("Nome: " + p.getNome(), 100, 100);
//                            g2d.drawString("CPF: " + p.getCpf(), 100, 100);
//                            g2d.drawString("Endereço: " + p.getEndereco(), 100, 100);
//                            g2d.drawString("Telefone: " + p.getTelefone(), 100, 100);
//                            g2d.drawString("Salario Base: " + p.getSalarioBaseMensal(), 100, 100);
//                            g2d.drawString("Horas trabalhada noturno: " + p.getSalarioBaseMensal(), 100, 100);
//                        }
//                    } catch(SQLException e) {
//                        e.printStackTrace();
//                    }
                break;
        }
        try {
            pdfDoc.addPage(newPage);
            pdfDoc.saveDocument("relatorio.pdf");
            System.out.println("Relatorio impresso!");
        } catch (IOException ex) {
            Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createPDF(int cod) {
        int cont = 90;
        switch (type) {
            case "Fornecedor":
                DaoFornecedor df = new DaoFornecedor();
                try {
                    GestaoFornecedor f = (GestaoFornecedor) df.getById(cod);
                    g2d.drawString("Nome: " + f.getNome(), 100, cont);
                    g2d.drawString("CPNJ: " + f.getCnpj(), 100, cont + 20);
                    g2d.drawString("Endereço: " + f.getEndereco(), 100, cont + 40);
                    g2d.drawString("É recorente: " + String.valueOf(f.isRecorrente()), 100, cont + 60);
                    g2d.drawString("Taxa: " + String.valueOf(f.getTaxaDesconto()), 100, cont + 80);
                    g2d.drawString("-------------------------------", 100, cont + 95);
                    cont = cont + 110;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Produto":
                DaoEstoque daoe = new DaoEstoque();
                try {
                    ArrayList<Object> produtos = (ArrayList<Object>) daoe.getById(cod);
                    GestaoEstoque f = (GestaoEstoque) produtos.get(0);
                    GestaoProduto p = f.getProduto();
                    g2d.drawString("Nome: " + p.getNome(), 100, cont);
                    g2d.drawString("Apelido: " + p.getApelido(), 100, cont + 20);
                    g2d.drawString("Preço Custo: " + p.getPrecoCusto(), 100, cont + 40);
                    g2d.drawString("Fornecedor: " + p.getFornecedor().getNome(), 100, cont + 60);
                    g2d.drawString("Data de validade: " + f.getDataValidade(), 100, cont + 80);
                    g2d.drawString("Quantidade em estoque: " + f.getQtdProduto(), 100, cont + 100);
                    g2d.drawString("-------------------------------", 100, cont + 115);
                    cont = cont + 130;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Cliente":
                DaoCliente dc = new DaoCliente();
                try {
                    GestaoCliente f = (GestaoCliente) dc.getById(cod);
                    g2d.drawString("Nome: " + f.getNome(), 100, cont);
                    g2d.drawString("CPF: " + f.getCpf(), 100, cont + 20);
                    g2d.drawString("Endereço: " + f.getEndereco(), 100, cont + 40);
                    g2d.drawString("Telefone: " + f.getTelefone(), 100, cont + 60);
                    g2d.drawString("Cartao: " + f.getCartaoFidelidade(), 100, cont + 80);
                    g2d.drawString("-------------------------------", 100, cont + 95);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Vendedor":
                DaoVendedor dv = new DaoVendedor();
                try {
                    Vendedor v = (Vendedor) dv.getById(cod);
                    g2d.drawString("Nome: " + v.getNome(), 100, cont);
                    g2d.drawString("CPF: " + v.getCpf(), 100, cont + 20);
                    g2d.drawString("Endereço: " + v.getEndereco(), 100, cont + 40);
                    g2d.drawString("Telefone: " + v.getTelefone(), 100, cont + 60);
                    g2d.drawString("Salario Base: " + v.getSalarioBaseMensal(), 100, cont + 80);
                    g2d.drawString("Meta De Venda: " + v.getMetaVenda(), 100, cont + 100);
                    g2d.drawString("Vendido: R$ " + v.getMontanteVenda(), 100, cont + 120);
                    g2d.drawString("-------------------------------", 100, cont + 135);
                        cont = cont + 150;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Padeiro":
                DaoPadeiro daopadeiro = new DaoPadeiro();
                try {
                    Padeiro p = (Padeiro) daopadeiro.getById(cod);
                    g2d.drawString("Nome: " + p.getNome(), 100, cont);
                    g2d.drawString("CPF: " + p.getCpf(), 100, cont + 20);
                    g2d.drawString("Endereço: " + p.getEndereco(), 100, cont + 40);
                    g2d.drawString("Telefone: " + p.getTelefone(), 100, cont + 60);
                    g2d.drawString("Salario Base: " + p.getSalarioBaseMensal(), 100, cont + 80);
                    g2d.drawString("Horas Trabalhada noturno: " + p.getHorasTrabalhadaNoturno(), 100, cont + 100);
                    g2d.drawString("-------------------------------", 100, cont + 115);
                    cont = cont + 130;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "Gerente":
                DaoGerente daog = new DaoGerente();
                try {
                    GestaoGerente p = (GestaoGerente) daog.getById(cod);
                    g2d.drawString("Nome: " + p.getNome(), 100, cont);
                    g2d.drawString("CPF: " + p.getCpf(), 100, cont + 20);
                    g2d.drawString("Endereço: " + p.getEndereco(), 100, cont + 40);
                    g2d.drawString("Telefone: " + p.getTelefone(), 100, cont + 60);
                    g2d.drawString("Salario Base: " + p.getSalarioBaseMensal(), 100, cont + 80);
                    g2d.drawString("-------------------------------", 100, cont + 95);
                    cont = cont + 115;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Impostos":
//                DaoImposto daog = new DaoGerente();
//                    try {
//                        ArrayList<Object> gerentes = (ArrayList<Object>) daog.getAll();
//                        for (int i = 0; i < gerentes.size(); i++) {
//                            GestaoGerente p = (GestaoGerente) gerentes.get(i);
//                            g2d.drawString("Nome: " + p.getNome(), 100, 100);
//                            g2d.drawString("CPF: " + p.getCpf(), 100, 100);
//                            g2d.drawString("Endereço: " + p.getEndereco(), 100, 100);
//                            g2d.drawString("Telefone: " + p.getTelefone(), 100, 100);
//                            g2d.drawString("Salario Base: " + p.getSalarioBaseMensal(), 100, 100);
//                            g2d.drawString("Horas trabalhada noturno: " + p.getSalarioBaseMensal(), 100, 100);
//                        }
//                    } catch(SQLException e) {
//                        e.printStackTrace();
//                    }
                break;
        }
        try {
            pdfDoc.addPage(newPage);
            pdfDoc.saveDocument("relario.pdf");
            System.out.println("Relatorio impresso!");
        } catch (IOException ex) {
            Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
