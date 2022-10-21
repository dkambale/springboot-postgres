package com.game.gamewallet.repo;

import com.game.gamewallet.model.UserWalletDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserWalletDetailsRepo extends CrudRepository<UserWalletDetails,Integer> {

  public UserWalletDetails getByUserId(int userId);
}
