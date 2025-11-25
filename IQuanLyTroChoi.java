public interface IQuanLyTroChoi {
    public void themTroChoi(TroChoi game);
    public TroChoi timKiemTroChoi(String maGame);
    public boolean xoaTroChoi(String maGame);
    public void hienThiDanhSach();
    public boolean capNhatTroChoi(String maGame, TroChoi gameMoi);
    public boolean thucHienGiaoDichMua(String maGame, int soLuong);
    public void thongKeDoanhSo30NgayGanNhat(); 
}