package test;

import com.ztom.domain.Hero;
import com.ztom.service.HeroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/29 09:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-*.xml")
public class ServiceTest {
    @Autowired
    HeroService heroService;

    @Test
    public void test(){
        List<Hero> heroes = heroService.findAll();
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
