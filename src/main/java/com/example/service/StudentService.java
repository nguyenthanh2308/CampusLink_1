package com.example.service;

import com.example.dao.StudentDao;
import com.example.model.SinhVien;
import com.example.model.TotNghiep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
  @Autowired
  private StudentDao studentDao;

  @Transactional
  public void registerGraduate(SinhVien sv, TotNghiep tn) {
    studentDao.saveSinhVien(sv);
    tn.setSoCMND(sv.getSoCMND());
    studentDao.saveTotNghiep(tn);
  }
}
