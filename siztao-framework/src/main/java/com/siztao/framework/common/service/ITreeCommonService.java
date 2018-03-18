package com.siztao.framework.common.service;

import com.siztao.framework.common.entity.tree.TreeNode;

import java.io.Serializable;

public interface ITreeCommonService<T extends Serializable & TreeNode<ID>,ID extends Serializable> extends ICommonService<T>{
}
