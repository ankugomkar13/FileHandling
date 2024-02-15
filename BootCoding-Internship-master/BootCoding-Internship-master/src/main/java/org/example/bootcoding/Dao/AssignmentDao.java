package org.example.bootcoding.Dao;

import org.example.bootcoding.model.Assignment;

import java.sql.SQLException;
import java.util.List;

public interface AssignmentDao
{
    void  SaveAssignment(List<Assignment> assignment);

    List<Assignment> getData();

    List<Assignment> getByDifficultyLevel(String input);

    List <Assignment> getByPaidOnly(boolean input);

}
