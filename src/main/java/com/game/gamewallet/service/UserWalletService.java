package com.game.gamewallet.service;

import com.game.gamewallet.model.UserWalletDetails;
import com.game.gamewallet.model.WalletResponse;
import com.game.gamewallet.repo.UserWalletDetailsRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletService {

  @Autowired
  UserWalletDetailsRepo userWalletDetailsRepo;

  public WalletResponse saveUserWalletDetails(UserWalletDetails userWalletDetails) {
    WalletResponse response = new WalletResponse();
    try {
      userWalletDetailsRepo.save(userWalletDetails);
      return response;
    } catch (Exception e) {
      response.setError("Error has occured while saving user wallet details");
      return response;
    }
  }

  public UserWalletDetails updateUserBalance(Integer userId, double point) throws Exception {
    UserWalletDetails userWalletDetails = null;
    try {

      userWalletDetails = userWalletDetailsRepo.getByUserId(userId);
      if (userWalletDetails != null) {

        if (point < 0) {
          double remainingBalance = userWalletDetails.getBalance() - Math.abs(point);
          if (remainingBalance < 0) {
            throw new Exception("User has less balance");
          } else {
            userWalletDetails.setBalance(remainingBalance);
            userWalletDetails.setUpdatedAt(new Date());
          }
        } else {
          double remainingBalance = userWalletDetails.getBalance() + Math.abs(point);
          userWalletDetails.setBalance(remainingBalance);
          userWalletDetails.setUpdatedAt(new Date());
        }
        userWalletDetails = userWalletDetailsRepo.save(userWalletDetails);
      }
    } catch (Exception e) {
      throw new Exception("Error has  occurred  while update balance");
    } finally {
      System.out.println("saved transaction");
    }
    return userWalletDetails;
  }
}
