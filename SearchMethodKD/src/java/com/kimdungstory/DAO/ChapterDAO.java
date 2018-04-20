/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimdungstory.DAO;

import com.kimdungstory.connectDB.ConnectDB;
import com.kimdungstory.model.ChaptersModel;
import com.kimdungstory.model.StoriesModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class ChapterDAO {

    public List<ChaptersModel> getAllChapter(String id_Story) {
        List<ChaptersModel> listChapter = new ArrayList<>();
        String sql = "SELECT * FROM chapters WHERE ID_STORY = ?";
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareCall(sql);
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
            ConnectDB.closeConnection();
        }
        return null;
    }

    public ChaptersModel getChapter(String idChapter) {
        String sql = "SELECT * FROM chapters WHERE ID_CHAPTER = ?";
        try {
            ChaptersModel chapter = new ChaptersModel();
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareCall(sql);
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
            ConnectDB.closeConnection();
        }
        return null;
    }
    public List<ChaptersModel> getChapterSearch1(String key) {
        List<ChaptersModel> listChapter = new ArrayList<>();
        String sql = "SELECT * FROM chapters WHERE CHAPTER_CONTENT LIKE ?";
        try {
            Connection connection = ConnectDB.getConnection();
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, key);
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
            ConnectDB.closeConnection();
        }
        return null;
    }
}
