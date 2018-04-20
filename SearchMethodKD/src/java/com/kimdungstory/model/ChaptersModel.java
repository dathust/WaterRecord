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
public class ChaptersModel {

    private int id_Chapter;
    private int id_Story;
    private int chapter_Number;
    private String chapter_Name;
    private String chapter_content;

    public ChaptersModel() {
    }

    public ChaptersModel(int id_Chapter, int id_Story, int chapter_Number, String chapter_Name, String chapter_content) {
        this.id_Chapter = id_Chapter;
        this.id_Story = id_Story;
        this.chapter_Number = chapter_Number;
        this.chapter_Name = chapter_Name;
        this.chapter_content = chapter_content;
    }

    public int getId_Chapter() {
        return id_Chapter;
    }

    public void setId_Chapter(int id_Chapter) {
        this.id_Chapter = id_Chapter;
    }

    public int getId_Story() {
        return id_Story;
    }

    public void setId_Story(int id_Story) {
        this.id_Story = id_Story;
    }

    public int getChapter_Number() {
        return chapter_Number;
    }

    public void setChapter_Number(int chapter_Number) {
        this.chapter_Number = chapter_Number;
    }

    public String getChapter_Name() {
        return chapter_Name;
    }

    public void setChapter_Name(String chapter_Name) {
        this.chapter_Name = chapter_Name;
    }

    public String getChapter_content() {
        return chapter_content;
    }

    public void setChapter_content(String chapter_content) {
        this.chapter_content = chapter_content;
    }

}
