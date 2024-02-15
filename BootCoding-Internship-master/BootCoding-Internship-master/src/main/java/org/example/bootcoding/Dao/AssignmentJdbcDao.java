package org.example.bootcoding.Dao;

import org.example.bootcoding.connection.JdbcConnection;
import org.example.bootcoding.model.Assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentJdbcDao implements AssignmentDao
{
    Connection con = JdbcConnection.getConnection();
    @Override
    public void SaveAssignment(List<Assignment> assignments) {
        String sql = "INSERT INTO Assignment(qid, title, difficultylevel, acceptancerate, paidonly) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            for (Assignment assignment : assignments) {
                ps.setInt(1, assignment.getQID());
                ps.setString(2, assignment.getTitle());
                ps.setString(3, assignment.getDifficultyLevel());
                ps.setDouble(4, assignment.getAcceptanceRate());
                ps.setBoolean(5, assignment.isPaidOnly());
                ps.executeUpdate();
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Assignment> getData() {
        List<Assignment> assignmentList = new ArrayList<>();
        String sql = "SELECT qid, title, difficultylevel, acceptancerate, paidonly FROM Assignment";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                int qid = rs.getInt("qid");
                String title = rs.getString("title");
                String difficultyLevel = rs.getString("difficultylevel");
                double acceptanceRate = rs.getDouble("acceptancerate");
                boolean paidOnly = rs.getBoolean("paidonly");

                Assignment assignment = new Assignment(qid, title, difficultyLevel, acceptanceRate, paidOnly);
                assignmentList.add(assignment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return assignmentList;
    }

    @Override
    public List<Assignment> getByDifficultyLevel(String input) {
        List<Assignment> assignmentList = new ArrayList<>();
        String sql = "SELECT qid, title, difficultylevel, acceptancerate, paidonly FROM assignment WHERE difficultylevel = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, input);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int qid = rs.getInt("qid");
                String title = rs.getString("title");
                String difficultyLevel = rs.getString("difficultylevel");
                double acceptanceRate = rs.getDouble("acceptancerate");
                boolean paidOnly = rs.getBoolean("paidonly");

                Assignment assignment = new Assignment(qid, title, difficultyLevel, acceptanceRate, paidOnly);
                assignmentList.add(assignment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return assignmentList;
    }

    @Override
    public List<Assignment> getByPaidOnly(boolean input)
    {
        List<Assignment> assignmentList = new ArrayList<>();
        String sql = "SELECT qid, title, difficultylevel, acceptancerate, paidonly FROM assignment WHERE paidonly = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1,input);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int qid = rs.getInt("qid");
                String title = rs.getString("title");
                String difficultyLevel = rs.getString("difficultylevel");
                double acceptanceRate = rs.getDouble("acceptancerate");
                boolean paidOnly = rs.getBoolean("paidonly");

                Assignment assignment = new Assignment(qid, title, difficultyLevel, acceptanceRate, paidOnly);
                assignmentList.add(assignment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return assignmentList;


}


}
