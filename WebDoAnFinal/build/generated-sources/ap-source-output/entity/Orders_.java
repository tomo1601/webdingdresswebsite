package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-28T22:57:21")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> diaChi;
    public static volatile SingularAttribute<Orders, String> soDienThoai;
    public static volatile SingularAttribute<Orders, String> iDOrder;
    public static volatile SingularAttribute<Orders, Date> ngayDatHang;
    public static volatile SingularAttribute<Orders, String> tenNguoiNhan;
    public static volatile SingularAttribute<Orders, Double> thanhTien;
    public static volatile SingularAttribute<Orders, String> email;

}