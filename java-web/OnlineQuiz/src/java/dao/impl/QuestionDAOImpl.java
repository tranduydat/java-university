/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-16    1.0        DatDuyTran       Release 1.0<br>
 */
package dao.impl;

import dao.AbstractDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Question;
import dao.QuestionDAO;

/**
 *
 * @author datdu
 */
public class QuestionDAOImpl extends AbstractDAO implements QuestionDAO {

    @Override
    public List<Question> getAll() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String query = "SELECT [question_id]"
                    + "      ,[content]"
                    + "      ,[option1]"
                    + "      ,[option2]"
                    + "      ,[option3]"
                    + "      ,[option4]"
                    + "      ,[answer]"
                    + "      ,[user_id]"
                    + "      ,[created_at]"
                    + "  FROM [dbo].[questions]";

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            List<Question> listOfQuestions = new ArrayList<>();

            while (rs.next()) {
                listOfQuestions.add(new Question(
                        rs.getInt("question_id"),
                        rs.getString("content"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("answer"),
                        rs.getInt("user_id"),
                        rs.getDate("created_at")
                ));
            }

            return listOfQuestions;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public List<Question> getAllByUserID(int userID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "SELECT [question_id]"
                    + "      ,[content]"
                    + "      ,[option1]"
                    + "      ,[option2]"
                    + "      ,[option3]"
                    + "      ,[option4]"
                    + "      ,[answer]"
                    + "      ,[user_id]"
                    + "      ,[created_at]"
                    + "  FROM [dbo].[questions]"
                    + "  WHERE user_id = (?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();

            List<Question> listOfQuestions = new ArrayList<>();

            while (rs.next()) {
                listOfQuestions.add(new Question(
                        rs.getInt("question_id"),
                        rs.getString("content"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("answer"),
                        rs.getInt("user_id"),
                        rs.getDate("created_at")
                ));
            }

            return listOfQuestions;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public void add(Question question) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "INSERT INTO [dbo].[questions]"
                    + "           ([content]"
                    + "           ,[option1]"
                    + "           ,[option2]"
                    + "           ,[option3]"
                    + "           ,[option4]"
                    + "           ,[answer]"
                    + "           ,[user_id]"
                    + "           ,[created_at])"
                    + "     VALUES"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,GETDATE())";

            ps = conn.prepareStatement(query);
            ps.setString(1, question.getContent());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getOption4());
            ps.setString(6, question.getAnswer());
            ps.setInt(7, question.getUserID());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public Question getForEachPage(int number) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "SELECT question_id, content, option1, option2, option3, option4, answer "
                    + "FROM(SELECT question_id, content, option1, option2, option3, option4, answer, ROW_NUMBER() OVER (ORDER BY question_id DESC) AS Seq FROM dbo.questions)AS x "
                    + "WHERE Seq = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1, number);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Question(
                        rs.getInt("question_id"),
                        rs.getString("content"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("answer")
                );
            }

            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public int count() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "SELECT COUNT(*) AS [total_of_questions] FROM dbo.questions";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                int countRow = rs.getInt("total_of_questions");
                return countRow;
            }
            return 0;

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }
}
