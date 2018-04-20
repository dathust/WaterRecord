/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimdungstory.model;

/**
 *
 * @author DatPT
 */
public class StoriesModel {

    private int id_Story;
    private String story_Name;
    private int chapter_Total;
    private String introduction;

    public StoriesModel() {
    }

    public StoriesModel(int id_Story, String story_Name, int chapter_Total, String introduction) {
        this.id_Story = id_Story;
        this.story_Name = story_Name;
        this.chapter_Total = chapter_Total;
        this.introduction = introduction;
    }

    public int getId_Story() {
        return id_Story;
    }

    public void setId_Story(int id_Story) {
        this.id_Story = id_Story;
    }

    public String getStory_Name() {
        return story_Name;
    }

    public void setStory_Name(String story_Name) {
        this.story_Name = story_Name;
    }

    public int getChapter_Total() {
        return chapter_Total;
    }

    public void setChapter_Total(int chapter_Total) {
        this.chapter_Total = chapter_Total;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}
