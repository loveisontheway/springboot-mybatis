package com.liotw.springboot.mybatis.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "md_administrative_region")
public class MdAdministrativeRegion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 行政区划编码
     */
    @Column(name = "area_code")
    private Long areaCode;

    /**
     * 行政区划名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 城乡分类代码
     */
    private Integer category;

    /**
     * 行政区域变更原因
     */
    @Column(name = "change_reason")
    private String changeReason;

    /**
     * 市（地区、自治州、盟）代码
     */
    @Column(name = "city_id")
    private Long cityId;

    /**
     * 市（地区、自治州、盟）名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 县（市辖区、县级市、旗）代码
     */
    @Column(name = "county_id")
    private Long countyId;

    /**
     * 县（市辖区、县级市、旗）名称
     */
    @Column(name = "county_name")
    private String countyName;

    /**
     * 创建者id
     */
    @Column(name = "create_id")
    private String createId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 行政区划全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 等级（省1、市2、县3、镇4、村5）
     */
    private Integer grade;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 修改者id
     */
    @Column(name = "modify_id")
    private String modifyId;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 行政区划原代码
     */
    @Column(name = "native_code")
    private String nativeCode;

    /**
     * 行政区划原名称
     */
    @Column(name = "native_name")
    private String nativeName;

    /**
     * 第三方行政区划编码
     */
    @Column(name = "other_code")
    private String otherCode;

    /**
     * 父级行政区划编码
     */
    @Column(name = "parent_code")
    private Long parentCode;

    /**
     * 省（自治区、直辖市、特别行政区）代码
     */
    @Column(name = "province_id")
    private Long provinceId;

    /**
     * 省（自治区、直辖市、特别行政区）名称
     */
    @Column(name = "province_name")
    private String provinceName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 行版本，记录数据版本号
     */
    @Column(name = "row_version")
    private String rowVersion;

    /**
     * 排序方式
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 状态值（0启用、1停用）
     */
    private Integer state;

    /**
     * 乡、镇（街道办事处）代码
     */
    @Column(name = "town_id")
    private Long townId;

    /**
     * 乡、镇（街道办事处）名称
     */
    @Column(name = "town_name")
    private String townName;

    /**
     * 村（居民委员会、村民委员会）代码
     */
    @Column(name = "village_id")
    private Long villageId;

    /**
     * 村（居民委员会、村民委员会）名称
     */
    @Column(name = "village_name")
    private String villageName;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取行政区划编码
     *
     * @return area_code - 行政区划编码
     */
    public Long getAreaCode() {
        return areaCode;
    }

    /**
     * 设置行政区划编码
     *
     * @param areaCode 行政区划编码
     */
    public void setAreaCode(Long areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取行政区划名称
     *
     * @return area_name - 行政区划名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置行政区划名称
     *
     * @param areaName 行政区划名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取城乡分类代码
     *
     * @return category - 城乡分类代码
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置城乡分类代码
     *
     * @param category 城乡分类代码
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取行政区域变更原因
     *
     * @return change_reason - 行政区域变更原因
     */
    public String getChangeReason() {
        return changeReason;
    }

    /**
     * 设置行政区域变更原因
     *
     * @param changeReason 行政区域变更原因
     */
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    /**
     * 获取市（地区、自治州、盟）代码
     *
     * @return city_id - 市（地区、自治州、盟）代码
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置市（地区、自治州、盟）代码
     *
     * @param cityId 市（地区、自治州、盟）代码
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取市（地区、自治州、盟）名称
     *
     * @return city_name - 市（地区、自治州、盟）名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置市（地区、自治州、盟）名称
     *
     * @param cityName 市（地区、自治州、盟）名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取县（市辖区、县级市、旗）代码
     *
     * @return county_id - 县（市辖区、县级市、旗）代码
     */
    public Long getCountyId() {
        return countyId;
    }

    /**
     * 设置县（市辖区、县级市、旗）代码
     *
     * @param countyId 县（市辖区、县级市、旗）代码
     */
    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    /**
     * 获取县（市辖区、县级市、旗）名称
     *
     * @return county_name - 县（市辖区、县级市、旗）名称
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * 设置县（市辖区、县级市、旗）名称
     *
     * @param countyName 县（市辖区、县级市、旗）名称
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /**
     * 获取创建者id
     *
     * @return create_id - 创建者id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 设置创建者id
     *
     * @param createId 创建者id
     */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取行政区划全称
     *
     * @return full_name - 行政区划全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置行政区划全称
     *
     * @param fullName 行政区划全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 获取等级（省1、市2、县3、镇4、村5）
     *
     * @return grade - 等级（省1、市2、县3、镇4、村5）
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置等级（省1、市2、县3、镇4、村5）
     *
     * @param grade 等级（省1、市2、县3、镇4、村5）
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取修改者id
     *
     * @return modify_id - 修改者id
     */
    public String getModifyId() {
        return modifyId;
    }

    /**
     * 设置修改者id
     *
     * @param modifyId 修改者id
     */
    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取行政区划原代码
     *
     * @return native_code - 行政区划原代码
     */
    public String getNativeCode() {
        return nativeCode;
    }

    /**
     * 设置行政区划原代码
     *
     * @param nativeCode 行政区划原代码
     */
    public void setNativeCode(String nativeCode) {
        this.nativeCode = nativeCode;
    }

    /**
     * 获取行政区划原名称
     *
     * @return native_name - 行政区划原名称
     */
    public String getNativeName() {
        return nativeName;
    }

    /**
     * 设置行政区划原名称
     *
     * @param nativeName 行政区划原名称
     */
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    /**
     * 获取第三方行政区划编码
     *
     * @return other_code - 第三方行政区划编码
     */
    public String getOtherCode() {
        return otherCode;
    }

    /**
     * 设置第三方行政区划编码
     *
     * @param otherCode 第三方行政区划编码
     */
    public void setOtherCode(String otherCode) {
        this.otherCode = otherCode;
    }

    /**
     * 获取父级行政区划编码
     *
     * @return parent_code - 父级行政区划编码
     */
    public Long getParentCode() {
        return parentCode;
    }

    /**
     * 设置父级行政区划编码
     *
     * @param parentCode 父级行政区划编码
     */
    public void setParentCode(Long parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * 获取省（自治区、直辖市、特别行政区）代码
     *
     * @return province_id - 省（自治区、直辖市、特别行政区）代码
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省（自治区、直辖市、特别行政区）代码
     *
     * @param provinceId 省（自治区、直辖市、特别行政区）代码
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取省（自治区、直辖市、特别行政区）名称
     *
     * @return province_name - 省（自治区、直辖市、特别行政区）名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置省（自治区、直辖市、特别行政区）名称
     *
     * @param provinceName 省（自治区、直辖市、特别行政区）名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取行版本，记录数据版本号
     *
     * @return row_version - 行版本，记录数据版本号
     */
    public String getRowVersion() {
        return rowVersion;
    }

    /**
     * 设置行版本，记录数据版本号
     *
     * @param rowVersion 行版本，记录数据版本号
     */
    public void setRowVersion(String rowVersion) {
        this.rowVersion = rowVersion;
    }

    /**
     * 获取排序方式
     *
     * @return sort_order - 排序方式
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序方式
     *
     * @param sortOrder 排序方式
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取状态值（0启用、1停用）
     *
     * @return state - 状态值（0启用、1停用）
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态值（0启用、1停用）
     *
     * @param state 状态值（0启用、1停用）
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取乡、镇（街道办事处）代码
     *
     * @return town_id - 乡、镇（街道办事处）代码
     */
    public Long getTownId() {
        return townId;
    }

    /**
     * 设置乡、镇（街道办事处）代码
     *
     * @param townId 乡、镇（街道办事处）代码
     */
    public void setTownId(Long townId) {
        this.townId = townId;
    }

    /**
     * 获取乡、镇（街道办事处）名称
     *
     * @return town_name - 乡、镇（街道办事处）名称
     */
    public String getTownName() {
        return townName;
    }

    /**
     * 设置乡、镇（街道办事处）名称
     *
     * @param townName 乡、镇（街道办事处）名称
     */
    public void setTownName(String townName) {
        this.townName = townName;
    }

    /**
     * 获取村（居民委员会、村民委员会）代码
     *
     * @return village_id - 村（居民委员会、村民委员会）代码
     */
    public Long getVillageId() {
        return villageId;
    }

    /**
     * 设置村（居民委员会、村民委员会）代码
     *
     * @param villageId 村（居民委员会、村民委员会）代码
     */
    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    /**
     * 获取村（居民委员会、村民委员会）名称
     *
     * @return village_name - 村（居民委员会、村民委员会）名称
     */
    public String getVillageName() {
        return villageName;
    }

    /**
     * 设置村（居民委员会、村民委员会）名称
     *
     * @param villageName 村（居民委员会、村民委员会）名称
     */
    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}