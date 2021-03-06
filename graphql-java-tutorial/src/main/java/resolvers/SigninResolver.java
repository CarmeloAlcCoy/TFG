package resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;

import modelo.SigninPayload;
import modelo.User;

public class SigninResolver implements GraphQLResolver<SigninPayload> {

    public User user(SigninPayload payload) {
        return payload.getUser();
    }
}