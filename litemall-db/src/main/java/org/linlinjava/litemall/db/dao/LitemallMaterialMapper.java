package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallMaterial;
import org.linlinjava.litemall.db.domain.LitemallMaterialExample;

public interface LitemallMaterialMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    long countByExample(LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int insert(LitemallMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int insertSelective(LitemallMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallMaterial selectOneByExample(LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallMaterial selectOneByExampleSelective(@Param("example") LitemallMaterialExample example, @Param("selective") LitemallMaterial.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallMaterial selectOneByExampleWithBLOBs(LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallMaterial> selectByExampleSelective(@Param("example") LitemallMaterialExample example, @Param("selective") LitemallMaterial.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    List<LitemallMaterial> selectByExampleWithBLOBs(LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    List<LitemallMaterial> selectByExample(LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallMaterial selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") LitemallMaterial.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    LitemallMaterial selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallMaterial selectByPrimaryKeyWithLogicalDelete(@Param("id") Long id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallMaterial record, @Param("example") LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LitemallMaterial record, @Param("example") LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallMaterial record, @Param("example") LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LitemallMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallMaterial record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") LitemallMaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_material
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Long id);
}