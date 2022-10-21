package com.game.gamewallet.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wallet_txn")
public class UserWalletTransaction  extends  TenantBase{

  int userId;
  double amount;
  Date createdAt;
  double closingBalance;
  String entity;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public double getClosingBalance() {
    return closingBalance;
  }

  public void setClosingBalance(double closingBalance) {
    this.closingBalance = closingBalance;
  }

  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }
}
