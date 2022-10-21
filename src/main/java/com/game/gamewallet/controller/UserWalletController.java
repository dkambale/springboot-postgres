package com.game.gamewallet.controller;

import com.game.gamewallet.model.UserWalletDetails;
import com.game.gamewallet.model.WalletResponse;
import com.game.gamewallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-wallet")
public class UserWalletController {

  @Autowired
  UserWalletService userWalletService;

  @PostMapping(name = "/saveUserDetails", value = "/saveUserDetails")
  public ResponseEntity<WalletResponse> saveUserWalletEntry(UserWalletDetails userWalletBalance) {
    WalletResponse response = null;
    try {
      response = userWalletService.saveUserWalletDetails(userWalletBalance);
      return new ResponseEntity<WalletResponse>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<WalletResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(name = "/updateWalletBalance", value = "/updateWalletBalance")
  public ResponseEntity<UserWalletDetails> updateBalance(@RequestParam Integer userId, @RequestParam Double balance) {
    UserWalletDetails updateResponse = null;
    try {
      updateResponse = userWalletService.updateUserBalance(userId, balance);
      return new ResponseEntity<UserWalletDetails>(updateResponse, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<UserWalletDetails>(updateResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
