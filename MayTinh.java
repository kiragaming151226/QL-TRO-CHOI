import java.time.Year;// lấy năm hiện tại

public class MayTinh extends TroChoi {
    private String yeuCauCauHinh;
    private boolean laBanGioiHan;

    public MayTinh(String maGame, String tenGame, String nhaSanXuat, int namPhatHanh, double giaCoBan, String yeuCauCauHinh, boolean laBanGioiHan) {
        //  năm hiện tại hệ thống
        int namHienTai = Year.now().getValue();
        // Kiểm tra năm phát hành không vượt quá thời gian hệ thống
        if (namPhatHanh > namHienTai) {
            throw new IllegalArgumentException("Loi: nam phat hanh (" + namPhatHanh + ") khong vuot qua nam hien tai (" + namHienTai + ").");
        }

        super(maGame, tenGame, nhaSanXuat, namPhatHanh, giaCoBan);
        this.yeuCauCauHinh = yeuCauCauHinh;
        this.laBanGioiHan = laBanGioiHan;
    }

    public String getYeuCauCauHinh() { return yeuCauCauHinh; }
    public boolean getLaBanGioiHan() { return laBanGioiHan; }

    @Override
    public double tinhGiaBan() {
        double giaThem = laBanGioiHan ? giaCoBan * 0.15 : 0.0; // phiên bản giới hạn (tăng 15%)
        return giaCoBan + giaThem;
    }

    @Override
    public boolean kiemTraTinhTrangServer(boolean isOnline) {
        System.out.println("Game " + tenGame + " hien dang " + (isOnline ? "ONLINE" : "OFFLINE") + ".");
        return isOnline;
    }

    @Override
    public void capNhatPhienBan(String versionMoi) {
        System.out.println("Da cap nhat " + tenGame + " len phien ban: " + versionMoi + ".");
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Yeu Cau Cau Hinh: " + yeuCauCauHinh +
               ", La Ban Gioi Han: " + (laBanGioiHan ? "Co" : "Khong") +
               ", Gia Ban: " + tinhGiaBan() + " VNĐ";
    }
}