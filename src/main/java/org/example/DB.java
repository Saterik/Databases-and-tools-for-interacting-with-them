package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.List;

public class DB {

    public static final String URL = "jdbc:mysql://localhost:3306";
    public static final String USER = "root";
    public static final String PASSWORD = "142314";

    public static void con() {
        Connector connector = new Connector();
        try(Session session = connector.getSession()) {

            Transaction t = session.beginTransaction();
            List<Magic> magics = session.createQuery("FROM Magic", Magic.class).getResultList();
            magics.forEach(m ->
                    session.delete(m));
            t.commit();

//            Добавление данных
//            String hql = "from Magic where id = :id";
//            Query<Magic> query = session.createQuery(hql, Magic.class);
//            query.setParameter("id", 4);
//            Magic magic = query.getSingleResult();
//            System.out.println(magic);
//            magic.setAttBonus(100);
//            magic.setName("Ярость");
//            session.beginTransaction();
//            session.update(magic);
//            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }













//        Создание колонок заполняемых данных

//        Magic magic = new Magic("Волшебная стрела", 10, 0, 0);
//        session.beginTransaction();
//        session.save(magic);
//        magic = new Magic("Молния", 25, 0, 0);
//        session.save(magic);
//        magic = new Magic("Каменная кожа", 0, 0, 6);
//        session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0);
//        session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0);
//        session.save(magic);
//        magic = new Magic("Проклятие", 0, -3, 0);
//        session.save(magic);
//        magic = new Magic("Лечение", -30, 0, 0);
//        session.save(magic);
//        session.getTransaction().commit();
//        session.close();

























//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Magic magic = new Magic("Волшебная стрела", 10,0);
//        session.beginTransaction();
//        session.save(magic);
//        session.getTransaction().commit();
//        session.close();










//        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            Statement statement = con.createStatement();
//            statement.execute("DROP SCHEMA test");
//            statement.execute("CREATE SCHEMA test");
//            statement.execute("CREATE TABLE test.table (id INT NOT NULL, firstname VARCHAR(45) NULL, lastname VARCHAR(45) NULL, PRIMARY KEY (id))");
//            statement.execute("INSERT INTO test.table ( id,firstname,lastname)\n" +
//                    "VALUES (1, 'Иванов', 'Иван');");
//            statement.execute("INSERT INTO test.table ( id,firstname,lastname)\n" +
//                    "VALUES (2, 'Иванов', 'Иван');");
//
//
//        ResultSet set = statement.executeQuery("SELECT * FROM test.table;");
//        while (set.next()){
//            System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
//        }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }


}