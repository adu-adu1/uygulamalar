package com.projectteam3.recipeproject.app.crd.dao;

import com.projectteam3.recipeproject.app.crd.entity.CrdCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrdCreditCardDao extends JpaRepository<CrdCreditCard, Long> {
    List<CrdCreditCard> findAllByUsrUser_Id(Long id);
    CrdCreditCard findByCardNo(String cardNo);
}
