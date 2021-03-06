package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.subject.SubjectService;
import com.kang.service.subject.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/20 21:21
 * @version: 1.0
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService = new SubjectServiceImpl();

    // 根据ID查询题目
    @RequestMapping(value = "/getSubjectById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getSubjectById(String subjectId){
        return JSONObject.toJSONString(subjectService.getSubjectById(subjectId));
    }

    // 添加单选题
    @RequestMapping(value = "/addOneChoice",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addOneChoice(String title, String classify, String type,String optionA,String optionB,String optionC,String optionD){
        return JSONObject.toJSONString(subjectService.addOneChoice(title,classify,type,optionA,optionB,optionC,optionD));
    }

    // 修改单选题
    @RequestMapping(value = "/modifyOneChoice",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyOneChoice(String id,String title, String classify,String optionA,String optionB,String optionC,String optionD){
        return JSONObject.toJSONString(subjectService.modifyOneChoice(id,title,classify,optionA,optionB,optionC,optionD));
    }

    // 删除题目
    @RequestMapping(value = "/deleteSubject",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteSubject(String id){
        return JSONObject.toJSONString(subjectService.deleteSubject(id));
    }

    // 添加简答题
    @RequestMapping(value = "/addShortAns",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addShortAns(String title, String classify, String type,String content){
        return JSONObject.toJSONString(subjectService.addShortAns(title,classify,type,content));
    }

    // 修改简答题
    @RequestMapping(value = "/modifyShortAns",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyShortAns(String id,String title, String classify,String content){
        return JSONObject.toJSONString(subjectService.modifyShortAns(id,title,classify,content));
    }

    // 用户添加笔记
    @RequestMapping(value = "/addNote",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addNote(String subjectId,String content, String userId){
        // 返回1 添加成功
        return JSONObject.toJSONString(subjectService.addNote(subjectId,content,userId));
    }

    // 用户修改笔记
    @RequestMapping(value = "/modifyNote",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyNote(String id,String content){
        // 返回1 添加成功
        return JSONObject.toJSONString(subjectService.modifyNote(id,content));
    }

    // 加载用户的笔记
    @RequestMapping(value = "/loadNoteById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadNoteById(String subjectId,String userId){
        // 返回1 添加成功
        return JSONObject.toJSONString(subjectService.loadNoteById(subjectId,userId));
    }

    // 检测用户的笔记是否存在
    @RequestMapping(value = "/checkNoteById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkNoteById(String subjectId,String userId){
        return JSONObject.toJSONString(subjectService.checkUserNoteExist(subjectId,userId));
    }

    // 收藏习题
    @RequestMapping(value = "/addCollection",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addCollection(String subjectId,String userId){
        return JSONObject.toJSONString(subjectService.addCollection(subjectId,userId));
    }

    // 取消收藏习题
    @RequestMapping(value = "/deleteCollection",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteCollection(String subjectId,String userId){
        return JSONObject.toJSONString(subjectService.deleteCollection(subjectId,userId));
    }

    // 查找收藏习题
    @RequestMapping(value = "/searchCollection",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchCollection(String subjectId,String userId){
        return JSONObject.toJSONString(subjectService.searchCollection(subjectId,userId));
    }

    // 获取数据结构的习题个数
    @RequestMapping(value = "/searchCountOfDS",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchCountOfDS(){
        return JSONObject.toJSONString(subjectService.searchCountOfDS());
    }

    // 获取计算机网络的习题个数
    @RequestMapping(value = "/searchCountOfNet",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchCountOfNet(){
        return JSONObject.toJSONString(subjectService.searchCountOfNet());
    }

    // 获取计算机组成原理的习题个数
    @RequestMapping(value = "/searchCountOfOrg",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchCountOfOrg(){
        return JSONObject.toJSONString(subjectService.searchCountOfOrg());
    }

    // 获取操作系统的习题个数
    @RequestMapping(value = "/searchCountOfOp",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchCountOfOp(){
        return JSONObject.toJSONString(subjectService.searchCountOfOp());
    }

    // 获取用户记了笔记的个数
    @RequestMapping(value = "/searchCountNote",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchCountNote(String userId, String type){
        return JSONObject.toJSONString(subjectService.searchCountNote(userId,type));
    }

    // 获取用户的收藏
    @RequestMapping(value = "/loadCollection",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadQuestionCollectByUser(String userId, String classify){
        return JSONObject.toJSONString(subjectService.loadQuestionCollectByUser(userId,classify));
    }

    // 获取用户的笔记
    @RequestMapping(value = "/loadNote",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadQuestionNoteByUser(String userId, String classify){
        return JSONObject.toJSONString(subjectService.loadQuestionNoteByUser(userId,classify));
    }

    // 获取每日一题
    @RequestMapping(value = "/loadDailySubject",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadDailySubject(){
        return JSONObject.toJSONString(subjectService.loadDailySubject());
    }
}
