package view;

import controller.MemberController;
import controller.StudentController;

public class MainView {
    public static void main(String[] args) {
        MemberController memberController = new MemberController();
        memberController.menuManagement();
    }
}
