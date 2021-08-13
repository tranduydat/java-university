/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-16    1.0        DatDuyTran       Release 1.0<br>
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author datdu
 */
public interface UserDAO {

    public List<User> getAll() throws Exception;

    public void add(User user) throws Exception;

    public boolean doesExist(User user, List<User> listOfUsers);

    public User get(String userName, String password) throws Exception;

}
