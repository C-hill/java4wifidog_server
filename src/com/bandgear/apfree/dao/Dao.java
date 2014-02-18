package com.bandgear.apfree.dao;

import java.sql.SQLException;
import java.util.List;

import com.bandgear.apfree.bean.Device;
import com.bandgear.apfree.bean.Host;
/**
 * dao接口
 * @author hill
 *
 * @param <T>
 */
public interface  Dao<T>{
	List<T> find() throws SQLException;//获取
	int add(T t) throws SQLException;//增加
	int delete(T t) throws SQLException;//删除
	int update(T t) throws SQLException;//更新
}
