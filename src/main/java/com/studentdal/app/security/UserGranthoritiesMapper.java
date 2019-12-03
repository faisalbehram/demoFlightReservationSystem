package com.studentdal.app.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

public class UserGranthoritiesMapper implements GrantedAuthoritiesMapper{
	

	@Override
	public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
		Set<GrantedAuthority> mappedAuthorites = new HashSet<>();
		
		authorities.forEach(authority -> {
			if(OidcUserAuthority.class.isInstance(authority)){
				OidcUserAuthority oidcUserAuthority = (OidcUserAuthority) authority;
				OidcIdToken idToken = oidcUserAuthority.getIdToken();
				OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();
				Map<String,Object> userAttributes = oidcUserAuthority.getAttributes();
			}else if (OAuth2UserAuthority.class.isInstance(authority)) {
				OAuth2UserAuthority oAuth2UserAuthority = (OAuth2UserAuthority) authority;
				Map<String, Object> userAttributes   = oAuth2UserAuthority.getAttributes();
			}
			mappedAuthorites.add(new SimpleGrantedAuthority("USER"));
		});
		return mappedAuthorites;
	}

}
