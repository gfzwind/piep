package com.petweb.service.impl;

import com.petweb.dao.PetDao;
import com.petweb.pojo.Pet;
import com.petweb.service.PetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create By yushe on 2020/4/18
 */
@Service
public class PetServiceImpl implements PetService {
    @Resource
    private PetDao petDao;

    @Override
    public List<Pet> getPetsByUid(String uid) {
        if( uid==null || uid.equals("")) return null;
        return petDao.getPetsByUid(uid);
    }

    @Override
    public List<Pet> getPetsNoPubByUid(String uid) {
        if( uid==null || uid.equals("")) return null;
        return petDao.getPetsNoPubByUid(uid);
    }

    @Override
    public int deletePet(int pid) {
        return petDao.deletePet(pid);
    }

    @Override
    public int insertPet(Pet pet) {
        return petDao.insertPet(pet);
    }
}
