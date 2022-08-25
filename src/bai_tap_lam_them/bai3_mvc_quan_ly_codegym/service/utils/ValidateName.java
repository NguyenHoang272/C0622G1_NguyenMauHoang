package bai_tap_lam_them.bai3_mvc_quan_ly_codegym.service.utils;

public class ValidateName {
    public static boolean validateName(String name){
        //tên không được chứa số và ký tự đặc biệt. yêu cầu chỉ từ 5 đến 50 kí tự
        final String nameRegex = "^[a-zA-Z ]{5,50}$";
        return name.matches(nameRegex);
    }
}
