package com.duokan.reader.domain.account.oauth.evernote;

import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.utils.OAuthEncoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvernoteAuthToken extends Token {
    private static final Pattern NOTESTORE_REGEX = Pattern.compile("edam_noteStoreUrl=([^&]+)");
    private static final Pattern USERID_REGEX = Pattern.compile("edam_userId=([^&]+)");
    private static final Pattern WEBAPI_REGEX = Pattern.compile("edam_webApiUrlPrefix=([^&]+)");
    private static final long serialVersionUID = -6892516333656106315L;
    private String noteStoreUrl = extract(getRawResponse(), NOTESTORE_REGEX);
    private int userId = Integer.parseInt(extract(getRawResponse(), USERID_REGEX));
    private String webApiUrlPrefix = extract(getRawResponse(), WEBAPI_REGEX);

    public EvernoteAuthToken(Token token) {
        super(token.getToken(), token.getSecret(), token.getRawResponse());
    }

    private String extract(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() >= 1) {
            return OAuthEncoder.decode(matcher.group(1));
        }
        throw new OAuthException("Response body is incorrect. Can'TaskHandler extract token and secret from this: '" + str + "'", null);
    }

    public String getNoteStoreUrl() {
        return this.noteStoreUrl;
    }

    public String getWebApiUrlPrefix() {
        return this.webApiUrlPrefix;
    }

    public int getUserId() {
        return this.userId;
    }
}
