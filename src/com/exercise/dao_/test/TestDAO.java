package com.exercise.dao_.test;

import com.exercise.dao_.dao.AccountDAO;
import com.exercise.dao_.dao.ActorDAO;
import com.exercise.dao_.domain.Account;
import com.exercise.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    @Test
    public void testActor(){
        ActorDAO actorDAO = new ActorDAO();
        System.out.println("=========查询多行记录========");
        List<Actor> actors = actorDAO.queryMulti
                ("select * from actor where id >= ?", Actor.class, 2);
        for(Actor actor : actors){
            System.out.println(actor);
        }
        System.out.println("=========查询单行记录========");
        Actor actor = actorDAO.querySingle("select id,name from actor where id = ?", Actor.class, 2);
        System.out.println(actor);
        System.out.println("=========查询单行单列记录========");
        Object o = actorDAO.queryScalar("select name from actor where id = ?", Actor.class, 1);
        System.out.println(o);
        System.out.println("=========dml========");
        int update = actorDAO.update("update actor set phone = '13849956789' where id = ?",3);
        System.out.println(update);
        //乱用之多搜单行，单行单列，都可通过
        List<Actor> actors1 = actorDAO.queryMulti
                ("select * from actor where id = ?", Actor.class, 2);
        for(Actor actor1 : actors1){
            System.out.println(actor1);
        }
        List<Actor> actors2 = actorDAO.queryMulti
                ("select id from actor where id = ?", Actor.class, 2);
        for(Actor actor2 : actors2){
            System.out.println(actor2);
        }
        System.out.println("++++++++++++++++++++");
        //乱用之单搜多只返回一行记录，单行单列会返回一行记录，可通过
        Actor actor3 = actorDAO.querySingle("select id,name from actor where id >= ?", Actor.class, 2);
        System.out.println(actor3);
        Actor actor4 = actorDAO.querySingle("select id from actor where id = ?", Actor.class, 2);
        System.out.println(actor4);
        //乱用之单行单列搜多，只返回结果集首行首列值；单行则首列值
        System.out.println("----------------------");
        Object o5 = actorDAO.queryScalar("select name,id from actor where id >= ?", Actor.class, 1);
        System.out.println(o5);
        Object o6 = actorDAO.queryScalar("select name,id from actor where id = ?", Actor.class, 1);
        System.out.println(o6);
    }
    @Test
    public void testAccount(){
        List<Account> accounts = new AccountDAO().queryMulti("select * from account", Account.class);
        for(Account account : accounts){
            System.out.println(account);
        }
    }
}
