package com.liotw.springboot.mybatis.core;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class TreeNode implements Serializable {
    private String name;
    private String id ;
    private String pId;
    private String parantpaths;

    private Boolean checked = false;
    private List<TreeNode> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getParantpaths() {
        return parantpaths;
    }

    public void setParantpaths(String parantpaths) {
        this.parantpaths = parantpaths;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public void addChild(TreeNode child) {
        if (children == null) {
            children = Lists.newArrayList();
        }
        children.add(child);
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
