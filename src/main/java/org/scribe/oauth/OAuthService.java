package org.scribe.oauth;

import org.scribe.http.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

/**
 * The main Scribe object.
 *
 * A facade responsible for the retrieval of request and access tokens and for the signing of HTTP requests.
 *
 * @author Pablo Fernandez
 */
public interface OAuthService {
  /**
   * Retrieve the access token.
   *
   * @param verifier verifier code
   * @return access token
   */
  Token getAccessToken(Verifier verifier);

  /**
   * Signs am OAuth request.
   *
   * @param accessToken access token (obtained previously)
   * @param request request to sign
   */
  void signRequest(Token accessToken, OAuthRequest request);

  /**
   * Returns the URL where you should redirect your users to authenticate
   * your application.
   *
   * @return the URL where you should redirect your users
   */
  String getAuthorizationUrl();

  /**
   * Returns the URL where you should redirect your users to authenticate
   * your application.
   *
   * @param state the csrf state token for this session
   * @return the URL where you should redirect your users
   */
  String getAuthorizationUrl(String state);
}
