/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimdungstory.DAO;

import com.kimdungstory.connectDB.ConnectDB;
import com.kimdungstory.connectDB.ConnectDBSQLServer;
import com.kimdungstory.model.ChaptersModel;
import com.kimdungstory.model.StoriesModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class TestSQL {

    public List<StoriesModel> getAllStory() {
        List<StoriesModel> listStory = new ArrayList<>();
        String sql = "SELECT * FROM STORIES";
        try {
            Connection connection = ConnectDBSQLServer.getConnectData();
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StoriesModel story = new StoriesModel();
                story.setId_Story(rs.getInt(1));
                story.setStory_Name(rs.getString(2));
                story.setChapter_Total(rs.getInt(3));
                story.setIntroduction(rs.getString(4));
                listStory.add(story);
            }
            return listStory;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDBSQLServer.Close();
        }
        return null;
    }

    public boolean insertChapterContent(ChaptersModel chapter) {
        try {
            Connection conn = ConnectDBSQLServer.getConnectData();
            String sql = "INSERT INTO CHAPTERS(ID_STORY,CHAPTER_NUMBER,CHAPTER_NAME,CHAPTER_CONTENT) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, chapter.getId_Story());
            ps.setInt(2, chapter.getChapter_Number());
            ps.setString(3, chapter.getChapter_Name());
            ps.setString(4, chapter.getChapter_content());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (SQLException e) {
        } finally {
            ConnectDBSQLServer.Close();
        }
        return false;
    }

    public List<ChaptersModel> getAllChapter(String id_Story) {
        List<ChaptersModel> listChapter = new ArrayList<>();
        String sql = "SELECT * FROM chapters WHERE ID_STORY = ?";
        try {
            Connection conn = ConnectDBSQLServer.getConnectData();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, id_Story);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChaptersModel chapter = new ChaptersModel();
                chapter.setId_Chapter(rs.getInt(1));
                chapter.setId_Story(rs.getInt(2));
                chapter.setChapter_Number(rs.getInt(3));
                chapter.setChapter_Name(rs.getString(4));
                chapter.setChapter_content(rs.getString(5));
                listChapter.add(chapter);
            }
            return listChapter;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDBSQLServer.Close();
        }
        return null;
    }

    public ChaptersModel getChapter(String idChapter) {
        String sql = "SELECT * FROM CHAPTERS WHERE ID_CHAPTER = ?";
        try {
            ChaptersModel chapter = new ChaptersModel();
            Connection conn = ConnectDBSQLServer.getConnectData();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, idChapter);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                chapter.setId_Chapter(rs.getInt(1));
                chapter.setId_Story(rs.getInt(2));
                chapter.setChapter_Number(rs.getInt(3));
                chapter.setChapter_Name(rs.getString(4));
                chapter.setChapter_content(rs.getString(5));
            }

            return chapter;
        } catch (Exception e) {
        } finally {
            ConnectDBSQLServer.Close();
        }
        return null;
    }
}
