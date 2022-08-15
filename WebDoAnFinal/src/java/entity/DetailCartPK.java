/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ASUS
 */
@Embeddable
public class DetailCartPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_Cart")
    private String iDCart;
    @Basic(optional = false)
    @Column(name = "ID_Prod")
    private String iDProd;

    public DetailCartPK() {
    }

    public DetailCartPK(String iDCart, String iDProd) {
        this.iDCart = iDCart;
        this.iDProd = iDProd;
    }

    public String getIDCart() {
        return iDCart;
    }

    public void setIDCart(String iDCart) {
        this.iDCart = iDCart;
    }

    public String getIDProd() {
        return iDProd;
    }

    public void setIDProd(String iDProd) {
        this.iDProd = iDProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCart != null ? iDCart.hashCode() : 0);
        hash += (iDProd != null ? iDProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailCartPK)) {
            return false;
        }
        DetailCartPK other = (DetailCartPK) object;
        if ((this.iDCart == null && other.iDCart != null) || (this.iDCart != null && !this.iDCart.equals(other.iDCart))) {
            return false;
        }
        if ((this.iDProd == null && other.iDProd != null) || (this.iDProd != null && !this.iDProd.equals(other.iDProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetailCartPK[ iDCart=" + iDCart + ", iDProd=" + iDProd + " ]";
    }
    
}
