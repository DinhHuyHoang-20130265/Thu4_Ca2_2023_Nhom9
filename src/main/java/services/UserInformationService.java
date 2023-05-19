package services;


import DAO.UserInformationDAO;
import beans.UserInformation;

    public class UserInformationService {
        private static UserInformationService userInformationService;

        public static UserInformationService getInstance() {
        if (userInformationService == null) {
            userInformationService = new UserInformationService();
        }
        return userInformationService;
    }

    public UserInformation getUserInfo(String id) {
        UserInformationDAO DAO = new UserInformationDAO();
        return DAO.getUserInfo(id);
    }

    public UserInformation getUserInfoById(String id) {
        UserInformationDAO DAO = new UserInformationDAO();
        return DAO.getUserInfoById(id);
    }

    public String getIdUserByName(String username) {
        UserInformationDAO DAO = new UserInformationDAO();
        return DAO.getIdUserByName(username);
    }

    public void UpdateUserInfo(String id, String username, String email, String address, String phone_number, String file_name) {
        new UserInformationDAO().updateUserInfo(id, username, email, address, phone_number, file_name);
    }
}
