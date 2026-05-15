package com.dao;

import java.sql.*;
import java.util.*;
import com.model.StudentMark;

public class MarkDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/markdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_SQL =
    		"INSERT INTO StudentMarks(StudentName, Subject, Marks, ExamDate) VALUES (?, ?, ?, ?)";

    private static final String UPDATE_SQL =
            "UPDATE StudentMarks SET StudentName=?, Subject=?, Marks=?, ExamDate=? WHERE StudentID=?";

    private static final String DELETE_SQL =
            "DELETE FROM StudentMarks WHERE StudentID=?";

    private static final String SELECT_ALL =
            "SELECT * FROM StudentMarks";

    private static final String SELECT_BY_ID =
            "SELECT * FROM StudentMarks WHERE StudentID=?";

    protected Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertMark(StudentMark mark) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

        	ps.setString(1, mark.getStudentName());
        	ps.setString(2, mark.getSubject());
        	ps.setInt(3, mark.getMarks());
        	ps.setDate(4, mark.getExamDate());
            ps.executeUpdate();
        }
    }

    public void updateMark(StudentMark mark) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {

            ps.setString(1, mark.getStudentName());
            ps.setString(2, mark.getSubject());
            ps.setInt(3, mark.getMarks());
            ps.setDate(4, mark.getExamDate());
            ps.setInt(5, mark.getStudentID());
            ps.executeUpdate();
        }
    }

    public void deleteMark(int id) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<StudentMark> getAllMarks() throws Exception {
        List<StudentMark> list = new ArrayList<>();

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {

            while (rs.next()) {
                StudentMark m = new StudentMark();
                m.setStudentID(rs.getInt("StudentID"));
                m.setStudentName(rs.getString("StudentName"));
                m.setSubject(rs.getString("Subject"));
                m.setMarks(rs.getInt("Marks"));
                m.setExamDate(rs.getDate("ExamDate"));
                list.add(m);
            }
        }
        return list;
    }

    public StudentMark getMarkById(int id) throws Exception {
        StudentMark m = null;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new StudentMark();
                m.setStudentID(rs.getInt("StudentID"));
                m.setStudentName(rs.getString("StudentName"));
                m.setSubject(rs.getString("Subject"));
                m.setMarks(rs.getInt("Marks"));
                m.setExamDate(rs.getDate("ExamDate"));
            }
        }
        return m;
    }

    // Reports
    public List<StudentMark> getAboveMarks(int value) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks WHERE Marks > ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, value);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StudentMark m = new StudentMark();
                m.setStudentID(rs.getInt("StudentID"));
                m.setStudentName(rs.getString("StudentName"));
                m.setSubject(rs.getString("Subject"));
                m.setMarks(rs.getInt("Marks"));
                m.setExamDate(rs.getDate("ExamDate"));
                list.add(m);
            }
        }
        return list;
    }

    public List<StudentMark> getBySubject(String subject) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks WHERE Subject=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, subject);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StudentMark m = new StudentMark();
                m.setStudentID(rs.getInt("StudentID"));
                m.setStudentName(rs.getString("StudentName"));
                m.setSubject(rs.getString("Subject"));
                m.setMarks(rs.getInt("Marks"));
                m.setExamDate(rs.getDate("ExamDate"));
                list.add(m);
            }
        }
        return list;
    }

    public List<StudentMark> getTopN(int n) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, n);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StudentMark m = new StudentMark();
                m.setStudentID(rs.getInt("StudentID"));
                m.setStudentName(rs.getString("StudentName"));
                m.setSubject(rs.getString("Subject"));
                m.setMarks(rs.getInt("Marks"));
                m.setExamDate(rs.getDate("ExamDate"));
                list.add(m);
            }
        }
        return list;
    }
}