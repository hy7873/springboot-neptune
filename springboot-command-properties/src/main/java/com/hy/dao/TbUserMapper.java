/**
 * This code generated by CodeGenerator<ptma@163.com>
 */
package com.hy.dao;


import com.hy.model.TbUser;

import java.util.List;

/**
 * <p>Mapper接口</p>
 * <p>Table: tb_user - </p>
 * @since 2018-06-10 07:07:41
 */

public interface TbUserMapper {
	/**
	 *保存,未经校验,禁止直接调用
	 */
	void save(TbUser model);
	
	/**
	 *获取单个对象,未经校验,禁止直接调用
	 */
	TbUser getByCondition(TbUser model);
	
	/**
	 *查询多个对象,未经校验,禁止直接调用
	 */
	List<TbUser> getListByCondition(TbUser model);
	
	/**
	 *修改,未经校验,禁止直接调用
	 */
	Integer update(TbUser model);

	/**
	 *分页查询,未经校验,禁止直接调用
	 */
	List<TbUser> getPageList(TbUser model);

	/**
	 *获取总记录数,未经校验,禁止直接调用
	 */
	Long totalSize(TbUser model);
}