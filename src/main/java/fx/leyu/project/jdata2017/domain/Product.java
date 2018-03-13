package fx.leyu.project.jdata2017.domain;

import java.util.Arrays;

public class Product {
    private int id;
    private int attr1;
    private int attr2;
    private int attr3;
    private int cate;
    private int brand;
    
    public Product(int id, int attr1, int attr2, int attr3, int cate,
            int brand) {
        super();
        this.id = id;
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.attr3 = attr3;
        this.cate = cate;
        this.brand = brand;
    }
    
    public Product(String[] strs) {
        if (strs == null || strs.length != 6) {
            throw new IllegalArgumentException("value is " + Arrays.toString(strs));
        }
        this.id = Integer.parseInt(strs[0]);
        this.attr1 = Integer.parseInt(strs[1]);
        this.attr2 = Integer.parseInt(strs[2]);
        this.attr3 = Integer.parseInt(strs[3]);
        this.cate = Integer.parseInt(strs[4]);
        this.brand = Integer.parseInt(strs[5]);
    }

    public int getId() {
        return id;
    }
    public int getAttr1() {
        return attr1;
    }
    public int getAttr2() {
        return attr2;
    }
    public int getAttr3() {
        return attr3;
    }
    public int getCate() {
        return cate;
    }
    public int getBrand() {
        return brand;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAttr1(int attr1) {
        this.attr1 = attr1;
    }
    public void setAttr2(int attr2) {
        this.attr2 = attr2;
    }
    public void setAttr3(int attr3) {
        this.attr3 = attr3;
    }
    public void setCate(int cate) {
        this.cate = cate;
    }
    public void setBrand(int brand) {
        this.brand = brand;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + attr1;
        result = prime * result + attr2;
        result = prime * result + attr3;
        result = prime * result + brand;
        result = prime * result + cate;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (attr1 != other.attr1)
            return false;
        if (attr2 != other.attr2)
            return false;
        if (attr3 != other.attr3)
            return false;
        if (brand != other.brand)
            return false;
        if (cate != other.cate)
            return false;
        return id == other.id;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", attr1=" + attr1 + ", attr2=" + attr2
                + ", attr3=" + attr3 + ", cate=" + cate + ", brand=" + brand
                + "]";
    }
}
