package services;

import DAO.PromotionDAO;
import beans.Promotion;

import java.util.List;

public class PromotionService {
    private static PromotionService promotionService;

    public static PromotionService getInstance() {

        if (promotionService == null) {
            promotionService = new PromotionService();
        }
        return promotionService;
    }
    public List<Promotion> loadAll() {
        return new PromotionDAO().loadAll();
    }
    public List<Promotion> loadPromotionWithConditionContainsStatus(int page, int num_per_page) {
        return  new PromotionDAO().loadPromotionWithConditionContainsStatus(page, num_per_page);
    }
    public void RemovePromotion(String id) {
        new PromotionDAO().RemovePromotion(id);
    }

    public Promotion getPromotionHiddenAndDetails(String id) {
        return new PromotionDAO().getPromotionHiddenAndDetails(id);
    }
    public void InsertNewPromotion(String product_id, String name_promo, String desc_promo, int discount_rate, int status, String start_date, String end_date) {
        new PromotionDAO().InsertNewPromotion(product_id, name_promo, desc_promo, discount_rate, status, start_date, end_date);
    }
    public void UpdatePromotion(String promo_id, String product_id, String name_promo, String desc_promo, int discount_rate, int status, String start_date, String end_date) {
        new PromotionDAO().UpdatePromotion(promo_id, product_id, name_promo, desc_promo, discount_rate, status, start_date, end_date);
    }
}
