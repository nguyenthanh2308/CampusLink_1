package com.example.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class TotNghiep {
  private String soCMND;

  @NotBlank(message="Vui lòng chọn trường")
  private String maTruong;

  @NotBlank(message="Vui lòng chọn ngành")
  private String maNganh;

  @NotNull(message="Ngày tốt nghiệp không được để trống")
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private LocalDate ngayTN;

  private String heTN;
  private String loaiTN;
  
  // getters & setters...
  public String getSoCMND() {
      return soCMND;
  }

  public void setSoCMND(String soCMND) {
      this.soCMND = soCMND;
  }

  public String getMaTruong() {
      return maTruong;
  }

  public void setMaTruong(String maTruong) {
      this.maTruong = maTruong;
  }

  public String getMaNganh() {
      return maNganh;
  }

  public void setMaNganh(String maNganh) {
      this.maNganh = maNganh;
  }

  public LocalDate getNgayTN() {
      return ngayTN;
  }

  public void setNgayTN(LocalDate ngayTN) {
      this.ngayTN = ngayTN;
  }

  public String getHeTN() {
      return heTN;
  }

  public void setHeTN(String heTN) {
      this.heTN = heTN;
  }

  public String getLoaiTN() {
      return loaiTN;
  }

  public void setLoaiTN(String loaiTN) {
      this.loaiTN = loaiTN;
  }
}
