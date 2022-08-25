package bai_tap_lam_them.bai3_mvc_quan_ly_codegym.service.utils;

public class ValidateClassName {
    public static boolean validateClassName(String className){
        final String classNameRegex = "^(A|C)\\d{4}(G|I)1$";
        return className.matches(classNameRegex);
    }
}
