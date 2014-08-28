package com.yaoge.sql.mongotest;

import java.net.UnknownHostException;




import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class SimpleTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws UnknownHostException, MongoException {
        Mongo mg = new Mongo("127.0.0.1",27017);
        
        //查询所有的Database
        for (String name : mg.getDatabaseNames()) {
            System.out.println("dbName: " + name);
        }
        
        DB db = mg.getDB("java");
    //    if(db.authenticate("hello", "hello".toCharArray())) {
        
        
    
        //查询所有的聚集集合
        for (String name : db.getCollectionNames()) {
            System.out.println("collectionName: " + name);
        }
        
        DBCollection users = db.getCollection("col1");
        DBObject o=new BasicDBObject();
        o.put("name", "yaoge22");
        o.put("pass", "yaoge22");
        
        
        users.insert(o);
        System.out.println(users.count());
        //查询所有的数据
        DBCursor cur = users.find();
        while (cur.hasNext()) {
            System.out.println(cur.next());
        }
        System.out.println(cur.count());
        System.out.println(cur.getCursorId());
        System.out.println(JSON.serialize(cur));
        mg.close();
      //  else{
        //	System.out.println("auth error");
        //}
    }
}
