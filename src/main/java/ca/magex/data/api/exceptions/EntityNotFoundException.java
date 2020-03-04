package ca.magex.data.api.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.magex.data.api.entities.Identifier;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class EntityNotFoundException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> extensions = new HashMap<>();

    public EntityNotFoundException(Identifier id) {
        super("Could not find entity: " + id);
        extensions.put("id", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}