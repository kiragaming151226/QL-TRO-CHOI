import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class TroChoi implements IGiaTriTroChoi, IKiemKeTroChoi, Serializable {
    private static final long serialVersionUID = 1L;
    public static class LichSuMuaHang implements Serializable {
        private static final long serialVersionUID = 1L;
        public LocalDateTime thoiGianMua; 
        public int soLuong;

        public LichSuMuaHang(int soLuong) {
            this.soLuong = soLuong;
            // Ghi lại thời gian hiện tại, đảm bảo không vượt quá thời gian ngoài dữ liệu ( cô dạy)
            this.thoiGianMua = LocalDateTime.now(); 
        }

        @Override
        public String toString() {
            return " [Thoi Gian: " + thoiGianMua.toString().substring(0, 19) + ", SL: " + soLuong + "]";
        }
    }
    protected String maGame;
    protected String tenGame;
    protected String nhaSanXuat;
    protected int namPhatHanh;
    protected double giaCoBan;
    protected List<LichSuMuaHang> lichSuMua; 
    public TroChoi() {
        this.lichSuMua = new ArrayList<>();
    }

    public TroChoi(String maGame, String tenGame, String nhaSanXuat, int namPhatHanh, double giaCoBan) {
        this.maGame = maGame;
        this.tenGame = tenGame;
        this.nhaSanXuat = nhaSanXuat;
        this.namPhatHanh = namPhatHanh;
        this.giaCoBan = giaCoBan;
        this.lichSuMua = new ArrayList<>(); 
    }
    public String getMaGame() { return maGame; }
    public String getTenGame() { return tenGame; }
    public double getGiaCoBan() { return giaCoBan; }
    public List<LichSuMuaHang> getLichSuMua() { return lichSuMua; }
    
    // Phương thức 
    public void themGiaoDichMua(int soLuong) {
        if (soLuong > 0) {
            lichSuMua.add(new LichSuMuaHang(soLuong));
        }
    }

    public void hienThiThongTin() {
        System.out.println("Ma Game: " + maGame);
        System.out.println("Ten Game: " + tenGame);
        System.out.println("Nha San Xuat: " + nhaSanXuat);
        System.out.println("Nam Phat Hanh: " + namPhatHanh);
        System.out.println("Gia Co Ban: " + giaCoBan + " VNĐ");
        System.out.println("Tong so giao dich: " + lichSuMua.size()); 
    }

    @Override
    public String toString() {
        return "TroChoi [maGame=" + maGame + ", tenGame=" + tenGame + ", nhaSanXuat=" + nhaSanXuat
                + ", namPhatHanh=" + namPhatHanh + ", giaCoBan=" + giaCoBan + ", Lich Su Mua: " + lichSuMua + "]";
    }
}