package com.petweb.service;

import com.petweb.pojo.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create By yushe on 2020/4/18
 */
public interface PetService {
    public List<Pet> getPetsByUid(String uid);
    public List<Pet> getPetsNoPubByUid(String uid);
    public int deletePet(int pid);
    public int insertPet(Pet pet);
}
