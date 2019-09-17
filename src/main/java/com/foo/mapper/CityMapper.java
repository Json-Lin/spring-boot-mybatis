package com.foo.mapper;

import com.foo.domain.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/9/17
 */
@Mapper
public interface CityMapper {
    City selectCityById(int cityId);
    List<City> selectCitys();
    void insertCity(City city);
    void batchInsert(List<City> citys);
    void updateCity(City city);
    void deleteCity(Long id);
}
