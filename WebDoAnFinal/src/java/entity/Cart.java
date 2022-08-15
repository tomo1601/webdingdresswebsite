/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByIDCart", query = "SELECT c FROM Cart c WHERE c.iDCart = :iDCart"),
    @NamedQuery(name = "Cart.findByMailClient", query = "SELECT c FROM Cart c WHERE c.mailClient = :mailClient"),
    @NamedQuery(name = "Cart.findByTongTien", query = "SELECT c FROM Cart c WHERE c.tongTien = :tongTien")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Cart")
    private String iDCart;
    @Column(name = "Mail_Client")
    private String mailClient;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Tong_Tien")
    private Double tongTien;

    public Cart() {
    }

    public Cart(String iDCart) {
        this.iDCart = iDCart;
    }

    public String getIDCart() {
        return iDCart;
    }

    public void setIDCart(String iDCart) {
        this.iDCart = iDCart;
    }

    public String getMailClient() {
        return mailClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    
    public String getTotalCurrencyFormat() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((tongTien));
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCart != null ? iDCart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.iDCart == null && other.iDCart != null) || (this.iDCart != null && !this.iDCart.equals(other.iDCart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cart[ iDCart=" + iDCart + " ]";
    }
    
}
