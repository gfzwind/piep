package com.petweb.dao;

import com.petweb.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create By yushe on 2020/4/18
 */
@Mapper
public interface PetDao {
    public List<Pet> getPetsByUid(@Param("uid") String uid);
    public List<Pet> getPetsNoPubByUid(@Param("uid") String uid);
    public int deletePet(@Param("pid") int pid);
    public int insertPet(Pet pet);
}
