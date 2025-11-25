import java.time.Year; // lấy năm hiện tại
public class DienThoai extends TroChoi {
    private String nenTang; 
    private boolean coQuangCao; 

    public DienThoai(String maGame, String tenGame, String nhaSanXuat, int namPhatHanh, double giaCoBan, String nenTang, boolean coQuangCao) {
        //  năm hiện tại hệ thống
        int namHienTai = Year.now().getValue();
        // Kiểm tra năm phát hành không vượt quá thời gian hệ thống
        if (namPhatHanh > namHienTai) {
            throw new IllegalArgumentException("Loi: nam phat hanh (" + namPhatHanh + ") khong vuot qua nam hien tai (" + namHienTai + ").");
            // throw new IllegalArgumentException (tham số không phù hợp hoặc không hợp lệ).
            //loại ngoại lệ.
        }

        super(maGame, tenGame, nhaSanXuat, namPhatHanh, giaCoBan);
        this.nenTang = nenTang;
        this.coQuangCao = coQuangCao;
    }
    public String getNenTang() { return nenTang; }
    public boolean getCoQuangCao() { return coQuangCao; }

    @Override
    public double tinhGiaBan() {
        //  chi phí mua bản Premium ( có quảng cáo, giảm 50000)
        double giaPremium = giaCoBan; 
        if (coQuangCao) {
            giaPremium -= 50000.0; 
        }
        return Math.max(0, giaPremium); //giá không âm
    }

    @Override
    public boolean kiemTraTinhTrangServer(boolean isOnline) // tình trạng server
    {
        System.out.println("Mobile Game " + tenGame + " hien dang " + (isOnline ? "ONLINE" : "OFFLINE") + " tren nen tang " + nenTang + ".");
        return isOnline;
    }

    @Override
    public void capNhatPhienBan(String versionMoi) // phiên bản 
    {
        System.out.println("Da cap nhat " + tenGame + " len phien ban: " + versionMoi + " cho tat ca nen tang.");
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Nen Tang: " + nenTang +
               ", Co Quang Cao: " + (coQuangCao ? "Co" : "Khong") +
               ", Gia Ban Premium: " + tinhGiaBan() + " VNĐ";
    }
}