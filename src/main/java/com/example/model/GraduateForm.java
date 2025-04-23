package com.example.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class GraduateForm {
    @Valid
    @NotNull
    private SinhVien sinhVien = new SinhVien();

    @Valid
    @NotNull
    private TotNghiep totNghiep = new TotNghiep();

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public TotNghiep getTotNghiep() {
        return totNghiep;
    }

    public void setTotNghiep(TotNghiep totNghiep) {
        this.totNghiep = totNghiep;
    }
}