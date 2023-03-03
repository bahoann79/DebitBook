/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author bahoann79
 */
public class Debt {

    private int id;
    private String reason;
    private boolean roleDebt;
    private BigDecimal money;
    private Date debtCreatedTime;
    private String image;
    private int createdBy;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private boolean isDeleted;
    private Debtor debtor;

    public Debt() {
    }

    public Debt(int id, String reason, boolean roleDebt, BigDecimal money, Date debtCreatedTime, String image, int createdBy, Date createdAt, Date updatedAt, Date deletedAt, boolean isDeleted) {
        this.id = id;
        this.reason = reason;
        this.roleDebt = roleDebt;
        this.money = money;
        this.debtCreatedTime = debtCreatedTime;
        this.image = image;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isRoleDebt() {
        return roleDebt;
    }

    public void setRoleDebt(boolean roleDebt) {
        this.roleDebt = roleDebt;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getDebtCreatedTime() {
        return debtCreatedTime;
    }

    public void setDebtCreatedTime(Date debtCreatedTime) {
        this.debtCreatedTime = debtCreatedTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }

}
