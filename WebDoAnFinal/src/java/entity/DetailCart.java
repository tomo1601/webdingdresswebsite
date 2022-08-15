/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "detail_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailCart.findAll", query = "SELECT d FROM DetailCart d"),
    @NamedQuery(name = "DetailCart.findByIDCart", query = "SELECT d FROM DetailCart d WHERE d.detailCartPK.iDCart = :iDCart"),
    @NamedQuery(name = "DetailCart.findByIDProd", query = "SELECT d FROM DetailCart d WHERE d.detailCartPK.iDProd = :iDProd"),
    @NamedQuery(name = "DetailCart.findBySoLuong", query = "SELECT d FROM DetailCart d WHERE d.soLuong = :soLuong"),
    @NamedQuery(name = "DetailCart.findByDonGia", query = "SELECT d FROM DetailCart d WHERE d.donGia = :donGia")})
public class DetailCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailCartPK detailCartPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "So_Luong")
    private Double soLuong;
    @Column(name = "Don_Gia")
    private Double donGia;

    public DetailCart() {
    }

    public DetailCart(DetailCartPK detailCartPK) {
        this.detailCartPK = detailCartPK;
    }

    public DetailCart(String iDCart, String iDProd) {
        this.detailCartPK = new DetailCartPK(iDCart, iDProd);
    }

    public DetailCartPK getDetailCartPK() {
        return detailCartPK;
    }

    public void setDetailCartPK(DetailCartPK detailCartPK) {
        this.detailCartPK = detailCartPK;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    
    public String getPriceCurrencyFormat() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((donGia));
    }
    
    public String getTotalCurrencyFormat() {
        double total = soLuong * donGia;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((total));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailCartPK != null ? detailCartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailCart)) {
            return false;
        }
        DetailCart other = (DetailCart) object;
        if ((this.detailCartPK == null && other.detailCartPK != null) || (this.detailCartPK != null && !this.detailCartPK.equals(other.detailCartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetailCart[ detailCartPK=" + detailCartPK + " ]";
    }

    
}
