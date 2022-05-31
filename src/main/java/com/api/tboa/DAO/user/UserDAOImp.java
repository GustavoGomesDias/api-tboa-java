package com.api.tboa.DAO.user;

import com.api.tboa.DAO.generic.GenericDAOImp;
import com.api.tboa.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class UserDAOImp extends GenericDAOImp<UserModel> implements UserDAO {
    public UserDAOImp() {
        super(UserModel.class);
    }
}
