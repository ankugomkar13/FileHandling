package org.example.bootcoding.service;

import org.example.bootcoding.Dao.AssignmentDao;
import org.example.bootcoding.Dao.AssignmentJdbcDao;
import org.example.bootcoding.model.Assignment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentService {
    public List<Assignment> readFile(String filename)  {
        List<Assignment> assignmentList = new ArrayList<>();
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> recordData = csvFileReader.read(filename);

        for (String record:
             recordData) {
            Assignment assignment = convertToAssignment(record);
            assignmentList.add(assignment);
        }
        AssignmentDao assignmentDao = new AssignmentJdbcDao();
        assignmentDao.SaveAssignment(assignmentList);
        return assignmentList;
    }

    private Assignment convertToAssignment(String record) {
//        1,Two Sum,two-sum,Easy,51.76576548830185,False,"array,hash-table",algorithms
        String[] splitResult = record.split(",");
        double acceptanceRate ;
        try {
            acceptanceRate = Double.parseDouble(splitResult[4]);
        }catch (NumberFormatException exception){
            acceptanceRate = 0.0d;
        }
        return new Assignment(Integer.parseInt(splitResult[0]), splitResult[1], splitResult[3],
                acceptanceRate, Boolean.parseBoolean(splitResult[5]));

    }


    //For Fetching data from database
    public List<Assignment> getAssignment()
    {
       AssignmentDao assignmentDao = new AssignmentJdbcDao();
       List<Assignment> assignmentList =  assignmentDao.getData();
       return assignmentList;
    }


    //Fetch data by difficulty level
    public List<Assignment> getByDifficultyLevel(String userinput)
    {
        AssignmentDao assignmentDao = new AssignmentJdbcDao();
        List<Assignment> Assignmentlist = assignmentDao.getByDifficultyLevel(userinput);
        return Assignmentlist;
    }

    public List<Assignment> getByPaidonly(boolean userinput)
    {
        AssignmentDao assignmentDao = new AssignmentJdbcDao();
        List<Assignment> Assignmentlist = assignmentDao.getByPaidOnly(userinput);
        return Assignmentlist;
    }

    }

