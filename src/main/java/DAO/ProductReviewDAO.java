package DAO;

import beans.ProductReview;
import db.JDBIConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ProductReviewDAO {
    public List<ProductReview> getCommentsByProductID(String id) {
        return JDBIConnector.get().withHandle(handle -> handle.createQuery("SELECT pr.review_id, pr.review_prod" +
                        ", pr.review_by, pr.vote_star ,pr.review_desc, pr.review_status, pr.review_date FROM product_review pr" +
                        " INNER JOIN product prod ON pr.review_prod = prod.id WHERE pr.review_status = 1 AND prod.id =? ")
                .bind(0, id)
                .mapToBean(ProductReview.class)
                .stream()
                .collect(Collectors.toList()));
    }

    public ProductReview getReviewByUserId(String id) {
        Optional<ProductReview> review = JDBIConnector.get().withHandle(handle -> handle.createQuery("SELECT * FROM product_review WHERE review_by = ?")
                .bind(0, id)
                .mapToBean(ProductReview.class)
                .findFirst()
        );
        if (review.isEmpty()) {
            return null;
        } else {
            return review.get();
        }
    }

    public ProductReview getReviewByIdReview(String id) {
        Optional<ProductReview> review = JDBIConnector.get().withHandle(handle -> handle.createQuery("SELECT * FROM product_review WHERE review_id = ?")
                .bind(0, id)
                .mapToBean(ProductReview.class)
                .findFirst()
        );
        if (review.isEmpty()) {
            return null;
        } else {
            return review.get();
        }
    }

    public String generateIdReviewProduct() {
        List<String> id = JDBIConnector.get().withHandle(handle -> handle.createQuery("SELECT review_id FROM product_review").mapTo(String.class).stream().collect(Collectors.toList()));
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        int length = 10;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }
        if (id.contains(sb.toString())) return generateIdReviewProduct();
        else return sb.toString();
    }

    public String AddNewReview(String id, String productid, String comment, int stars) {
        String idProductReview = generateIdReviewProduct();
        JDBIConnector.get().withHandle(handle -> {
                    handle.createUpdate("INSERT INTO product_review values (?, ?, ?, ?, ?, 1, CURDATE())")
                            .bind(0, idProductReview)
                            .bind(1, productid)
                            .bind(2, id)
                            .bind(3, stars)
                            .bind(4, comment)
                            .execute();
                    return true;
                }
        );
        return idProductReview;
    }

    public void RemoveComment(String id) {
        JDBIConnector.get().withHandle(handle -> {
                    handle.createUpdate("DELETE FROM product_review WHERE review_id = ?")
                            .bind(0, id)
                            .execute();
                    return true;
                }
        );
    }

    public void EditComment(String id, String new_reviewdesc) {
        JDBIConnector.get().withHandle(handle -> {
                    handle.createUpdate("UPDATE product_review SET review_desc = ? WHERE review_id = ?")
                            .bind(0, new_reviewdesc)
                            .bind(1, id)
                            .execute();
                    return true;
                }
        );
    }

    public List<ProductReview> loadAllReviewByPage(int page) {
        List<ProductReview> list = JDBIConnector.get().withHandle(handle -> handle.createQuery("SELECT * FROM product_review ")
                .mapToBean(ProductReview.class)
                .stream().collect(Collectors.toList())
        );
        int numpage;
        int start = (page - 1) * 6;
        if (list.size() - start >= 6) {
            numpage = start + 6;
        } else {
            numpage = list.size();
        }
        List<ProductReview> temp = new ArrayList<>();
        for (int i = start; i < numpage; i++) {
            temp.add(list.get(i));
        }
        return temp;
    }

    public void ChangeStatusComment(String id, String status) {
        JDBIConnector.get().withHandle(handle -> handle.createUpdate("UPDATE product_review SET review_status=? WHERE review_id = ?")
                .bind(0, status.equals("0") ? 1 : 0)
                .bind(1, id)
                .execute()
        );
    }

    public static void main(String[] args) {
        System.out.println(new ProductReviewDAO().loadAllReviewByPage(3));
    }
}

