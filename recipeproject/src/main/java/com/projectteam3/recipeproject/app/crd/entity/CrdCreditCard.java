package com.projectteam3.recipeproject.app.crd.entity;

import com.projectteam3.recipeproject.app.usr.entity.UsrUser;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CRD_CREDIT_CARD")
@Getter
@Setter
public class CrdCreditCard {
    @Id
    @SequenceGenerator(name = "CrdCreditCard", sequenceName = "CRD_CREDIT_CARD_ID_SEQ")
    @GeneratedValue(generator = "CrdCreditCard")
    private Long id;

    @Column(name = "CARD_NO", nullable = false, length = 16, unique = true)
    private String cardNo;

    @Column(name = "CVV", nullable = false)
    private Long cvv;

    @Column(name = "EXPIRATION_DATE", nullable = false)
    private Date expirationDate;

    @Column(name = "CARDHOLDER_NAME", length = 100, nullable = false)
    private String cardholderName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_USR_USER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UsrUser usrUser;
}
