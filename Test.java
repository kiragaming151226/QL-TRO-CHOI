import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        IQuanLyTroChoi quanLy = new QuanLyTroChoiImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CHUONG TRINH QUAN LY TRO CHOI ---");
            System.out.println("1. Them tro choi (MayTinh)");
            System.out.println("2. Them tro choi (DienThoai)");
            System.out.println("3. Hien thi danh sach");
            System.out.println("4. Tim tro choi theo ma");
            System.out.println("5. Cap nhat tro choi theo ma");
            System.out.println("6. Xoa tro choi theo ma");
            System.out.println("7. Kiem tra tinh trang server");
            System.out.println("8. Them giao dich mua"); 
            System.out.println("9. Thong ke doanh so 30 ngay gan nhat"); 
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1": {
                        System.out.print("Ma Game: "); String ma = sc.nextLine();
                        System.out.print("Ten Game: "); String td = sc.nextLine();
                        System.out.print("Nha San Xuat: "); String tg = sc.nextLine();
                        System.out.print("Nam phat hanh: "); int nam = Integer.parseInt(sc.nextLine());
                        System.out.print("Gia co ban: "); double gia = Double.parseDouble(sc.nextLine());
                        System.out.print("Yeu cau cau hinh: "); String cauHinh = sc.nextLine();
                        System.out.print("La ban gioi han (true/false): "); boolean gioiHan = Boolean.parseBoolean(sc.nextLine());
                        MayTinh game = new MayTinh(ma, td, tg, nam, gia, cauHinh, gioiHan);
                        quanLy.themTroChoi(game);
                        System.out.println("Da them PC Game.");
                        break;
                    }
                    case "2": {
                        System.out.print("Ma Game: "); String ma = sc.nextLine();
                        System.out.print("Ten Game: "); String td = sc.nextLine();
                        System.out.print("Nha San Xuat: "); String tg = sc.nextLine();
                        System.out.print("Nam phat hanh: "); int nam = Integer.parseInt(sc.nextLine());
                        System.out.print("Gia co ban: "); double gia = Double.parseDouble(sc.nextLine());
                        System.out.print("Nen tang (Android/iOS): "); String nenTang = sc.nextLine();
                        System.out.print("Co quang cao (true/false): "); boolean coQuangCao = Boolean.parseBoolean(sc.nextLine());
                        DienThoai game = new DienThoai(ma, td, tg, nam, gia, nenTang, coQuangCao);
                        quanLy.themTroChoi(game);
                        System.out.println("Da them Mobile Game.");
                        break;
                    }
                    case "3": {
                        quanLy.hienThiDanhSach();
                        break;
                    }
                    case "4": {
                        System.out.print("Nhap ma game can tim: ");
                        String ma = sc.nextLine();
                        TroChoi found = quanLy.timKiemTroChoi(ma);
                        if (found != null) {
                            System.out.println("Da tim thay: " + found.toString());
                        } else {
                            System.out.println("Khong tim thay tro choi.");
                        }
                        break;
                    }
                    case "5": {
                        System.out.println("Chuc nang cap nhat tuong tu them moi.");
                        break;
                    }
                    case "6": {
                        System.out.print("Nhap ma game can xoa: ");
                        String ma = sc.nextLine();
                        if (quanLy.xoaTroChoi(ma)) System.out.println("Da xoa."); else System.out.println("Khong tim thay de xoa.");
                        break;
                    }
                    case "7": {
                        System.out.print("Nhap ma game de kiem tra: ");
                        String ma = sc.nextLine();
                        TroChoi game = quanLy.timKiemTroChoi(ma);
                        if (game instanceof MayTinh || game instanceof DienThoai) {
                            System.out.print("Server dang online (true/false): ");
                            boolean status = Boolean.parseBoolean(sc.nextLine());
                            game.kiemTraTinhTrangServer(status);
                        } else if (game != null) {
                            System.out.println("Khong the kiem tra tinh trang server cho loai tro choi nay.");
                        } else {
                            System.out.println("Khong tim thay tro choi.");
                        }
                        break;
                    }
                    case "8": { 
                        System.out.print("Nhap ma game da ban: ");
                        String ma = sc.nextLine();
                        System.out.print("Nhap so luong da ban: ");
                        int sl = Integer.parseInt(sc.nextLine());
                        if (quanLy.thucHienGiaoDichMua(ma, sl)) {
                            System.out.println("Giao dich mua thanh cong! Thoi gian: " + java.time.LocalDateTime.now());
                        } else {
                            System.out.println("Giao dich that bai. Kiem tra ma game va so luong.");
                        }
                        break;
                    }
                    case "9": { 
                        quanLy.thongKeDoanhSo30NgayGanNhat();
                        break;
                    }
                    case "0": {
                        System.out.println("Thoat chuong trinh.");
                        sc.close();
                        return;
                    }
                    default:
                        System.out.println("Lua chon khong hop le.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Loi nhap lieu: Vui long nhap dung dinh dang so.");
            }
        }
    }
}