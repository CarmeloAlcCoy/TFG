package reporitories;

import com.mongodb.client.MongoCollection;

import modelo.User;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.bson.Document;

public class TrackRepository {

	private final MongoCollection<Document> users;

	public TrackRepository(MongoCollection<Document> users) {
		this.users = users;
	}

	public User findByEmail(String email) {
		Document doc = users.find(eq("email", email)).first();
		return user(doc);
	}

	public User findById(String id) {
		Document doc = users.find(eq("_id", new ObjectId(id))).first();
		return user(doc);
	}

	public User saveUser(User user) {
		Document doc = new Document();
		doc.append("name", user.getName());
		doc.append("email", user.getEmail());
		doc.append("password", user.getPassword());
		users.insertOne(doc);
		return new User(doc.get("_id").toString(), user.getName(), user.getEmail(), user.getPassword());
	}

	private User user(Document doc) {
		if (doc == null) {
			return null;
		}
		return new User(doc.get("_id").toString(), doc.getString("name"), doc.getString("email"),
				doc.getString("password"));
	}

	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>();
		for (Document doc : users.find()) {
			allUsers.add(user(doc));
		}
		return allUsers;

	}
}
