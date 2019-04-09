package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountExample;

public interface LitemallQwfbAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    long countByExample(LitemallQwfbAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallQwfbAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int insert(LitemallQwfbAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int insertSelective(LitemallQwfbAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallQwfbAccount selectOneByExample(LitemallQwfbAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallQwfbAccount selectOneByExampleSelective(@Param("example") LitemallQwfbAccountExample example, @Param("selective") LitemallQwfbAccount.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallQwfbAccount> selectByExampleSelective(@Param("example") LitemallQwfbAccountExample example, @Param("selective") LitemallQwfbAccount.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    List<LitemallQwfbAccount> selectByExample(LitemallQwfbAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallQwfbAccount selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallQwfbAccount.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    LitemallQwfbAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallQwfbAccount selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallQwfbAccount record, @Param("example") LitemallQwfbAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallQwfbAccount record, @Param("example") LitemallQwfbAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallQwfbAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallQwfbAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") LitemallQwfbAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_qwfb_account
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}