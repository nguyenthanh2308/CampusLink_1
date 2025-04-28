package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.SinhVien;

@Repository
public class SinhVienDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Tìm kiếm sinh viên theo CMND hoặc họ tên (LIKE)
     */
    @SuppressWarnings("deprecation")
	public List<SinhVien> searchBasic(String keyword) {
        String sql = "SELECT SoCMND, HoTen, Email, SoDT, DiaChi FROM SINHVIEN " +
                     "WHERE SoCMND LIKE ? OR HoTen LIKE ?";
        String kw = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new Object[]{kw, kw}, (rs, idx) -> {
            SinhVien sv = new SinhVien();
            sv.setSoCMND(rs.getString("SoCMND"));
            sv.setHoTen(rs.getString("HoTen"));
            sv.setEmail(rs.getString("Email"));
            sv.setSoDT(rs.getString("SoDT"));
            sv.setDiaChi(rs.getString("DiaChi"));
            return sv;
        });
    }

    /**
     * Tìm kiếm thông tin tốt nghiệp và việc làm theo CMND
     */
    public List<Map<String,Object>> searchGraduate(String cmnd) {
        String sql =
            "SELECT sv.SoCMND, sv.HoTen, tn.MaNganh AS NganhTN, tn.MaTruong,"
          + " cv.MaNganh AS NganhCV, cv.TenCongTy, cv.ThoiGianLamViec"
          + " FROM SINHVIEN sv"
          + " LEFT JOIN TOT_NGHIEP tn ON sv.SoCMND=tn.SoCMND"
          + " LEFT JOIN CONG_VIEC cv ON sv.SoCMND=cv.SoCMND"
          + " WHERE sv.SoCMND LIKE ?";
        return jdbcTemplate.queryForList(sql, "%" + cmnd + "%");
    }
}