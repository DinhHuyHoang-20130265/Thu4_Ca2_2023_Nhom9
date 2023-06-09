package beans;

import java.io.Serializable;

public class Promotion implements Serializable {
    private String promo_id;
    private String product_id;
    private String name_prom;
    private String desc_prom;
    private int discount_rate;
    private int status;
    private String start_date;
    private String end_date;
    public Promotion() {
    }

    public Promotion(String promo_id, String product_id, String name_prom, String desc_prom, int discount_rate, int status, String start_date, String end_date) {
        this.promo_id = promo_id;
        this.product_id = product_id;
        this.name_prom = name_prom;
        this.desc_prom = desc_prom;
        this.discount_rate = discount_rate;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(String promo_id) {
        this.promo_id = promo_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getName_prom() {
        return name_prom;
    }

    public void setName_prom(String name_prom) {
        this.name_prom = name_prom;
    }

    public String getDesc_prom() {
        return desc_prom;
    }

    public void setDesc_prom(String desc_prom) {
        this.desc_prom = desc_prom;
    }

    public int getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(int discount_rate) {
        this.discount_rate = discount_rate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promo_id='" + promo_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", name_prom='" + name_prom + '\'' +
                ", desc_prom='" + desc_prom + '\'' +
                ", discount_rate=" + discount_rate +
                ", status=" + status +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }
}
