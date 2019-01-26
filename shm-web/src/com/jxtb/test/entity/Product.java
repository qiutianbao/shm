package com.jxtb.test.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-28
 * Time: 下午3:06
 * 商品信息
 */
public class Product {
    private String id;  //商品ID
    private String name; //商品名称
    private double price; //单价（元）
    private String factory; //生产厂家
    private String baoZhi; //保质期
    private int saleNum; //销售量

    public Product() {
    }

    public Product(String id, String name, double price, String factory,
                   String baoZhi, int saleNum) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.factory = factory;
        this.baoZhi = baoZhi;
        this.saleNum = saleNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getBaoZhi() {
        return baoZhi;
    }

    public void setBaoZhi(String baoZhi) {
        this.baoZhi = baoZhi;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }


}

