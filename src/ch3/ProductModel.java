package ch3;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 12 October 2021 - 7:59 AM
 */
public class ProductModel implements Serializable {

    private String name;
    private String category;
    private BigDecimal selling_price;
    private BigDecimal cost_price;

    ProductModel(String name, String category, BigDecimal selling_price, BigDecimal cost_price) {
        this.name = name;
        this.category = category;
        this.selling_price = selling_price;
        this.cost_price = cost_price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(BigDecimal selling_price) {
        this.selling_price = selling_price;
    }

    public BigDecimal getCost_price() {
        return cost_price;
    }

    public void setCost_price(BigDecimal cost_price) {
        this.cost_price = cost_price;
    }


    public String toString() {
        return "{ " + "name: " + name + " category: " + category + " selling_price: " + selling_price
                + " cost_price: " + cost_price + "}";
    }

}
