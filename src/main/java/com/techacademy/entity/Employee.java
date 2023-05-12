package com.techacademy.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.transaction.Transactional;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    /** 主キー。自動生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 氏名。20桁。必須 */
    @Column(length = 20, nullable = false)
    private String name;

    /** 削除フラグ。INT。必須 */
    @Column(nullable = false)
    private int delete_flag;

    /** 登録日時。DATETIME。必須 */
    @Column(nullable = false)
    private Timestamp created_at;

    /** 更新日時。DATETIME。必須 */
    @Column(nullable = false)
    private Timestamp updated_at;

    //認証
    @OneToOne(mappedBy="employee")
    private Authentication authentication;

    @PreRemove
    @Transactional
    private void preRemove() {
        // 認証エンティティからuserを切り離す
        if (authentication!=null) {
            authentication.setEmployee(null); 
        }
    }


}
