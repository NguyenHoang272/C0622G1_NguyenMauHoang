package casestudy.services.impl;

import bai_tap_lam_them.bai3_mvc_quan_ly_codegym.service.utils.InvalidNumberException;
import casestudy.models.person.Customer;
import casestudy.services.ICustomerService;
import casestudy.utils.exception.*;
import casestudy.utils.io_text_file.ReadAndWriteCustomer;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = new LinkedList<>();
    private static final String CUSTOMER_PATH = "C0622G1_NguyenMauHoang\\src\\casestudy\\data\\customer.csv";
    private static final String NAME_REGEX = "^(\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*){5,50}$";
    private static final String DATE_OF_BIRTH_REGEX = "^\\d*$";
    private static final String GENDER_REGEX = "^[a-zA-Z]+$";
    private static final String INDENTITY_CARD_REGEX = "^[0-9]{9}|[0-9]{12}$";
    private static final String PHONE_NUMBER_REGEX = "^\\([+][8][4]\\)[1-9][1-9]{8}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+\\@[A-Za-z0-9]+[.][A-Za-z]+$";


    @Override
    public void displayListCustomer() {
        System.out.println("Danh sách khách hàng");
        customers = ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        if (customers.size() == 0) {
            System.out.println("Danh sách rỗng");
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void addNewCustomer() {
        Customer customer = this.infoCustomer();
        customers.add(customer);
        ReadAndWriteCustomer.writeCustomerFile(CUSTOMER_PATH, customers, true);
        System.out.println("Thêm mới khách hàng thành công!");
        System.out.println("Danh sách sau khi thêm");
        ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        displayListCustomer();
    }

    private Customer infoCustomer() {
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã khách hàng: ");
                id = scanner.nextLine();
                ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
                for (int i = 0; i < customers.size(); i++) {
                    if (id.equals(customers.get(i).getId())) {
                        throw new IdException("Mã khách hàng này đã tồn tại. Vui lòng nhập mã khách hàng mới.");
                    }
                }

                if (id.equals("")) {
                    throw new SpaceException("Vui lòng nhập mã khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (IdException e) {
                e.getMessage();
            } catch (SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập mã không đúng yêu cầu");
            }
        }

        String name;
        while (true) {
            try {
                System.out.println("Mời bạn nhập Họ và tên: ");
                name = scanner.nextLine();
                name = name.trim();
                if (!(name.matches("^(\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*){1,50}$"))) {
                    throw new NameException("Vui lòng nhập tên viết hoa chữ cái đầu và tên hơn 5 kí tự và nhỏ hơn 50 kí tụ.");
                }
                if (name.equals("")) {
                    throw new SpaceException("Vui lòng nhập họ và tên nhân viên. Không được bỏ trống mục này.");
                }
                break;
            } catch (NameException | SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
        }

        int maxAge=150;
        int minAge=18;
        MyDate dateOfBirth;
        while (true)
            try {
                System.out.print("Mời bạn nhập ngày tháng năm:");
                dateOfBirth = new MyDate(scanner.nextLine());
                if (dateOfBirth.getAge() < minAge || dateOfBirth.getAge() > maxAge) {
                    throw new InvalidNumberException("Age must be from " + minAge + " to " + maxAge + " years old");
                }
                break;
            } catch (ParseException e) {
                System.out.println("Data is incorrect or not in the format dd/MM/yyyy. Please re-enter!");
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
            }

        String gender;
        while (true) {
            try {
                System.out.println("Mời bạn nhập giới tính: ");
                gender = scanner.nextLine();
                if (!(gender.matches(GENDER_REGEX))) {
                    throw new GenderException("Vui lòng nhập giới tính là Nam, Nữ hoặc Khác. Không được nhập số");
                }
                if (gender.equals("")) {
                    throw new SpaceException("Vui lòng nhập giới tính khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (GenderException | SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String identityCard;
        while (true) {
            try {
                System.out.println("Mời bạn nhập CMND: ");
                identityCard = scanner.nextLine();
                if (!(identityCard.matches(INDENTITY_CARD_REGEX))) {
                    throw new IdentityCardException("Vui lòng nhập số chứng minh nhân dân 9 số hoặc 12 số");
                }
                if (identityCard.equals("")) {
                    throw new SpaceException("Vui lòng nhập CMND khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (IdentityCardException | SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai, vui lòng nhập lại.");
            }
        }

        String phoneNumber;
        while (true) {
            try {
                System.out.println("Mời bạn nhập số điện thoại: ");
                phoneNumber = scanner.nextLine();
                if (!(phoneNumber.matches(PHONE_NUMBER_REGEX))) {
                    throw new PhoneNumberException("Vui lòng nhập số điện thoại gồm 9 số với số đầu tiên không phải là số 0");
                }
                if (phoneNumber.equals("")) {
                    throw new SpaceException("Vui lòng nhập số điện thoại khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (PhoneNumberException | SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String email;
        while (true) {
            try {
                System.out.println("Mời bạn nhập địa chỉ email: ");
                email = scanner.nextLine();
                if (!(email.matches(EMAIL_REGEX))) {
                    throw new EmailException("Vui lòng nhập mail theo định dạng abc@gmail.com,ab@yahoo.com,abc@hotmail.com");
                }
                if (email.equals("")) {
                    throw new SpaceException("Vui lòng nhập email khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (EmailException | SpaceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        System.out.println("Mời bạn nhập loại khách");
        String customerType = customerType();

        String address;
        while (true) {
            try {
                System.out.println("Mời bạn nhập địa chỉ");
                address = scanner.nextLine();
                if (address.equals("")) {
                    throw new SpaceException("Vui lòng nhập địa chỉ khách hàng. Không được bỏ trống mục này.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        Customer customer = new Customer(id, name, dateOfBirth.getStrDate(), gender, identityCard, phoneNumber, email, customerType, address);
        return customer;
    }

    public static int calculatePeriod(LocalDate localDate) {
        LocalDate now = LocalDate.now();
        int age = Period.between(localDate, now).getYears();
        return age;

    }

    public String customerType() {
        int choice;
        while (true) {
            try {
                System.out.println("-----Loại khách-----");
                System.out.println("1. Diamond");
                System.out.println("2. Platinum");
                System.out.println("3. Gold");
                System.out.println("4. Silver");
                System.out.println("5. Member");
                System.out.print("Vui lòng chọn loại khách phù hợp (1->5): ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 5) {
                    throw new CustomerException("Vui lòng chọn chức năng từ 1->5");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
            }
        }

        String line = "";
        switch (choice) {
            case 1:
                line += "Diamond";
                break;
            case 2:
                line += "Platinum";
                break;
            case 3:
                line += "Gold";
                break;
            case 4:
                line += "Silver";
                break;
            case 5:
                line += "Member";
                break;
        }
        return line;

    }

    @Override
    public void editCustomer() {
        customers = ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        Customer customer = findCustomer();

        if (customer == null) {
            System.out.println("Khách hàng không tồn tại trong danh sách!");
            return;
        }

        do {
            System.out.println("Nhân viên cần chỉnh sửa");
            System.out.println(customer.toString());
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. Mã khách hàng");
            System.out.println("2. Họ và tên");
            System.out.println("3. Ngày tháng năm sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. CMND");
            System.out.println("6. Số điện thoại");
            System.out.println("7. Địa chỉ email");
            System.out.println("8. Loại khách");
            System.out.println("9. Địa chỉ ");
            System.out.println("10. Thoát");
            System.out.println("Vui lòng chọn nội dung cần chỉnh sửa 1->10: ");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    for (int i = 0; i <customers.size() ; i++) {
                        if(getEditInfo("mã nhân viên").equals(customers.get(i).getId())){
                            System.out.println("Mã nhân viên bạn nhập vào đã tồn tại, vui lòng nhập mã nhân viên mới.");
                        } else {
                            customer.setId(getEditInfo("mã nhân viên"));
                            break;
                        }
                    }
                    break;
                case 2:
                    customer.setName(getEditInfo("họ và tên"));
                    break;
                case 3:
                    customer.setDateOfBirth(getEditInfo("ngày tháng năm sinh với đúng định dạng là dd/MM/YYYY (với dd là ngày, MM là tháng, YYYY là năm)"));
                    break;
                case 4:
                    customer.setGender(getEditInfo("giới tính"));
                    break;
                case 5:
                    customer.setIdentityCard(getEditInfo("CMND"));
                    break;
                case 6:
                    customer.setPhoneNumber(getEditInfo("số điện thoại"));
                    break;
                case 7:
                    customer.setEmail(getEditInfo("địa chỉ email"));
                    break;
                case 8:
                    customer.setCustomerType(customerType());
                    break;
                case 9:
                    customer.setAddress(getEditInfo("địa chỉ"));
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Chức năng bạn chọn không có trong menu!");
            }
            ReadAndWriteCustomer.writeCustomerFile(CUSTOMER_PATH, customers, false);
            System.out.println("Chỉnh sửa thành công!");
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.println("Vui lòng chọn 1(Có) - 2(Không)");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    private Customer findCustomer() {
        customers = ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        System.out.println("Mời bạn nhập mã khách hàng: ");
        String id = scanner.nextLine();
        ReadAndWriteCustomer.readCustomerFile(CUSTOMER_PATH);
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public String getEditInfo(String editContent) {
        System.out.println("Vui lòng nhập " + editContent + " mới: ");
        return scanner.nextLine();
    }
}
