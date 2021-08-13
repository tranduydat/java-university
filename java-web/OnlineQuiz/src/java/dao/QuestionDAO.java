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
import model.Question;

/**
 *
 * @author datdu
 */
public interface QuestionDAO {

    public List<Question> getAll() throws Exception;

    public List<Question> getAllByUserID(int userID) throws Exception;

    public void add(Question quiz) throws Exception;

    public Question getForEachPage(int number) throws Exception;

    public int count() throws Exception;

}
