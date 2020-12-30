package com.sulluscocha.user_application.Imp;

import com.sulluscocha.types.types.Profile;
import com.sulluscocha.types.types.UserRequest;
import com.sulluscocha.user_application.UserService;
import com.sulluscocha.user_domain.domain.RecordUser;
import com.sulluscocha.user_domain.domain.User;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;
import com.sulluscocha.user_domain.exception.UserNotFoundException;
import com.sulluscocha.user_persistence.persistence.repositorymongo.Imp.RecordRepositoryImp;
import com.sulluscocha.user_persistence.persistence.repositorymysql.Imp.UserRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {


    private final UserRepositoryImp userRepositoryImp;
    private final RecordRepositoryImp recordRepositoryImp;

    @Autowired
    public UserServiceImp(UserRepositoryImp userRepositoryImp, RecordRepositoryImp recordRepositoryImp) {
        this.userRepositoryImp = userRepositoryImp;
        this.recordRepositoryImp = recordRepositoryImp;
    }


    @Override
    public User ingresoUsuario(UserRequest userRequest) {


        try {
            System.out.println(userRequest.getEmail());
            User user = new User();
            user.setProfile(new Profile(userRequest.getId(), userRequest.getEmail()));
            System.out.println("usuario guardado");
            return this.userRepositoryImp.guardarUsuario(user);


        } catch (Exception ex) {

            return null;
        }


    }

    @Override
    public User obtenerUsuario(String token) throws UserNotFoundException, RecordNotFoundException {


        RecordUser recordUser = this.recordRepositoryImp.buscarPorToken(token);

        System.out.println(recordUser.getSub());
        return this.userRepositoryImp.buscarUsuario(recordUser.getSub());


    }

    @Override
    public void limpiarHistorial() {

        this.recordRepositoryImp.limpiarHistorial();


    }


}
