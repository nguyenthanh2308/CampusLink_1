package com.example.dao;

import com.example.model.SinhVien;
import com.example.model.TotNghiep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public int saveSinhVien(SinhVien sv) {
    String sql = "INSERT INTO SINHVIEN (SoCMND, HoTen, Email, SoDT, DiaChi) VALUES (?,?,?,?,?)";
    return jdbcTemplate.update(sql,
      sv.getSoCMND(), sv.getHoTen(), sv.getEmail(), sv.getSoDT(), sv.getDiaChi());
  }

  public int saveTotNghiep(TotNghiep tn) {
    String sql = "INSERT INTO TOT_NGHIEP (SoCMND, MaTruong, MaNganh, NgayTN, HeTN, LoaiTN) VALUES (?,?,?,?,?,?)";
    return jdbcTemplate.update(sql,
      tn.getSoCMND(), tn.getMaTruong(), tn.getMaNganh(),
      tn.getNgayTN(), tn.getHeTN(), tn.getLoaiTN());
  }
}
