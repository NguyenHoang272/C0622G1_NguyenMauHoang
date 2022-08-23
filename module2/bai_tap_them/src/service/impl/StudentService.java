package service.impl;

import model.Student;
import model.Teacher;
import service.IStudentService;
import ulti_exception.ulti_exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "nguyen van a", "11/02/1996", "nam", "C06", 8));
        students.add(new Student(2, "nguyen van b", "23/04/2000", "nam", "C06", 9));
    }


    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm mới học viên thành công");
    }

    @Override
    public void displayAllStudent() {
        sort();
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    private void sort() {
        boolean needNextPass = true;

        for (int k = 1; k < students.size() && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < students.size() - k; i++) {
                if (students.get(i).getName().charAt(i) > students.get(i + 1).getName().charAt(i)) {
                    Student temp = students.get(i);
                    students.set(i, students.get(i + 1));
                    students.set(i + 1, temp);

                    needNextPass = true; /* Next pass still needed */
                }
            }
        }
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudentID();
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có thực sự muốn xóa học viên có ID " + student.getId() + " không?");
            System.out.println("1 . Có");
            System.out.println("2 . Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Xóa thành công");
            }
        }
    }

    private Student findStudentID() {
        System.out.print("Mời bạn nhập vào id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    @Override
    public void searchStudent() {
        while (true) {
            System.out.println("1. Tìm theo ID");
            System.out.println("2. Tìm theo tên");
            System.out.println("3. Thoát");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Student student = this.findStudentID();
                    if (student == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    Student student1 = this.findStudentName();
                    if (student1 == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println(student1);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }
    }

    private Student findStudentName() {
        System.out.println("Mời bạn nhập tên");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                return student;
            }
        }
        return null;
    }

    private Student infoStudent() {
        int id;
        while (true) {
            try {
                System.out.print("Mời bạn nhập id: ");
                id = Integer.parseInt(scanner.nextLine());
                boolean isCheck = true;
                for (Student student : students) {
                    if (student.getId() == id) {
                        System.out.println("ID bị trùng mời bạn nhập lại");
                        isCheck = false;
                        break;
                    }
                }
                if (isCheck) break;
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ mời bạn nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d+")) {
                        throw new StringFormatException("Tên bạn không hợp lệ vui lòng nhập lại");
                    }
                }
                break;
            } catch (StringFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Trường hợp ngoại lệ");
            }
        }
        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh: ");
                dateOfBirth = scanner.nextLine();
                if (!dateOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                    throw new DateOfBirthException("Dữ liệu không đúng định dạng");
                }
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2016) {
                    throw new DateOfBirthException("Dữ liệu không đúng định dạng");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String sex;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                sex = scanner.nextLine();
                if (!sex.equals("Nam") && (!sex.equals("Nữ"))) {
                    throw new GenderException("Dữ liệu bạn nhập không hợp lệ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                if (point < 0 || point > 100) {
                    throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 hoặc lớn hơn 100");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (PointException p) {
                System.err.println(p.getMessage());
            } catch (Exception e) {
                System.out.println("Trường hợp ngoại lệ");
            }
        }
        String nameClass;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên lớp: ");
                nameClass = scanner.nextLine();
                if (!nameClass.matches("\\D+\\d+\\d+\\d+\\d+\\D+\\d")) {
                    throw new NameClassException("Tên lớp không hợp lệ");
                }
                break;
            } catch (NameClassException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Student(id, name, dateOfBirth, sex, nameClass, point);
    }
}
