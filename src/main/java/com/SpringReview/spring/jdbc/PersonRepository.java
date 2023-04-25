package com.SpringReview.spring.jdbc;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private String url = "jdbc:mariadb://localhost:3306/spring";
    private String username = "root";
    private String password = "1111";

    public PersonRepository() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(Person person) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);

            String sql = "INSERT INTO personreview (person_name, person_age) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, person.getPersonName());
            pstmt.setInt(2, person.getAge());

            int result = pstmt.executeUpdate();
            if (result == 1) conn.commit();
            else conn.rollback();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Person p) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);

            conn.setAutoCommit(false);

            String sql = "UPDATE personreview SET person_name=?,person_age=? WHERE id= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, p.getPersonName());
            pstmt.setInt(2, p.getAge());
            pstmt.setLong(3, p.getId());

            int result = pstmt.executeUpdate();
            if (result == 1) conn.commit();
            else conn.rollback();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Person> findAll(){
        List<Person> people = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url,username,password)){
            conn.setAutoCommit(false);

            String url = "SELECT * FROM personreview";
            PreparedStatement pstmt = conn.prepareStatement(url);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                int age = rs.getInt("person_age");
                String name = rs.getString("person_name");

                Person p = new Person(id, name, age);
                people.add(p);
            }

        }catch (Exception e){

        }
        return people;
    }

    public Person findOne(long id2){
        try(Connection conn = DriverManager.getConnection(url,username,password)){
            conn.setAutoCommit(false);

            String url = "SELECT * FROM personreview WHERE id =? ";
            PreparedStatement pstmt = conn.prepareStatement(url);
            pstmt.setLong(1,id2);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                long id = rs.getLong("id");
                int age = rs.getInt("person_age");
                String name = rs.getString("person_name");

                Person p = new Person(id, name, age);
                return p;
            }

        }catch (Exception e){
        e.printStackTrace();
        }
        return null;
    }





}
