package com.example.dao;

import com.example.model.Nganh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class NganhDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Nganh> getAll() {
    String sql = "SELECT MaNganh, TenNganh FROM NGANH";
    return jdbcTemplate.query(sql, (rs, rn) -> {
      Nganh n = new Nganh();
      n.setMaNganh(rs.getString("MaNganh"));
      n.setTenNganh(rs.getString("TenNganh"));
      return n;
    });
  }
}
