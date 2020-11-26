# AutoBill Java SDK

**Connect AutoBill**
1. Construct APIConfig with required information
2. Forward to APIConfig.getAuthorizeUrl() to authorize
3. After successful authorization, it will be redirected to APIConfig.redirectUrl with code
4. Implement the redirect URL (APIConfig.redirectUrl) so that it retrieves access token and refresh token by calling APICaller.getAccessToken(ApiConfig, code), and stores the tokens

**Renew Token**  
1. API calls will throw TokenExpiredException if token expires
2. In that case, renew token by calling APICaller.renewToken(APIConfig), and save the new tokens

**Resource Fetch**
1. For Account, use AccountDao

**Complete Example**
See https://github.com/arifcs/autobill-sdk-java-test.git