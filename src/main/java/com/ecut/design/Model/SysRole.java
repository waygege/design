package com.ecut.design.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 角色
 */
@Entity
@Table(name = "role_t")
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -8687790154329829056L;
    @Id
    @GeneratedValue
    private Integer id;

    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
    @JoinColumn(name = "pid") })
    private List<SysPermission> permissions;

    @ManyToMany
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
    @JoinColumn(name = "uid") })
    private List<User> users;



}

