/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimdungstory.controller;

import com.kimdungstory.DAO.ChapterDAO;
import com.kimdungstory.model.ChaptersModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DatPT
 */
public class ChapterController {

    ChapterDAO chapterDAO = new ChapterDAO();
    ChaptersModel chaptersModel = new ChaptersModel();

    /*
        tách từ đoạn của 1 chương
     */
    public List<String> subChapterContent(String contentChapter) {
        String sTmp;
        List<String> list = new ArrayList<>();
        int lengthChapter = contentChapter.length();
        int postionTag = 0, i = 1, charTag = 0, key;
        while (charTag >= 0) {

            charTag = contentChapter.indexOf('\n');

            key = charTag - 1;
            sTmp = contentChapter.substring(4, key);
            list.add(sTmp);
            postionTag = charTag + 4;
            contentChapter = contentChapter.substring(postionTag);
            charTag = contentChapter.indexOf('\n');
            lengthChapter = contentChapter.length();
        }
        return list;
    }

    /*
        tìm kiếm trong từ đoạn, lưu chỉ số của đoạn
        trả về đoạn đầu tiên nếu đúng 100%
        đưa ra đoạn đúng nhiều nhất.
     */
    //"ếch Hồng Mai gà vịt"
	//FindCorrectParagraph
    public int findKeyInParagraph(String key, List<String> list) {
        //tách key
        String[] arrKey = key.split(" ");
        int tmp = 0, countTrue = 0, max = 0;
        for (int i = 0; i < list.size(); i++) {
            for (String itemKey : arrKey) {
                if (list.get(i).contains(itemKey)) {
                    countTrue++;
                    if (countTrue > max) {
                        max = countTrue;
                        tmp = i;
                    }
                }
            }
            countTrue = 0;
        }
        return tmp;
    }
	//FindKeyInParagraph
    public List<String> findKeyMatch(String key, String para) {
        String[] arrKeySub = key.split(" ");
        List<String> list = new ArrayList<>();
        for (String itemKey : arrKeySub) {
            if (para.contains(itemKey)) {
                list.add(itemKey);
            }
        }
        return list;
    }
	//ReplaceKeyInParagraph
    public String replaceKeyContent(String para, List<String> listKey) {
        for (String item : listKey) {
            para = para.replace(item+" ", " <mark>"+item+"</mark> ");
        }
        return para;
    }
    //ReplaceParagraphInChapter
    public String replacePara(String content, String para1, String para2){
        content = content.replace(para1,"<div id=\"para\">" + para2+"</div>");
        return content;
    }

    public static void main(String[] args) {
        ChapterDAO chapterDAO = new ChapterDAO();
        ChapterController cc = new ChapterController();
        ChaptersModel chaptersModel = chapterDAO.getChapter("1");
        String stContent = chaptersModel.getChapter_content();

//      
        System.out.println("123");
        //System.out.println("Content: " + cc.editContent(stContent));
        List<String> subS = cc.subChapterContent(chaptersModel.getChapter_content());
        System.out.println("size: " + subS.size());
        for (int i = 0; i < subS.size(); i++) {
            System.out.println("chapter " + i + ": " + subS.get(i));
        }
        //

        String s = "Nhược chôn kéo Hồng Mai gà vịt";
        String para = subS.get(cc.findKeyInParagraph(s, subS));
        System.out.println("Match:" + para);
        //String[] arrKey = cc.findKeyMatch(s, para);
        for (String item : cc.findKeyMatch(s, para)) {
            System.out.println("Key Match: " + item);
        }
        //
        //
        String s1 = "Dat dai \"co sao dau\", ca:. coongh? chả tlam sao \n";
        System.out.println("s: " + s1);
//        String s2 = "Pham Tien Dat \n";
//        String s3 = "DHBKHN";
//        String s4 = s1+s2+s3;
//        System.out.println("S: " + s4);
//        s4 = s4.replaceAll("\n", "111");
//        System.out.println("S edit: " + s4);
//        String s1 = "%Hồng%";
//        List<ChaptersModel> list = chapterDAO.getChapterSearch1(s1);
//        System.out.println("siez: " + list.size());
//
//        System.out.println("length: " + stContent.length());
    }
}
