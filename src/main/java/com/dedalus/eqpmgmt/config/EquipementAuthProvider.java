package com.dedalus.eqpmgmt.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.dedalus.eqpmgmt.entity.Users;
import com.dedalus.eqpmgmt.repository.UsersRepository;

@Component
public class EquipementAuthProvider implements AuthenticationProvider{
	@Autowired
	UsersRepository usersRepository;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String un = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Users user = usersRepository.findByEmail(un);
		
		if(user == null) {
			throw new StackOverflowError("No user Registered");
			
		}
		else if(pwd.equals(user.getPass())) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			return new UsernamePasswordAuthenticationToken(un,pwd, authorities);
		}
		else {
			System.out.println("Bad credentials");
			throw new StackOverflowError("Invalid Credentials");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
