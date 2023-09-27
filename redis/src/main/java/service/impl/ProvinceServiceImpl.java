package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.provinceImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import utils.JedisPoolUtils;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    provinceImpl pi = new provinceImpl();

    @Override
    public List<Province> findAll() {
        return pi.getAllProvince();

    }

    public String findAllJson(){
        Jedis jd = JedisPoolUtils.getJedis();
        String province = jd.get("province");

        //jedis没有内容,就调用JDBCUtils加载数据库，将得到的数据写入redis内存中
        if (province==null || province.length()==0){

            System.out.println("redis中没有数据，查询数据库");
            List<Province> provinces = pi.getAllProvince();
            ObjectMapper om = new ObjectMapper();
            try {
                province = om.writeValueAsString(provinces);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //设置
            jd.set("province",province);
            jd.close();



        } else {
            System.out.println("redis中有数据，查询缓存");

        }
        return province;
    }
}
