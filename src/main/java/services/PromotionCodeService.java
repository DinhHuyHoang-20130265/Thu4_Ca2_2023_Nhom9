package services;

import DAO.PromotionCodeDAO;
import beans.PromotionCode;

import java.util.List;

public class PromotionCodeService {
    private static PromotionCodeService promotionCodeService;

    public static PromotionCodeService getInstance() {

        if (promotionCodeService == null) {
            promotionCodeService = new PromotionCodeService();
        }
        return promotionCodeService;
    }
    public List<PromotionCode> loadAllLegitCode() {
        return new PromotionCodeDAO().loadAllLegitCode();
    }
    public PromotionCode getPromotionCodeById(String id) {
        return new PromotionCodeDAO().getPromotionCodeById(id);
    }
    public List<PromotionCode> loadPromotionWithConditionContainsStatus(int page, int num_per_page) {
        return new PromotionCodeDAO().loadPromotionWithConditionContainsStatus(page, num_per_page);
    }
    public void RemovePromotionCode(String id) {
        new PromotionCodeDAO().RemovePromotionCode(id);
    }
    public PromotionCode getPromotionHiddenAndDetails(String id) {
        return new PromotionCodeDAO().getPromotionHiddenAndDetails(id);
    }
    public void InsertNewPromotionCode(String code_id, String name_code, String desc_code, String type_code, int discount_money, int status, String start_date, String end_date, String created_by) {
        new PromotionCodeDAO().InsertNewPromotionCode(code_id, name_code, desc_code, type_code, discount_money, status, start_date, end_date, created_by);
    }
    public void UpdateNewPromotionCode(String code_edit, String code_id, String name_code, String desc_code, String type_code, int discount_money, int status, String start_date, String end_date, String created_by) {
        new PromotionCodeDAO().InsertNewPromotionCode(code_id, name_code, desc_code, type_code, discount_money, status, start_date, end_date, created_by);
    }
}
