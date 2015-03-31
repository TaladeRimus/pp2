/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 631310007
 */
@ManagedBean
@SessionScoped
public class BeanPadaria {
    private ArrayList<String> produtos = new ArrayList();
    private String prodAdd, prodEditOld, ProdEditNew;
    /**
     * Creates a new instance of BeanPadaria
     */
    public BeanPadaria() {
        prodAdd = "";
    }
    
    public String editarProdutos(){
        if(getProdAdd().isEmpty()){
            return "sucesso";
        }
        else{
            for (int i = 0; i < produtos.size(); i++) {
                if(getProdEditOld().equals(produtos.get(i))){
                    produtos.add(getProdEditNew());
                    continue;
                }
                else{
                    continue;
                }
            }
            return "sucesso";
        }
    }
    
    public String insereProdutos(){ 
        if(getProdAdd().isEmpty()){
            return "account";
        }
        else{
        produtos.add(getProdAdd());
        return "sucesso";
            
        }
    }
    
    public ArrayList<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<String> produtos) {
        this.produtos = produtos;
    }

    public String getProdAdd() {
        return prodAdd;
    }

    public void setProdAdd(String prodAdd) {
        this.prodAdd = prodAdd;
    }

    public String getProdEditOld() {
        return prodEditOld;
    }

    public void setProdEditOld(String prodEditOld) {
        this.prodEditOld = prodEditOld;
    }

    public String getProdEditNew() {
        return ProdEditNew;
    }

    public void setProdEditNew(String ProdEditNew) {
        this.ProdEditNew = ProdEditNew;
    }

    
    
    
    
    
}
