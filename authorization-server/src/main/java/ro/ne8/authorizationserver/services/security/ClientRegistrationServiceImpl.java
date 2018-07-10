package ro.ne8.authorizationserver.services.security;

import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import java.util.List;

public class ClientRegistrationServiceImpl implements ClientRegistrationService {
    @Override
    public void addClientDetails(final ClientDetails clientDetails) throws ClientAlreadyExistsException {

    }

    @Override
    public void updateClientDetails(final ClientDetails clientDetails) throws NoSuchClientException {

    }

    @Override
    public void updateClientSecret(final String clientId, final String secret) throws NoSuchClientException {

    }

    @Override
    public void removeClientDetails(final String clientId) throws NoSuchClientException {

    }

    @Override
    public List<ClientDetails> listClientDetails() {
        return null;
    }
}
