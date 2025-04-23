package com.example.dao;

import com.example.model.Truong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TruongDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Truong> getAll() {
    String sql = "SELECT MaTruong, TenTruong FROM TRUONG";
    return jdbcTemplate.query(sql, (rs, rn) -> {
      Truong t = new Truong();
      t.setMaTruong(rs.getString("MaTruong"));
      t.setTenTruong(rs.getString("TenTruong"));
      return t;
    });
  }
}
