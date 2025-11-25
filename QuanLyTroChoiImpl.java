import java.time.LocalDateTime;//hàm thời gian
import java.util.ArrayList;
import java.util.List;

public class QuanLyTroChoiImpl implements IQuanLyTroChoi {
	private List<TroChoi> danhSach;

	public QuanLyTroChoiImpl() {
		danhSach = new ArrayList<>();
	}

    @Override
    public void themTroChoi(TroChoi game) {
        if (game != null) danhSach.add(game);
    }

    @Override
    public TroChoi timKiemTroChoi(String maGame) {
        if (maGame == null) return null;
        for (TroChoi game : danhSach) {
            if (maGame.equals(game.getMaGame())) return game;
        }
        return null;
    }

    @Override
    public boolean xoaTroChoi(String maGame) {
        TroChoi game = timKiemTroChoi(maGame);
        if (game != null) return danhSach.remove(game);
        return false;
    }

    @Override
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach tro choi trong.");
            return;
        }
        System.out.println("--- DANH SACH TRO CHOI ---");
        for (TroChoi game : danhSach) {
            game.hienThiThongTin();
            System.out.println("Gia ban cuoi: " + game.tinhGiaBan() + " VNĐ");
            System.out.println("-------------------------");
        }
    }

    @Override
    public boolean capNhatTroChoi(String maGame, TroChoi gameMoi) {
        if (maGame == null || gameMoi == null) return false;
        for (int i = 0; i < danhSach.size(); i++) {
            if (maGame.equals(danhSach.get(i).getMaGame())) {
                danhSach.set(i, gameMoi);
                return true;
            }
        }
        return false;
    }
    
    // mua hàng
    @Override
    public boolean thucHienGiaoDichMua(String maGame, int soLuong) {
        TroChoi game = timKiemTroChoi(maGame);
        if (game != null && soLuong > 0) {
            game.themGiaoDichMua(soLuong);
            return true;
        }
        return false;
    }
    
    // thống kê
    @Override
    public void thongKeDoanhSo30NgayGanNhat() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach tro choi trong, khong the thong ke.");
            return;
        }

        LocalDateTime thoiGianHienTai = LocalDateTime.now();
        LocalDateTime thoiGianBatDau = thoiGianHienTai.minusDays(30);

        int tongSoLuongBan = 0;
        double tongDoanhThu = 0.0;

        System.out.println("\n--- THONG KE TRONG 30 NGAY (Tu " + thoiGianBatDau.toLocalDate() + " den " + thoiGianHienTai.toLocalDate() + ") ---");
        
        for (TroChoi game : danhSach) {
            int soLuongBanGame = 0;
            double doanhThuGame = 0.0;
            
            for (TroChoi.LichSuMuaHang giaoDich : game.getLichSuMua()) {
                if (giaoDich.thoiGianMua.isAfter(thoiGianBatDau)) //khoảng thời gian trong 30 ngày
                { 
                    soLuongBanGame += giaoDich.soLuong;
                    doanhThuGame += giaoDich.soLuong * game.tinhGiaBan(); 
                }
            }

            if (soLuongBanGame > 0) {
                System.out.printf("  - Game [%s]: So luong: %d, Doanh thu: %.2f VNĐ\n", 
                                  game.getTenGame(), soLuongBanGame, doanhThuGame);
                tongSoLuongBan += soLuongBanGame;
                tongDoanhThu += doanhThuGame;
            }
        }
        
        System.out.println("----------------------------------------------");
        System.out.printf("TONG DOANH SO TRONG 30 NGAY: %d san pham.\n", tongSoLuongBan);
        System.out.printf("TONG DOANH THU TRONG 30 NGAY: %.2f VNĐ.\n", tongDoanhThu);
        System.out.println("----------------------------------------------");
    }
}