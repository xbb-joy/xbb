package com.ep.model.entity;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;


@Table(name = "tb_data_item")
public class DataItem implements Serializable {


    @Id
    private String id;

    private String dataId;

    /**
     * 1-实际液高，2-标准液高，3-实际压力，4-标准压力
     */
    private Integer type;

    /**
         * 0℃~10℃
     */
    private Double zero = 0d;

    private Double one = 0d;

    private Double two = 0d;

    private Double three = 0d;

    private Double four = 0d;

    private Double five = 0d;

    private Double six = 0d;

    private Double seven = 0d;

    private Double eight = 0d;

    private Double nine= 0d;

    private Double ten = 0d;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getZero() {
        return this.zero;
    }

    public void setZero(Double zero) {
        this.zero = zero;
    }

    public Double getOne() {
        return this.one;
    }

    public void setOne(Double one) {
        this.one = one;
    }

    public Double getTwo() {
        return this.two;
    }

    public void setTwo(Double two) {
        this.two = two;
    }

    public Double getThree() {
        return this.three;
    }

    public void setThree(Double three) {
        this.three = three;
    }

    public Double getFour() {
        return this.four;
    }

    public void setFour(Double four) {
        this.four = four;
    }

    public Double getFive() {
        return this.five;
    }

    public void setFive(Double five) {
        this.five = five;
    }

    public Double getSix() {
        return this.six;
    }

    public void setSix(Double six) {
        this.six = six;
    }

    public Double getSeven() {
        return this.seven;
    }

    public void setSeven(Double seven) {
        this.seven = seven;
    }

    public Double getEight() {
        return this.eight;
    }

    public void setEight(Double eight) {
        this.eight = eight;
    }

    public Double getNine() {
        return this.nine;
    }

    public void setNine(Double nine) {
        this.nine = nine;
    }

    public Double getTen() {
        return this.ten;
    }

    public void setTen(Double ten) {
        this.ten = ten;
    }

    @Transient
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
