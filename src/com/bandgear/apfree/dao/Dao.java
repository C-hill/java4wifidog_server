package com.bandgear.apfree.dao;

import java.sql.SQLException;
import java.util.List;
/**
 * dao接口
 * @author hill
 *
 * @param <T>
 */
public interface  Dao<T>{
	List<T> find() throws SQLException;//获取
	void add(T t) throws SQLException;//增加
	void delete(T t) throws SQLException;//删除
	void update(T t) throws SQLException;//更新
}
