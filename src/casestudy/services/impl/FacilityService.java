package casestudy.services.impl;

import casestudy.controllers.FacilityController;
import casestudy.models.facility.Facility;
import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;
import casestudy.services.IFacilityService;
import casestudy.utils.exception.FacilityException;
import casestudy.utils.io_text_file.ReadAndWriteFacility;

import java.util.*;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PATH_VILLA = "C0622G1_NguyenMauHoang\\src\\casestudy\\data\\villa.csv";
    private static final String PATH_HOUSE = "C0622G1_NguyenMauHoang\\src\\casestudy\\data\\house.csv";
    private static final String PATH_ROOM = "C0622G1_NguyenMauHoang\\src\\casestudy\\data\\room.csv";
    private static final String VILLA_REGEX = "^SVVL[0-9]{4}$";
    private static final String HOUSE_REGEX = "^SVHO[0-9]{4}$";
    private static final String ROOM_REGEX = "^SVRO[0-9]{4}$";

    @Override
    public void displayListFacility() {
        int choice;
        do {
            while (true) {
                try {
                    System.out.println("Danh sách cơ sở vật chất");
                    System.out.println("1. Villa");
                    System.out.println("2. House");
                    System.out.println("3. Room");
                    System.out.println("4. Trở về menu chính");
                    System.out.print("Vui lòng chọn mục bạn muốn hiển thị (1->4): ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                } catch (Exception e) {
                    System.out.println("Bạn nhập sai, vui lòng nhập lại.");
                }
            }

            switch (choice) {
                case 1:
                    Map<Facility, Integer> villas = ReadAndWriteFacility.readFacilityFile(PATH_VILLA);

                    if (villas.isEmpty()) {
                        System.out.println("Danh sách villa trống.");
                    } else {
                        for (Facility villa : villas.keySet()) {
                            System.out.println(villa + " được sử dụng là: " + villas.get(villa));
                        }
                    }
                    break;
                case 2:
                    Map<Facility, Integer> houses = ReadAndWriteFacility.readFacilityFile(PATH_HOUSE);
                    if (houses.isEmpty()) {
                        System.out.println("Danh sách house trống");
                    } else {
                        for (Facility house : houses.keySet()) {
                            System.out.println(house + " được sử dụng là: " + houses.get(house));
                        }
                    }
                    break;
                case 3:
                    Map<Facility, Integer> rooms = ReadAndWriteFacility.readFacilityFile(PATH_ROOM);
                    if (rooms.isEmpty()) {
                        System.out.println("Danh sách phòng trống");
                    } else {
                        for (Facility room : rooms.keySet()) {
                            System.out.println(room + " được sử dụng là: " + rooms.get(room));
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Số bạn chọn không đúng. Vui lòng nhập lại.");
            }
        } while (true);
    }

    @Override
    public void addNewFacility() {
        System.out.println("-----Dịch vụ-----");
        System.out.println("1. Thêm mới Villa");
        System.out.println("2. Thêm mới House");
        System.out.println("3. Thêm mới Room");
        System.out.println("4. Trở về menu chính");
        System.out.print("Vui lòng chọn dịch vụ muốn thêm mới (1->4): ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                return;

        }
    }

    private void addNewRoom() {
        Map<Facility, Integer> rooms = new LinkedHashMap<>();

        String serviceCode;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã dịch vụ phòng");
                serviceCode = scanner.nextLine();
                if (!serviceCode.matches(ROOM_REGEX)) {
                    throw new FacilityException("Vui lòng nhập đúng định dạng mã dịch vụ phòng là SVRO-XXXX (với X là số)");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập đúng định dạng");
            }
        }


        String serviceName;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên dịch vụ");
                serviceName = scanner.nextLine();
                if (!serviceName.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập tên dịch vụ với chữ cái đầu phải viết hoa và các kí tự phía sau là viết thường");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại cho đúng.");
            }
        }

        double area;
        while (true) {
            try {
                System.out.print("Mời bạn nhập diện tích phòng");
                area = Double.parseDouble(scanner.nextLine());
                if (area < 30) {
                    throw new FacilityException("Diện tích sử dụng phải lớn hơn 30m^2");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            }
        }

        double price;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giá phòng");
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    throw new FacilityException("Vui lòng nhập chi phí thuê lớn hơn 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
            }
        }


        int amountOfPeople;
        while (true) {
            try {
                System.out.println("Mời bạn nhập số lượng người thuê");
                amountOfPeople = Integer.parseInt(scanner.nextLine());
                if (amountOfPeople < 0 && amountOfPeople > 20) {
                    throw new FacilityException("Vui lòng nhập số lượng người nhỏ hơn 20 và lớn hơn 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String rentalType;
        while (true) {
            try {
                System.out.println("Mời bạn nhập kiểu thuê ");
                rentalType = scanner.nextLine();
                if (!rentalType.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập kiểu thuê với ký tự đầu là viết hoa, các ký tự sau là viết thường.");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String freeStuff;
        while (true) {
            try {
                System.out.println("Mời bạn nhập dịch vụ miễn phí đi kèm");
                freeStuff = scanner.nextLine();
                if (!freeStuff.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập kiểu thuê với ký tự đầu là viết hoa, các ký tự sau là viết thường.");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        Room room = new Room(serviceCode, serviceName, area, price, amountOfPeople, rentalType, freeStuff);
        rooms.put(room, 0);
        ReadAndWriteFacility.writeFacilityFile(PATH_ROOM, rooms, true);
        System.out.println("Thêm mới phòng thành công");
    }

    private void addNewHouse() {
        Map<Facility, Integer> houses = new LinkedHashMap<>();
        String serviceCode;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã dịch vụ phòng");
                serviceCode = scanner.nextLine();
                if (!serviceCode.matches(HOUSE_REGEX)) {
                    throw new FacilityException("Vui lòng nhập đúng định dạng mã dịch vụ phòng là SVHO-XXXX (với X là số)");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập đúng định dạng");
            }
        }


        String serviceName;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên dịch vụ");
                serviceName = scanner.nextLine();
                if (!serviceName.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập tên dịch vụ với chữ cái đầu phải viết hoa và các kí tự phía sau là viết thường");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại cho đúng.");
            }
        }

        double area;
        while (true) {
            try {
                System.out.print("Mời bạn nhập diện tích phòng");
                area = Double.parseDouble(scanner.nextLine());
                if (area < 30) {
                    throw new FacilityException("Diện tích sử dụng phải lớn hơn 30m^2");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            }
        }

        double price;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giá phòng");
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    throw new FacilityException("Vui lòng nhập chi phí thuê lớn hơn 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
            }
        }


        int amountOfPeople;
        while (true) {
            try {
                System.out.println("Mời bạn nhập số lượng người thuê");
                amountOfPeople = Integer.parseInt(scanner.nextLine());
                if (amountOfPeople < 0 && amountOfPeople > 20) {
                    throw new FacilityException("Vui lòng nhập số lượng người nhỏ hơn 20 và lớn hơn 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String rentalType;
        while (true) {
            try {
                System.out.println("Mời bạn nhập kiểu thuê ");
                rentalType = scanner.nextLine();
                if (!rentalType.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập kiểu thuê với ký tự đầu là viết hoa, các ký tự sau là viết thường.");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String roomStandard;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tiêu chuẩn phòng");
                roomStandard = scanner.nextLine();
                if (!roomStandard.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập kiểu thuê với ký tự đầu là viết hoa, các ký tự sau là viết thường.");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        int floor;
        while (true) {
            try {
                System.out.println("Mời bạn nhập số tầng");
                floor = Integer.parseInt(scanner.nextLine());
                if (floor < 0) {
                    throw new FacilityException("Vui lòng nhập số nguyên dương");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại");
            }
        }

        House house = new House(serviceCode, serviceName, area, price, amountOfPeople, rentalType, roomStandard, floor);
        houses.put(house, 0);
        ReadAndWriteFacility.writeFacilityFile(PATH_HOUSE, houses, true);
        System.out.println("Thêm mới nhà thành công");
    }

    private void addNewVilla() {
        Map<Facility, Integer> villas = new LinkedHashMap<>();
        String serviceCode;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã dịch vụ phòng");
                serviceCode = scanner.nextLine();
                if (!serviceCode.matches(VILLA_REGEX)) {
                    throw new FacilityException("Vui lòng nhập đúng định dạng mã dịch vụ phòng là SVVL-XXXX (với X là số)");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập đúng định dạng");
            }
        }


        String serviceName;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên dịch vụ");
                serviceName = scanner.nextLine();
                if (!serviceName.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập tên dịch vụ với chữ cái đầu phải viết hoa và các kí tự phía sau là viết thường");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại cho đúng.");
            }
        }

        double area;
        while (true) {
            try {
                System.out.print("Mời bạn nhập diện tích phòng");
                area = Double.parseDouble(scanner.nextLine());
                if (area < 30) {
                    throw new FacilityException("Diện tích sử dụng phải lớn hơn 30m^2");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            }
        }

        double price;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giá phòng");
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    throw new FacilityException("Vui lòng nhập chi phí thuê lớn hơn 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
            }
        }


        int amountOfPeople;
        while (true) {
            try {
                System.out.println("Mời bạn nhập số lượng người thuê");
                amountOfPeople = Integer.parseInt(scanner.nextLine());
                if (amountOfPeople < 0 || amountOfPeople > 20) {
                    throw new FacilityException("Vui lòng nhập số lượng người nhỏ hơn 20 và lớn hơn 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String rentalType;
        while (true) {
            try {
                System.out.println("Mời bạn nhập kiểu thuê ");
                rentalType = scanner.nextLine();
                if (!rentalType.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập kiểu thuê với ký tự đầu là viết hoa, các ký tự sau là viết thường.");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        String roomStandard;
        while (true) {
            try {
                System.out.println("Mời bạn nhập tiêu chuẩn phòng");
                roomStandard = scanner.nextLine();
                if (!roomStandard.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new FacilityException("Vui lòng nhập kiểu thuê với ký tự đầu là viết hoa, các ký tự sau là viết thường.");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại.");
            }
        }

        double poolArea;
        while (true) {
            try {
                System.out.println("Mời bạn nhập diện tích hồ bơi");
                poolArea = Double.parseDouble(scanner.nextLine());
                if (poolArea < 30) {
                    throw new FacilityException("Diện tích sử dụng phải lớn hơn 30m^2");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            }
        }


        int floor;
        while (true) {
            try {
                System.out.println("Mời bạn nhập số tầng");
                floor = Integer.parseInt(scanner.nextLine());
                if (floor < 0) {
                    throw new FacilityException("Vui lòng nhập số nguyên dương");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại");
            }
        }
        Villa villa = new Villa(serviceCode, serviceName, area, price, amountOfPeople, rentalType, roomStandard, poolArea, floor);
        villas.put(villa, 0);
        ReadAndWriteFacility.writeFacilityFile(PATH_VILLA, villas, true);
        System.out.println("Thêm mới villa thành công");
    }


    @Override
    public void displayListFacilityMaintenance() {
        int choice;
        do {
            while (true) {
                try {
                    System.out.println("Danh sách cơ sở vật chất đang bảo trì");
                    System.out.println("1. Villa");
                    System.out.println("2. House");
                    System.out.println("3. Room");
                    System.out.println("4. Trở về menu chính");
                    System.out.println("Vui lòng chọn mục bạn muốn hiển thị");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            }

            switch (choice) {
                case 1:
                    Map<Facility, Integer> villas = ReadAndWriteFacility.readFacilityFile(PATH_VILLA);
                    if (villas.isEmpty()) {
                        System.out.println("Không có villa nào đang được bảo trì");
                    } else {
                        for (Facility villa : villas.keySet()) {
                            if (villas.get(villa) >= 5) {
                                System.out.println(villa + " được sử dụng: " + villas.get(villa));

                            } else {
                                System.out.println("Không có villa nào cần được bảo trì");
                            }
                        }
                    }
                    break;
                case 2:
                    Map<Facility, Integer> houses = ReadAndWriteFacility.readFacilityFile(PATH_HOUSE);
                    if (houses.isEmpty()) {
                        System.out.println("Không có house nào đang được bảo trì");
                    } else {
                        for (Facility house : houses.keySet()) {
                            if (houses.get(house) > 5) {
                                System.out.println(house + " được sử dụng: " + houses.get(house));
                            } else {
                                System.out.println("Không có house nào cần được bảo trì");
                            }
                        }
                    }
                    break;
                case 3:
                    Map<Facility, Integer> rooms = ReadAndWriteFacility.readFacilityFile(PATH_ROOM);
                    if (rooms.isEmpty()) {
                        System.out.println("Không có phòng nào đang được bảo trì");
                    } else {
                        for (Facility room : rooms.keySet()) {
                            if (rooms.get(room) > 5) {
                                System.out.println(room + " được sử dụng: " + rooms.get(room));
                            } else {
                                System.out.println("Không có phòng nào cần được bảo trì");
                            }
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không đúng. Vui lòng chọn lại");
            }
        } while (true);
    }
}
