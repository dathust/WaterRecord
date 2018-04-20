/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimdungstory.DAO;

import com.kimdungstory.connectDB.ConnectDB;
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
public class StoryDAO {

    public List<StoriesModel> getAllStory() {
        List<StoriesModel> listStory = new ArrayList<>();
        String sql = "SELECT * FROM stories";
        try {
            Connection connection = ConnectDB.getConnection();
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
            ConnectDB.closeConnection();
        }
        return null;
    }
}
