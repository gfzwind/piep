package com.petweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.petweb.dao.EssayDao;
import com.petweb.pojo.Essay;
import com.petweb.service.EssayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/4/18
 */
@Service
public class EssayServiceImpl implements EssayService {
    @Resource
    private EssayDao essayDao;
    @Override
    public PageInfo<Essay> getAllPubEssay(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays = essayDao.getAllPubEssay();
        PageInfo<Essay> essayPageInfo = new PageInfo<Essay>(essays);
        return essayPageInfo;
//        essays.forEach(System.out::println);
//        System.out.println("-------------------------");
//        System.out.println("getNextPage(): "+essayPageInfo.getNextPage());
//        System.out.println("getPageNum(): "+essayPageInfo.getPageNum());
//        System.out.println("getSize(): "+essayPageInfo.getSize());
//        System.out.println("getPageSize(): "+essayPageInfo.getPageSize());
//        System.out.println("getTotal(): "+essayPageInfo.getTotal());
//        System.out.println("getList(): "+essayPageInfo.getList());
    }

    @Override
    public int insertEssay(Essay essay) {
        int result = 0;
        // 发布者
        if(essay.getEtitle() != null && !essay.getEtitle().equals("")) {
            result = essayDao.insertEssayPub(essay);
        } else {
            result = essayDao.insertEssayRec(essay);
        }
        return result;
    }

    @Override
    public int getCount(String selectContent) {
        int result = 0;
        if(selectContent.equals("pub")) {
            result = essayDao.getCountEEidNull();
        } else if (selectContent.equals("rec")) {
            result = essayDao.getCountEEidNotNull();
        }
        return result;
    }

    @Override
    public HashMap<String, Object> getEssayByEid(int eid) {
        return essayDao.getEssayByEid(eid);
    }

    @Override
    public List<HashMap<String, Object>> getAllRecEssayByEid(int eid) {
        return essayDao.getAllRecEssayByEid(eid);
    }

    @Override
    public List<Essay> getEssayMyPub(String uid) {
        return essayDao.getEssayMyPub(uid);
    }

    @Override
    public List<HashMap<String, Object>> getEssayMyRec(String uid) {
        return essayDao.getEssayMyRec(uid);
    }

    @Override
    public int deleteEssay(int eid) {
        return essayDao.deleteEssay(eid);
    }
}
