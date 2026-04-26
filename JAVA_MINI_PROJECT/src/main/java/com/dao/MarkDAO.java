package com.dao;

import java.sql.*;
import java.util.*;
import com.model.StudentMark;

public class MarkDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/markdb","root","password");
    }

    public void addMark(StudentMark s) throws Exception {
        Connection con = getConnection();
        String sql = "INSERT INTO StudentMarks VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, s.getStudentId());
        ps.setString(2, s.getStudentName());
        ps.setString(3, s.getSubject());
        ps.setInt(4, s.getMarks());
        ps.setDate(5, s.getExamDate());
        ps.executeUpdate();
        con.close();
    }
    public void updateMark(StudentMark s) throws Exception {
        Connection con = getConnection();
        String sql = "UPDATE StudentMarks SET StudentName=?, Subject=?, Marks=?, ExamDate=? WHERE StudentID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, s.getStudentName());
        ps.setString(2, s.getSubject());
        ps.setInt(3, s.getMarks());
        ps.setDate(4, s.getExamDate());
        ps.setInt(5, s.getStudentId());
        ps.executeUpdate();
        con.close();
    }

    public void deleteMark(int id) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM StudentMarks WHERE StudentID=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    public List<StudentMark> getMarksAbove(int value) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentMarks WHERE Marks > ?");
        ps.setInt(1, value);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            StudentMark s = new StudentMark();
            s.setStudentId(rs.getInt(1));
            s.setStudentName(rs.getString(2));
            s.setSubject(rs.getString(3));
            s.setMarks(rs.getInt(4));
            s.setExamDate(rs.getDate(5));
            list.add(s);
        }
        con.close();
        return list;
    }

    public List<StudentMark> getBySubject(String subject) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentMarks WHERE Subject=?");
        ps.setString(1, subject);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            StudentMark s = new StudentMark();
            s.setStudentId(rs.getInt(1));
            s.setStudentName(rs.getString(2));
            s.setSubject(rs.getString(3));
            s.setMarks(rs.getInt(4));
            s.setExamDate(rs.getDate(5));
            list.add(s);
        }
        con.close();
        return list;
    }

    public List<StudentMark> getAllMarks() throws Exception {
        List<StudentMark> list = new ArrayList<>();
        Connection con = getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM StudentMarks");
        while(rs.next()){
            StudentMark s = new StudentMark();
            s.setStudentId(rs.getInt(1));
            s.setStudentName(rs.getString(2));
            s.setSubject(rs.getString(3));
            s.setMarks(rs.getInt(4));
            s.setExamDate(rs.getDate(5));
            list.add(s);
        }
        con.close();
        return list;
    }

public List<StudentMark> getTopN(int n) throws Exception {
    List<StudentMark> list = new ArrayList<>();

    Connection con = getConnection();
    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?"
    );
    ps.setInt(1, n);

    ResultSet rs = ps.executeQuery();

    while(rs.next()){
        StudentMark s = new StudentMark();
        s.setStudentId(rs.getInt(1));
        s.setStudentName(rs.getString(2));
        s.setSubject(rs.getString(3));
        s.setMarks(rs.getInt(4));
        s.setExamDate(rs.getDate(5));
        list.add(s);
    }

    con.close();
    return list;

}
}