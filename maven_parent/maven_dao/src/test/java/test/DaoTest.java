package test;

import com.ztom.dao.HeroDao;
import com.ztom.domain.Hero;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/28 13:25
 */
public class DaoTest {
    @Test
    public void testDao(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        HeroDao heroDao = context.getBean(HeroDao.class);
        List<Hero> heroes = heroDao.findAll();
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
