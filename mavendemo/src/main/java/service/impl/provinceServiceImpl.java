package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Impl.provinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.provinceService;
import utils.JedisPoolUtils;

import java.util.List;

public class provinceServiceImpl implements provinceService {
     provinceDaoImpl pdi = new provinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return pdi.getAllProvince();
    }


    public String findAllJson(){
        Jedis jd = JedisPoolUtils.getJedis();
        String provinces = jd.get("province");

        if (provinces==null || provinces.length()==0){
            //如果redis没有province，到数据库搜索数据
            List<Province> pro = pdi.getAllProvince();

            //将读取到的数据转换为json
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                provinces = objectMapper.writeValueAsString(pro);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jd.set("province", provinces);
            jd.close();
            System.out.println("redis中没有数据，查询数据库");

        } else {
            System.out.println("redis中有数据，查询缓存");
        }

        return provinces;

    }
}
