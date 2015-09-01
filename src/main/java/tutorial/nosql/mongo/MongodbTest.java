package tutorial.nosql.mongo;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;
import com.mongodb.QueryOperators;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongodbTest {
	public static void main(String[] args) {
		MongoClient mongo = new MongoClient("10.59.94.166");
		MongoDatabase db = mongo.getDatabase("mytest");

		// db.createCollection("newcollection");

		System.out.println("create collection success...");

		MongoCollection<Document> coll = db.getCollection("newcollection");

		Document doc1 = new Document("name", "david");

		doc1.append("title", "MongoDB").append("description", "database")
				.append("likes", 10)
				.append("url", "http://www.w3cschool.cc/mongodb/")
				.append("by", "w3cschool.cc");

		coll.insertOne(doc1);


		// while(ds.hasNext()){
		//
		// System.out.println(ds.next());
		// }


		MongoCollection<Document> user = db.getCollection("user");
		
		
		mongo.close();

	}
}
