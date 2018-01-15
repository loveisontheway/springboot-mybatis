package com.liotw.springboot.mybatis.utils;


import com.liotw.springboot.mybatis.constants.Constant;
import com.liotw.springboot.mybatis.core.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;


public class TreeUtil {

    private TreeUtil(){}

    /**
     * 将传过来的节点集合转换为树结构，
     * @param nodes
     * @param pid
     * @return
     */
    public static List<TreeNode> convert(List<TreeNode> nodes, String pid){
        if(CollectionUtils.isEmpty(nodes)){
            return null;
        }
        TreeNode treeNode = new TreeNode();
        convert(nodes, treeNode, Constant.ROOT_MENU_PID);
        return treeNode.getChildren();
    }
    /**
     * 将treeNode集合根据pid转换成一个树形结构
     * @param nodes
     * @return
     */
    private static  void convert(List<TreeNode> nodes, TreeNode treeNode, String pid) {
        if (nodes == null || nodes.isEmpty() || StringUtils.isEmpty(pid)) {
            return;
        }
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if (isParentAndSonByPid(pid, node)) {
                treeNode.addChild(node);// 添加到孩子节点列表
                nodes.remove(node);
                i = -1;
                convert(nodes, node, node.getId());// 递归，实现无限层级*//*
            }

        }
    }

    private static  Boolean isParentAndSonByPid(String pid, TreeNode node) {
        if (Constant.ROOT_MENU_PID.equals(pid)) {
            if ( node!= null && pid.equals(node.getpId())) {
                return true;
            }
        } else {
            if (node != null && pid != null && (!Constant.ROOT_MENU_PID.equals(node.getpId())) && (pid.startsWith(node.getpId()))) {
                return true;
            }
        }
        return false;
    }
}
