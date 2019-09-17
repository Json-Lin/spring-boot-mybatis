package com.foo;

import com.foo.dao.CityDao;
import com.foo.domain.City;
import com.foo.mapper.CityMapper;
import com.foo.mapper.HotelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/9/17
 */
@SpringBootApplication
public class MybatisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    private final CityDao cityDao;

    private final HotelMapper hotelMapper;
    private final CityMapper cityMapper;

    public MybatisApplication(CityDao cityDao, HotelMapper hotelMapper, CityMapper cityMapper) {
        this.cityDao = cityDao;
        this.hotelMapper = hotelMapper;
        this.cityMapper = cityMapper;
    }

    @Override
    public void run(String... args) {
        //select();
        //batchSelect();
        //insert();
        //batchInsert();
        //update();
        delete();
    }

    private void delete() {
        cityMapper.deleteCity(3L);
    }

    private void update() {
        City city = cityMapper.selectCityById(2);
        city.setName("德阳");
        cityMapper.updateCity(city);
    }

    private void batchSelect() {
        List<City> citys = cityMapper.selectCitys();
        citys.forEach(city -> System.out.println(city.toString()));
    }

    private void batchInsert() {
        City city2 = new City();
        city2.setCountry("中国");
        city2.setName("广安市");
        city2.setState("四川省");
        City city1 = new City();
        city1.setCountry("中国");
        city1.setName("达州市");
        city1.setState("四川省");
        List<City> citys = Arrays.asList(city2,city1);
        cityMapper.batchInsert(citys);
        citys.forEach(city -> System.out.println(city.getId()));
    }

    private void insert() {
        City city = new City();
        city.setCountry("中国");
        city.setName("成都");
        city.setState("四川省");
        cityMapper.insertCity(city);
        System.out.println(city.getId());
    }

    private void select() {
        System.out.println(this.cityDao.selectCityById(1));
        System.out.println(this.hotelMapper.selectByCityId(1));
    }

}